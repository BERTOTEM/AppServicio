package co.com.appservicio.servicio.ordenservicio.entities;

import co.com.appservicio.servicio.ordenservicio.values.RepuestoID;
import co.com.appservicio.servicio.ordenservicio.values.RequiereRepuesto;
import co.com.sofka.domain.generic.Entity;

/**
 * Esta clase es para la creación de la entidad Repuesto
 *
 * @author Keivys José Rodríguez - keivys17@gmail.com
 * @author Julian Roberto Mazo Arroyave - jrtma34@gmail.com
 * @version 1.00.000 2023-01-23
 * @since 1
 */
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
