package co.com.appservicio.servicio.cliente;

import co.com.appservicio.servicio.cliente.entities.Contacto;
import co.com.appservicio.servicio.cliente.entities.Encuesta;
import co.com.appservicio.servicio.cliente.events.ClienteActualizado;
import co.com.appservicio.servicio.cliente.events.ClienteCreado;
import co.com.appservicio.servicio.cliente.events.ContactoAgregado;
import co.com.appservicio.servicio.cliente.events.EncuestaAgregada;
import co.com.appservicio.servicio.cliente.values.Calificacion;
import co.com.appservicio.servicio.cliente.values.EncuestaId;
import co.com.appservicio.servicio.cliente.values.Observaciones;
import co.com.sofka.domain.generic.EventChange;

import java.util.HashSet;

public class ClienteChange  extends EventChange {

    public ClienteChange(Cliente cliente) {
       apply((ClienteCreado event)->{
           cliente.informacioncliente=event.getInformacioncliente();
           cliente.contactos = new HashSet<>();
           cliente.encuestas = new Encuesta(new EncuestaId(),
                   new Observaciones(cliente.encuestas.getObservaciones().value().observacion(),
                           cliente.encuestas.getObservaciones().value().fecha()),
                           new Calificacion(cliente.encuestas.getCalificacion().value()));

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
