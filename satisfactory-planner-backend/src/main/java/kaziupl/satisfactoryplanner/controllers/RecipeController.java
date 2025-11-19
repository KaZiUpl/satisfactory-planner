package kaziupl.satisfactoryplanner.controllers;

import com.example.satisfactoryplanner.api.RecipesApi;
import com.example.satisfactoryplanner.model.Recipe;
import com.example.satisfactoryplanner.model.RecipePage;
import kaziupl.satisfactoryplanner.services.RecipeService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController()
@RequestMapping("recipes")
@RequiredArgsConstructor
public class RecipeController implements RecipesApi {
    private final RecipeService recipeService;

    @GetMapping("")
    @Override
    public ResponseEntity<RecipePage> getAllRecipes(Integer page, Integer size, String sort, Pageable pageable) {
        return ResponseEntity.ok(this.recipeService.getRecipePage(pageable));
    }

    @GetMapping("{recipeId}")
    @Override
    public ResponseEntity<Recipe> getRecipeById(UUID recipeId) {
        return ResponseEntity.ok(this.recipeService.getRecipeById(recipeId));
    }
}
