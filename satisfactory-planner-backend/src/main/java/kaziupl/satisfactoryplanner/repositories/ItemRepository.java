package kaziupl.satisfactoryplanner.repositories;

import kaziupl.satisfactoryplanner.entities.ItemModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemRepository extends JpaRepository<ItemModel, Long> {
}
