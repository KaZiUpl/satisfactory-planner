package kaziupl.satisfactoryplanner.repositories;

import kaziupl.satisfactoryplanner.entities.RecipeModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecipeRepository extends JpaRepository<RecipeModel, Long> {
}
