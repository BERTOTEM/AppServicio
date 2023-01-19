package co.com.appservicio.servicio.ordenservicio;

import co.com.appservicio.servicio.cliente.values.ClienteId;
import co.com.appservicio.servicio.ordenservicio.entities.Estado;
import co.com.appservicio.servicio.ordenservicio.events.EstadoAgregado;
import co.com.appservicio.servicio.ordenservicio.events.OrdenActualizada;
import co.com.appservicio.servicio.ordenservicio.events.OrdenServicioCreada;
import co.com.appservicio.servicio.ordenservicio.events.RepuestoAgregado;
import co.com.appservicio.servicio.ordenservicio.values.*;
import co.com.appservicio.servicio.ordenservicio.entities.Repuesto;
import co.com.appservicio.servicio.soportetecnico.values.SoporteTecnicoId;
import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.domain.generic.DomainEvent;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;

public class OrdenServicio extends AggregateEvent<OrdenSevicioID> {
    protected OrdenSevicioID ordenSevicioID;
    protected SoporteTecnicoId soporteTecnicoID;
    protected ClienteId clienteId;
    protected Estado estado;
    protected Set<Repuesto> repuestos;
    protected Objetivo objetivo;

    private OrdenServicio(OrdenSevicioID ordenSevicioID){
        super(ordenSevicioID);
        subscribe(new OrdenServicioChange(this));
    }

    public static OrdenServicio from(OrdenSevicioID ordenSevicioID, List<DomainEvent> events){
        var ordenServicio = new OrdenServicio(ordenSevicioID);
        events.forEach(ordenServicio::applyEvent);
        return ordenServicio;
    }

    // CREA ORDEN DE SERVICIO
    public OrdenServicio(OrdenSevicioID ordenServicioID, Objetivo objetivo) {
        super(ordenServicioID);
        appendChange(new OrdenServicioCreada(objetivo)).apply();
    }

    // ACTUALIZA ORDEN DE SERVICIO
    public void ActualizarOrdenDeServicio(OrdenSevicioID ordenSevicioID, Objetivo objetivo){
        Objects.requireNonNull(ordenSevicioID);
        Objects.requireNonNull(objetivo);
        appendChange(new OrdenActualizada(ordenSevicioID, objetivo)).apply();
    }

    // AGREGAR ESTADO
    public void AgregarEstadoDeEstado(EstadoID estadoID, Fecha fecha, Pendiente pendiente){
        Objects.requireNonNull(estadoID);
        Objects.requireNonNull(fecha);
        Objects.requireNonNull(pendiente);
        appendChange(new EstadoAgregado(estadoID, fecha, pendiente)).apply();
    }

    // AGREGAR REPUESTO
    public void AgregarRepuestoDeRepuesto(RepuestoID repuestoID, RequiereRepuesto requiereRepuesto){
        Objects.requireNonNull(repuestoID);
        Objects.requireNonNull(requiereRepuesto);
        appendChange(new RepuestoAgregado(repuestoID, requiereRepuesto)).apply();
    }

    public SoporteTecnicoId getSoporteTecnicoID() {
        return soporteTecnicoID;
    }

    public ClienteId getClienteId() {
        return clienteId;
    }

    public Estado getEstado() {
        return estado;
    }

    public Objetivo getObjetivo() {
        return objetivo;
    }

    protected Optional<Repuesto> getRepuestoPorID(RepuestoID repuestoID){
        return repuestos
                .stream()
                .filter(repuesto -> repuesto.identity().equals(repuestoID))
                .findFirst();
    }
}
