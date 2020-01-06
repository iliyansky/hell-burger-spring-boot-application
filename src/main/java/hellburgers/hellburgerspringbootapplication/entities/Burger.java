package hellburgers.hellburgerspringbootapplication.entities;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table
public class Burger {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column
    private String name;

    @Column
    private double price;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable
    private List<Ingredient> ingredients;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable
    private Set<Meat> meats;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable
    private Set<Bread> breads;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable
    private Set<Sauce> sauces;

    public Burger() {
        this.ingredients = new ArrayList<>();
        this.meats = new HashSet<>();
        this.breads = new HashSet<>();
        this.sauces = new HashSet<>();
    }

    public Burger(String name) {
        this.name = name;
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

    public List<Ingredient> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }

    public Set<Meat> getMeats() {
        return meats;
    }

    public void setMeats(Set<Meat> meats) {
        this.meats = meats;
    }

    public Set<Bread> getBreads() {
        return breads;
    }

    public void setBreads(Set<Bread> breads) {
        this.breads = breads;
    }

    public void addBread(Bread bread){
        this.breads.add(bread);
    }

    public void addMeat(Meat meat){
        this.meats.add(meat);
    }

    public void addIngredients(Ingredient ingredient){
        this.ingredients.add(ingredient);
    }

    public Set<Sauce> getSauces() {
        return sauces;
    }

    public void setSauces(Set<Sauce> sauces) {
        this.sauces = sauces;
    }
}
