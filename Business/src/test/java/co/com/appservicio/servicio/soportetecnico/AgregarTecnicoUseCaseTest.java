package co.com.appservicio.servicio.soportetecnico;


import co.com.appservicio.servicio.soportetecnico.commands.AgregarTecnico;
import co.com.appservicio.servicio.soportetecnico.events.SoporteTecnicoCreado;
import co.com.appservicio.servicio.soportetecnico.events.TecnicoAgregado;
import co.com.appservicio.servicio.soportetecnico.values.DesplazamientoEnSitio;
import co.com.appservicio.servicio.soportetecnico.values.HerramientaEspecializada;
import co.com.appservicio.servicio.soportetecnico.values.InformacionTecnico;
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


import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class AgregarTecnicoUseCaseTest {
    @InjectMocks
    private  AgregarTecnicoUseCase useCase;
    @Mock
    private DomainEventRepository repository;

    @Test
    public void agregarTecnicoHappyPass(){
        //arra
        SoporteTecnicoId soporteTecnicoId = SoporteTecnicoId.of("jjjj");

        InformacionTecnico informacionTecnico=new InformacionTecnico("julian","3003413828","ingeniero");
        DesplazamientoEnSitio desplazamientoEnSitio = new DesplazamientoEnSitio(true);
        var command = new AgregarTecnico(soporteTecnicoId,informacionTecnico,desplazamientoEnSitio);

        when(repository.getEventsBy("jjjj")).thenReturn(history());
        useCase.addRepository(repository);

        //act
        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor(command.getSoporteTecnicoId().value())
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();
        // ASSERT
        var event = (TecnicoAgregado)events.get(0);
        Assertions.assertEquals("julian", event.getInformacionTecnico().value().nombre());
        Assertions.assertEquals("3003413828", event.getInformacionTecnico().value().telefono());
        Assertions.assertEquals("ingeniero", event.getInformacionTecnico().value().cargo());
        Assertions.assertEquals(true,event.getDesplazamientoEnSitio().value());


    }

    private List<DomainEvent> history() {
        HerramientaEspecializada herramientaEspecializada = new HerramientaEspecializada(true);
        var event = new SoporteTecnicoCreado(herramientaEspecializada);
        event.setAggregateRootId("xxxx");
        return List.of(event);
    }

}