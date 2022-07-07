package usuario.service.usuarioserivce.feignclient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import usuario.service.usuarioserivce.models.Carro;

@FeignClient(name = "carro-service", url = "http://localhost:8002", path = "/carro")

public interface ICarroFeignClient {

    @PostMapping
    public Carro save(@RequestBody Carro carro);
}
