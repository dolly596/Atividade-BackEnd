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

import com.projetohosp.entities.Hospede;
import com.projetohosp.service.HospedeService;

@RestController
@RequestMapping("/hospedagem")
public class HospedeController {
	
	private final HospedeService hospedeService;
	
	@Autowired
	public HospedeController(HospedeService hospedeService) {
		this.hospedeService = hospedeService;
	}
	@GetMapping ("/{id}")
	public ResponseEntity<Hospede> buscaProdutoIdControlId (@ PathVariable Long id) {
		Hospede hospede = hospedeService.buscaHospedeId(id);
		if (hospede != null) {
			return ResponseEntity.ok(hospede);
		}
		else {
			return ResponseEntity.notFound().build();
		}
	}

	@GetMapping("/")
	public ResponseEntity<List<Hospede>> buscaTodosHospedeControl(){
		List<Hospede> hospede = hospedeService.buscaTodosHospedes();
		return ResponseEntity.ok(hospede);
	}
	@PostMapping("/")
	public ResponseEntity<Hospede> salvaHospedeControl(@RequestBody Hospede hospede){
		Hospede salvaHospede = hospedeService.salvaHospede(hospede);
		return ResponseEntity.status(HttpStatus.CREATED).body(salvaHospede);
	}
	@PutMapping("/")
	public ResponseEntity<Hospede> alterarHospedeControl(@PathVariable Long id, @RequestBody Hospede hospede){
		Hospede alterarHospede = hospedeService.alterarHospede(id, hospede);
		if(alterarHospede != null) {
			return ResponseEntity.ok(hospede);
		}
		else {
			return ResponseEntity.notFound().build();
		}
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<String> apagaHospedeControl(@PathVariable Long id){
		boolean apagar = hospedeService.apagarHospede(id);
		if (apagar) {
			return ResponseEntity.ok().body("O produto foi excluído com sucesso");
		}
		else {
			return ResponseEntity.notFound().build();
		}
	}
}
