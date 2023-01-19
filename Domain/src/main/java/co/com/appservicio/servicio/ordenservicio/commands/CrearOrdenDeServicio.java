package co.com.appservicio.servicio.ordenservicio.commands;

import co.com.appservicio.servicio.ordenservicio.values.Objetivo;
import co.com.appservicio.servicio.ordenservicio.values.OrdenSevicioID;
import co.com.sofka.domain.generic.Command;

public class CrearOrdenDeServicio extends Command {
    private final OrdenSevicioID ordenSevicioID;
    private final Objetivo objetivo;

    public CrearOrdenDeServicio(OrdenSevicioID ordenSevicioID, Objetivo objetivo) {
        this.ordenSevicioID = ordenSevicioID;
        this.objetivo = objetivo;
    }

    public OrdenSevicioID getOrdenSevicioID() {
        return ordenSevicioID;
    }

    public Objetivo getObjetivo() {
        return objetivo;
    }
}
