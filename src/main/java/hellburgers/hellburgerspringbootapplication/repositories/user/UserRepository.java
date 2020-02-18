package hellburgers.hellburgerspringbootapplication.repositories.user;

import hellburgers.hellburgerspringbootapplication.entities.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
}
