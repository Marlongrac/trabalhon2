package edu.fae.trabalho.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import edu.fae.trabalho.model.Categoria;
import edu.fae.trabalho.model.Message;
import edu.fae.trabalho.repository.CategoriaRepository;

@RestController
@RequestMapping("/api/categorias")
public class CategoriaController {
	@Autowired CategoriaRepository categoriaRepository;

	@RequestMapping(value="", method=RequestMethod.GET)
	public List<Categoria> find() {
		return categoriaRepository.findAll();	
	}

	@RequestMapping(value="", method=RequestMethod.POST)
	public Categoria save(@RequestBody Categoria categoria) {
		categoriaRepository.save(categoria);
		return categoria;
	}	

	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public Categoria show(@PathVariable Long id) {
		return categoriaRepository.findOne(id);
	}

	@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
	public Message delete(@PathVariable Long id) {
		categoriaRepository.delete(id);
		return Message.OK;
	}	

}
