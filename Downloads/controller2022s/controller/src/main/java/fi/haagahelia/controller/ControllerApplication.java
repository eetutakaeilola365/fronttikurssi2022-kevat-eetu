package fi.haagahelia.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import fi.haagahelia.controller.domain.Kategoria;
import fi.haagahelia.controller.domain.KategoriaRepository;
import fi.haagahelia.controller.domain.Viesti;
import fi.haagahelia.controller.domain.ViestiRepository;
import fi.haagahelia.controller.domain.User;
import fi.haagahelia.controller.domain.UserRepository;

@SpringBootApplication
public class ControllerApplication {
	private static final Logger log = LoggerFactory.getLogger(ControllerApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(ControllerApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner studentDemo(ViestiRepository vrepository, KategoriaRepository krepository, UserRepository urepository) {
		return (args) -> {
			log.info("save a couple of students");
			krepository.save(new Kategoria(null, "Formulat"));
			krepository.save(new Kategoria(null, "Talous"));
			krepository.save(new Kategoria(null, "Perhe"));
			
			vrepository.save(new Viesti("jotain", "jotain",krepository.findByNimi("Formulat").get(0)));
			vrepository.save(new Viesti("jotain", "jotain", krepository.findByNimi("Talous").get(0)));	
			
			User user1 = new User("user", "$2a$06$3jYRJrg0ghaaypjZ/.g4SethoeA51ph3UD4kZi9oPkeMTpjKU5uo6", "USER");
			User user2 = new User("admin", "$2a$10$0MMwY.IQqpsVc1jC8u7IJ.2rT8b0Cd3b3sfIBGV2zfgnPGtT4r0.C", "ADMIN");
			urepository.save(user1);
			urepository.save(user2);
			
			log.info("fetchaa viestit");
			for (Viesti viesti : vrepository.findAll()) {
				log.info(viesti.toString());
			}

		};
	}
}
					
		
