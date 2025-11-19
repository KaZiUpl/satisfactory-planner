package kaziupl.satisfactoryplanner.mappers;

import com.example.satisfactoryplanner.model.Recipe;
import com.example.satisfactoryplanner.model.RecipeItemAmount;
import com.example.satisfactoryplanner.model.RecipePage;
import kaziupl.satisfactoryplanner.entities.RecipeItemAmountModel;
import kaziupl.satisfactoryplanner.entities.RecipeModel;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.springframework.data.domain.Page;

@Mapper
public interface RecipeMapper extends BaseMapper<Recipe, RecipeModel> {
    RecipeMapper INSTANCE = Mappers.getMapper(RecipeMapper.class);

    Recipe toDto(RecipeModel recipeModel);
    RecipeModel toBase(Recipe recipe);

    RecipePage pageToRecipePage(Page<Recipe> recipes);
    RecipePage modelPageToRecipePage(Page<RecipeModel> recipes);

    RecipeItemAmountModel toBaseRecipeItem(RecipeItemAmount recipeItemAmount);
    RecipeItemAmount toDtoRecipeItem(RecipeItemAmountModel recipeItemAmountModel);
}
