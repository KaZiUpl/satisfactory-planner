package kaziupl.satisfactoryplanner.entities;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Embeddable
@Getter
@Setter
@EqualsAndHashCode
public class RecipeItemAmountModel {
    private String className;
    private Integer amount;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "item_id")
    private ItemModel item;

    @Column(name="item_id", insertable = false, updatable = false)
    private UUID itemId;
}
