package br.com.fatec.modulo2_1.repository.client;

import br.com.fatec.modulo2_1.repository.orm.UsuarioOrm;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsuarioRepositoryWithMongodb extends MongoRepository<UsuarioOrm, String> {
    Optional<UsuarioOrm> findByUsername(String username);
}
