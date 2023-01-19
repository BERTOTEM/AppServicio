package co.com.appservicio.servicio.cliente.commands;

import co.com.appservicio.servicio.cliente.values.Calificacion;
import co.com.appservicio.servicio.cliente.values.EncuestaId;
import co.com.appservicio.servicio.cliente.values.Observaciones;
import co.com.sofka.domain.generic.Command;

public class AgregarEncuesta extends Command {

    private final EncuestaId encuestaId;
    private final Observaciones observaciones;
    private final Calificacion calificacion;

    public AgregarEncuesta(EncuestaId encuestaId, Observaciones observaciones, Calificacion calificacion) {
        this.encuestaId = encuestaId;
        this.observaciones = observaciones;
        this.calificacion = calificacion;
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
