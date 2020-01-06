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

    @RequestMapping("/display")
    public List<Burger> displayBurger(){
        return burgerService.displayBurger();
    }

    @RequestMapping(value = "/review")
    public Burger theStateBeforeCreating(@RequestBody Burger burger){
        return this.burgerService.review(burger);
    }

    @RequestMapping("/create")
    public Burger createBurger(@RequestBody Burger burger){
        return this.burgerService.createBurger(burger);
    }
}