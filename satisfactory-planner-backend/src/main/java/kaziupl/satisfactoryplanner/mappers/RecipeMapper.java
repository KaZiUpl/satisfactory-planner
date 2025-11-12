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
    public RecipeMapper INSTANCE = Mappers.getMapper(RecipeMapper.class);

    Recipe toDto(RecipeModel recipeModel);
    RecipeModel toBase(Recipe recipe);

    public RecipePage pageToItem(Page<Recipe> items);

    public RecipeItemAmountModel toBaseRecipeItem(RecipeItemAmount recipeItemAmount);
    public RecipeItemAmount toDtoRecipeItem(RecipeItemAmountModel recipeItemAmountModel);
}
