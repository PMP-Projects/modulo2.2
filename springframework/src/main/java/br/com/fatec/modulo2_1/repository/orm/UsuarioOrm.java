package br.com.fatec.modulo2_1.repository.orm;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "user")
public record UsuarioOrm(
        @Id
        String id,
        @Indexed(unique = true)
        String username,
        String password
) {}
