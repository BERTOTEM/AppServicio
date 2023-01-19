package co.com.appservicio.servicio.ordenservicio;

import co.com.appservicio.servicio.ordenservicio.entities.Estado;
import co.com.appservicio.servicio.ordenservicio.entities.Repuesto;
import co.com.appservicio.servicio.ordenservicio.events.EstadoAgregado;
import co.com.appservicio.servicio.ordenservicio.events.OrdenActualizada;
import co.com.appservicio.servicio.ordenservicio.events.OrdenServicioCreada;
import co.com.appservicio.servicio.ordenservicio.events.RepuestoAgregado;
import co.com.appservicio.servicio.ordenservicio.values.RepuestoID;
import co.com.sofka.domain.generic.EventChange;

public class OrdenServicioChange extends EventChange {
    public OrdenServicioChange(OrdenServicio ordenServicio) {
        apply((EstadoAgregado event) -> {
            ordenServicio.estado = new Estado(event.getEstadoID(), event.getFecha(), event.getPendiente());
        });
        apply((OrdenActualizada event) -> {
            ordenServicio.ActualizarOrdenDeServicio(event.getOrdenSevicioID(), event.getObjetivo());
        });
        apply((OrdenServicioCreada event) -> {
            ordenServicio.objetivo = event.getObjetivo();
        });
        apply((RepuestoAgregado event) -> {
            ordenServicio.repuestos.add(new Repuesto(event.getRepuestoID(), event.getRequiereRepuesto()));
        });
    }
}
