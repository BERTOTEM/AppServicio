package co.com.appservicio.servicio.cliente.commands;

import co.com.appservicio.servicio.cliente.values.ClienteId;
import co.com.appservicio.servicio.cliente.values.InformacionCliente;
import co.com.sofka.domain.generic.Command;

public class ActualizarCliente extends Command {
    private final ClienteId clienteId;
    private final InformacionCliente informacionCliente;

    public ActualizarCliente(ClienteId clienteId, InformacionCliente informacionCliente) {
        this.clienteId = clienteId;
        this.informacionCliente = informacionCliente;
    }

    public ClienteId getClienteId() {
        return clienteId;
    }

    public InformacionCliente getInformacionCliente() {
        return informacionCliente;
    }


}
