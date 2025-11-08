package kaziupl.satisfactoryplanner.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "items")
public class ItemModel {

    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String description;
    private Integer stackSize;
    private Integer sinkValue;
    private Long energyValue;
    private Boolean radioactive;
}
