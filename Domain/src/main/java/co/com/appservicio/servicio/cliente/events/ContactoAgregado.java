package co.com.appservicio.servicio.cliente.events;

import co.com.appservicio.servicio.cliente.values.*;
import co.com.sofka.domain.generic.DomainEvent;

public class ContactoAgregado extends DomainEvent {

    private final ContactoId contactoId;
    private final InformacionContacto informacioncontacto;

    public ContactoAgregado(ContactoId contactoId, InformacionContacto informacioncontacto) {
        super("co.com.appservicio.servicio.cliente.events.ContactoAgregado");
        this.contactoId=contactoId;
        this.informacioncontacto=informacioncontacto;

    }

    public ContactoId getContactoId() {
        return contactoId;
    }

    public InformacionContacto getInformacionContacto() {
        return informacioncontacto;
    }
}
