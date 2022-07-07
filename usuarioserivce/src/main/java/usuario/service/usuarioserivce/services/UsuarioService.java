package usuario.service.usuarioserivce.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import usuario.service.usuarioserivce.entities.Usuario;
import usuario.service.usuarioserivce.feignclient.ICarroFeignClient;
import usuario.service.usuarioserivce.models.Carro;
import usuario.service.usuarioserivce.models.Moto;
import usuario.service.usuarioserivce.repositories.UsuraioRepository;

@Service
public class UsuarioService {

    @Autowired
    private ICarroFeignClient carroFeignClient;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private UsuraioRepository usuraioRepository;

    public List<Usuario> getAll() {
        return usuraioRepository.findAll();
    }

    public Usuario getUsuarioById(Integer id) {
        return usuraioRepository.findById(id).orElse(null);
    }

    public Usuario saveUsuario(Usuario usuario) {
        return usuraioRepository.save(usuario);
    }

    // RestTemplate Methoods

    public List<Carro> getCarros(int usuarioId) {
        List<Carro> carros = restTemplate.getForObject("http://localhost:8002/carro/usuario/" + usuarioId, List.class);
        return carros;
    }

    public List<Moto> getMotos(int usuarioId) {
        List<Moto> motos = restTemplate.getForObject("http://localhost:8003/moto/usuario/" + usuarioId, List.class);
        return motos;
    }

    // Feign Client Methods

    public Carro saveCarro(int usuarioId, Carro carro) {
        carro.setUsuarioId(usuarioId);
        Carro nuevoCarro = carroFeignClient.save(carro);
        return nuevoCarro;
    }

}
