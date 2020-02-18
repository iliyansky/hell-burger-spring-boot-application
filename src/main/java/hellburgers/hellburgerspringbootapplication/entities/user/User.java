package hellburgers.hellburgerspringbootapplication.entities.user;

import org.hibernate.annotations.GeneratorType;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
public class User {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    long id;

    @NotNull
    String firtName;

    @NotNull
    String lastname;

    @NotNull
    String email;

    @NotNull
    String password;
}
