package hellburgers.hellburgerspringbootapplication.services;

import hellburgers.hellburgerspringbootapplication.entities.Sauce;
import hellburgers.hellburgerspringbootapplication.repositories.SauceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class SauceService {

    @Autowired
    private SauceRepository sauceRepository;

    public void addSauce(Sauce sauce){
        sauceRepository.save(sauce);
    }

    public List<Sauce> getAll(){
        return this.sauceRepository.findAll();
    }

    public void edit(Long id, Sauce sauce){
        sauceRepository.getOne(id).setName(sauce.getName());
        sauceRepository.getOne(id).setPrice(sauce.getPrice());
        sauceRepository.flush();
    }

    @Transactional
    public void delete(Long id){
        sauceRepository.deleteById(id);
        sauceRepository.flush();
    }
}
