package br.com.fatec.modulo2_1.controller;

import br.com.fatec.modulo2_1.controller.adapter.UsuarioControllerAdapter;
import br.com.fatec.modulo2_1.controller.request.LoginRequest;
import br.com.fatec.modulo2_1.controller.response.AuthResponse;
import br.com.fatec.modulo2_1.entity.Token;
import br.com.fatec.modulo2_1.security.TokenSecurity;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/auth")
public class AuthController {
    private final TokenSecurity tokenSecurity;

    public AuthController(TokenSecurity tokenSecurity) {
        this.tokenSecurity = tokenSecurity;
    }

    @ResponseStatus(HttpStatus.OK)
    @PostMapping("/login")
    public AuthResponse login(@RequestBody LoginRequest request) {
        Token token = tokenSecurity.gerarToken(UsuarioControllerAdapter.toDomain(request));
        return new AuthResponse(token.value());
    }

}
