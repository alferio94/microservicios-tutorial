package usuario.service.usuarioserivce.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import usuario.service.usuarioserivce.entities.Usuario;

@Repository
public interface UsuraioRepository extends JpaRepository<Usuario, Integer> {

}
