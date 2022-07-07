package usuario.service.usuarioserivce.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Moto {

    private String marca;
    private String modelo;
    private int usuarioId;

}
