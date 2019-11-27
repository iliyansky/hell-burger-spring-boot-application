package hellburgers.hellburgerspringbootapplication.repositories;

import hellburgers.hellburgerspringbootapplication.entities.Ingredient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IngredientRepository extends JpaRepository<Ingredient,Long> {
    void deleteByName(String name);

    Ingredient getByName(String name);
}
