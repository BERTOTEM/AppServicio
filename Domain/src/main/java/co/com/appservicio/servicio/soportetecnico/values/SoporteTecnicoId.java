package co.com.appservicio.servicio.soportetecnico.values;

import co.com.appservicio.servicio.cliente.values.ClienteId;
import co.com.sofka.domain.generic.Identity;

public class SoporteTecnicoId extends Identity {
    public SoporteTecnicoId(String id){
        super(id);
    }
    public static SoporteTecnicoId of(String id) {
        return new SoporteTecnicoId(id);
    }
}
