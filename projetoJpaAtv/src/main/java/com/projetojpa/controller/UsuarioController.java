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

import com.projetojpa.entities.Usuario;
import com.projetojpa.services.UsuarioService;

@RestController
@RequestMapping("/produtos")

public class UsuarioController {
    
	private final UsuarioService usuarioService;

    @Autowired // Injeção de dependencia por construtor
    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @PostMapping
    public Usuario createProduct(@RequestBody Usuario usuario) {
        return usuarioService.saveProduto(usuario);
    }

    @GetMapping("/{id}")
    public Usuario getProduto(@PathVariable Long id) {
        return usuarioService.getProdutoById(id);
    }

    @GetMapping
    public List<Usuario> getAllProdutos() {
        return usuarioService.getAllProdutos();
    }

    @DeleteMapping("/{id}")
    public void deleteProduto(@PathVariable Long id) {
    	usuarioService.deleteProduto(id);
    }
}