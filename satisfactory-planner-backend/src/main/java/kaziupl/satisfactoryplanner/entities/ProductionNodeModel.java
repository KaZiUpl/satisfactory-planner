package kaziupl.satisfactoryplanner.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Entity
@Table(name = "productions")
@Getter
@Setter
public class ProductionNodeModel {
    @Id
    @GeneratedValue
    private UUID id;
    private String buildingId;
    private Integer machineCount;
    private Long clockSpeed = 1L;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "recipe_id", nullable = false)
    private RecipeModel recipe;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "outpost_id", nullable = false)
    private OutpostModel outpost;

}
