package edu.fae.trabalho.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Marca {
	@Id
	@GeneratedValue
	private Long id;
	private String nomeMarca;
	private String descMarca;
	
	
	public Long getId() {
		return id;
	}

	public Marca(String nomeMarca, String descMarca) {
			super();
			this.nomeMarca = nomeMarca;
			this.descMarca = descMarca;
		}
	
	public Marca(){
		
	}


	public void setId(Long id) {
		this.id = id;
	}

	public String getNomeMarca() {
		return nomeMarca;
	}

	public void setNomeMarca(String nomeMarca) {
		this.nomeMarca = nomeMarca;
	}

	public String getDescMarca() {
		return descMarca;
	}

	public void setDescMarca(String descMarca) {
		this.descMarca = descMarca;
	}

}

