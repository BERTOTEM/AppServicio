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

public class Cliente extends AggregateEvent<ClienteId> {
    protected ClienteId clienteId;
    protected InformacionCliente informacioncliente;
    protected Encuesta encuestas;
    protected Set<Contacto> contactos;

    public Cliente(ClienteId clienteId, InformacionCliente informacioncliente) {
        super(clienteId);
        appendChange(new ClienteCreado(informacioncliente)).apply();
    }

    private Cliente(ClienteId clienteId){
        super(clienteId);
        subscribe(new ClienteChange(this));
    }

    public static Cliente from(ClienteId clienteId, List<DomainEvent> events){
        var cliente= new Cliente(clienteId);
        events.forEach(cliente::applyEvent);
        return cliente;
    }

    public void AgregarEncuesta(Observaciones observaciones, Calificacion calificacion) {
        var encuestaId = new EncuestaId();
        Objects.requireNonNull(encuestaId);
        Objects.requireNonNull(observaciones);
        Objects.requireNonNull(calificacion);
        appendChange(new EncuestaAgregada(encuestaId, observaciones, calificacion)).apply();
    }

    public void AgregarContacto( InformacionContacto informacioncontacto) {
        var contactoId = new ContactoId();
        Objects.requireNonNull(contactoId);
        Objects.requireNonNull(informacioncontacto);
        appendChange(new ContactoAgregado(contactoId, informacioncontacto)).apply();
    }

    public void ActualizarCliente(ClienteId clienteId, InformacionCliente informacionCliente) {
        Objects.requireNonNull(clienteId);
        Objects.requireNonNull(informacionCliente);
        appendChange(new ClienteActualizado(clienteId, informacionCliente)).apply();
    }

    public InformacionCliente getInformacioncliente() {
        return informacioncliente;
    }

    public Encuesta getEncuestas() {
        return encuestas;
    }

    protected Optional<Contacto> getContactoPorID(ContactoId contactoId) {
        return contactos
                .stream()
                .filter(contacto -> contacto.identity().equals(contactoId))
                .findFirst();
    }

    public ClienteId getClienteId() {
        return clienteId;
    }
}
