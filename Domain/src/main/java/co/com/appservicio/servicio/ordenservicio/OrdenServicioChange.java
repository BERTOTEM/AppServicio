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

public class OrdenServicioChange extends EventChange {
    public OrdenServicioChange(OrdenServicio ordenServicio) {
        apply((OrdenServicioCreada event) -> {
            ordenServicio.objetivo = event.getObjetivo();
            ordenServicio.repuestos= new HashSet<>();
            ordenServicio.estado= ordenServicio.getEstado();

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
