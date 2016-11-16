package edu.fae.trabalho.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import edu.fae.trabalho.model.Grupo;
import edu.fae.trabalho.model.Message;
import edu.fae.trabalho.repository.GrupoRepository;


@RestController
@RequestMapping("/api/grupos")
public class GrupoController {
	@Autowired GrupoRepository grupoRepository;

	@RequestMapping(value="", method=RequestMethod.GET)
	public List<Grupo> find() {
		return grupoRepository.findAll();	
	}

	@RequestMapping(value="", method=RequestMethod.POST)
	public Grupo save(@RequestBody Grupo grupo) {
		grupoRepository.save(grupo);
		return grupo;
	}	

	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public Grupo show(@PathVariable Long id) {
		return grupoRepository.findOne(id);
	}

	@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
	public Message delete(@PathVariable Long id) {
		grupoRepository.delete(id);
		return Message.OK;
	}	
}





