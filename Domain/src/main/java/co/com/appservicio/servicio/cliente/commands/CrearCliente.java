package co.com.appservicio.servicio.cliente.commands;

import co.com.appservicio.servicio.cliente.values.ClienteId;
import co.com.appservicio.servicio.cliente.values.InformacionCliente;
import co.com.sofka.domain.generic.Command;

public class CrearCliente extends Command {

    private final ClienteId clienteId;
    private final InformacionCliente informacioncliente;

    public CrearCliente(ClienteId clienteId, InformacionCliente informacioncliente) {
        this.clienteId = clienteId;
        this.informacioncliente = informacioncliente;

    }

    public ClienteId getClienteId() {
        return clienteId;
    }

    public InformacionCliente informacioncliente() {
        return informacioncliente;
    }


}
