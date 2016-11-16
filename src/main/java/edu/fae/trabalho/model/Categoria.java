package edu.fae.trabalho.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Categoria {
	@Id
	@GeneratedValue
	private Long id;
	private String nomeCat;
	private String descCat;
	
	public Categoria(){
		
	}
	
	public Categoria(String nomeCat, String descCat) {
		super();
		this.nomeCat = nomeCat;
		this.descCat = descCat;
	}
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNomeCat() {
		return nomeCat;
	}

	public void setNomeCat(String nomeCat) {
		this.nomeCat = nomeCat;
	}

	public String getDescCat() {
		return descCat;
	}

	public void setDescCat(String descCat) {
		this.descCat = descCat;
	}

}
