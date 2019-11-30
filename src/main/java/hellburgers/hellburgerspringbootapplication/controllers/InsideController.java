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
        return "Choose what you want to edit with /.../{id}";
    }

    @RequestMapping(value = "/delete")
    public String delete(){
        return "Chose what you want to delete with /delete/.../{id}";
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

    @RequestMapping(value = "/edit/bread/{id}")
    public void editBreadById(@PathVariable("id") Long id, @RequestBody Bread bread){
        breadService.edit(id,bread);
    }

    @RequestMapping(value = "/edit/meat/{id}")
    public void editMeatById(@PathVariable("id") Long id, @RequestBody Meat meat){
        meatServices.edit(id,meat);
    }

    @RequestMapping(value = "/edit/ingredient/{id}")
    public void editIngredientById(@PathVariable("id")Long id, @RequestBody Ingredient ingredient){
        ingredientService.edit(id,ingredient);
    }

    @RequestMapping(value = "/delete/bread/{id}")
    public void deleteBreadById(@PathVariable("id") Long id){
        breadService.delete(id);
    }

    @RequestMapping(value = "/delete/meat/{id}")
    public void deleteMeatById(@PathVariable("id") Long id){
        meatServices.delete(id);
    }

    @RequestMapping(value = "/delete/ingredient/{id}")
    public void deleteIngredientById(@PathVariable("id") Long id){
        ingredientService.delete(id);
    }
}
