package kaziupl.satisfactoryplanner.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "outposts")
@Getter
@Setter
public class OutpostModel {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String name;
    private String description;

    @OneToMany(mappedBy = "outpost", cascade = CascadeType.ALL)
    List<ProductionNodeModel> productions;

    @ManyToOne
    @JoinColumn(name = "factory_id", nullable = false)
    private FactoryModel factory;
}
