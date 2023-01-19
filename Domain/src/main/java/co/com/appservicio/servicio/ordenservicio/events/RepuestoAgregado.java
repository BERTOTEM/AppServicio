package co.com.appservicio.servicio.ordenservicio.events;

import co.com.appservicio.servicio.ordenservicio.values.RepuestoID;
import co.com.appservicio.servicio.ordenservicio.values.RequiereRepuesto;
import co.com.sofka.domain.generic.DomainEvent;

public class RepuestoAgregado extends DomainEvent {

    private final RepuestoID repuestoID;
    private final RequiereRepuesto requiereRepuesto;
    public RepuestoAgregado(RepuestoID repuestoID, RequiereRepuesto requiereRepuesto) {
        super("co.com.appservicio.servicio.ordenservicio.events.RepuestoAgregado");
        this.repuestoID = repuestoID;
        this.requiereRepuesto = requiereRepuesto;
    }

    public RepuestoID getRepuestoID() {
        return repuestoID;
    }

    public RequiereRepuesto getRequiereRepuesto() {
        return requiereRepuesto;
    }
}
