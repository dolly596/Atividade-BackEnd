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

import com.projetohosp.entities.Aposento;
import com.projetohosp.service.AposentoService;

@RestController
@RequestMapping("/aposento")
public class AposentoController {
	
	private final AposentoService aposentoService;
	
	@Autowired
	public AposentoController(AposentoService aposentoService) {
		this.aposentoService = aposentoService;
	}
	@GetMapping ("/{id}")
	public ResponseEntity<Aposento> buscaAposentoIdControlId (@ PathVariable Long id) {
		Aposento aposento = aposentoService.buscaAposentoId(id);
		if (aposento != null) {
			return ResponseEntity.ok(aposento);
		}
		else {
			return ResponseEntity.notFound().build();
		}
	}

	@GetMapping("/")
	public ResponseEntity<List<Aposento>> buscaTodosAposentoControl(){
		List<Aposento> aposento = aposentoService.buscaTodosAposento();
		return ResponseEntity.ok(aposento);
	}
	@PostMapping("/")
	public ResponseEntity<Aposento> salvaAposentoControl(@RequestBody Aposento aposento){
		Aposento salvaAposento = aposentoService.salvaAposento(aposento);
		return ResponseEntity.status(HttpStatus.CREATED).body(salvaAposento);
	}
	@PutMapping("/")
	public ResponseEntity<Aposento> alterarAposentoControl(@PathVariable Long id, @RequestBody Aposento aposento){
		Aposento alterarAposento = aposentoService.alterarAposento(id, aposento);
		if(alterarAposento != null) {
			return ResponseEntity.ok(aposento);
		}
		else {
			return ResponseEntity.notFound().build();
		}
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<String> apagaAposentoControl(@PathVariable Long id){
		boolean apagar = aposentoService.apagarAposento(id);
		if (apagar) {
			return ResponseEntity.ok().body("O produto foi excluído com sucesso");
		}
		else {
			return ResponseEntity.notFound().build();
		}
	}
}
