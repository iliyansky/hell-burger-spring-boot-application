package hellburgers.hellburgerspringbootapplication.controllers;

import hellburgers.hellburgerspringbootapplication.entities.Burger;
import hellburgers.hellburgerspringbootapplication.services.BurgerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class HomeController {

    @Autowired
    private BurgerService burgerService;

    @RequestMapping("/create/{id1}/{id2}/{id3}/{name}")
    public void createBurger(@PathVariable(name = "id1") Long idBread, @PathVariable(name = "id2") Long idMeat, @PathVariable(name = "id3") Long idIngredient, @PathVariable("name") String name){
        burgerService.createBurger();
        burgerService.addBreadToTheBurger(idBread);
        burgerService.addMeatToTheBurger(idMeat);
        burgerService.addIngredientToTheBurger(idIngredient);
        burgerService.addName(name);
    }

    @RequestMapping("/display")
    public List<Burger> displayBurger(){
        return burgerService.displayBurger();
    }

}
