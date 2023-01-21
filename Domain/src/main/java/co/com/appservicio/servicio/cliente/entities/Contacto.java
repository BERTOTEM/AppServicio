package co.com.appservicio.servicio.cliente.entities;

import co.com.appservicio.servicio.cliente.values.ContactoId;
import co.com.appservicio.servicio.cliente.values.InformacionContacto;
import co.com.sofka.domain.generic.Entity;

/**
 * Esta clase es para la creacion de la entidad contacto
 *
 * @author Keivys José Rodríguez - keivys17@gmail.com
 * @author Julian Roberto Mazo Arroyave - jrtma34@gmail.com
 * @version 1.00.000 2023-01-23
 * @since 1
 */
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
