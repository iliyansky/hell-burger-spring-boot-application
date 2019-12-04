package hellburgers.hellburgerspringbootapplication.services;

import hellburgers.hellburgerspringbootapplication.entities.Burger;
import hellburgers.hellburgerspringbootapplication.entities.CurrentBurger;
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
    private CurrentBurgerRepository currentBurgerRepository;

    @Autowired
    private IngredientRepository ingredientRepository;

    private CurrentBurger currentBurger = new CurrentBurger();

    public void createBurger(){
        Burger burger = new Burger();
        burger.setName("Burger");
        this.burgerRepository.save(burger);
        this.currentBurger.setCurrentBurger(burger.getId());
        this.currentBurgerRepository.save(currentBurger);

    }

    public void addBreadToTheBurger(long id){
        Burger burger = this.burgerRepository.getOne(currentBurger.getCurrentBurger());
        burger.addBread(this.breadRepository.getOne(id));
        burger.setName("Bread");
        burger.setPrice(burger.getPrice() + this.breadRepository.getOne(id).getPrice());
        this.burgerRepository.save(burger);
    }

    public void addMeatToTheBurger(long id){
        Burger burger = this.burgerRepository.getOne(currentBurger.getCurrentBurger());
        burger.addMeat(this.meatRepository.getOne(id));
        burger.setName("Meat");
        burger.setPrice(burger.getPrice() + meatRepository.getOne(id).getPrice());
        this.burgerRepository.save(burger);
    }

    public void addIngredientToTheBurger(long id){
        Burger burger = this.burgerRepository.getOne(currentBurger.getCurrentBurger());
        burger.addIngredients(this.ingredientRepository.getOne(id));
        burger.setName("Ingredient");
        burger.setPrice(burger.getPrice() + this.ingredientRepository.getOne(id).getPrice());
        this.burgerRepository.save(burger);
    }

    public void addName(String name){
        Burger burger = this.burgerRepository.getOne(currentBurger.getCurrentBurger());
        burger.setName(name);
        this.currentBurgerRepository.deleteAll();
    }

    public List<Burger> displayBurger(){
        return burgerRepository.findAll();
    }
}
