package co.com.appservicio.servicio.ordenservicio;

import co.com.appservicio.servicio.ordenservicio.commands.AgregarEstadoDeEstado;
import co.com.appservicio.servicio.ordenservicio.events.EstadoAgregado;
import co.com.appservicio.servicio.ordenservicio.values.EstadoID;
import co.com.appservicio.servicio.ordenservicio.values.Fecha;
import co.com.appservicio.servicio.ordenservicio.values.OrdenSevicioID;
import co.com.appservicio.servicio.ordenservicio.values.Pendiente;
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

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class AgregarEstadoDeEstadoUseCaseTest {

    @InjectMocks
    private AgregarEstadoDeEstadoUseCase useCase;
    @Mock
    private DomainEventRepository repository;

    @Test
    void AgregarEstadoDeEstadoHappyPass() {
        // ARRANGE
        OrdenSevicioID ordenSevicioID = OrdenSevicioID.of("xxx");
        Fecha fecha = new Fecha();
        Pendiente pendiente = new Pendiente(false);

        var command = new AgregarEstadoDeEstado(ordenSevicioID, fecha, pendiente);

        when(repository.getEventsBy("xxx")).thenReturn(history());
        useCase.addRepository(repository);

        // ACT
        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor(command.getOrdenSevicioID().value())
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        // ASSERT
        var event = (EstadoAgregado) events.get(0);
        Assertions.assertEquals(false, event.getPendiente().value());

    }

    private List<DomainEvent> history() {
//        EstadoID estadoID = new EstadoID();
//        Fecha fecha = new Fecha();
//        Pendiente pendiente = new Pendiente(false);
        var event = new EstadoAgregado(new EstadoID(), new Fecha(), new Pendiente(false));
        event.setAggregateRootId("xxx");
        return List.of(event);
    }

}