package co.com.appservicio.servicio.cliente;

import co.com.appservicio.servicio.cliente.commands.ActualizarCliente;

import co.com.appservicio.servicio.cliente.events.ClienteActualizado;

import co.com.appservicio.servicio.cliente.events.ClienteCreado;
import co.com.appservicio.servicio.cliente.values.ClienteId;
import co.com.appservicio.servicio.cliente.values.InformacionCliente;
import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ActualizarClienteUseCaseTest {
    @InjectMocks
    private ActualizarClienteUseCase useCase;

    @Mock
    private DomainEventRepository repository;



    @Test
    public void actualizarCLienteHappyPass(){
        var event = new ActualizarCliente(ClienteId.of("ddd"),
                 InformacionCliente.of("Sofka", "3003413827"));

        when(repository.getEventsBy("ddd")).thenReturn(clientes());
        useCase.addRepository(repository);

        // Act
        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor(event.getClienteId().value())
                .syncExecutor(useCase, new RequestCommand<>(event))
                .orElseThrow()
                .getDomainEvents();

        // ASSERT
        var clienteactualizado =  (ClienteActualizado)events.get(0);
        Assertions.assertEquals("Sofka",clienteactualizado.getInformacionCliente().value().nombre());
        Assertions.assertEquals("3003413827",clienteactualizado.getInformacionCliente().value().telefono());


    }

    private List<DomainEvent> clientes(){
        var event = new ClienteCreado(InformacionCliente.of("julian","5555"));
        event.setAggregateRootId("ddd");
        return  List.of(event);
    }


    }




