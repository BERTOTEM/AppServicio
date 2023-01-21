package co.com.appservicio.servicio.ordenservicio;

import co.com.appservicio.servicio.ordenservicio.commands.ActualizarOrdenDeServicio;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;

public class ActualizarOrdenDeServicioUseCase extends UseCase<RequestCommand<ActualizarOrdenDeServicio>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<ActualizarOrdenDeServicio> actualizarOrdenDeServicioRequestCommand) {
        var command = actualizarOrdenDeServicioRequestCommand.getCommand();
        var orden = OrdenServicio.from(command.getOrdenSevicioID(), repository().getEventsBy(command.getOrdenSevicioID().value()));

        orden.ActualizarOrdenDeServicio(command.getOrdenSevicioID(), command.getObjetivo());

        emit().onResponse(new ResponseEvents(orden.getUncommittedChanges()));
    }
}
