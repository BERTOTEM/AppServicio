package co.com.appservicio.servicio.cliente.events;

import co.com.appservicio.servicio.cliente.values.Calificacion;
import co.com.appservicio.servicio.cliente.values.EncuestaId;
import co.com.appservicio.servicio.cliente.values.Observaciones;
import co.com.sofka.domain.generic.DomainEvent;

public class EncuestaAgregado extends DomainEvent {
    private final EncuestaId encuestaId;
    private final Observaciones observaciones;
    private final Calificacion calificacion;


    public EncuestaAgregado(EncuestaId encuestaId, Observaciones observaciones, Calificacion calificacion) {
        super("co.com.appservicio.servicio.cliente.events.EncuestaAgregado");
        this.encuestaId=encuestaId;
        this.observaciones=observaciones;
        this.calificacion=calificacion;

    }

    public EncuestaId getEncuestaId() {
        return encuestaId;
    }

    public Observaciones getObservaciones() {
        return observaciones;
    }

    public Calificacion getCalificacion() {
        return calificacion;
    }
}
