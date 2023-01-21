package co.com.appservicio.servicio.ordenservicio.events;

import co.com.appservicio.servicio.ordenservicio.values.EstadoID;
import co.com.appservicio.servicio.ordenservicio.values.Fecha;
import co.com.appservicio.servicio.ordenservicio.values.Pendiente;
import co.com.sofka.domain.generic.DomainEvent;

public class EstadoAgregado extends DomainEvent {

    private final EstadoID estadoID;
    private final  Fecha fecha;
    private final Pendiente pendiente;
    public EstadoAgregado(EstadoID estadoID, Fecha fecha, Pendiente pendiente) {
        super("co.com.appservicio.servicio.ordenservicio.events.EstadoAgregado");
        this.estadoID = estadoID;
        this.fecha = fecha;
        this.pendiente = pendiente;
    }

    public EstadoID getEstadoID() {
        return estadoID;
    }

    public Fecha getFecha() {
        return fecha;
    }

    public Pendiente getPendiente() {
        return pendiente;
    }
}
