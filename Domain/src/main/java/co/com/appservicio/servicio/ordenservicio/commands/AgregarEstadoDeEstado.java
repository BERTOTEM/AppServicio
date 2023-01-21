package co.com.appservicio.servicio.ordenservicio.commands;

import co.com.appservicio.servicio.ordenservicio.values.EstadoID;
import co.com.appservicio.servicio.ordenservicio.values.Fecha;
import co.com.appservicio.servicio.ordenservicio.values.OrdenSevicioID;
import co.com.appservicio.servicio.ordenservicio.values.Pendiente;
import co.com.sofka.domain.generic.Command;

public class AgregarEstadoDeEstado extends Command {
    private final OrdenSevicioID ordenSevicioID;
    private final Fecha fecha;
    private final Pendiente pendiente;

    public AgregarEstadoDeEstado(OrdenSevicioID ordenSevicioID, Fecha fecha, Pendiente pendiente) {
        this.ordenSevicioID = ordenSevicioID;
        this.fecha = fecha;
        this.pendiente = pendiente;
    }

    public OrdenSevicioID getOrdenSevicioID() {
        return ordenSevicioID;
    }

    public Fecha getFecha() {
        return fecha;
    }

    public Pendiente getPendiente() {
        return pendiente;
    }
}
