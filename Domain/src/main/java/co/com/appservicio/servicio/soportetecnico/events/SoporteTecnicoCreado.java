package co.com.appservicio.servicio.soportetecnico.events;

import co.com.appservicio.servicio.cliente.values.InformacionCliente;
import co.com.appservicio.servicio.soportetecnico.values.HerramientaEspecializada;
import co.com.sofka.domain.generic.DomainEvent;

public class SoporteTecnicoCreado extends DomainEvent {
    private final HerramientaEspecializada herramientaEspecializada;
    public SoporteTecnicoCreado(HerramientaEspecializada herramientaEspecializada) {
        super("co.com.appservicio.servicio.soportetecnico.events.SoporteTecnicoCreado");
        this.herramientaEspecializada = herramientaEspecializada;
    }

    public HerramientaEspecializada getHerramientaEspecializada() {
        return herramientaEspecializada;
    }
}
