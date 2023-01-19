package co.com.appservicio.servicio.ordenservicio.commands;

import co.com.appservicio.servicio.ordenservicio.values.RepuestoID;
import co.com.appservicio.servicio.ordenservicio.values.RequiereRepuesto;
import co.com.sofka.domain.generic.Command;

public class AgregarRepuestoDeRepuesto extends Command {
    private final RepuestoID repuestoID;
    private final RequiereRepuesto requiereRepuesto;

    public AgregarRepuestoDeRepuesto(RepuestoID repuestoID, RequiereRepuesto requiereRepuesto){
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
