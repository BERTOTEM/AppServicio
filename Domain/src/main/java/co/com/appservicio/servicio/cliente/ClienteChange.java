package co.com.appservicio.servicio.cliente;

import co.com.appservicio.servicio.cliente.entities.Contacto;
import co.com.appservicio.servicio.cliente.entities.Encuesta;
import co.com.appservicio.servicio.cliente.events.ClienteActualizado;
import co.com.appservicio.servicio.cliente.events.ClienteCreado;
import co.com.appservicio.servicio.cliente.events.ContactoAgregado;
import co.com.appservicio.servicio.cliente.events.EncuestaAgregada;
import co.com.appservicio.servicio.cliente.values.Calificacion;
import co.com.appservicio.servicio.cliente.values.EncuestaId;
import co.com.appservicio.servicio.cliente.values.InformacionCliente;
import co.com.appservicio.servicio.cliente.values.Observaciones;
import co.com.sofka.domain.generic.EventChange;

import java.util.HashSet;

/**
 * Domain events de agregado root Cliente
 *
 * @author Keivys José Rodríguez - keivys17@gmail.com
 * @author Julian Roberto Mazo Arroyave - jrtma34@gmail.com
 * @version 1.00.000 2023-01-23
 * @since 1
 */
public class ClienteChange extends EventChange {

    public ClienteChange(Cliente cliente) {
        apply((ClienteCreado event) -> {
            cliente.informacioncliente = event.getInformacioncliente();
            cliente.contactos = new HashSet<>();
            cliente.encuestas = cliente.getEncuestas();

        });
        apply((ContactoAgregado event) -> {
            cliente.contactos.add(new Contacto(event.getContactoId(), event.getInformacionContacto()));

        });
        apply((EncuestaAgregada event) -> {
            cliente.encuestas = new Encuesta(event.getEncuestaId(), event.getObservaciones(), event.getCalificacion());
        });
        apply((ClienteActualizado event) -> {
            cliente.informacioncliente = cliente.getInformacioncliente();
        });

    }
}
