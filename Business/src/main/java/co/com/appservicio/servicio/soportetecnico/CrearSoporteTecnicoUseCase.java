package co.com.appservicio.servicio.soportetecnico;

import co.com.appservicio.servicio.soportetecnico.commands.CrearSoporteTecnico;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;

public class CrearSoporteTecnicoUseCase  extends UseCase<RequestCommand<CrearSoporteTecnico>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<CrearSoporteTecnico> crearSoporteTecnicoRequestCommand) {
        var command =crearSoporteTecnicoRequestCommand.getCommand();
        var soportetecnico= new SoporteTecnico(command.getSoporteTecnicoId(), command.getHerramientaEspecializada());
        emit().onResponse(new ResponseEvents(soportetecnico.getUncommittedChanges()));

    }
}
