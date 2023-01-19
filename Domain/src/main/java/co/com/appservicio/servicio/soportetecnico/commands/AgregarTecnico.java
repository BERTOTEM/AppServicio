package co.com.appservicio.servicio.soportetecnico.commands;

import co.com.appservicio.servicio.soportetecnico.values.DesplazamientoEnSitio;
import co.com.appservicio.servicio.soportetecnico.values.InformacionTecnico;
import co.com.appservicio.servicio.soportetecnico.values.TecnicoId;
import co.com.sofka.domain.generic.Command;

public class AgregarTecnico extends Command {
    private final TecnicoId tecnicoId;
    private final InformacionTecnico informacionTecnico;
    private final DesplazamientoEnSitio desplazamientoEnSitio;

    public AgregarTecnico(TecnicoId tecnicoId, InformacionTecnico informacionTecnico, DesplazamientoEnSitio desplazamientoEnSitio) {
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
