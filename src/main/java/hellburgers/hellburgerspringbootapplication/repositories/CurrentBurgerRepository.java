package hellburgers.hellburgerspringbootapplication.repositories;

import hellburgers.hellburgerspringbootapplication.entities.CurrentBurger;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CurrentBurgerRepository extends JpaRepository<CurrentBurger,Long> {
}
