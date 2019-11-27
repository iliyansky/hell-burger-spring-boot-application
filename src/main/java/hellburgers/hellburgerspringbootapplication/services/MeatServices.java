package hellburgers.hellburgerspringbootapplication.services;

import hellburgers.hellburgerspringbootapplication.entities.Meat;
import hellburgers.hellburgerspringbootapplication.repositories.MeatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class MeatServices {

    @Autowired
    MeatRepository meatRepository;

    public void addMeat(Meat meat){
        meatRepository.save(meat);
    }

    public List<Meat> getMeats(){
        return meatRepository.findAll();
    }

    public void edit(String name, Meat meat){
        meatRepository.getByName(name).setName(meat.getName());
        meatRepository.getByName(name).setPrice(meat.getPrice());
        meatRepository.flush();
    }

    @Transactional
    public void delete(String name){
        meatRepository.deleteByName(name);
        meatRepository.flush();
    }
}
