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

import com.br.generation.BackEnd.Farmacia.Model.Produto;
import com.br.generation.BackEnd.Farmacia.Repository.ProdutoRepository;

@RestController
@RequestMapping ("/Produto")
@CrossOrigin ("*")

public class ProdutoController {
	public class Produto {

	}

	@Autowired
	private ProdutoRepository repository;
	
	@GetMapping
	public ResponseEntity<List<com.br.generation.BackEnd.Farmacia.Model.Produto>> findAllProduto(){
		return ResponseEntity.ok(repository.findAll());
	}
		@GetMapping("/{id}")
		public ResponseEntity<com.br.generation.BackEnd.Farmacia.Model.Produto> findByIdProduto(@PathVariable long id){
			return repository.findById(id).map(resposta -> ResponseEntity.ok(resposta))
					.orElse(ResponseEntity.notFound().build());
	}
		@GetMapping("/nome{nome}")
		public ResponseEntity<Produto> findBy(@PathVariable String nome){
			return ResponseEntity.notFound().build();
	}
	
		@GetMapping("/valor{valor}")
		public ResponseEntity<Produto> findBy(@PathVariable Double valor){
			return ResponseEntity.notFound().build();
	}
		@GetMapping("/validade{validade}")
		public ResponseEntity<Produto> findBy(@PathVariable int validade){
			return ResponseEntity.notFound().build();
	}
		@PostMapping
		public ResponseEntity<Produto> postProduto(@RequestBody Produto produto){
			return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(produto));
	}
		@PutMapping 
		public ResponseEntity<Produto> putProduto(@RequestBody Produto produto){
			return ResponseEntity.ok(repository.save(produto));
	}
		@DeleteMapping("{id}")
		public void deleteCategoria(@PathVariable long id) {
			repository.deleteById(id);
		}	
}


