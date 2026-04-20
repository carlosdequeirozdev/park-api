package com.queirozdec.park_api.service;

import com.queirozdec.park_api.entity.Usuario;
import com.queirozdec.park_api.repository.UsuarioRepository;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Service
@Getter
@Setter
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;

    @Transactional
    public Usuario salvar(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    @Transactional(readOnly = true)
    public Usuario buscarPorId(Long id) {
        return usuarioRepository.findById(id).orElseThrow(
                () -> new RuntimeException("Usuario nao encontrado")
        );

    }
    @Transactional
    public Usuario editPassword(Long id, String senhaAtual, String novaSenha, String confirmarSenha) {
        if(!novaSenha.equals(confirmarSenha)){
            throw new RuntimeException("A nova senha não corresponde à confirmação.");
        }
        Usuario user = buscarPorId(id);
        if(!user.getPassword().equals(senhaAtual)){
            throw new RuntimeException("Sua senha não confere.");
        }
        user.setPassword(novaSenha);
        return user;
    }
    @Transactional(readOnly = true)
    public List<Usuario> listAllUser(){
        return usuarioRepository.findAll();
    }
}
