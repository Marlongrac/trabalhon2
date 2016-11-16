package edu.fae.trabalho.model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;



@Entity
public class Grupo {
	@Id
	@GeneratedValue
	private Long id;
	private String nomeGrupo;

	public Grupo(){
	}

	public Grupo(String nomeGrupo) {
		super();
		this.nomeGrupo = nomeGrupo;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNomeGrupo() {
		return nomeGrupo;
	}

	public void setNomeGrupo(String nomeGrupo) {
		this.nomeGrupo = nomeGrupo;
	}

}
