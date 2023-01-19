package co.com.appservicio.servicio.cliente;

import co.com.appservicio.servicio.cliente.entities.Contacto;
import co.com.appservicio.servicio.cliente.events.ClienteCreado;
import co.com.appservicio.servicio.cliente.values.ClienteId;
import co.com.appservicio.servicio.cliente.values.InformacionCliente;
import co.com.sofka.domain.generic.AggregateRoot;
import co.com.appservicio.servicio.cliente.events.ClienteCreado;

import java.util.Set;


public class Cliente  extends AggregateRoot <ClienteId>{
    protected InformacionCliente informacioncliente;
    protected Set<Contacto> contacto;
    public Cliente(ClienteId clienteId,InformacionCliente informacioncliente) {
        super(clienteId);
        appendChange(new ClienteCreado(informacioncliente)).apply();
    }




    public InformacionCliente getInformacioncliente() {
        return informacioncliente;
    }


}
