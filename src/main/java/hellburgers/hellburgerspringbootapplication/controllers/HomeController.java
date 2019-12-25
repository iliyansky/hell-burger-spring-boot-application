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

    @RequestMapping("/create")
    public Burger createBurger(@RequestBody Burger burger){
        return this.burgerService.createBurger(burger);
    }










//        burgerService.createBurger();
//        burgerService.addBreadToTheBurger(idBread);
//        burgerService.addMeatToTheBurger(idMeat);
//        burgerService.addIngredientToTheBurger(idIngredient);
//        burgerService.addName(name);

//    {
//    "name": "Burgerchu",
//            "price": 0,
//            "ingredients": [
//    {
//        "id": 1,
//            "name": "Pepper",
//            "price": 0.7
//    },
//    {
//        "id": 2,
//            "name": "Tomato",
//            "price": 0.8
//    }
//    ],
//            "meats": [
//    {
//        "id": 1,
//            "name": "Beef",
//            "price": 7.0
//    }
//
//    ],
//            "breads": [
//    {
//        "id": 1,
//            "name": "White",
//            "price": 0.5
//    },
//    {
//        "id": 2,
//            "name": "Black",
//            "price": 0.6
//    }
//        ]
//}
}
