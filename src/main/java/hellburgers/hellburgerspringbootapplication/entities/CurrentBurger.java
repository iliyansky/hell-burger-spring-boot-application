package hellburgers.hellburgerspringbootapplication.entities;

import javax.persistence.*;

@Entity
@Table(name = "currentBurger")
public class CurrentBurger {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long currentBurger;

    public CurrentBurger() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCurrentBurger() {
        return currentBurger;
    }

    public void setCurrentBurger(Long currentBurger) {
        this.currentBurger = currentBurger;
    }
}
