package co.com.appservicio.servicio.soportetecnico;

import co.com.appservicio.servicio.soportetecnico.commands.ActualizarSoporteTecnico;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;

public class ActualizarSoporteTecnicoUseCase extends UseCase<RequestCommand<ActualizarSoporteTecnico>,ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<ActualizarSoporteTecnico> actualizarSoporteTecnicoRequestCommand) {
        var commad = actualizarSoporteTecnicoRequestCommand.getCommand();
        var soportetecnico = SoporteTecnico.from(commad.getSoporteTecnicoId(),repository().getEventsBy(commad.getSoporteTecnicoId().value()));
        soportetecnico.ActualizarSoporteTecnico(commad.getSoporteTecnicoId(),commad.getHerramientaEspecializada());

        emit().onResponse(new ResponseEvents(soportetecnico.getUncommittedChanges()));

    }
}
