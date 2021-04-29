package com.example.algamoney.api.service;

import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.example.algamoney.api.model.Pessoa;
import com.example.algamoney.api.repository.PessoaRepository;

@Service
public class PessoaService{
	
	@Autowired
	private PessoaRepository pessoaRepository;
	
	public Pessoa atualizar(Long code, Pessoa pessoa){
		
		Pessoa pessoaSalva = buscarPessoaPeloCodigo(code);
		
		BeanUtils.copyProperties(pessoa, pessoaSalva, "code");
		return pessoaRepository.save(pessoaSalva);
	}

	private Pessoa buscarPessoaPeloCodigo(Long code) {
		Optional<Pessoa> optionalPessoaSalva = pessoaRepository.findById(code);
		if (!optionalPessoaSalva.isPresent()){
			throw new EmptyResultDataAccessException(1);
		}
		
		Pessoa pessoaSalva = optionalPessoaSalva.get();
		return pessoaSalva;
	}

	public void atualizarPropriedadeAtivo(Long code, Boolean ativo) {
		Pessoa pessoaSalva = buscarPessoaPeloCodigo(code);
		pessoaSalva.setAtivo(ativo);
		pessoaRepository.save(pessoaSalva);		
	}
}
