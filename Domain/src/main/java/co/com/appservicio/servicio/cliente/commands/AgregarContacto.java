package co.com.appservicio.servicio.cliente.commands;

import co.com.appservicio.servicio.cliente.values.*;
import co.com.sofka.domain.generic.Command;

public class AgregarContacto extends Command {
    private final ContactoId contactoId;
    private final InformacionContacto informacionContacto;

    public AgregarContacto(ContactoId contactoId, InformacionContacto informacionContacto) {
        this.contactoId = contactoId;
        this.informacionContacto = informacionContacto;
    }

    public ContactoId getContactoId() {
        return contactoId;
    }

    public InformacionContacto getInformacionContacto() {
        return informacionContacto;
    }
}
