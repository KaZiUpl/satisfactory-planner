package kaziupl.satisfactoryplanner.mappers;

import com.example.satisfactoryplanner.model.Item;
import com.example.satisfactoryplanner.model.ItemPage;
import kaziupl.satisfactoryplanner.entities.ItemModel;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.springframework.data.domain.Page;

@Mapper
public interface ItemMapper extends BaseMapper<Item, ItemModel> {
    public ItemMapper INSTANCE = Mappers.getMapper(ItemMapper.class);

    public Item toDto(ItemModel item);
    public ItemModel toBase(Item item);

    public ItemPage pageToItemPage(Page<Item> items);
}
