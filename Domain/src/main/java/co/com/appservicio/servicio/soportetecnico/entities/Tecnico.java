package co.com.appservicio.servicio.soportetecnico.entities;

import co.com.appservicio.servicio.soportetecnico.values.DesplazamientoEnSitio;
import co.com.appservicio.servicio.soportetecnico.values.InformacionTecnico;
import co.com.appservicio.servicio.soportetecnico.values.TecnicoId;
import co.com.sofka.domain.generic.Entity;

public class Tecnico  extends Entity<TecnicoId> {
    private final InformacionTecnico informacionTecnico;
    private final DesplazamientoEnSitio desplazamientoEnSitio;

    public Tecnico(TecnicoId tecnicoId, InformacionTecnico informacionTecnico, DesplazamientoEnSitio desplazamientoEnSitio) {
        super(tecnicoId);
        this.informacionTecnico = informacionTecnico;
        this.desplazamientoEnSitio = desplazamientoEnSitio;
    }

    public InformacionTecnico getInformacionTecnico() {
        return informacionTecnico;
    }

    public DesplazamientoEnSitio getDesplazamientoEnSitio() {
        return desplazamientoEnSitio;
    }
}
