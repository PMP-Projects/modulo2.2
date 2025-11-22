package br.com.fatec.modulo2_1.repository.adapter;

import br.com.fatec.modulo2_1.entity.Usuario;
import br.com.fatec.modulo2_1.repository.orm.UsuarioOrm;

public final class UsuarioRepositoryImplAdapter {
    private UsuarioRepositoryImplAdapter() {}

    public static UsuarioOrm toOrm(Usuario usuario, String encodedPassword) {
        return new UsuarioOrm(
                usuario.id(),
                usuario.username(),
                encodedPassword
        );
    }

    public static Usuario toDomain(UsuarioOrm orm) {
        // ORM already contains encoded password; do NOT re-encode here
        return new Usuario(
                orm.id(),
                orm.username(),
                orm.password()
        );
    }
}
