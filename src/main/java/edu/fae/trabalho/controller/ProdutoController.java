package edu.fae.trabalho.controller;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import edu.fae.trabalho.model.Message;
import edu.fae.trabalho.model.Produto;
import edu.fae.trabalho.repository.ProdutoRepository;
import edu.fae.trabalho.service.FilesService;


@RestController
@RequestMapping("/api/produtos")
public class ProdutoController {
	@Autowired ProdutoRepository produtoRepository;
	@Autowired FilesService filesService;
	
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
	
	@RequestMapping(value="/{id}/upload", method=RequestMethod.POST)
	public Produto upload(@PathVariable Long id, @RequestParam("file") MultipartFile file) 
			throws IOException {
		Produto produto = produtoRepository.findOne(id);
		
		String imageName = filesService.saveFile(file);
		produto.setImagem(imageName);
		
		produtoRepository.save(produto);
		return produto;
	}
	
	@RequestMapping(value="/imagens")
	public void getImagem(@RequestParam("src") String imagem, HttpServletRequest request, 
			HttpServletResponse response) {
		filesService.showFile(imagem, request, response);
	}
		

}







