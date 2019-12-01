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

    public void edit(Long id, Meat meat){
        meatRepository.getOne(id).setName(meat.getName());
        meatRepository.getOne(id).setPrice(meat.getPrice());
        meatRepository.flush();
    }

    @Transactional
    public void delete(Long id){
        meatRepository.deleteById(id);
        meatRepository.flush();
    }
}
