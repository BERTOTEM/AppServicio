package co.com.appservicio.servicio.ordenservicio;

import co.com.appservicio.servicio.ordenservicio.commands.ActualizarOrdenDeServicio;
import co.com.appservicio.servicio.ordenservicio.events.OrdenActualizada;
import co.com.appservicio.servicio.ordenservicio.values.Objetivo;
import co.com.appservicio.servicio.ordenservicio.values.OrdenSevicioID;
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
class ActualizarOrdenDeServicioUseCaseTest {
    @InjectMocks
    private ActualizarOrdenDeServicioUseCase useCase;

    @Mock
    private DomainEventRepository repository;

    @Test
    public void actualizarOrdenDeServicioHappyPass() {
        // ARRANGE
        Objetivo objetivo = new Objetivo("Cambio");
        var event = new ActualizarOrdenDeServicio(OrdenSevicioID.of("ddd"),
                objetivo);

        when(repository.getEventsBy("ddd")).thenReturn(history());
        useCase.addRepository(repository);

        // ACT
        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor(event.getOrdenSevicioID().value())
                .syncExecutor(useCase, new RequestCommand<>(event))
                .orElseThrow()
                .getDomainEvents();

        // ASSERT
        var ordenActualizada = (OrdenActualizada) events.get(0);
        Assertions.assertEquals("Cambio", ordenActualizada.getObjetivo().value().objetivo());
    }

    private List<DomainEvent> history() {
        Objetivo objetivo = new Objetivo("Hola");
        var event = new OrdenActualizada(OrdenSevicioID.of("ddd"), objetivo);
        event.setAggregateRootId("ddd");
        return List.of(event);
    }
}