package co.com.appservicio.servicio.soportetecnico;

import co.com.appservicio.servicio.cliente.ClienteChange;
import co.com.appservicio.servicio.cliente.values.ClienteId;
import co.com.appservicio.servicio.soportetecnico.events.SedeAgregada;
import co.com.appservicio.servicio.soportetecnico.events.SoporteTecnicoActualizado;
import co.com.appservicio.servicio.soportetecnico.events.SoporteTecnicoCreado;
import co.com.appservicio.servicio.soportetecnico.entities.Sede;
import co.com.appservicio.servicio.soportetecnico.entities.Tecnico;
import co.com.appservicio.servicio.soportetecnico.events.TecnicoAgregado;
import co.com.appservicio.servicio.soportetecnico.values.*;
import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.domain.generic.DomainEvent;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;

public class SoporteTecnico extends AggregateEvent<SoporteTecnicoId> {

    protected HerramientaEspecializada herramientaEspecializada;
    protected Sede sede;
    protected Set<Tecnico> tecnicos;

    public SoporteTecnico(SoporteTecnicoId soporteTecnicoId,HerramientaEspecializada herramientaEspecializada) {
        super(soporteTecnicoId);
        appendChange(new SoporteTecnicoCreado(herramientaEspecializada)).apply();
    }

    private SoporteTecnico(SoporteTecnicoId soporteTecnicoId){
        super(soporteTecnicoId);
        subscribe(new SoporteTecnicoChange(this));}

        public static SoporteTecnico from(SoporteTecnicoId soporteTecnicoId, List<DomainEvent> events){
        var soporteTecnico= new SoporteTecnico(soporteTecnicoId);
        events.forEach(soporteTecnico::applyEvent);
        return soporteTecnico;
    }



    public void AgregarTecnico(TecnicoId tecnicoId, InformacionTecnico informacionTecnico, DesplazamientoEnSitio desplazamientoEnSitio) {
        Objects.requireNonNull(tecnicoId);
        Objects.requireNonNull(informacionTecnico);
        Objects.requireNonNull(desplazamientoEnSitio);
        appendChange(new TecnicoAgregado(tecnicoId, informacionTecnico, desplazamientoEnSitio)).apply();
    }
    public void AgregarSede(SedeId sedeId, InformacionSede informacionSede) {
        Objects.requireNonNull(sedeId);
        Objects.requireNonNull(informacionSede);
        appendChange(new SedeAgregada(sedeId, informacionSede)).apply();
    }
    public void ActualizarSoporteTecnico(SoporteTecnicoId soporteTecnicoId, HerramientaEspecializada herramientaEspecializada) {
        Objects.requireNonNull(soporteTecnicoId);
        Objects.requireNonNull(herramientaEspecializada);
        appendChange(new SoporteTecnicoActualizado(soporteTecnicoId, herramientaEspecializada)).apply();
    }

    public HerramientaEspecializada getHerramientaEspecializada() {
        return herramientaEspecializada;
    }

    public Sede getSede() {
        return sede;
    }
    protected Optional<Tecnico> getTecnicoPorID(TecnicoId tecnicoId) {
        return tecnicos
                .stream()
                .filter(tecnico -> tecnico.identity().equals(tecnicoId))
                .findFirst();
    }
}
