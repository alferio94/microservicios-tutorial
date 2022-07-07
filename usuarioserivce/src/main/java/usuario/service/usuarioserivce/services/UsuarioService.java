package usuario.service.usuarioserivce.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import usuario.service.usuarioserivce.entities.Usuario;
import usuario.service.usuarioserivce.repositories.UsuraioRepository;

@Service
public class UsuarioService {

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

}
