package co.com.appservicio.servicio.soportetecnico;

import co.com.appservicio.servicio.cliente.events.ClienteCreado;
import co.com.appservicio.servicio.cliente.events.EncuestaAgregada;
import co.com.appservicio.servicio.cliente.values.InformacionCliente;
import co.com.appservicio.servicio.soportetecnico.commands.AgregarSede;
import co.com.appservicio.servicio.soportetecnico.events.SedeAgregada;
import co.com.appservicio.servicio.soportetecnico.events.SoporteTecnicoCreado;
import co.com.appservicio.servicio.soportetecnico.values.HerramientaEspecializada;
import co.com.appservicio.servicio.soportetecnico.values.InformacionSede;
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
class AgregarSedeUseCaseTest {
    @InjectMocks
    private AgregarSedeUseCase useCase;
    @Mock
    private DomainEventRepository repository;

    @Test
    public void AgregarSedeHappyPass(){
        //arr
        SoporteTecnicoId soporteTecnicoId = SoporteTecnicoId.of("llll2");
        InformacionSede informacionSede = new InformacionSede("Medellin","Cra98a #67-90","jrt45@gmail.com","46789");
        var command = new AgregarSede(soporteTecnicoId,informacionSede);

        when(repository.getEventsBy("llll2")).thenReturn(history());
        useCase.addRepository(repository);
        //Act
        var events= UseCaseHandler.getInstance()
                .setIdentifyExecutor(command.getSoporteTecnicoId().value())
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();
        // ASSERT
        var event = (SedeAgregada)events.get(0);
        Assertions.assertEquals("Medellin", event.getInformacionSede().value().nombre());
        Assertions.assertEquals("Cra98a #67-90", event.getInformacionSede().value().direccion());
        Assertions.assertEquals("jrt45@gmail.com", event.getInformacionSede().value().correo());
        Assertions.assertEquals("46789", event.getInformacionSede().value().telefono());





    }
    private List<DomainEvent> history() {
        HerramientaEspecializada herramientaEspecializada = new HerramientaEspecializada(true);
        var event = new SoporteTecnicoCreado(herramientaEspecializada);
        event.setAggregateRootId("xxxx");
        return List.of(event);
    }




}