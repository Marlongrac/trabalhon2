package edu.fae.trabalho.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Produto {
	@Id
	@GeneratedValue
	private Long id;
	private String nomeProd;
	private String descProd;
	private double valor;
	
	@ManyToOne
	private Categoria categoria;
	
	@ManyToOne
	private Marca marca;
		
	
	public Produto(){
		
	}

	public Produto(String nomeProd, String descProd, double valor, Categoria categoria, Marca marca) {
		super();
		this.nomeProd = nomeProd;
		this.descProd = descProd;
		this.valor = valor;
		this.categoria = categoria;
		this.marca = marca;
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNomeProd() {
		return nomeProd;
	}
	public void setNomeProd(String nomeProd) {
		this.nomeProd = nomeProd;
	}
	public String getDescProd() {
		return descProd;
	}
	public void setDescProd(String descProd) {
		this.descProd = descProd;
	}
	public double getValor() {
		return valor;
	}
	public void setValor(double valor) {
		this.valor = valor;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public Marca getMarca() {
		return marca;
	}

	public void setMarca(Marca marca) {
		this.marca = marca;
	}

	
}

