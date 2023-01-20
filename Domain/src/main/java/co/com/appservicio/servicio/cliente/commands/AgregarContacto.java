package co.com.appservicio.servicio.cliente.commands;

import co.com.appservicio.servicio.cliente.values.*;
import co.com.sofka.domain.generic.Command;

public class AgregarContacto extends Command {
    private  final ClienteId clienteId;
    private final InformacionContacto informacionContacto;

    public AgregarContacto(ClienteId clienteId, InformacionContacto informacionContacto) {
        this.clienteId = clienteId;
        this.informacionContacto = informacionContacto;
    }

    public ContactoId getContactoId() {
        return contactoId;
    }

    public InformacionContacto getInformacionContacto() {
        return informacionContacto;
    }

    public ClienteId getClienteId() {
        return clienteId;
    }
}
