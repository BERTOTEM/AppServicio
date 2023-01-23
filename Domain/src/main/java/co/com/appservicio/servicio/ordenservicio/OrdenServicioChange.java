package co.com.appservicio.servicio.ordenservicio;

import co.com.appservicio.servicio.ordenservicio.entities.Estado;
import co.com.appservicio.servicio.ordenservicio.entities.Repuesto;
import co.com.appservicio.servicio.ordenservicio.events.EstadoAgregado;
import co.com.appservicio.servicio.ordenservicio.events.OrdenActualizada;
import co.com.appservicio.servicio.ordenservicio.events.OrdenServicioCreada;
import co.com.appservicio.servicio.ordenservicio.events.RepuestoAgregado;
import co.com.appservicio.servicio.ordenservicio.values.RepuestoID;
import co.com.sofka.domain.generic.EventChange;

import java.util.HashSet;

/**
 * Domain events de agregado root OrdenServicio
 *
 * @author Keivys José Rodríguez - keivys17@gmail.com
 * @author Julian Roberto Mazo Arroyave - jrtma34@gmail.com
 * @version 1.00.000 2023-01-23
 * @since 1
 */
public class OrdenServicioChange extends EventChange {
    public OrdenServicioChange(OrdenServicio ordenServicio) {
        apply((OrdenServicioCreada event) -> {
            ordenServicio.objetivo = event.getObjetivo();
            ordenServicio.repuestos = new HashSet<>();
            ordenServicio.estado = ordenServicio.getEstado();

        });
        apply((EstadoAgregado event) -> {
            ordenServicio.estado = new Estado(event.getEstadoID(), event.getFecha(), event.getPendiente());
        });
        apply((OrdenActualizada event) -> {
            ordenServicio.objetivo = event.getObjetivo();
        });
        apply((RepuestoAgregado event) -> {
            ordenServicio.repuestos.add(new Repuesto(event.getRepuestoID(), event.getRequiereRepuesto()));
        });
    }
}
