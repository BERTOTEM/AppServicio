package co.com.appservicio.servicio.ordenservicio;

import co.com.appservicio.servicio.ordenservicio.commands.AgregarEstadoDeEstado;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;

public class AgregarEstadoDeEstadoUseCase extends UseCase<RequestCommand<AgregarEstadoDeEstado>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<AgregarEstadoDeEstado> agregarEstadoDeEstadoRequestCommand) {
        var command = agregarEstadoDeEstadoRequestCommand.getCommand();

        var orden = OrdenServicio.from(
                command.getOrdenSevicioID(), repository().getEventsBy(command.getOrdenSevicioID().value()));
                orden.AgregarEstadoDeEstado(command.getFecha(), command.getPendiente());

                emit().onResponse(new ResponseEvents(orden.getUncommittedChanges()));
    }
}
