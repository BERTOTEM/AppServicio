package co.com.appservicio.servicio.soportetecnico;

import co.com.appservicio.servicio.soportetecnico.commands.AgregarSede;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;

public class AgregarSedeUseCase  extends UseCase<RequestCommand<AgregarSede>, ResponseEvents>{

    @Override
    public void executeUseCase(RequestCommand<AgregarSede> agregarSedeRequestCommand) {
        var command = agregarSedeRequestCommand.getCommand();
        var sede =SoporteTecnico.from(command.getSoporteTecnicoId(),repository().getEventsBy(command.getSoporteTecnicoId().value()));
        sede.AgregarSede(command.getInformacionSede());
        emit().onResponse(new ResponseEvents(sede.getUncommittedChanges()));
    }
}
