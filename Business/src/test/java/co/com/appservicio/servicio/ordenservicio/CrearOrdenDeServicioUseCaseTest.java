package co.com.appservicio.servicio.ordenservicio;

import co.com.appservicio.servicio.ordenservicio.commands.CrearOrdenDeServicio;
import co.com.appservicio.servicio.ordenservicio.events.OrdenServicioCreada;
import co.com.appservicio.servicio.ordenservicio.values.Objetivo;
import co.com.appservicio.servicio.ordenservicio.values.OrdenSevicioID;
import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.support.RequestCommand;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
@ExtendWith(MockitoExtension.class)
class CrearOrdenDeServicioUseCaseTest {
    private CrearOrdenDeServicioUseCase useCase;

    @BeforeEach
    public void setup(){
        useCase = new CrearOrdenDeServicioUseCase();
    }

    @Test
    public void crearOrdenDeServicioHappyPass(){
        // ARRANGE
        OrdenSevicioID ordenSevicioID = OrdenSevicioID.of("xxx");
        Objetivo objetivo = new Objetivo("Revisar Internet");
        var command = new CrearOrdenDeServicio(ordenSevicioID, objetivo);

        //ACT
        var events = UseCaseHandler.getInstance()
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();
        //ASSERTS
        var ordenCreada = (OrdenServicioCreada)events.get(0);
        Assertions.assertEquals("xxx", ordenCreada.aggregateRootId());
        Assertions.assertEquals("Revisar Internet", ordenCreada.getObjetivo().value().objetivo());
    }

}