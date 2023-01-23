package co.com.appservicio.servicio.ordenservicio.entities;

import co.com.appservicio.servicio.ordenservicio.values.EstadoID;
import co.com.appservicio.servicio.ordenservicio.values.Fecha;
import co.com.appservicio.servicio.ordenservicio.values.Pendiente;
import co.com.sofka.domain.generic.Entity;

/**
 * Esta clase es para la creación de la entidad Estado
 *
 * @author Keivys José Rodríguez - keivys17@gmail.com
 * @author Julian Roberto Mazo Arroyave - jrtma34@gmail.com
 * @version 1.00.000 2023-01-23
 * @since 1
 */
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
