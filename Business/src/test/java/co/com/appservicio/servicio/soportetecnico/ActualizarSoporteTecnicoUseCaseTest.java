package co.com.appservicio.servicio.soportetecnico;

import co.com.appservicio.servicio.cliente.events.ClienteActualizado;
import co.com.appservicio.servicio.cliente.events.ClienteCreado;
import co.com.appservicio.servicio.cliente.values.InformacionCliente;
import co.com.appservicio.servicio.soportetecnico.commands.ActualizarSoporteTecnico;
import co.com.appservicio.servicio.soportetecnico.events.SoporteTecnicoActualizado;
import co.com.appservicio.servicio.soportetecnico.events.SoporteTecnicoCreado;
import co.com.appservicio.servicio.soportetecnico.values.HerramientaEspecializada;
import co.com.appservicio.servicio.soportetecnico.values.SoporteTecnicoId;
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
class ActualizarSoporteTecnicoUseCaseTest {
    @InjectMocks
    private ActualizarSoporteTecnicoUseCase useCase;
    @Mock
    private DomainEventRepository repository;
    @Test
    public void actualizarSoporteTecnicoHappyPass(){
        var event = new ActualizarSoporteTecnico(SoporteTecnicoId.of("ddd")
        ,HerramientaEspecializada.of(true));

        when(repository.getEventsBy("ddd")).thenReturn(Soporte());
        useCase.addRepository(repository);

        // Act
        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor(event.getSoporteTecnicoId().value())
                .syncExecutor(useCase, new RequestCommand<>(event))
                .orElseThrow()
                .getDomainEvents();
        // ASSERT
        var soporteactualizado =  (SoporteTecnicoActualizado)events.get(0);
        Assertions.assertEquals(true,soporteactualizado.getHerramientaEspecializada().getValue());





    }

    private List<DomainEvent> Soporte(){
        var event = new SoporteTecnicoCreado(HerramientaEspecializada.of(false));
        event.setAggregateRootId("ddd");
        return  List.of(event);
    }

}