package br.com.fatec.modulo2_1;

import br.com.fatec.modulo2_1.repository.UsuarioRepository;
import br.com.fatec.modulo2_1.repository.client.UsuarioRepositoryWithMongodb;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.convert.MongoConverter;
import org.springframework.data.mongodb.gridfs.GridFsTemplate;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.bean.override.mockito.MockitoBean;

@SpringBootTest
@ActiveProfiles("test")
class Modulo21ApplicationTests {

    @MockitoBean
    private MongoTemplate mongoTemplate;

    @MockitoBean
    private UsuarioRepository userRepositoryInterface;

    @MockitoBean
    private UsuarioRepositoryWithMongodb userRepositoryWithMongodb;

    @MockitoBean
    private GridFsTemplate gridFsTemplate;

    @Mock
    private MongoConverter mongoConverter;

	@Test
	void contextLoads() {
	}

}
