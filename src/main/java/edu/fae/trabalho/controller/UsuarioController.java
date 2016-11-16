package edu.fae.trabalho.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import edu.fae.trabalho.model.Message;
import edu.fae.trabalho.model.Usuario;
import edu.fae.trabalho.repository.UsuarioRepository;


@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {
	@Autowired UsuarioRepository usuarioRepository;

	@RequestMapping(value="", method=RequestMethod.GET)
	public List<Usuario> find() {
		return usuarioRepository.findAll();	
	}

	@RequestMapping(value="", method=RequestMethod.POST)
	public Usuario save(@RequestBody Usuario usuario) {
		usuarioRepository.save(usuario);
		return usuario;
	}	

	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public Usuario show(@PathVariable Long id) {
		return usuarioRepository.findOne(id);
	}

	@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
	public Message delete(@PathVariable Long id) {
		usuarioRepository.delete(id);
		return Message.OK;
	}	

}

