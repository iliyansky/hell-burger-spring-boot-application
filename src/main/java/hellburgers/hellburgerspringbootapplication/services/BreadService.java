package hellburgers.hellburgerspringbootapplication.services;

import hellburgers.hellburgerspringbootapplication.entities.Bread;
import hellburgers.hellburgerspringbootapplication.repositories.BreadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class BreadService {

    @Autowired
    private BreadRepository breadRepository;

    public List<Bread> getBreads (){
        return breadRepository.findAll();
    }

    public void addBread(Bread bread){
        breadRepository.save(bread);
    }

    @Transactional
    public void delete(String name){
        breadRepository.removeByName(name);
        //breadRepository.flush();
    }

    public void edit(String name,Bread bread){
        breadRepository.getByName(name).setName(bread.getName());
        breadRepository.getByName(name).setPrice(bread.getPrice());
        breadRepository.flush();
    }
}
