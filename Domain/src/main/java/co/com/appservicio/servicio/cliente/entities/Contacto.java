package co.com.appservicio.servicio.cliente.entities;

import co.com.appservicio.servicio.cliente.values.ContactoId;
import co.com.appservicio.servicio.cliente.values.InformacionContacto;
import co.com.sofka.domain.generic.Entity;

public class Contacto extends Entity<ContactoId> {
    private final InformacionContacto informacioncontacto;
    public Contacto(ContactoId contactoId, InformacionContacto informacioncontacto) {
        super(contactoId);
        this.informacioncontacto = informacioncontacto;
    }

    public InformacionContacto getInformacioncontacto() {
        return informacioncontacto;
    }
}
