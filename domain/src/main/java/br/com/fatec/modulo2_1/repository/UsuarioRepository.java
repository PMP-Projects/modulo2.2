package br.com.fatec.modulo2_1.repository;

import br.com.fatec.modulo2_1.entity.Usuario;

public interface UsuarioRepository {
    Usuario save(Usuario usuario);

    Usuario findByUsername(String username);
}
