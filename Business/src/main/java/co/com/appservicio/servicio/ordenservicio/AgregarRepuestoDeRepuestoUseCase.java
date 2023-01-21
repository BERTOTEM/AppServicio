package co.com.appservicio.servicio.ordenservicio;

import co.com.appservicio.servicio.ordenservicio.commands.AgregarRepuestoDeRepuesto;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;

public class AgregarRepuestoDeRepuestoUseCase extends UseCase<RequestCommand<AgregarRepuestoDeRepuesto>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<AgregarRepuestoDeRepuesto> agregarRepuestoDeRepuestoRequestCommand) {
        var command = agregarRepuestoDeRepuestoRequestCommand.getCommand();

        var orden = OrdenServicio.from(
                command.getOrdenSevicioID(), repository().getEventsBy(command.getOrdenSevicioID().value()));
        orden.AgregarRepuestoDeRepuesto(command.getRequiereRepuesto());

        emit().onResponse(new ResponseEvents(orden.getUncommittedChanges()));
    }
}
