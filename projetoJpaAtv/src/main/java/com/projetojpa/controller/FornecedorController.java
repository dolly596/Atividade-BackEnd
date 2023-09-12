package com.projetojpa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projetojpa.entities.Fornecedor;
import com.projetojpa.services.FornecedorService;

@RestController
@RequestMapping("/produtos")

public class FornecedorController {
    
	private final FornecedorService fornecedorService;

    @Autowired // Injeção de dependencia por construtor
    public FornecedorController(FornecedorService fornecedorService) {
        this.fornecedorService = fornecedorService;
    }

    @PostMapping
    public Fornecedor createProduct(@RequestBody Fornecedor fornecedor) {
        return fornecedorService.saveProduto(fornecedor);
    }

    @GetMapping("/{id}")
    public Fornecedor getProduto(@PathVariable Long id) {
        return fornecedorService.getProdutoById(id);
    }

    @GetMapping
    public List<Fornecedor> getAllProdutos() {
        return fornecedorService.getAllProdutos();
    }

    @DeleteMapping("/{id}")
    public void deleteProduto(@PathVariable Long id) {
    	fornecedorService.deleteProduto(id);
    }
}