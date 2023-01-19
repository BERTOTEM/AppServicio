package co.com.appservicio.servicio.ordenservicio.entities;

import co.com.appservicio.servicio.ordenservicio.values.EstadoID;
import co.com.appservicio.servicio.ordenservicio.values.Fecha;
import co.com.appservicio.servicio.ordenservicio.values.Pendiente;
import co.com.sofka.domain.generic.Entity;

public class Estado extends Entity<EstadoID> {
    private final Fecha fecha;
    private final Pendiente pendiente;

    public Estado(EstadoID estadoID, Fecha fecha, Pendiente pendiente) {
        super(estadoID);
        this.fecha = fecha;
        this.pendiente = pendiente;
    }

    public Fecha getFecha() {
        return fecha;
    }

    public Pendiente getPendiente() {
        return pendiente;
    }
}
