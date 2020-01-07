package hellburgers.hellburgerspringbootapplication.entities;

import java.util.Set;
// Future implementation to work with DTO object for more security
public class BurgerDTO {

    private String name;

    private double price;

    private Set<Bread> bread;

    private Set<Meat> meats;

    private Set<Ingredient> ingredients;

    private Set<Sauce> sauces;

    public BurgerDTO() {
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

    public Set<Bread> getBread() {
        return bread;
    }

    public void setBread(Set<Bread> bread) {
        this.bread = bread;
    }

    public Set<Meat> getMeats() {
        return meats;
    }

    public void setMeats(Set<Meat> meats) {
        this.meats = meats;
    }

    public Set<Ingredient> getIngredients() {
        return ingredients;
    }

    public void setIngredients(Set<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }

    public Set<Sauce> getSauces() {
        return sauces;
    }

    public void setSauces(Set<Sauce> sauces) {
        this.sauces = sauces;
    }
}
