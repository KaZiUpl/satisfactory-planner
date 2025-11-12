package kaziupl.satisfactoryplanner.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "items")
@Builder(toBuilder = true)
@AllArgsConstructor(access = AccessLevel.PACKAGE)
@NoArgsConstructor(access = AccessLevel.PACKAGE)
@Setter(value = AccessLevel.PACKAGE)
@Getter
public class ItemModel {

    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String className;
    @Column(length = 1024)
    private String description;
    private Integer stackSize;
    private Integer sinkPoints;
    private Long energyValue;
    private Long radioactiveDecay;
}


