package br.com.fatec.modulo2_1.controller;

import br.com.fatec.modulo2_1.controller.adapter.UsuarioControllerAdapter;
import br.com.fatec.modulo2_1.controller.request.UsuarioRequest;
import br.com.fatec.modulo2_1.controller.response.UsuarioResponse;
import br.com.fatec.modulo2_1.entity.Usuario;
import br.com.fatec.modulo2_1.repository.UsuarioRepository;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/modulo-auth/api/v1/user")
public class UsuarioController {
    private final UsuarioRepository repository;

    private static final Logger log = LoggerFactory.getLogger(UsuarioController.class);

    public UsuarioController(UsuarioRepository repository) {
        this.repository = repository;
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/save")
    public UsuarioResponse save(@Valid @RequestBody UsuarioRequest request) {
        Usuario saved = repository.save(UsuarioControllerAdapter.toDomain(request));
        log.info(
                "\nRecebendo cadastro de usuário:\nNome do Cliente: {}",
                request.username()
        );
        return new UsuarioResponse(saved.id(), saved.username());
    }
}
