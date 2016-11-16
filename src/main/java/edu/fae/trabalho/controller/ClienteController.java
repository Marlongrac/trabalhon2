package edu.fae.trabalho.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import edu.fae.trabalho.model.Cliente;
import edu.fae.trabalho.model.Message;
import edu.fae.trabalho.repository.ClienteRepository;


@RestController
@RequestMapping("/api/clientes")
public class ClienteController {
	@Autowired ClienteRepository clienteRepository;

	@RequestMapping(value="", method=RequestMethod.GET)
	public List<Cliente> find() {
		return clienteRepository.findAll();	
	}

	@RequestMapping(value="", method=RequestMethod.POST)
	public Cliente save(@RequestBody Cliente cliente) {
		clienteRepository.save(cliente);
		return cliente;
	}	

	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public Cliente show(@PathVariable Long id) {
		return clienteRepository.findOne(id);
	}

	@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
	public Message delete(@PathVariable Long id) {
		clienteRepository.delete(id);
		return Message.OK;
	}

}







