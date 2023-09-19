package com.projetohosp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projetohosp.entities.Funcionario;
import com.projetohosp.service.FuncionarioService;

@RestController
@RequestMapping("/funcionario")
public class FuncionarioController {
	
	private final FuncionarioService funcionarioService;
	
	@Autowired
	public FuncionarioController(FuncionarioService funcionarioService) {
		this.funcionarioService = funcionarioService;
	}
	@GetMapping ("/{id}")
	public ResponseEntity<Funcionario> buscaFuncionarioIdControlId (@ PathVariable Long id) {
		Funcionario funcionario = funcionarioService.buscaFuncionarioId(id);
		if (funcionario != null) {
			return ResponseEntity.ok(funcionario);
		}
		else {
			return ResponseEntity.notFound().build();
		}
	}

	@GetMapping("/")
	public ResponseEntity<List<Funcionario>> buscaTodosFuncionarioControl(){
		List<Funcionario> funcionario = funcionarioService.buscaTodosFuncionario();
		return ResponseEntity.ok(funcionario);
	}
	@PostMapping("/")
	public ResponseEntity<Funcionario> salvaHospedeControl(@RequestBody Funcionario funcionario){
		Funcionario salvaFuncionario = funcionarioService.salvaFuncionario(funcionario);
		return ResponseEntity.status(HttpStatus.CREATED).body(salvaFuncionario);
	}
	@PutMapping("/")
	public ResponseEntity<Funcionario> alterarHospedeControl(@PathVariable Long id, @RequestBody Funcionario funcionario){
		Funcionario alterarFuncionario = funcionarioService.alterarFuncionario(id, funcionario);
		if(alterarFuncionario != null) {
			return ResponseEntity.ok(funcionario);
		}
		else {
			return ResponseEntity.notFound().build();
		}
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<String> apagaFuncionarioControl(@PathVariable Long id){
		boolean apagar = funcionarioService.apagarFuncionario(id);
		if (apagar) {
			return ResponseEntity.ok().body("O produto foi excluído com sucesso");
		}
		else {
			return ResponseEntity.notFound().build();
		}
	}
}
