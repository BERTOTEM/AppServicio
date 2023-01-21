package co.com.appservicio.servicio.ordenservicio;

import co.com.appservicio.servicio.cliente.Cliente;
import co.com.appservicio.servicio.ordenservicio.commands.CrearOrdenDeServicio;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;

public class CrearOrdenDeServicioUseCase extends UseCase<RequestCommand<CrearOrdenDeServicio>, ResponseEvents> {


    @Override
    public void executeUseCase(RequestCommand<CrearOrdenDeServicio> crearOrdenDeServicioRequestCommand) {
        var command = crearOrdenDeServicioRequestCommand.getCommand();
        var orden = new OrdenServicio(command.getOrdenSevicioID(), command.getObjetivo());
        emit().onResponse(new ResponseEvents(orden.getUncommittedChanges()));
    }
}
