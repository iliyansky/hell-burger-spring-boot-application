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
    public void delete(Long id){
        breadRepository.deleteById(id);
    }

    public void edit(Long id,Bread bread){
        breadRepository.getOne(id).setName(bread.getName());
        breadRepository.getOne(id).setPrice(bread.getPrice());
        breadRepository.flush();
    }
}
