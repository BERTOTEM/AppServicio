package co.com.appservicio.servicio.cliente;

import co.com.appservicio.servicio.cliente.commands.AgregarEncuesta;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;

public class AgregarEncuestaUseCase  extends UseCase<RequestCommand<AgregarEncuesta>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<AgregarEncuesta> agregarEncuestaRequestCommand) {
        var command = agregarEncuestaRequestCommand.getCommand();
        var encuesta =Cliente.from(command.getClienteId(),repository().getEventsBy(command.getClienteId().value()));
        encuesta.AgregarEncuesta(command.getObservaciones(),command.getCalificacion());
        emit().onResponse(new ResponseEvents(encuesta.getUncommittedChanges()));

    }
}
