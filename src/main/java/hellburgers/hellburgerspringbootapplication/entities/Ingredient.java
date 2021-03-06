package hellburgers.hellburgerspringbootapplication.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Ingredient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;

    private double price;

    @ManyToMany(fetch = FetchType.LAZY)
    @JsonIgnore
    private Set<Burger> burgers;

    public Ingredient() {
    }

    public Ingredient(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Set<Burger> getBurgers() {
        return burgers;
    }

    public void setBurgers(Set<Burger> burgers) {
        this.burgers = burgers;
    }
}
