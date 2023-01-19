package co.com.appservicio.servicio.ordenservicio.commands;

import co.com.appservicio.servicio.ordenservicio.values.EstadoID;
import co.com.appservicio.servicio.ordenservicio.values.Fecha;
import co.com.appservicio.servicio.ordenservicio.values.Pendiente;
import co.com.sofka.domain.generic.Command;

public class AgregarEstadoDeEstado extends Command {
    private final EstadoID estadoID;
    private final Fecha fecha;
    private final Pendiente pendiente;

    public AgregarEstadoDeEstado(EstadoID estadoID, Fecha fecha, Pendiente pendiente) {
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
