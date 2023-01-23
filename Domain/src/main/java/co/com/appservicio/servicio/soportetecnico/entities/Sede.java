package co.com.appservicio.servicio.soportetecnico.entities;

import co.com.appservicio.servicio.soportetecnico.values.InformacionSede;
import co.com.appservicio.servicio.soportetecnico.values.SedeId;
import co.com.sofka.domain.generic.Entity;
/**
 * Esta clase es para la creación de la entidad Sede
 *
 * @author Keivys José Rodríguez - keivys17@gmail.com
 * @author Julian Roberto Mazo Arroyave - jrtma34@gmail.com
 * @version 1.00.000 2023-01-23
 * @since 1
 */
public class Sede extends Entity<SedeId> {

    private final InformacionSede informacionSede;

    public Sede(SedeId sedeId, InformacionSede informacionSede) {
        super(sedeId);
        this.informacionSede = informacionSede;
    }

}
