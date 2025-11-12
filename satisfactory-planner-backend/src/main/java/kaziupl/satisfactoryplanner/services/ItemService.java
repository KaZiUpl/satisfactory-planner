package kaziupl.satisfactoryplanner.services;

import com.example.satisfactoryplanner.model.Item;
import com.example.satisfactoryplanner.model.ItemPage;
import kaziupl.satisfactoryplanner.entities.ItemModel;
import kaziupl.satisfactoryplanner.mappers.ItemMapper;
import kaziupl.satisfactoryplanner.repositories.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ItemService {
    private final ItemRepository itemRepository;

    public ItemPage getAllItems(Pageable pageable) {
       Page<ItemModel> items = this.itemRepository.findAll(pageable);
       return ItemMapper.INSTANCE.pageToItemPage(items.map(ItemMapper.INSTANCE::toDto));
    }

    /**
     * Create item and save it to database
     * @param item
     * @return created item based on input
     */
    public ItemModel createItem(Item item) {
        ItemModel itemModel = ItemMapper.INSTANCE.toBase(item);
        itemModel = itemRepository.save(itemModel);
        return itemModel;
    }
}
