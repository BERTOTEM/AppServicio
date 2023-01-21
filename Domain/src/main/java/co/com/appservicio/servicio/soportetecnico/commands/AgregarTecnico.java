package co.com.appservicio.servicio.soportetecnico.commands;

import co.com.appservicio.servicio.soportetecnico.values.DesplazamientoEnSitio;
import co.com.appservicio.servicio.soportetecnico.values.InformacionTecnico;
import co.com.appservicio.servicio.soportetecnico.values.SoporteTecnicoId;
import co.com.appservicio.servicio.soportetecnico.values.TecnicoId;
import co.com.sofka.domain.generic.Command;

public class AgregarTecnico extends Command {
    private final SoporteTecnicoId soporteTecnicoId;
    private final InformacionTecnico informacionTecnico;
    private final DesplazamientoEnSitio desplazamientoEnSitio;

    public AgregarTecnico(SoporteTecnicoId soporteTecnicoId, InformacionTecnico informacionTecnico, DesplazamientoEnSitio desplazamientoEnSitio) {
        this.soporteTecnicoId = soporteTecnicoId;
        this.informacionTecnico = informacionTecnico;
        this.desplazamientoEnSitio = desplazamientoEnSitio;
    }

    public SoporteTecnicoId getSoporteTecnicoId() {
        return soporteTecnicoId;
    }

    public InformacionTecnico getInformacionTecnico() {
        return informacionTecnico;
    }

    public DesplazamientoEnSitio getDesplazamientoEnSitio() {
        return desplazamientoEnSitio;
    }
}
