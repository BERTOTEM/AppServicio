package co.com.appservicio.servicio.cliente;

import co.com.appservicio.servicio.cliente.commands.AgregarContacto;
import co.com.appservicio.servicio.cliente.commands.CrearCliente;
import co.com.appservicio.servicio.cliente.events.ClienteCreado;
import co.com.appservicio.servicio.cliente.events.ContactoAgregado;
import co.com.appservicio.servicio.cliente.values.ClienteId;
import co.com.appservicio.servicio.cliente.values.ContactoId;
import co.com.appservicio.servicio.cliente.values.InformacionCliente;
import co.com.appservicio.servicio.cliente.values.InformacionContacto;
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
class AgregarContactoUseCaseTest {

    @InjectMocks
    private AgregarContactoUseCase useCase;
    @Mock
    private DomainEventRepository repository;

    @Test
    void AgregarContactoHappyPass(){
        //ARRANGE
        ClienteId clienteId =ClienteId.of("jjjjj");

        InformacionContacto informacionContacto=new InformacionContacto("julian","123456","ingeniero");
        var command = new AgregarContacto(clienteId,informacionContacto);

        when(repository.getEventsBy("jjjjj")).thenReturn(history());
        useCase.addRepository(repository);

        // ACT
        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor(command.getClienteId().value())
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        // ASSERT
        var event = (ContactoAgregado)events.get(0);
        Assertions.assertEquals("julian", event.getInformacionContacto().value().nombre());
        Assertions.assertEquals("123456", event.getInformacionContacto().value().telefono());
        Assertions.assertEquals("ingeniero", event.getInformacionContacto().value().cargo());

    }

    private List<DomainEvent> history() {
        InformacionCliente informacionCliente = new InformacionCliente("jose","456987");
        var event = new ClienteCreado(informacionCliente);
        event.setAggregateRootId("xxxx");
        return List.of(event);
    }

}