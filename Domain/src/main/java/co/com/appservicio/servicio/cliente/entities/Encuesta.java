package co.com.appservicio.servicio.cliente.entities;

import co.com.appservicio.servicio.cliente.values.Calificacion;
import co.com.appservicio.servicio.cliente.values.EncuestaId;
import co.com.appservicio.servicio.cliente.values.Observaciones;
import co.com.sofka.domain.generic.Entity;

public class Encuesta extends Entity<EncuestaId> {

    private final Observaciones observaciones;
    private final Calificacion calificacion;

    public Encuesta(EncuestaId entityId, Observaciones observaciones, Calificacion calificacion) {
        super(entityId);
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
