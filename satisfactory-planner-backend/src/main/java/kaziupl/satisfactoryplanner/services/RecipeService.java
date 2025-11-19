package kaziupl.satisfactoryplanner.services;

import com.example.satisfactoryplanner.model.Recipe;
import com.example.satisfactoryplanner.model.RecipePage;
import kaziupl.satisfactoryplanner.entities.RecipeModel;
import kaziupl.satisfactoryplanner.errors.ResourceNotFoundException;
import kaziupl.satisfactoryplanner.mappers.RecipeMapper;
import kaziupl.satisfactoryplanner.repositories.RecipeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class RecipeService {
    private final RecipeRepository recipeRepository;

    public RecipePage getRecipePage(Pageable pageable){
        Page<RecipeModel> recipeModelPage = this.recipeRepository.findAll(pageable);
        return RecipeMapper.INSTANCE.modelPageToRecipePage(recipeModelPage);
    }

    public Recipe getRecipeById(UUID id) {
        Optional<RecipeModel> recipeModel = this.recipeRepository.findById(id);
        return RecipeMapper.INSTANCE.toDto(recipeModel.orElseThrow(()->new ResourceNotFoundException("recipe", id.toString())));
    }
}
