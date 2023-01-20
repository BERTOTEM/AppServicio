package co.com.appservicio.servicio.ordenservicio.commands;

import co.com.appservicio.servicio.ordenservicio.values.OrdenSevicioID;
import co.com.appservicio.servicio.ordenservicio.values.RepuestoID;
import co.com.appservicio.servicio.ordenservicio.values.RequiereRepuesto;
import co.com.sofka.domain.generic.Command;

public class AgregarRepuestoDeRepuesto extends Command {
    private final OrdenSevicioID ordenSevicioID;
    private final RequiereRepuesto requiereRepuesto;

    public AgregarRepuestoDeRepuesto(OrdenSevicioID ordenSevicioID, RequiereRepuesto requiereRepuesto){
        this.ordenSevicioID = ordenSevicioID;
        this.requiereRepuesto = requiereRepuesto;
    }

    public OrdenSevicioID getOrdenSevicioID() {
        return ordenSevicioID;
    }

    public RequiereRepuesto getRequiereRepuesto() {
        return requiereRepuesto;
    }
}
