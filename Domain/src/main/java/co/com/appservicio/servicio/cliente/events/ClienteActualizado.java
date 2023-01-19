package co.com.appservicio.servicio.cliente.events;

import co.com.appservicio.servicio.cliente.values.ClienteId;
import co.com.appservicio.servicio.cliente.values.ContactoId;
import co.com.appservicio.servicio.cliente.values.InformacionCliente;
import co.com.appservicio.servicio.cliente.values.InformacionContacto;
import co.com.sofka.domain.generic.DomainEvent;

public class ClienteActualizado extends DomainEvent {

    private final ClienteId clienteId;
    private final InformacionCliente informacionCliente;
    public ClienteActualizado(ClienteId clienteId, InformacionCliente informacionCliente) {
        super("co.com.appservicio.servicio.cliente.events.ContactoActualizado");
        this.clienteId=clienteId;
        this.informacionCliente=informacionCliente;
    }

    public ClienteId getClienteId() {
        return clienteId;
    }

    public InformacionCliente getInformacionCliente() {
        return informacionCliente;
    }
}
