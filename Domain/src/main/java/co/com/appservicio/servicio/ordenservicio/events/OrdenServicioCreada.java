package co.com.appservicio.servicio.ordenservicio.events;

import co.com.appservicio.servicio.ordenservicio.values.Objetivo;
import co.com.sofka.domain.generic.DomainEvent;

import java.util.Objects;

public class OrdenServicioCreada extends DomainEvent {

    private  final Objetivo objetivo;
    public OrdenServicioCreada(Objetivo objetivo) {
        super("co.com.appservicio.servicio.ordenservicio.events.OrdenServicioCreada");
        this.objetivo = objetivo;
    }

    public Objetivo getObjetivo() {
        return objetivo;
    }
}
