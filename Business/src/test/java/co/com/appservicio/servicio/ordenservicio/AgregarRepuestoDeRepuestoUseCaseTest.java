package co.com.appservicio.servicio.ordenservicio;

import co.com.appservicio.servicio.ordenservicio.commands.AgregarRepuestoDeRepuesto;
import co.com.appservicio.servicio.ordenservicio.events.OrdenServicioCreada;
import co.com.appservicio.servicio.ordenservicio.events.RepuestoAgregado;
import co.com.appservicio.servicio.ordenservicio.values.Descripcion;
import co.com.appservicio.servicio.ordenservicio.values.Objetivo;
import co.com.appservicio.servicio.ordenservicio.values.OrdenSevicioID;
import co.com.appservicio.servicio.ordenservicio.values.RequiereRepuesto;
import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class AgregarRepuestoDeRepuestoUseCaseTest {
    @InjectMocks
    private AgregarRepuestoDeRepuestoUseCase useCase;
    @Mock
    private DomainEventRepository repository;
    @Test
    void AgregarRepuestoDeRepuestoHappyPass(){
        // ARRANGE
        OrdenSevicioID ordenSevicioID = OrdenSevicioID.of("xxx");
        RequiereRepuesto requiereRepuesto = new RequiereRepuesto(false, new Descripcion("", ""));

        var command = new AgregarRepuestoDeRepuesto(ordenSevicioID, requiereRepuesto);

        when(repository.getEventsBy("xxx")).thenReturn(history());
        useCase.addRepository(repository);

        // ACT
        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor(command.getOrdenSevicioID().value())
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        // ASSERT
        var event = (RepuestoAgregado)events.get(0);
        Assertions.assertEquals(false, event.getRequiereRepuesto().getValue().booleanValue());









    }

    private List<DomainEvent> history() {
        Objetivo objetivo = new Objetivo("Prueba");
        var event = new OrdenServicioCreada(objetivo);
        event.setAggregateRootId("xxx");
        return List.of(event);
    }


}