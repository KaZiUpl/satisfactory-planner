package kaziupl.satisfactoryplanner.mappers;

import com.example.satisfactoryplanner.model.RecipeItemAmount;
import kaziupl.satisfactoryplanner.entities.RecipeItemAmountModel;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface RecipeItemAmountMapper extends BaseMapper<RecipeItemAmount, RecipeItemAmountModel> {
    public RecipeItemAmountMapper INSTANCE = Mappers.getMapper(RecipeItemAmountMapper.class);

    @Override
    public RecipeItemAmount toDto(RecipeItemAmountModel recipeItemAmountModel);

    @Override
    public RecipeItemAmountModel toBase(RecipeItemAmount recipeItemAmount);
}
