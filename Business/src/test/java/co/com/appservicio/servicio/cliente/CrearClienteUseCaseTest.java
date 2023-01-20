package co.com.appservicio.servicio.cliente;

import co.com.appservicio.servicio.cliente.commands.CrearCliente;
import co.com.appservicio.servicio.cliente.events.ClienteCreado;
import co.com.appservicio.servicio.cliente.values.ClienteId;
import co.com.appservicio.servicio.cliente.values.InformacionCliente;
import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.support.RequestCommand;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CrearClienteUseCaseTest {
    private  CrearClienteUseCase useCase;

    @BeforeEach
    public void setup(){useCase =new CrearClienteUseCase();}


    @Test
    public void crearClienteHappyPass(){
        //arrange
        ClienteId clienteId = ClienteId.of("xxxx");
        InformacionCliente  informacionCliente=new InformacionCliente("julian","123456");
        var command = new CrearCliente(clienteId,informacionCliente);
        //act
        var events= UseCaseHandler.getInstance()
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();
        //asserts
        var clienteCreado =(ClienteCreado)events.get(0);
        Assertions.assertEquals("xxxx",clienteCreado.aggregateRootId());
        Assertions.assertEquals("julian",clienteCreado.getInformacioncliente().value().nombre());
        Assertions.assertEquals("123456",clienteCreado.getInformacioncliente().value().telefono());


    }

}