package hellburgers.hellburgerspringbootapplication.repositories;

import hellburgers.hellburgerspringbootapplication.entities.Bread;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BreadRepository extends JpaRepository<Bread,Long> {
}
