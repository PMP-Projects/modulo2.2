package br.com.fatec.modulo2_1.controller.adapter;

import br.com.fatec.modulo2_1.controller.request.LoginRequest;
import br.com.fatec.modulo2_1.controller.request.UsuarioRequest;
import br.com.fatec.modulo2_1.entity.Usuario;

import java.util.UUID;

public final class UsuarioControllerAdapter {
    private UsuarioControllerAdapter() {}

    /** usado no cadastro: cria id */
    public static Usuario toDomain(UsuarioRequest request) {
        return new Usuario(
                UUID.randomUUID().toString(),
                request.username(),
                request.password()
        );
    }

    /** usado no login: id desnecessário */
    public static Usuario toDomain(LoginRequest request) {
        return new Usuario(
                null,
                request.username(),
                request.password()
        );
    }
}
