package co.com.appservicio.servicio.soportetecnico.entities;

import co.com.appservicio.servicio.soportetecnico.values.DesplazamientoEnSitio;
import co.com.appservicio.servicio.soportetecnico.values.InformacionTecnico;
import co.com.appservicio.servicio.soportetecnico.values.TecnicoId;
import co.com.sofka.domain.generic.Entity;

/**
 * Esta clase es para la creación de la entidad Tecnico
 *
 * @author Keivys José Rodríguez - keivys17@gmail.com
 * @author Julian Roberto Mazo Arroyave - jrtma34@gmail.com
 * @version 1.00.000 2023-01-23
 * @since 1
 */
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
