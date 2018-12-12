package springboot.my_first_application.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import springboot.my_first_application.model.Maschine;
import springboot.my_first_application.repository.MaschineRepository;

@RestController
@RequestMapping("api/v1/")
public class MaschineController {
  
    @Autowired
    private MaschineRepository maschineRepository;
    @RequestMapping(value = "maschines", method = RequestMethod.GET)
    public List<Maschine> list(){
      return maschineRepository.findAll();
    }
    @RequestMapping(value = "maschines", method = RequestMethod.POST)
    public Maschine create(@RequestBody Maschine maschine){
      return maschineRepository.save(maschine);
    }
    @RequestMapping(value = "maschines/{id}", method = RequestMethod.GET)
    public Optional<Maschine> get(@PathVariable Long id){
      return maschineRepository.findById(id);
    }
    @RequestMapping(value = "maschines/{id}", method = RequestMethod.PUT)
    public Maschine update(@PathVariable Long id, @RequestBody Maschine maschine){    
      
      Optional<Maschine> exsistingMaschine = maschineRepository.findById(id);
      BeanUtils.copyProperties(maschine, exsistingMaschine);
 
      return maschineRepository.save(maschine);
    }
    @RequestMapping(value = "maschines/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable Long id){
      Maschine exsistingMaschine = maschineRepository.getOne(id);
      
      maschineRepository.delete(exsistingMaschine);
    }
  
}