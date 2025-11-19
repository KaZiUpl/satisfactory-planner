package kaziupl.satisfactoryplanner.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "recipes")
@Getter
@Setter

public class RecipeModel {

    @Id
    @GeneratedValue
    private UUID id;
    private String name;
    private String description;
    private Long craftTime;
    private List<String> producedIn = new ArrayList<>();
    private Boolean isAlternate;
    private String className;

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name="recipe_ingredients",joinColumns = @JoinColumn(name = "recipe_id"))
    private List<RecipeItemAmountModel> ingredients = new ArrayList<>();

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name="recipe_product",joinColumns = @JoinColumn(name = "recipe_id"))
    private List<RecipeItemAmountModel> product = new ArrayList<>();
}
