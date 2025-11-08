package kaziupl.satisfactoryplanner.services;

import com.example.satisfactoryplanner.model.Item;
import kaziupl.satisfactoryplanner.entities.ItemModel;
import kaziupl.satisfactoryplanner.mappers.ItemMapper;
import kaziupl.satisfactoryplanner.repositories.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemService {
    @Autowired
    private ItemRepository itemRepository;


    public List<Item> getAllItems() {
       List<ItemModel> items = this.itemRepository.findAll();

       return ItemMapper.INSTANCE.listItemModelToListItem(items);
    }
}
