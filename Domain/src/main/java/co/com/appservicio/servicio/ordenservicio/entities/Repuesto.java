package co.com.appservicio.servicio.ordenservicio.entities;

import co.com.appservicio.servicio.ordenservicio.values.RepuestoID;
import co.com.appservicio.servicio.ordenservicio.values.RequiereRepuesto;
import co.com.sofka.domain.generic.Entity;

public class Repuesto extends Entity<RepuestoID> {
    private final RequiereRepuesto requiereRepuesto;

    public Repuesto(RepuestoID repuestoID, RequiereRepuesto requiereRepuesto) {
        super(repuestoID);
        this.requiereRepuesto = requiereRepuesto;
    }

    public RequiereRepuesto getRequiereRepuesto() {
        return requiereRepuesto;
    }
}
