package hellburgers.hellburgerspringbootapplication.entities;
import javax.persistence.*;
import java.util.List;

@Entity
@Table
public class Burger {

    @Id
    @GeneratedValue(strategy =GenerationType.IDENTITY)
    private long id;

    @Column
    private String name;

    @Column
    private double price;

    @PersistenceContext
    EntityManager entityManager;


    @OneToMany(targetEntity = Ingredient.class, mappedBy = "burger", fetch = FetchType.LAZY)
    private List<Ingredient> ingredients;

    @OneToMany(targetEntity = Ingredient.class, mappedBy = "burger", fetch = FetchType.LAZY)
    private List<Meat> meats;

    @OneToMany(targetEntity = Ingredient.class, mappedBy = "burger", fetch = FetchType.LAZY)
    private List<Bread> breads;

    public Burger() {
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

    public List<Meat> getMeats() {
        return meats;
    }

    public void setMeats(List<Meat> meats) {
        this.meats = meats;
    }

    public List<Bread> getBreads() {
        return breads;
    }

    public void setBreads(List<Bread> breads) {
        this.breads = breads;
    }
}
