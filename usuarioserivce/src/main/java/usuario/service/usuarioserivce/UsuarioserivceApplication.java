package usuario.service.usuarioserivce;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class UsuarioserivceApplication {

	public static void main(String[] args) {
		SpringApplication.run(UsuarioserivceApplication.class, args);
	}

}
