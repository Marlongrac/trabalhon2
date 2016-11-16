package edu.fae.trabalho.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import edu.fae.trabalho.model.Marca;
import edu.fae.trabalho.model.Message;
import edu.fae.trabalho.repository.MarcaRepository;

@RestController
@RequestMapping("/api/marcas")
public class MarcaController {
	@Autowired MarcaRepository marcaRepository;

	@RequestMapping(value="", method=RequestMethod.GET)
	public List<Marca> find() {
		return marcaRepository.findAll();	
	}

	@RequestMapping(value="", method=RequestMethod.POST)
	public Marca save(@RequestBody Marca marca) {
		marcaRepository.save(marca);
		return marca;
	}	

	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public Marca show(@PathVariable Long id) {
		return marcaRepository.findOne(id);
	}

	@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
	public Message delete(@PathVariable Long id) {
		marcaRepository.delete(id);
		return Message.OK;
	}	
}






