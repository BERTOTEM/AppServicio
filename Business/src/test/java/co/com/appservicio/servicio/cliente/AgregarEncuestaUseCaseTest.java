package co.com.appservicio.servicio.cliente;

import co.com.appservicio.servicio.cliente.commands.AgregarEncuesta;
import co.com.appservicio.servicio.cliente.events.ClienteCreado;
import co.com.appservicio.servicio.cliente.events.EncuestaAgregada;
import co.com.appservicio.servicio.cliente.values.Calificacion;
import co.com.appservicio.servicio.cliente.values.ClienteId;
import co.com.appservicio.servicio.cliente.values.InformacionCliente;
import co.com.appservicio.servicio.cliente.values.Observaciones;

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
class AgregarEncuestaUseCaseTest {
    @InjectMocks
    private AgregarEncuestaUseCase useCase;
    @Mock
    private DomainEventRepository repository;

    @Test
    void AgregarEncuestaHappyPass(){
        //Arrange
        ClienteId clienteId = ClienteId.of("llll");
        LocalDate fecha = LocalDate.now();
        Observaciones observaciones= new Observaciones("muy bueno", fecha);
        Calificacion calificacion = new Calificacion(5);
        var command = new AgregarEncuesta(clienteId,observaciones,calificacion);

        when(repository.getEventsBy("llll")).thenReturn(history());
        useCase.addRepository(repository);

        //Act
        var events= UseCaseHandler.getInstance()
                .setIdentifyExecutor(command.getClienteId().value())
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();


        // ASSERT
        var event = (EncuestaAgregada)events.get(0);
        Assertions.assertEquals("muy bueno", event.getObservaciones().value().observacion());
        Assertions.assertEquals(fecha , event.getObservaciones().value().fecha());
        Assertions.assertEquals(5, event.getCalificacion().value());

    }

    private List<DomainEvent> history() {
        InformacionCliente informacionCliente = new InformacionCliente("xyz", "123456");
        var event = new ClienteCreado(informacionCliente);
        event.setAggregateRootId("xxx");
        return List.of(event);
    }



}