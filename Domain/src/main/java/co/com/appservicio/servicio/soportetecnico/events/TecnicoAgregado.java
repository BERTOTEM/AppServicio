package co.com.appservicio.servicio.soportetecnico.events;

import co.com.appservicio.servicio.soportetecnico.values.DesplazamientoEnSitio;
import co.com.appservicio.servicio.soportetecnico.values.InformacionTecnico;
import co.com.appservicio.servicio.soportetecnico.values.TecnicoId;
import co.com.sofka.domain.generic.DomainEvent;

public class TecnicoAgregado extends DomainEvent {

    private final TecnicoId tecnicoId;
    private final  InformacionTecnico informacionTecnico;
    private final DesplazamientoEnSitio desplazamientoEnSitio;

    public TecnicoAgregado(TecnicoId tecnicoId, InformacionTecnico informacionTecnico, DesplazamientoEnSitio desplazamientoEnSitio) {
        super("co.com.appservicio.servicio.soportetecnico.events.TecnicoAgregado");
        this.tecnicoId = tecnicoId;
        this.informacionTecnico = informacionTecnico;
        this.desplazamientoEnSitio = desplazamientoEnSitio;
    }

    public TecnicoId getTecnicoId() {
        return tecnicoId;
    }

    public InformacionTecnico getInformacionTecnico() {
        return informacionTecnico;
    }

    public DesplazamientoEnSitio getDesplazamientoEnSitio() {
        return desplazamientoEnSitio;
    }
}
