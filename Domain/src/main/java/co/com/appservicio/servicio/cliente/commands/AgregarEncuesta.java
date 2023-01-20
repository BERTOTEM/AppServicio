package co.com.appservicio.servicio.cliente.commands;

import co.com.appservicio.servicio.cliente.values.Calificacion;
import co.com.appservicio.servicio.cliente.values.ClienteId;
import co.com.appservicio.servicio.cliente.values.EncuestaId;
import co.com.appservicio.servicio.cliente.values.Observaciones;
import co.com.sofka.domain.generic.Command;

public class AgregarEncuesta extends Command {

    private final ClienteId clienteId;
    private final Observaciones observaciones;
    private final Calificacion calificacion;

    public AgregarEncuesta(ClienteId clienteId, Observaciones observaciones, Calificacion calificacion) {
        this.clienteId = clienteId;
        this.observaciones = observaciones;
        this.calificacion = calificacion;
    }

    public ClienteId getClienteId() {
        return clienteId;
    }

    public Observaciones getObservaciones() {
        return observaciones;
    }

    public Calificacion getCalificacion() {
        return calificacion;
    }
}
