package com.br.generation.BackEnd.Farmacia.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.br.generation.BackEnd.Farmacia.Model.Produto;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long>{

	public Produto findByNomeContainingIgnoreCase(String nome);
}
