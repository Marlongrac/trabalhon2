package edu.fae.trabalho.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Usuario {
	@Id
	@GeneratedValue
	private Long id;
	private String nome;
	
	@ManyToMany
	private List<Grupo> grupos = new ArrayList<Grupo>();

	public Usuario(){
	}	
	
	public Usuario(String nome, List<Grupo> grupos) {
		super();
		this.nome = nome;
		this.grupos = grupos;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<Grupo> getGrupos() {
		return grupos;
	}

	public void setGrupos(List<Grupo> grupos) {
		this.grupos = grupos;
	}
	

}

