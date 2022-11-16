package fi.haagahelia.controller.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Viesti {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    private String otsikko;
    private String teksti;
    
    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "kategoriaid")
    private Kategoria kategoria;

    public Viesti() {}

	public Viesti(String otsikko, String teksti, Kategoria kategoria) {
		super();
		this.otsikko = otsikko;
		this.teksti = teksti;
		this.kategoria = kategoria;
	}

	public Long id() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getotsikko() {
		return otsikko;
	}

	public void setotsikko(String otsikko) {
		this.otsikko = otsikko;
	}

	public String getTeksti() {
		return teksti;
	}

	public void setTeksti(String teksti) {
		this.teksti = teksti;
	}

	public Kategoria getKategoria() {
		return kategoria;
	}

	public void setKategoria(Kategoria kategoria) {
		this.kategoria = kategoria;
	}

	@Override
	public String toString() {
		if (this.kategoria != null)
			return "Student [id=" + id + ", otsikko=" + otsikko + ", teksti=" + teksti + " kategoria =" + this.getKategoria() + "]";		
		else
			return "Student [id=" + id + ", otsikko=" + otsikko + ", teksti=" + teksti  + "]";
	}
}
