package hellburgers.hellburgerspringbootapplication.controllers;

import hellburgers.hellburgerspringbootapplication.services.BurgerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @Autowired
    private BurgerService burgerService;

    @RequestMapping("/create")
    public void firstStep(){
        burgerService.createBurger();
    }

    @RequestMapping("/create/bread/{id}")
    public void addBreadToTheBurger(@PathVariable("id") Long id){
        burgerService.addBreadToTheBurger(id);
    }

    @RequestMapping("/create/meat/{id}")
    public void addMeatToTheBurger(@PathVariable("id") Long id){
        burgerService.addMeatToTheBurger(id);
    }

    @RequestMapping("/create/ingredient/{id}")
    public void addIngredientToTheBurger(@PathVariable("id") Long id){
        burgerService.addIngredientToTheBurger(id);
    }

    @RequestMapping("/finish")
    public void finish(){
        burgerService.finish();
    }
}
