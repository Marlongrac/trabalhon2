package edu.fae.trabalho.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import edu.fae.trabalho.model.Message;
import edu.fae.trabalho.model.Produto;
import edu.fae.trabalho.repository.ProdutoRepository;


@RestController
@RequestMapping("/api/produtos")
public class ProdutoController {
	@Autowired ProdutoRepository produtoRepository;
	@RequestMapping(value="", method=RequestMethod.GET)
	public List<Produto> find(@RequestParam(required=false)String texto) {
		if(texto!=null){
			return produtoRepository.findBynomeProdLike("%" + texto + "%");
		}else{
		return produtoRepository.findAll();
		}

	}

	@RequestMapping(value="", method=RequestMethod.POST)
	public Produto save(@RequestBody Produto produto) {
		produtoRepository.save(produto);
		return produto;
	}	

	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public Produto show(@PathVariable Long id) {
		return produtoRepository.findOne(id);
	}

	@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
	public Message delete(@PathVariable Long id) {
		produtoRepository.delete(id);
		return Message.OK;
	}	

}







