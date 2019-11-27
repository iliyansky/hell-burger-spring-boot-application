package hellburgers.hellburgerspringbootapplication.repositories;

import hellburgers.hellburgerspringbootapplication.entities.Burger;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BurgerRepository extends JpaRepository<Burger,Long> {
}
