package co.com.appservicio.servicio.soportetecnico;

import co.com.appservicio.servicio.soportetecnico.commands.AgregarTecnico;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;

public class AgregarTecnicoUseCase extends UseCase<RequestCommand<AgregarTecnico>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<AgregarTecnico> agregarTecnicoRequestCommand) {
        var command = agregarTecnicoRequestCommand.getCommand();
        var tecnico = SoporteTecnico.from(command.getSoporteTecnicoId(),repository().getEventsBy(command.getSoporteTecnicoId().value()));
        tecnico.AgregarTecnico(command.getInformacionTecnico(),command.getDesplazamientoEnSitio());
        emit().onResponse(new ResponseEvents(tecnico.getUncommittedChanges()));
    }
}
