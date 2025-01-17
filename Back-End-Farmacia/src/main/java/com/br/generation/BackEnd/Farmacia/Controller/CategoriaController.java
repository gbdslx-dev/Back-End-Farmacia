package com.br.generation.BackEnd.Farmacia.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.br.generation.BackEnd.Farmacia.Model.Categoria;
import com.br.generation.BackEnd.Farmacia.Repository.CategoriaRepository;

@RestController
@RequestMapping("/categoria")
@CrossOrigin("*")
public class CategoriaController {
	@Autowired
	private CategoriaRepository repository;
	@GetMapping
	public ResponseEntity<List<Categoria>> findAllCategoria() {
		return ResponseEntity.ok(repository.findAll());
	}

	@GetMapping("/{id}")
	public ResponseEntity<Categoria> findByIdCategoria(@PathVariable long id) {
		return repository.findById(id).map(resposta -> ResponseEntity.ok(resposta))
				.orElse(ResponseEntity.notFound().build());
	}

	@GetMapping("/fabricante/{fabricante}")
	public ResponseEntity<Categoria> findByFabricanteCategoria(@PathVariable String fabricante) {
		return ResponseEntity.ok(repository.findByFabricanteContainingIgnoreCase(fabricante));
	}

	@PostMapping
	public ResponseEntity<Categoria> postCategoria(@RequestBody Categoria categoria) {
		return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(categoria));

	}

	@PutMapping
	public ResponseEntity<Categoria> putCategoria(@RequestBody Categoria categoria) {
		return ResponseEntity.ok(repository.save(categoria));

	}

	@DeleteMapping("/{id}")
	public void deleteCategoria(@PathVariable long id) {
		repository.deleteById(id);
	}

}
