package co.com.appservicio.servicio.cliente.events;

import co.com.appservicio.servicio.cliente.values.InformacionCliente;
import co.com.sofka.domain.generic.DomainEvent;

import java.util.UUID;

public class ClienteCreado extends DomainEvent {

  private final InformacionCliente informacioncliente;

    public ClienteCreado(InformacionCliente informacioncliente) {
        super("co.com.appservicio.servicio.cliente.events.ClienteCreado");
        this.informacioncliente = informacioncliente;

    }


}
