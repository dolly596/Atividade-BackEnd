package com.projetojpa.services;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projetojpa.entities.Fornecedor;
import com.projetojpa.repository.FornecedorRepository;

@Service
public class FornecedorService {
    private final FornecedorRepository fornecedorRepository;

    //construtor que recebe a dependencia
    @Autowired
    public FornecedorService(FornecedorRepository fornecedorRepository) {
        this.fornecedorRepository = fornecedorRepository;
    }

    public Fornecedor saveProduto(Fornecedor fornecedor) {
        return fornecedorRepository.save(fornecedor);
    }

    public Fornecedor getProdutoById(Long id) {
        return fornecedorRepository.findById(id).orElse(null);
    }

    public List<Fornecedor> getAllProdutos() {
        return fornecedorRepository.findAll();
    }

    public void deleteProduto(Long id) {
    	fornecedorRepository.deleteById(id);
    }
}