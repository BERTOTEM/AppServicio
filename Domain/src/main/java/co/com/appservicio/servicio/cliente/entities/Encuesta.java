package co.com.appservicio.servicio.cliente.entities;

import co.com.appservicio.servicio.cliente.values.Calificacion;
import co.com.appservicio.servicio.cliente.values.EncuestaId;
import co.com.appservicio.servicio.cliente.values.Observaciones;
import co.com.sofka.domain.generic.Entity;

/**
 * Esta clase es para la creación de la entidad encuesta
 *
 * @author Keivys José Rodríguez - keivys17@gmail.com
 * @author Julian Roberto Mazo Arroyave - jrtma34@gmail.com
 * @version 1.00.000 2023-01-23
 * @since 1
 */
public class Encuesta extends Entity<EncuestaId> {
    private final Observaciones observaciones;
    private final Calificacion calificacion;

    public Encuesta(EncuestaId encuestaId, Observaciones observaciones, Calificacion calificacion) {
        super(encuestaId);
        this.observaciones = observaciones;
        this.calificacion = calificacion;
    }

    public Observaciones getObservaciones() {
        return observaciones;
    }

    public Calificacion getCalificacion() {
        return calificacion;
    }
}
