package kaziupl.satisfactoryplanner.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "recipes")
@Getter
@Setter

public class RecipeModel {

    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String description;
    private Long craftTime;
    private List<String> producedIn = new ArrayList<>();
    private Boolean isAlternate;
    private String className;

    @ElementCollection
    @CollectionTable(name="recipe_ingredients",joinColumns = @JoinColumn(name = "recipe_id"))
    private List<RecipeItemAmountModel> ingredients = new ArrayList<>();

    @ElementCollection
    @CollectionTable(name="recipe_product",joinColumns = @JoinColumn(name = "recipe_id"))
    private List<RecipeItemAmountModel> product = new ArrayList<>();
}
