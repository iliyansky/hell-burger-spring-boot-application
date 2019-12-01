package hellburgers.hellburgerspringbootapplication.services;

import hellburgers.hellburgerspringbootapplication.entities.Ingredient;
import hellburgers.hellburgerspringbootapplication.repositories.IngredientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.List;

@Service
public class IngredientService {

    @Autowired
    private IngredientRepository ingredientRepository;

    public void addIngredient(Ingredient ingredient){
        ingredientRepository.save(ingredient);
    }

    public List<Ingredient> getIngredients(){
        return ingredientRepository.findAll();
    }

    public void edit(Long id, Ingredient ingredient){
        ingredientRepository.getOne(id).setName(ingredient.getName());
        ingredientRepository.getOne(id).setPrice(ingredient.getPrice());
        ingredientRepository.flush();
    }

    @Transactional
    public void delete(Long id){
        ingredientRepository.deleteById(id);
        ingredientRepository.flush();
    }
}
