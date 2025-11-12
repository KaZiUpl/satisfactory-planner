package kaziupl.satisfactoryplanner.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "factories")
@Getter
@Setter
public class FactoryModel {
    @Id
    @GeneratedValue
    private UUID id;
    private String name;
    private String description;

    @OneToMany(mappedBy = "factory", cascade = CascadeType.ALL, orphanRemoval = true)
    List<OutpostModel> outposts;
}
