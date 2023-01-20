package co.com.appservicio.servicio.soportetecnico;

import co.com.appservicio.servicio.cliente.CrearClienteUseCase;
import co.com.appservicio.servicio.soportetecnico.commands.AgregarSede;
import co.com.appservicio.servicio.soportetecnico.commands.CrearSoporteTecnico;
import co.com.appservicio.servicio.soportetecnico.events.SoporteTecnicoCreado;
import co.com.appservicio.servicio.soportetecnico.values.HerramientaEspecializada;
import co.com.appservicio.servicio.soportetecnico.values.SoporteTecnicoId;
import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.support.RequestCommand;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CrearSoporteTecnicoUseCaseTest {

    private CrearSoporteTecnicoUseCase useCase;

    @BeforeEach
    public void set(){useCase = new CrearSoporteTecnicoUseCase();}

    @Test
    public void  crearSoporteTecnicoHappyPass(){
        //arrange
        SoporteTecnicoId soporteTecnicoId = SoporteTecnicoId.of("xxxx");
        Boolean X= true;
        HerramientaEspecializada herramientaEspecializada = new HerramientaEspecializada(X);
        var command=new CrearSoporteTecnico(soporteTecnicoId,herramientaEspecializada);

        //act
        var events= UseCaseHandler.getInstance()
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();
        //asserts
        var crearSoporteTecnico=(SoporteTecnicoCreado)events.get(0);
        Assertions.assertEquals("xxxx",crearSoporteTecnico.aggregateRootId());
        Assertions.assertEquals((true),crearSoporteTecnico.getHerramientaEspecializada().getValue());


    }

}