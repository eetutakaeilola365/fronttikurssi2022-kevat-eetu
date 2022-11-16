package fi.haagahelia.controller.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import fi.haagahelia.controller.domain.KategoriaRepository;
import fi.haagahelia.controller.domain.Viesti;
import fi.haagahelia.controller.domain.ViestiRepository;

@Controller
public class ControllerController {
	@Autowired
	private ViestiRepository repository; 

	@Autowired
	private KategoriaRepository krepository; 
	
    @RequestMapping(value="/login")
    public String login() {	
        return "login";
    }	
	
    @RequestMapping(value="/jutteluohjelma")
    public String jutteluohjelma(Model model) {	
        model.addAttribute("Viesti", repository.findAll());
        return "jutteluohjelma";
    }
  
    @RequestMapping(value="/viestit")
    public @ResponseBody List<Viesti> jutteluohjelmaRest() {	
        return (List<Viesti>) repository.findAll();
    }    

	
    @RequestMapping(value="/viesti/{id}", method = RequestMethod.GET)
    public @ResponseBody Optional<Viesti> findViestiRest(@PathVariable("id") Long Id) {	
    	return repository.findById(Id);
    }       
    
    @RequestMapping(value = "/uusiViesti")
    public String addViesti(Model model){
    	model.addAttribute("viesti", new Viesti());
    	model.addAttribute("kategoria", krepository.findAll());
        return "uusiViesti";
    }     
    
    @RequestMapping(value = "/tallenna", method = RequestMethod.POST)
    public String save(Viesti viesti){
        repository.save(viesti);
        return "redirect:jutteluohjelma";
    }    

    @PreAuthorize("hasAuthority('ADMIN')")
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public String deleteViesti(@PathVariable("id") Long Id, Model model) {
    	repository.deleteById(Id);
        return "redirect:../jutteluohjelma";
    }     
}
