package fi.haagahelia.controller.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Kategoria {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	private Long kategoriaid;
	private String nimi;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "kategoria")
	private List<Viesti> viestit;
	
	public Kategoria() {}
	
	public Kategoria(List<Viesti> viestit,String nimi) {
		super();
		this.viestit = viestit;
		this.nimi = nimi;
	}
	
	public Long getKategoriaid() {
		return kategoriaid;
	}
	
	public void setKategoriaid(Long kategoriaid) {
		this.kategoriaid = kategoriaid;
	}
	
	public String getNimi() {
		return nimi;
	}
	
	public void setNimi(String nimi) {
		this.nimi = nimi;
	}

	public List<Viesti> getViesti() {
		return viestit;
	}

	public void setViesti(List<Viesti> viestit) {
		this.viestit = viestit;
	}

	@Override
	public String toString() {
		return "Kategoria [kategoriaid=" + kategoriaid + ", nimi=" + nimi + "]";
	}
}

