package com.br.generation.BackEnd.Farmacia.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.br.generation.BackEnd.Farmacia.Model.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
	
	public Categoria findByFabricanteContainingIgnoreCase(String fabricante);

}
