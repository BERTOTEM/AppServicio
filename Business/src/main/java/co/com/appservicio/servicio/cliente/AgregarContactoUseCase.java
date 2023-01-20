package co.com.appservicio.servicio.cliente;

import co.com.appservicio.servicio.cliente.commands.AgregarContacto;
import co.com.appservicio.servicio.cliente.entities.Contacto;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.domain.generic.Command;

public class AgregarContactoUseCase  extends UseCase<RequestCommand<AgregarContacto>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<AgregarContacto> agregarContactoRequestCommand) {
        var command = agregarContactoRequestCommand.getCommand();

        var contacto = Cliente.from(
                command.getClienteId(),repository().getEventsBy(command.getClienteId().value()));
        contacto.AgregarContacto(command.getInformacionContacto());

        emit().onResponse(new ResponseEvents(contacto.getUncommittedChanges()));
    }
}
