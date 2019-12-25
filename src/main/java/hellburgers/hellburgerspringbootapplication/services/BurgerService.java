package hellburgers.hellburgerspringbootapplication.services;

import hellburgers.hellburgerspringbootapplication.entities.*;
import hellburgers.hellburgerspringbootapplication.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BurgerService {

    @Autowired
    private BurgerRepository burgerRepository;

    @Autowired
    private BreadRepository breadRepository;

    @Autowired
    private MeatRepository meatRepository;

    @Autowired
    private IngredientRepository ingredientRepository;

    @Autowired
    private SauceRepository sauceRepository;

    private double calculateThePrice(Burger burger) {
        double price = 0;
        price += burger.getBreads().stream().mapToDouble(Bread::getPrice).sum();
        price += burger.getMeats().stream().mapToDouble(Meat::getPrice).sum();
        price += burger.getIngredients().stream().mapToDouble(Ingredient::getPrice).sum();
        price += burger.getSauces().stream().mapToDouble(Sauce::getPrice).sum();
        return price;
    }

    public Burger review(Burger burger){
        burger.setPrice(calculateThePrice(burger));
        return burger;
    }
    public Burger createBurger(Burger burger) {
        burger.setPrice(calculateThePrice(burger));
        return burgerRepository.save(burger);
    }

    public List<Burger> displayBurger(){
        return burgerRepository.findAll();
    }

    public void deleteBurger(long id){
        burgerRepository.deleteById(id);
    }











    //    public void addName(String name){
    //        this.currentBurgerRepository.deleteAll();
    //        burger.setName(name);
    //        Burger burger = this.burgerRepository.getOne(currentBurger.getCurrentBurger());
    //
    //    }
    //    public void addIngredientToTheBurger(long id){
    //        this.burgerRepository.save(burger);
    //        burger.setPrice(burger.getPrice() + this.ingredientRepository.getOne(id).getPrice());
    //        burger.setName("Ingredient");
    //        burger.addIngredients(this.ingredientRepository.getOne(id));
    //        Burger burger = this.burgerRepository.getOne(currentBurger.getCurrentBurger());
    //
    //    }
    //    public void addMeatToTheBurger(long id){
    //        this.burgerRepository.save(burger);
    //        burger.setPrice(burger.getPrice() + meatRepository.getOne(id).getPrice());
    //        burger.setName("Meat");
    //        burger.addMeat(this.meatRepository.getOne(id));
    //        Burger burger = this.burgerRepository.getOne(currentBurger.getCurrentBurger());
    //
    //    }
    //    public void addBreadToTheBurger(long id){
    //        this.burgerRepository.save(burger);
    //        burger.setPrice(burger.getPrice() + this.breadRepository.getOne(id).getPrice());
    //        burger.setName("Bread");
    //        burger.addBread(this.breadRepository.getOne(id));
    //        Burger burger = this.burgerRepository.getOne(currentBurger.getCurrentBurger());
    //
    //    }
    //    public void createBurger(){
    //        this.currentBurgerRepository.save(currentBurger);
    //        this.currentBurger.setCurrentBurger(burger.getId());
    //        this.burgerRepository.save(burger);
    //        burger.setName("Burger");
    //        Burger burger = new Burger();
    //    }
}
