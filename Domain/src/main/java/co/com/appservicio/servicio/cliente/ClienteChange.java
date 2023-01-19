package co.com.appservicio.servicio.cliente;

import co.com.appservicio.servicio.cliente.commands.ActualizarCliente;
import co.com.appservicio.servicio.cliente.entities.Contacto;
import co.com.appservicio.servicio.cliente.entities.Encuesta;
import co.com.appservicio.servicio.cliente.events.ClienteActualizado;
import co.com.appservicio.servicio.cliente.events.ClienteCreado;
import co.com.appservicio.servicio.cliente.events.ContactoAgregado;
import co.com.appservicio.servicio.cliente.events.EncuestaAgregada;
import co.com.sofka.domain.generic.EventChange;

public class ClienteChange  extends EventChange {

    public ClienteChange(Cliente cliente) {
       apply((ClienteCreado event)->{
           cliente.informacioncliente=event.getInformacioncliente();
       });
       apply((ContactoAgregado event)->{
           cliente.contactos.add(new Contacto(event.getContactoId(),event.getInformacionContacto()));

       });
        apply((EncuestaAgregada event)->{
            cliente.encuestas = new Encuesta(event.getEncuestaId(), event.getObservaciones(),event.getCalificacion());
        });
        apply((ClienteActualizado event)->{
            cliente.ActualizarCliente(event.getClienteId(),event.getInformacionCliente());
        });

    }
}
