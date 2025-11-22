package br.com.fatec.modulo2_1.controller.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record UsuarioRequest(
        @NotBlank(message = "Nome de usuário é necessário")
        String username,
        @NotBlank(message = "Senha é necessária")
        @Size(min = 6, message = "Senha precisa ter ao menos 6 digitos")
        String password
) {
}
