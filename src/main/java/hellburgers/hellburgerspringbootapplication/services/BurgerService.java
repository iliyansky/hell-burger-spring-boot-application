package hellburgers.hellburgerspringbootapplication.services;

import hellburgers.hellburgerspringbootapplication.entities.*;
import hellburgers.hellburgerspringbootapplication.repositories.*;
import hellburgers.hellburgerspringbootapplication.services.discount.TwoMeatsDiscount;
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
        if (burger.getMeats().size() >= 2){
            burger.setPrice(new TwoMeatsDiscount().apply(burger.getPrice()));
        }
        return burger;
    }
    public Burger createBurger(Burger burger) {
        burger.setPrice(calculateThePrice(burger));
        if (burger.getMeats().size() >= 2){
            burger.setPrice(new TwoMeatsDiscount().apply(burger.getPrice()));
        }
        return burgerRepository.save(burger);
    }

    public Burger getBurgerByName(String name){
        return burgerRepository.findByName(name);
    }

    public List<Burger> displayBurger(){
        return burgerRepository.findAll();
    }

    public void deleteBurger(long id){
        burgerRepository.deleteById(id);
    }
}
