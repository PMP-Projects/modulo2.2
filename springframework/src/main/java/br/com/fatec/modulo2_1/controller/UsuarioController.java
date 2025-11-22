package br.com.fatec.modulo2_1.controller;

import br.com.fatec.modulo2_1.controller.adapter.UsuarioControllerAdapter;
import br.com.fatec.modulo2_1.controller.request.UsuarioRequest;
import br.com.fatec.modulo2_1.controller.response.UsuarioResponse;
import br.com.fatec.modulo2_1.entity.Usuario;
import br.com.fatec.modulo2_1.repository.UsuarioRepository;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/user")
public class UsuarioController {
    private final UsuarioRepository repository;

    public UsuarioController(UsuarioRepository repository) {
        this.repository = repository;
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/save")
    public UsuarioResponse save(@Valid @RequestBody UsuarioRequest request) {
        Usuario saved = repository.save(UsuarioControllerAdapter.toDomain(request));
        return new UsuarioResponse(saved.id(), saved.username());
    }

    /**
     * endpoint para testar autenticação. Retorna o username do token.
     */
    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/me")
    public UsuarioResponse me(@AuthenticationPrincipal UserDetails userDetails) {
        if (userDetails == null) {
            return new UsuarioResponse(null, null);
        }
        return new UsuarioResponse(null, userDetails.getUsername());
    }
}
