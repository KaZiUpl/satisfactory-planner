package kaziupl.satisfactoryplanner.controllers;

import com.example.satisfactoryplanner.api.ItemsApi;
import com.example.satisfactoryplanner.model.Item;
import com.example.satisfactoryplanner.model.ItemPage;
import kaziupl.satisfactoryplanner.services.ItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.data.domain.Pageable;

import java.util.UUID;

@RestController()
@RequestMapping("items")
@RequiredArgsConstructor
public class ItemController implements ItemsApi {
    private final ItemService itemService;

    @GetMapping("")
    @Override
    public ResponseEntity<ItemPage> getAllItems(Integer page, Integer size, String sort, Pageable pageable) {
        return ResponseEntity.ok(this.itemService.getAllItems(pageable));
    }

    @GetMapping("{itemId}")
    @Override
    public ResponseEntity<Item> getItemById( UUID itemId) {
        return ResponseEntity.ok(this.itemService.getItemById(itemId));
    }


}
