package co.com.appservicio.servicio.cliente;

import co.com.appservicio.servicio.cliente.commands.CrearCliente;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;

public class CrearClienteUseCase extends UseCase<RequestCommand<CrearCliente>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<CrearCliente> crearClienteRequestCommand) {
        var command =crearClienteRequestCommand.getCommand();
        var cliente = new Cliente(command.getClienteId(),command.informacioncliente()) ;
        emit().onResponse(new ResponseEvents(cliente.getUncommittedChanges()));

    }
}
