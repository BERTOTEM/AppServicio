package co.com.appservicio.servicio.cliente;

import co.com.appservicio.servicio.cliente.entities.Contacto;
import co.com.appservicio.servicio.cliente.entities.Encuesta;
import co.com.appservicio.servicio.cliente.events.ClienteCreado;
import co.com.appservicio.servicio.cliente.events.ClienteActualizado;
import co.com.appservicio.servicio.cliente.events.ContactoAgregado;
import co.com.appservicio.servicio.cliente.events.EncuestaAgregada;
import co.com.appservicio.servicio.cliente.values.*;
import co.com.sofka.domain.generic.AggregateEvent;

import java.util.Objects;
import java.util.Optional;
import java.util.Set;

public class Cliente extends AggregateEvent<ClienteId> {
    protected InformacionCliente informacioncliente;
    protected Encuesta encuestas;
    protected Set<Contacto> contactos;

    public Cliente(ClienteId clienteId, InformacionCliente informacioncliente) {
        super(clienteId);
        appendChange(new ClienteCreado(informacioncliente)).apply();
    }

    public void AgregarEncuesta(EncuestaId encuestaId, Observaciones observaciones, Calificacion calificacion) {
        Objects.requireNonNull(encuestaId);
        Objects.requireNonNull(observaciones);
        Objects.requireNonNull(calificacion);
        appendChange(new EncuestaAgregada(encuestaId, observaciones, calificacion)).apply();
    }

    public void AgregarContacto(ContactoId contactoId, InformacionContacto informacioncontacto) {
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

}
