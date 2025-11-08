package kaziupl.satisfactoryplanner.controllers;

import com.example.satisfactoryplanner.api.ItemsApi;
import com.example.satisfactoryplanner.model.Item;
import kaziupl.satisfactoryplanner.services.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.awt.print.Pageable;
import java.util.List;

@RestController()
@RequestMapping("items")
public class ItemController implements ItemsApi {

    @Autowired
    private ItemService itemService;

    @GetMapping(path = "")
    @Override
    public ResponseEntity<List<Item>> getAllItems() {
        return ResponseEntity.ok(this.itemService.getAllItems());
    }
}
