package fi.haagahelia.controller.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface ViestiRepository extends CrudRepository<Viesti, Long> {

    List<Viesti> findByTeksti(String teksti);
    
}