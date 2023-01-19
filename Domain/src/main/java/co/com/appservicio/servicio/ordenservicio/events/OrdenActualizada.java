package co.com.appservicio.servicio.ordenservicio.events;

import co.com.appservicio.servicio.ordenservicio.values.Objetivo;
import co.com.appservicio.servicio.ordenservicio.values.OrdenSevicioID;
import co.com.sofka.domain.generic.DomainEvent;

public class OrdenActualizada extends DomainEvent {

    private final OrdenSevicioID ordenSevicioID;
    private final Objetivo objetivo;
    public OrdenActualizada(OrdenSevicioID ordenSevicioID, Objetivo objetivo) {
        super("co.com.appservicio.servicio.ordenservicio.events.OrdenActualizada");
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
