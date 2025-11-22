package br.com.fatec.modulo2_1.security;

import br.com.fatec.modulo2_1.entity.Usuario;
import br.com.fatec.modulo2_1.repository.UsuarioRepository;
import br.com.fatec.modulo2_1.security.dto.AuthUsuarioDetails;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UsuarioDetailsServiceImpl implements UserDetailsService {

    private final UsuarioRepository repository;

    public UsuarioDetailsServiceImpl(UsuarioRepository repository) {
        this.repository = repository;
    }

    @Override
    public UserDetails loadUserByUsername(String username)
            throws UsernameNotFoundException {

        Usuario usuario = repository.findByUsername(username);

        if (usuario == null) {
            throw new UsernameNotFoundException("Usuário não encontrado: " + username);
        }

        return new AuthUsuarioDetails(usuario);
    }
}
