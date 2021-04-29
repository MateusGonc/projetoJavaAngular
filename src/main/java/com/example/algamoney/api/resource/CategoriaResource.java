package com.example.algamoney.api.resource;

import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.algamoney.api.event.RecursoCriadoEvent;
import com.example.algamoney.api.model.Categoria;
import com.example.algamoney.api.repository.CategoriaRepository;

@RestController
@RequestMapping("/categorias")
public class CategoriaResource {
	
	@Autowired
	private CategoriaRepository categoriaRepository;
	
	@Autowired
	private ApplicationEventPublisher publisher;
	
	@GetMapping
	public List<Categoria> listar(){
		return categoriaRepository.findAll();		 
	}
	
	@PostMapping
	public ResponseEntity<?> criar(@Valid @RequestBody Categoria categoria, HttpServletResponse response){
		
		Categoria categoriaSalva = categoriaRepository.save(categoria);
		
		publisher.publishEvent(new RecursoCriadoEvent(this, response, categoriaSalva.getCode()));
		
		return ResponseEntity.status(HttpStatus.CREATED).body(categoriaSalva);	
	}
	
	@GetMapping("/{code}")
	public ResponseEntity<?> buscarPeloCodigo(@PathVariable Long code){
		
		Optional<Categoria> CategoriaBusca = categoriaRepository.findById(code);
		
		if (!CategoriaBusca.isPresent()){
			return ResponseEntity.notFound().build();
		}
		
		return ResponseEntity.status(HttpStatus.OK).body(CategoriaBusca); 
		
	}
}
