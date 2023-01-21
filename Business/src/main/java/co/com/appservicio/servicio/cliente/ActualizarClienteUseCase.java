package co.com.appservicio.servicio.cliente;

import co.com.appservicio.servicio.cliente.commands.ActualizarCliente;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.business.support.TriggeredEvent;

public class ActualizarClienteUseCase extends UseCase<RequestCommand<ActualizarCliente>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<ActualizarCliente> actualizarClienteRequestCommand) {
        var command = actualizarClienteRequestCommand.getCommand();
        var cliente = Cliente.from(command.getClienteId(), repository().getEventsBy(command.getClienteId().value()));

        cliente.ActualizarCliente(command.getClienteId(), command.getInformacionCliente());

        emit().onResponse(new ResponseEvents(cliente.getUncommittedChanges()));
    }
}
