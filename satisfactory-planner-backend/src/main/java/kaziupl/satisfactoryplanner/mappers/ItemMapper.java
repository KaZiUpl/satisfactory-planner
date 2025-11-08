package kaziupl.satisfactoryplanner.mappers;

import com.example.satisfactoryplanner.model.Item;
import kaziupl.satisfactoryplanner.entities.ItemModel;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface ItemMapper {
    public ItemMapper INSTANCE = Mappers.getMapper(ItemMapper.class);
    public Item itemModelToItem(ItemModel item);
    public List<Item> listItemModelToListItem(List<ItemModel> items);
}
