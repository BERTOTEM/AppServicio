package co.com.appservicio.servicio.cliente;

import co.com.appservicio.servicio.cliente.entities.Contacto;
import co.com.appservicio.servicio.cliente.entities.Encuesta;
import co.com.appservicio.servicio.cliente.events.ClienteCreado;
import co.com.appservicio.servicio.cliente.events.ContactoAgregado;
import co.com.appservicio.servicio.cliente.events.EncuestaAgregado;
import co.com.appservicio.servicio.cliente.values.*;
import co.com.sofka.domain.generic.AggregateEvent;

import java.util.Objects;
import java.util.Set;


public class Cliente  extends AggregateEvent<ClienteId> {
    protected InformacionCliente informacioncliente;
    protected Encuesta encuesta;
    protected Set<Contacto> contacto;
    public Cliente(ClienteId clienteId,InformacionCliente informacioncliente) {
        super(clienteId);
        appendChange(new ClienteCreado(informacioncliente)).apply();
    }

    public void AgregarEncuesta(EncuestaId encuestaId, Observaciones observaciones, Calificacion calificacion){
        Objects.requireNonNull(encuestaId);
        Objects.requireNonNull(observaciones);
        Objects.requireNonNull(calificacion);
        appendChange(new EncuestaAgregado(encuestaId, observaciones, calificacion)).apply();
    }

    public void AgregarContacto(ContactoId contactoId, InformacionContacto informacioncontacto){
        Objects.requireNonNull(contactoId);
        Objects.requireNonNull(informacioncontacto);

        appendChange(new ContactoAgregado(contactoId,informacioncontacto)).apply();
    }





    public InformacionCliente getInformacioncliente() {
        return informacioncliente;
    }

    public Encuesta getEncuesta() {
        return encuesta;
    }
}
