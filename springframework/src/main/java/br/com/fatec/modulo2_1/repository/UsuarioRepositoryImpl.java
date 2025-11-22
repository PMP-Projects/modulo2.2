package br.com.fatec.modulo2_1.repository;

import br.com.fatec.modulo2_1.entity.Usuario;
import br.com.fatec.modulo2_1.execption.UsuarioPersistenceException;
import br.com.fatec.modulo2_1.repository.adapter.UsuarioRepositoryImplAdapter;
import br.com.fatec.modulo2_1.repository.client.UsuarioRepositoryWithMongodb;
import br.com.fatec.modulo2_1.repository.orm.UsuarioOrm;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class UsuarioRepositoryImpl implements UsuarioRepository {

    private final PasswordEncoder encoder;
    private final UsuarioRepositoryWithMongodb repository;

    public UsuarioRepositoryImpl(PasswordEncoder encoder, UsuarioRepositoryWithMongodb repository) {
        this.encoder = encoder;
        this.repository = repository;
    }

    @Override
    public Usuario save(Usuario usuario) {
        try {
            Optional<UsuarioOrm> exists = repository.findByUsername(usuario.username());
            if (exists.isPresent()) {
                throw new DuplicateKeyException("Username já existe");
            }

            String encoded = encoder.encode(usuario.password());
            UsuarioOrm orm = UsuarioRepositoryImplAdapter.toOrm(usuario, encoded);
            UsuarioOrm saved = repository.save(orm);

            return UsuarioRepositoryImplAdapter.toDomain(saved);
        } catch (DuplicateKeyException ex) {
            throw ex;
        } catch (Exception ex) {
            throw new UsuarioPersistenceException("Erro ao salvar usuário", ex);
        }
    }

    @Override
    public Usuario findByUsername(String username) {
        try {
            Optional<UsuarioOrm> optional = repository.findByUsername(username);
            if (optional.isEmpty()) {
                throw new UsernameNotFoundException("Credenciais inválidas");
            }

            return UsuarioRepositoryImplAdapter.toDomain(optional.get());
        } catch (UsernameNotFoundException ex) {
            throw ex;
        } catch (Exception ex) {
            throw new UsuarioPersistenceException("Erro ao buscar usuário", ex);
        }
    }
}
