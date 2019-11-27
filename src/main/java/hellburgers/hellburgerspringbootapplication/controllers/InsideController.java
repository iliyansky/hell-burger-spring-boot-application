package hellburgers.hellburgerspringbootapplication.controllers;

import hellburgers.hellburgerspringbootapplication.entities.Bread;
import hellburgers.hellburgerspringbootapplication.entities.Ingredient;
import hellburgers.hellburgerspringbootapplication.entities.Meat;
import hellburgers.hellburgerspringbootapplication.services.BreadService;
import hellburgers.hellburgerspringbootapplication.services.IngredientService;
import hellburgers.hellburgerspringbootapplication.services.MeatServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class InsideController {

    @Autowired
    private BreadService breadService;

    @Autowired
    private MeatServices meatServices;

    @Autowired
    private IngredientService ingredientService;


    @RequestMapping("/get")
    public String chooseWhatToGet(){
        return "Choose what to get with /...";
    }

    @RequestMapping("/add")
    public String chooseWhatToAdd(){
        return "Choose what to add with /... !";
    }

    @RequestMapping("edit")
    public String edit(){
        return "Choose what you want to edit with /.../{name}";
    }

    @RequestMapping(value = "/delete")
    public String delete(){
        return "Chose what you want to delete with /delete/.../{name}";
    }

    @RequestMapping("/add/bread")
    public void addBread(@RequestBody Bread bread){
        breadService.addBread(bread);
    }

    @RequestMapping("/add/meat")
    public void addMeat(@RequestBody Meat meat){
        meatServices.addMeat(meat);
    }

    @RequestMapping("/add/ingredient")
    public void addIngredient(@RequestBody Ingredient ingredient){
        ingredientService.addIngredient(ingredient);
    }

    @RequestMapping("/get/breads")
    public List<Bread> getBreads(){
       return breadService.getBreads();
    }

    @RequestMapping("/get/meats")
    public List<Meat> getMeats(){
        return meatServices.getMeats();
    }

    @RequestMapping("/get/ingredients")
    public List<Ingredient> getIngredients(){
        return ingredientService.getIngredients();
    }

    @RequestMapping(value = "/edit/bread/{name}")
    public void editBreadByName(@PathVariable("name") String name, @RequestBody Bread bread){
        breadService.edit(name,bread);
    }

    @RequestMapping(value = "/edit/meat/{name}")
    public void editMeatByName(@PathVariable("name") String name, @RequestBody Meat meat){
        meatServices.edit(name,meat);
    }

    @RequestMapping(value = "/edit/ingredient/{name}")
    public void editIngredientByName(@PathVariable("name")String name, @RequestBody Ingredient ingredient){
        ingredientService.edit(name,ingredient);
    }


    @RequestMapping(value = "/delete/bread/{name}")
    public void deleteBreadByName(@PathVariable("name") String name){
        breadService.delete(name);
    }

    @RequestMapping(value = "/delete/meat/{name}")
    public void deleteMeatByName(@PathVariable("name") String name){
        meatServices.delete(name);
    }

    @RequestMapping(value = "/delete/ingredient/{name}")
    public void deleteIngredientByName(@PathVariable("name") String name){
        ingredientService.delete(name);
    }
}
