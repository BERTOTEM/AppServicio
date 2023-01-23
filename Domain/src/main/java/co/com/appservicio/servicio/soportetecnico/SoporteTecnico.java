package co.com.appservicio.servicio.soportetecnico;

import co.com.appservicio.servicio.cliente.ClienteChange;
import co.com.appservicio.servicio.cliente.values.ClienteId;
import co.com.appservicio.servicio.cliente.values.ContactoId;
import co.com.appservicio.servicio.cliente.values.EncuestaId;
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

/**
 * Agregado Root SoporteTecnico extiende de AggregateEvent
 * Esta clase es para la creación del agregado root SoporteTecnico,
 * creación, Domain events, gestión de Commands y Events.
 *
 * @author Keivys José Rodríguez - keivys17@gmail.com
 * @author Julian Roberto Mazo Arroyave - jrtma34@gmail.com
 * @version 1.00.000 2023-01-23
 * @since 1
 */
public class SoporteTecnico extends AggregateEvent<SoporteTecnicoId> {
    protected SoporteTecnicoId soporteTecnicoId;
    protected HerramientaEspecializada herramientaEspecializada;
    protected Sede sede;
    protected Set<Tecnico> tecnicos;

    /**
     * Evento para agregar un SoporteTecnico
     * @param soporteTecnicoId Id de SoporteTécnico
     * @param herramientaEspecializada si se utiliza herramienta especializada
     */

    public SoporteTecnico(SoporteTecnicoId soporteTecnicoId,HerramientaEspecializada herramientaEspecializada) {
        super(soporteTecnicoId);
        appendChange(new SoporteTecnicoCreado(herramientaEspecializada)).apply();
    }

    /**
     * Método que construye el SoporteTecnico
     * @param soporteTecnicoId Id de Soportecnico
     */
    private SoporteTecnico(SoporteTecnicoId soporteTecnicoId){
        super(soporteTecnicoId);
        subscribe(new SoporteTecnicoChange(this));}

        public static SoporteTecnico from(SoporteTecnicoId soporteTecnicoId, List<DomainEvent> events){
        var soporteTecnico= new SoporteTecnico(soporteTecnicoId);
        events.forEach(soporteTecnico::applyEvent);
        return soporteTecnico;
    }


    /**
     *  Método para agregar un Técnico  a un SoporteTecnico
     * @param informacionTecnico información del técnico
     * @param desplazamientoEnSitio si se desplaza o no el técnico
     */
    public void AgregarTecnico( InformacionTecnico informacionTecnico, DesplazamientoEnSitio desplazamientoEnSitio) {
        var tecnicoId = new TecnicoId();
        Objects.requireNonNull(tecnicoId);
        Objects.requireNonNull(informacionTecnico);
        Objects.requireNonNull(desplazamientoEnSitio);
        appendChange(new TecnicoAgregado(tecnicoId, informacionTecnico, desplazamientoEnSitio)).apply();
    }

    /**
     * Método para agregar una Sede a un SoporteTecnico
     * @param informacionSede información del técnico
     */
    public void AgregarSede(InformacionSede informacionSede) {
        var sedeId = new SedeId();
        Objects.requireNonNull(sedeId);
        Objects.requireNonNull(informacionSede);
        appendChange(new SedeAgregada(sedeId, informacionSede)).apply();
    }

    /**
     * Método para actualizar la utilización de herramienta especializada
     * @param soporteTecnicoId
     * @param herramientaEspecializada
     */
    public void ActualizarSoporteTecnico(SoporteTecnicoId soporteTecnicoId, HerramientaEspecializada herramientaEspecializada) {
        Objects.requireNonNull(soporteTecnicoId);
        Objects.requireNonNull(herramientaEspecializada);
        appendChange(new SoporteTecnicoActualizado(soporteTecnicoId, herramientaEspecializada)).apply();
    }

    /**
     *  Método para obtener la utilización de Herramienta
     * @return herramienta
     */
    public HerramientaEspecializada getHerramientaEspecializada() {
        return herramientaEspecializada;
    }

    /**
     * Método para obtener la sede del soporte
     * @return la sede del soporte técnico
     */
    public Sede getSede() {
        return sede;
    }

    /**
     * Método para obtener un Técnico del soporte, del arreglo
     * @param tecnicoId
     * @return Técnico
     */
    protected Optional<Tecnico> getTecnicoPorID(TecnicoId tecnicoId) {
        return tecnicos
                .stream()
                .filter(tecnico -> tecnico.identity().equals(tecnicoId))
                .findFirst();
    }

    /**
     * Método para obtener el iD de soporte
     * @return Id Soportetecnico
     */
    public SoporteTecnicoId getSoporteTecnicoId() {
        return soporteTecnicoId;
    }
}
