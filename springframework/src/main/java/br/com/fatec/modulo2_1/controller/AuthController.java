package br.com.fatec.modulo2_1.controller;

import br.com.fatec.modulo2_1.controller.adapter.UsuarioControllerAdapter;
import br.com.fatec.modulo2_1.controller.request.LoginRequest;
import br.com.fatec.modulo2_1.controller.response.AuthResponse;
import br.com.fatec.modulo2_1.entity.Token;
import br.com.fatec.modulo2_1.security.TokenSecurity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/modulo-auth/api/v1/auth")
public class AuthController {
    private final TokenSecurity tokenSecurity;

    private static final Logger log = LoggerFactory.getLogger(AuthController.class);

    public AuthController(TokenSecurity tokenSecurity) {
        this.tokenSecurity = tokenSecurity;
    }

    @ResponseStatus(HttpStatus.OK)
    @PostMapping("/login")
    public AuthResponse login(@RequestBody LoginRequest request) {
        Token token = tokenSecurity.gerarToken(UsuarioControllerAdapter.toDomain(request));
        log.info(
                "\nRecebendo tentativa de login do usuário:\nNome do Cliente: {}",
                request.username()
        );
        return new AuthResponse(token.value());
    }

}
