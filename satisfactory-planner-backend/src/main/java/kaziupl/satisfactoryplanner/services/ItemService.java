package kaziupl.satisfactoryplanner.services;

import com.example.satisfactoryplanner.model.Item;
import com.example.satisfactoryplanner.model.ItemPage;
import kaziupl.satisfactoryplanner.errors.ResourceNotFoundException;
import kaziupl.satisfactoryplanner.entities.ItemModel;
import kaziupl.satisfactoryplanner.mappers.ItemMapper;
import kaziupl.satisfactoryplanner.repositories.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

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
     * @param item item object
     * @return created item based on input
     */
    public ItemModel createItem(Item item) {
        ItemModel itemModel = ItemMapper.INSTANCE.toBase(item);
        itemModel = itemRepository.save(itemModel);
        return itemModel;
    }

    public Item getItemById(UUID id) {
        Optional<ItemModel> item = itemRepository.findById(id);
        return ItemMapper.INSTANCE.toDto(item.orElseThrow(()->new ResourceNotFoundException("item", id.toString())));
    }
}
