package co.com.appservicio.servicio.ordenservicio;

import co.com.appservicio.servicio.cliente.values.ClienteId;
import co.com.appservicio.servicio.ordenservicio.entities.Estado;
import co.com.appservicio.servicio.ordenservicio.events.EstadoAgregado;
import co.com.appservicio.servicio.ordenservicio.events.OrdenActualizada;
import co.com.appservicio.servicio.ordenservicio.events.OrdenServicioCreada;
import co.com.appservicio.servicio.ordenservicio.events.RepuestoAgregado;
import co.com.appservicio.servicio.ordenservicio.values.*;
import co.com.appservicio.servicio.ordenservicio.entities.Repuesto;
import co.com.appservicio.servicio.soportetecnico.values.SoporteTecnicoId;
import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.domain.generic.DomainEvent;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;

/**
 * Agregado Root OrdenServicio extiende de AggregateEvent
 * Esta clase es para la creación del agregado root OrdenServicio,
 * creación, Domain events, gestión de Commands y Events.
 *
 * @author Keivys José Rodríguez - keivys17@gmail.com
 * @author Julian Roberto Mazo Arroyave - jrtma34@gmail.com
 * @version 1.00.000 2023-01-23
 * @since 1
 */
public class OrdenServicio extends AggregateEvent<OrdenSevicioID> {
    protected OrdenSevicioID ordenSevicioID;
    protected SoporteTecnicoId soporteTecnicoID;

    protected ClienteId clienteId;
    protected Estado estado;
    protected Set<Repuesto> repuestos;
    protected Objetivo objetivo;

    /**
     * Método que construye la orden de servicio.
     *
     * @param ordenSevicioID ID de la orden
     */
    private OrdenServicio(OrdenSevicioID ordenSevicioID) {
        super(ordenSevicioID);
        subscribe(new OrdenServicioChange(this));
    }

    /**
     * Método pra la gestión y búsqueda de Domain events
     *
     * @param ordenSevicioID Id de la orden
     * @param events         Domain events del agregado root
     * @return Orden de servicio
     */
    public static OrdenServicio from(OrdenSevicioID ordenSevicioID, List<DomainEvent> events) {
        var ordenServicio = new OrdenServicio(ordenSevicioID);
        events.forEach(ordenServicio::applyEvent);
        return ordenServicio;
    }

    /**
     * Evento para agregar una orden de servicio
     *
     * @param ordenServicioID Id de la orden
     * @param objetivo        Objetivo de la orden
     */
    public OrdenServicio(OrdenSevicioID ordenServicioID, Objetivo objetivo) {
        super(ordenServicioID);
        appendChange(new OrdenServicioCreada(objetivo)).apply();
    }

    /**
     * Evento para actualizar una orden de servicio
     *
     * @param ordenSevicioID Id de la orden de servicio.
     * @param objetivo       Objetivo de la orden de servicio.
     */
    public void ActualizarOrdenDeServicio(OrdenSevicioID ordenSevicioID, Objetivo objetivo) {
        Objects.requireNonNull(ordenSevicioID);
        Objects.requireNonNull(objetivo);
        appendChange(new OrdenActualizada(ordenSevicioID, objetivo)).apply();
    }

    /**
     * Método para agregar un estado a una orden de servicio.
     *
     * @param fecha     Fecha del servicio.
     * @param pendiente Sí la orden está pendiente o no.
     */
    public void AgregarEstadoDeEstado(Fecha fecha, Pendiente pendiente) {
        var estadoID = new EstadoID();
        Objects.requireNonNull(fecha);
        Objects.requireNonNull(pendiente);
        appendChange(new EstadoAgregado(estadoID, fecha, pendiente)).apply();
    }

    /**
     * Método para agregar un repuesto a la orden de servicio.
     *
     * @param requiereRepuesto Orden requiere repuesto
     */
    public void AgregarRepuestoDeRepuesto(RequiereRepuesto requiereRepuesto) {
        var repuestoID = new RepuestoID();
        Objects.requireNonNull(repuestoID);
        Objects.requireNonNull(requiereRepuesto);
        appendChange(new RepuestoAgregado(repuestoID, requiereRepuesto)).apply();
    }

    /**
     * Método para obtener el ID del soporte técnico.
     *
     * @return Id de soporte técnico.
     */
    public SoporteTecnicoId getSoporteTecnicoID() {
        return soporteTecnicoID;
    }

    /**
     * Método para obtener el ID del cliente
     *
     * @return ID del cliente
     */
    public ClienteId getClienteId() {
        return clienteId;
    }

    /**
     * Método para obtener el estado de una orden
     *
     * @return Estado de la orden
     */
    public Estado getEstado() {
        return estado;
    }

    /**
     * Método para obtener el objetivo de una orden
     *
     * @return Objetivo de la orden
     */
    public Objetivo getObjetivo() {
        return objetivo;
    }

    /**
     * Método para obtener el ID del repuesto
     *
     * @param repuestoID Id del repuesto
     * @return Id del repuesto
     */
    protected Optional<Repuesto> getRepuestoPorID(RepuestoID repuestoID) {
        return repuestos
                .stream()
                .filter(repuesto -> repuesto.identity().equals(repuestoID))
                .findFirst();
    }


}
