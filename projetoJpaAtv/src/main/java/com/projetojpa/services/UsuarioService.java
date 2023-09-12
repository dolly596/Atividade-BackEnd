package com.projetojpa.services;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projetojpa.entities.Usuario;
import com.projetojpa.repository.UsuarioRepository;

@Service
public class UsuarioService {
    private final UsuarioRepository usuarioRepository;

    //construtor que recebe a dependencia
    @Autowired
    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public Usuario saveProduto(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    public Usuario getProdutoById(Long id) {
        return usuarioRepository.findById(id).orElse(null);
    }

    public List<Usuario> getAllProdutos() {
        return usuarioRepository.findAll();
    }

    public void deleteProduto(Long id) {
    	usuarioRepository.deleteById(id);
    }
}