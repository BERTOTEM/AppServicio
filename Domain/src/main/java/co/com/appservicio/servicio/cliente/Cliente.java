package co.com.appservicio.servicio.cliente;

import co.com.appservicio.servicio.cliente.entities.Contacto;
import co.com.appservicio.servicio.cliente.entities.Encuesta;
import co.com.appservicio.servicio.cliente.events.ClienteCreado;
import co.com.appservicio.servicio.cliente.events.ClienteActualizado;
import co.com.appservicio.servicio.cliente.events.ContactoAgregado;
import co.com.appservicio.servicio.cliente.events.EncuestaAgregada;
import co.com.appservicio.servicio.cliente.values.*;
import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.domain.generic.DomainEvent;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;

/**
 * Agregado Root Cliente extiende de AggregateEvent
 * Esta clase es para la creación del agregado root cliente,
 * creación, Domain events, gestión de Commands y Events.
 *
 * @author Keivys José Rodríguez - keivys17@gmail.com
 * @author Julian Roberto Mazo Arroyave - jrtma34@gmail.com
 * @version 1.00.000 2023-01-23
 * @since 1
 */
public class Cliente extends AggregateEvent<ClienteId> {

    protected ClienteId clienteId;

    protected InformacionCliente informacioncliente;
    protected Encuesta encuestas;
    protected Set<Contacto> contactos;

    /**
     * Método que construye Cliente
     *
     * @param clienteId          id del cliente
     * @param informacioncliente información del cliente
     */
    public Cliente(ClienteId clienteId, InformacionCliente informacioncliente) {
        super(clienteId);
        appendChange(new ClienteCreado(informacioncliente)).apply();
    }

    /**
     * Método para suscribirse a ClienteChange
     *
     * @param clienteId Id del cliente
     */
    private Cliente(ClienteId clienteId) {
        super(clienteId);
        subscribe(new ClienteChange(this));
    }

    /**
     * Método pra la gestión y búsqueda de Domain events
     *
     * @param clienteId Id del cliente
     * @param events    Domain events del agregado root
     * @return Cliente
     */
    public static Cliente from(ClienteId clienteId, List<DomainEvent> events) {
        var cliente = new Cliente(clienteId);
        events.forEach(cliente::applyEvent);
        return cliente;
    }

    /**
     * Evento para agregar una encuesta
     *
     * @param observaciones Observaciones de la encuesta
     * @param calificacion  Calificación de la encuesta
     */
    public void AgregarEncuesta(Observaciones observaciones, Calificacion calificacion) {
        var encuestaId = new EncuestaId();
        Objects.requireNonNull(encuestaId);
        Objects.requireNonNull(observaciones);
        Objects.requireNonNull(calificacion);
        appendChange(new EncuestaAgregada(encuestaId, observaciones, calificacion)).apply();
    }

    /**
     * Evento para agregar un Contacto
     *
     * @param informacioncontacto Información del contacto
     */
    public void AgregarContacto(InformacionContacto informacioncontacto) {
        var contactoId = new ContactoId();
        Objects.requireNonNull(contactoId);
        Objects.requireNonNull(informacioncontacto);
        appendChange(new ContactoAgregado(contactoId, informacioncontacto)).apply();
    }

    /**
     * Evento para actualizar la información de un cliente
     *
     * @param clienteId          Id del cliente
     * @param informacionCliente Información del cliente
     */
    public void ActualizarCliente(ClienteId clienteId, InformacionCliente informacionCliente) {
        Objects.requireNonNull(clienteId);
        Objects.requireNonNull(informacionCliente);
        appendChange(new ClienteActualizado(clienteId, informacionCliente)).apply();
    }

    /**
     * Método para obtener la información de un cliente
     *
     * @return Información del cliente
     */
    public InformacionCliente getInformacioncliente() {
        return informacioncliente;
    }

    /**
     * Método para obtener la encuesta de un cliente
     *
     * @return Entidad Encuesta
     */
    public Encuesta getEncuestas() {
        return encuestas;
    }

    /**
     * Método para obtener un contacto de un cliente, del arreglo
     *
     * @param contactoId Id del contacto
     * @return Un contacto
     */
    protected Optional<Contacto> getContactoPorID(ContactoId contactoId) {
        return contactos
                .stream()
                .filter(contacto -> contacto.identity().equals(contactoId))
                .findFirst();
    }

    /**
     * Método para obtener el iD de cliente
     *
     * @return clienteId
     */
    public ClienteId getClienteId() {
        return clienteId;
    }
}
