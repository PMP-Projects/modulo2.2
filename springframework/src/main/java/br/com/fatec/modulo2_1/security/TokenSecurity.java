package br.com.fatec.modulo2_1.security;

import br.com.fatec.modulo2_1.entity.Token;
import br.com.fatec.modulo2_1.entity.Usuario;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;

@Component
public class TokenSecurity {
    private final JwtSecurity jwtSecurity;
    private final UserDetailsService userDetailsService;
    private final AuthenticationManager authenticationManager;

    public TokenSecurity(
            JwtSecurity jwtSecurity,
            UserDetailsService userDetailsService,
            AuthenticationManager authenticationManager) {
        this.jwtSecurity = jwtSecurity;
        this.userDetailsService = userDetailsService;
        this.authenticationManager = authenticationManager;
    }

    /**
     * autentica e gera token. Recebe um User cujo username e password são usados para autenticar.
     */
    public Token gerarToken(Usuario usuario) {
        UsernamePasswordAuthenticationToken authToken =
                new UsernamePasswordAuthenticationToken(usuario.username(), usuario.password());
        authenticationManager.authenticate(authToken); // lança exceção se inválido

        UserDetails userDetails = userDetailsService.loadUserByUsername(usuario.username());
        return new Token(jwtSecurity.generateToken(userDetails));
    }
}
