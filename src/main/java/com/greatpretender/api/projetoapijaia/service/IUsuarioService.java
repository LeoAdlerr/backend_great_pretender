package com.greatpretender.api.projetoapijaia.service;

import java.util.List;

import com.greatpretender.api.projetoapijaia.entity.Usuario;

public interface IUsuarioService {
    public Usuario buscarPorId(Long id);
    public Usuario novoUsuario(Usuario usuario);
    public List<Usuario> buscarTodosUsuarios();
    public Usuario deletarPorId(Long id);
    public Usuario buscarPorNome(String nome);

}
