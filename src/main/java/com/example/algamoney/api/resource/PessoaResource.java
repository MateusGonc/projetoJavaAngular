package com.example.algamoney.api.resource;

import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.algamoney.api.event.RecursoCriadoEvent;
import com.example.algamoney.api.model.Pessoa;
import com.example.algamoney.api.repository.PessoaRepository;
import com.example.algamoney.api.service.PessoaService;

@RestController
@RequestMapping("/pessoas")
public class PessoaResource {
	
	@Autowired
	private PessoaRepository pessoaRepository;
	
	@Autowired
	private ApplicationEventPublisher publisher;
	
	@Autowired
	private PessoaService pessoaService;
	
	@GetMapping
	public List<Pessoa> Listar(){
		return pessoaRepository.findAll();
	}
	
	@PostMapping
	public ResponseEntity<?> criar (@Valid @RequestBody Pessoa pessoa, HttpServletResponse response){
		
		Pessoa pessoaSalva = pessoaRepository.save(pessoa);
		
		publisher.publishEvent(new RecursoCriadoEvent(this, response, pessoaSalva.getCode()));
		
		return ResponseEntity.status(HttpStatus.CREATED).body(pessoaSalva);
	}
	
	@GetMapping("/{code}")
	public ResponseEntity<?> buscarPeloCodigo(@PathVariable Long code){
		
		Optional<Pessoa> PessoaBusca = pessoaRepository.findById(code);
		
		if (!PessoaBusca.isPresent()){
			return ResponseEntity.notFound().build();
		}
		
		return ResponseEntity.status(HttpStatus.OK).body(PessoaBusca);		
	}
	
	@DeleteMapping("/{code}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void remover(@PathVariable Long code){		
		pessoaRepository.deleteById(code);
	}
	
	@PutMapping("/{code}")
	public ResponseEntity<?> atualizar(@PathVariable Long code, @Valid @RequestBody Pessoa pessoa){
		
		Pessoa pessoaSalva = pessoaService.atualizar(code, pessoa);
		
		return ResponseEntity.ok(pessoaSalva);		
		
	}
	
	@PutMapping("/{code}/ativo")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void atualizarPropriedadeAtivo(@PathVariable Long code, @RequestBody Boolean ativo){
		pessoaService.atualizarPropriedadeAtivo(code, ativo);
	}
	
}
