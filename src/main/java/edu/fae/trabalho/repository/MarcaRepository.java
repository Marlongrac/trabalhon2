package edu.fae.trabalho.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.fae.trabalho.model.Marca;

@Repository
public interface MarcaRepository extends JpaRepository<Marca, Long> {

}
