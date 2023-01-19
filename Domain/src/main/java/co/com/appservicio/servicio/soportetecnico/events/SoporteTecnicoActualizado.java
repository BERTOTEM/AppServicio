package co.com.appservicio.servicio.soportetecnico.events;

import co.com.appservicio.servicio.soportetecnico.values.HerramientaEspecializada;
import co.com.appservicio.servicio.soportetecnico.values.SoporteTecnicoId;
import co.com.sofka.domain.generic.DomainEvent;

public class SoporteTecnicoActualizado extends DomainEvent {
    private final SoporteTecnicoId soporteTecnicoId;
    private final HerramientaEspecializada herramientaEspecializada;
    public SoporteTecnicoActualizado(SoporteTecnicoId soporteTecnicoId, HerramientaEspecializada herramientaEspecializada) {
        super("co.com.appservicio.servicio.soportetecnico.events.SoporteTecnicoActualizado");
        this.soporteTecnicoId=soporteTecnicoId;
        this.herramientaEspecializada=herramientaEspecializada;
    }

    public SoporteTecnicoId getSoporteTecnicoId() {
        return soporteTecnicoId;
    }

    public HerramientaEspecializada getHerramientaEspecializada() {
        return herramientaEspecializada;
    }
}
