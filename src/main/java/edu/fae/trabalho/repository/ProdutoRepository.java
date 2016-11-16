package edu.fae.trabalho.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.fae.trabalho.model.Produto;


@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long>{
	public List<Produto>findBynomeProdLike(String produto);

}
