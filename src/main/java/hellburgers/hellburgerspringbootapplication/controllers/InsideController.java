package hellburgers.hellburgerspringbootapplication.controllers;

import hellburgers.hellburgerspringbootapplication.entities.Bread;
import hellburgers.hellburgerspringbootapplication.entities.Ingredient;
import hellburgers.hellburgerspringbootapplication.entities.Meat;
import hellburgers.hellburgerspringbootapplication.entities.Sauce;
import hellburgers.hellburgerspringbootapplication.services.*;
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

    @Autowired
    private SauceService sauceService;

    @Autowired
    private BurgerService burgerService;


    // Info how to get item by name
    @RequestMapping(value = "/get")
    public String chooseWhatToGet(){
        return "Choose what to get with /...";
    }

    // Info how to add item
    @RequestMapping(value = "/add")
    public String chooseWhatToAdd(){
        return "Choose what to add with /... ! and type the properties in the body";
    }

    // Info how to edit item
    @RequestMapping(value = "edit")
    public String edit(){
        return "Choose what you want to edit with /.../{id} ! and type the new properties in the body";
    }

    // Info how to delete item
    @RequestMapping(value = "/delete")
    public String delete(){
        return "Chose what you want to delete with /delete/.../{id}";
    }

    // Endpoint for adding bread into the database using the body
    @RequestMapping(value = "/add/bread")
    public void addBread(@RequestBody Bread bread){
        breadService.addBread(bread);
    }

    // Endpoint for adding meat into the database
    @RequestMapping(value = "/add/meat")
    public void addMeat(@RequestBody Meat meat){
        meatServices.addMeat(meat);
    }

    // Endpoint for adding ingredient into the database
    @RequestMapping(value = "/add/ingredient")
    public void addIngredient(@RequestBody Ingredient ingredient){
        ingredientService.addIngredient(ingredient);
    }
    // Endpoint for adding sauce into the database
    @RequestMapping(value = "/add/sauce")
    public void addSauce(@RequestBody Sauce sauce){
        sauceService.addSauce(sauce);
    }

    // Endpoint to get all breads in database
    @RequestMapping(value = "/get/breads")
    public List<Bread> getBreads(){
       return breadService.getBreads();
    }

    // Endpoint to get all meats in database
    @RequestMapping(value = "/get/meats")
    public List<Meat> getMeats(){
        return meatServices.getMeats();
    }

    // Endpoint to get all ingredients in database
    @RequestMapping(value = "/get/ingredients")
    public List<Ingredient> getIngredients(){
        return ingredientService.getIngredients();
    }

    // Endpoint to get all sauce in database
    @RequestMapping(value = "/get/sauce")
    public List<Sauce> getSauces(){
        return sauceService.getAll();
    }

    //Endpoint to edit bread by Id
    @RequestMapping(value = "/edit/bread/{id}")
    public void editBreadById(@PathVariable("id") Long id, @RequestBody Bread bread){
        breadService.edit(id,bread);
    }

    //Endpoint to edit meat by Id
    @RequestMapping(value = "/edit/meat/{id}")
    public void editMeatById(@PathVariable("id") Long id, @RequestBody Meat meat){
        meatServices.edit(id,meat);
    }

    //Endpoint to edit ingredient by Id
    @RequestMapping(value = "/edit/ingredient/{id}")
    public void editIngredientById(@PathVariable("id")Long id, @RequestBody Ingredient ingredient){
        ingredientService.edit(id,ingredient);
    }

    //Endpoint to edit sauce by Id
    @RequestMapping(value = "/edit/sauce/{id}")
    public void editSauceById(@PathVariable("id")Long id, @RequestBody Sauce sauce){
        sauceService.edit(id,sauce);
    }

    //Endpoint to delete bread by Id
    @RequestMapping(value = "/delete/bread/{id}")
    public void deleteBreadById(@PathVariable("id") Long id){
        breadService.delete(id);
    }

    //Endpoint to delete meat by Id
    @RequestMapping(value = "/delete/meat/{id}")
    public void deleteMeatById(@PathVariable("id") Long id){
        meatServices.delete(id);
    }

    //Endpoint to delete ingredient by Id
    @RequestMapping(value = "/delete/ingredient/{id}")
    public void deleteIngredientById(@PathVariable("id") Long id){
        ingredientService.delete(id);
    }

    //Endpoint to delete sauce by Id
    @RequestMapping(value = "/delete/sauce/{id}")
    public void deleteSauceById(@PathVariable("id") Long id){
        sauceService.delete(id);
    }

    //Endpoint to delete burger by Id
    @RequestMapping(value = "/delete/{id}")
    public void deleteBurgerById(@PathVariable("id") Long id){
        this.burgerService.deleteBurger(id);
    }
}
