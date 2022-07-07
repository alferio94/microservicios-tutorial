package usuario.service.usuarioserivce;

import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import usuario.service.usuarioserivce.entities.Usuario;
import usuario.service.usuarioserivce.services.UsuarioService;

@SpringBootTest
public class UserServiceMockTest {

    @Autowired
    private UsuarioService userService;

    @Test
    public void wenGetAllUsers_thenReturnListOfUsers() {
        Usuario user = Usuario.builder().nombre("Juan").email("Juan@email.com").build();
        userService.saveUsuario(user);
        List<Usuario> users = userService.getAll();

        Assertions.assertThat(users).hasSize(4);

    }
}
