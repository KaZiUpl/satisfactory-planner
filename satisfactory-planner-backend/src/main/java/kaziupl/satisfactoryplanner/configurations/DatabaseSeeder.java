package kaziupl.satisfactoryplanner.configurations;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import kaziupl.satisfactoryplanner.entities.ItemModel;
import kaziupl.satisfactoryplanner.entities.RecipeModel;
import kaziupl.satisfactoryplanner.repositories.ItemRepository;
import kaziupl.satisfactoryplanner.repositories.RecipeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Configuration
@RequiredArgsConstructor
public class DatabaseSeeder implements ApplicationRunner {
    private final ItemRepository itemRepository;
    private final RecipeRepository recipeRepository;
    private final ObjectMapper objectMapper;

    @Value("classpath:static/item_seed.json")
    private Resource itemSeed;
    @Value("classpath:static/recipe_seed.json")
    private Resource recipeSeed;


    @Override
    public void run(ApplicationArguments args) throws Exception {
        List<ItemModel> itemsToSave;
        List<RecipeModel> recipesToSave;

        try {
            if(itemRepository.count() == 0) {
                InputStream itemSeedData = itemSeed.getInputStream();
                itemsToSave = itemRepository.saveAll(objectMapper.readValue(itemSeedData,
                        new TypeReference<List<ItemModel>>() {}));
            }
            else {
                itemsToSave = this.itemRepository.findAll();
            }
            if (recipeRepository.count() == 0) {

                InputStream recipeSeedData = recipeSeed.getInputStream();

                recipesToSave = objectMapper.readValue(recipeSeedData,
                        new TypeReference<List<RecipeModel>>() {});

                List<ItemModel> finalItemsToSave = itemsToSave;
                recipesToSave.forEach((recipeModel )->{
                    recipeModel.getIngredients().forEach(ingredient -> {
                        this.findItemByClassName(ingredient.getClassName(), finalItemsToSave).ifPresent(ingredient::setItem);
                    });

                    recipeModel.getProduct().forEach(product -> {
                        this.findItemByClassName(product.getClassName(), finalItemsToSave).ifPresent(product::setItem);
                    });

                });

                recipesToSave = this.recipeRepository.saveAll(recipesToSave);
            }
        } catch (IOException e) {

        }


    }

    private Optional<ItemModel> findItemByClassName(String className, List<ItemModel> itemsToSearch) {
        return itemsToSearch.stream().filter(itemModel -> itemModel.getClassName().equals(className)).findFirst();
    }

}
