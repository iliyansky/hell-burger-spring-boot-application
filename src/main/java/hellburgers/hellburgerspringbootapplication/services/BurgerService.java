package hellburgers.hellburgerspringbootapplication.services;

import hellburgers.hellburgerspringbootapplication.entities.Burger;
import hellburgers.hellburgerspringbootapplication.repositories.BreadRepository;
import hellburgers.hellburgerspringbootapplication.repositories.BurgerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.persistence.EntityManager;

@Service
public class BurgerService {

    @Autowired
    BreadRepository breadRepository;

//    public void createBurgerName(){
//        burgerRepository.save(new Burger());
//    }

//    @RequestMapping("/choseBread")
//    public void addBread(Long id){
//        Burger burger = new Burger();
//
//        // burger.getBreads().add(breadRepository.getOne(id));
}
