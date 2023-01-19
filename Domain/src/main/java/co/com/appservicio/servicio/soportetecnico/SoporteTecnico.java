package co.com.appservicio.servicio.soportetecnico;

import co.com.appservicio.servicio.soportetecnico.events.SoporteTecnicoCreado;
import co.com.appservicio.servicio.soportetecnico.entities.Sede;
import co.com.appservicio.servicio.soportetecnico.entities.Tecnico;
import co.com.appservicio.servicio.soportetecnico.values.HerramientaEspecializada;
import co.com.appservicio.servicio.soportetecnico.values.SoporteTecnicoId;
import co.com.sofka.domain.generic.AggregateEvent;

import java.util.Set;

public class SoporteTecnico extends AggregateEvent<SoporteTecnicoId> {

    protected HerramientaEspecializada herramientaEspecializada;
    protected Sede sede;
    protected Set<Tecnico> tecnicos;

    public SoporteTecnico(SoporteTecnicoId soporteTecnicoId, HerramientaEspecializada herramientaEspecializada) {
        super(soporteTecnicoId);
        this.herramientaEspecializada = herramientaEspecializada;
        appendChange(new SoporteTecnicoCreado(herramientaEspecializada)).apply();
    }


}
