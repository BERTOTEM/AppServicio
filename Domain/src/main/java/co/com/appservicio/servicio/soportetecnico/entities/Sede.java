package co.com.appservicio.servicio.soportetecnico.entities;

import co.com.appservicio.servicio.soportetecnico.values.InformacionSede;
import co.com.appservicio.servicio.soportetecnico.values.SedeId;
import co.com.sofka.domain.generic.Entity;

public class Sede extends Entity<SedeId> {

    private final InformacionSede informacionSede;

    public Sede(SedeId sedeId, InformacionSede informacionSede) {
        super(sedeId);
        this.informacionSede = informacionSede;
    }

}
