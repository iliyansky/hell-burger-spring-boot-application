package hellburgers.hellburgerspringbootapplication.controllers;

import hellburgers.hellburgerspringbootapplication.entities.Burger;
import hellburgers.hellburgerspringbootapplication.services.BurgerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class HomeController {

    @Autowired
    private BurgerService burgerService;

    // Display all burgers in database
    @RequestMapping("/display")
    public List<Burger> displayBurger(){
        return burgerService.displayBurger();
    }

    // Review endpoint to check the burger price and ingredients, before add it into the database and return Burger object
    @RequestMapping(value = "/review")
    public Burger theStateBeforeCreating(@RequestBody Burger burger){
        return this.burgerService.review(burger);
    }

    // Create the burger and add it into the database, then return Burger object
    @RequestMapping("/create")
    public Burger createBurger(@RequestBody Burger burger){
        return this.burgerService.createBurger(burger);
    }
}