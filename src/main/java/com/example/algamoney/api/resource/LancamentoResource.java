package com.example.algamoney.api.resource;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.algamoney.api.model.Lancamento;
import com.example.algamoney.api.repository.LancamentoRepository;

@RestController
@RequestMapping("/lancamento")
public class LancamentoResource {

	@Autowired
	private LancamentoRepository lancamentoRepository;
	
	@GetMapping
	public List<Lancamento> listar(){
		return lancamentoRepository.findAll();
	}
	
	@GetMapping("/{code}")
	public ResponseEntity<?> buscarPeloCodigo(@PathVariable Long code){
		
		Optional<Lancamento> lancamentoBusca = lancamentoRepository.findById(code);
		
		if(!lancamentoBusca.isPresent()){
			return ResponseEntity.notFound().build();
		}		
		
		return ResponseEntity.status(HttpStatus.OK).body(lancamentoBusca);
	}

}
