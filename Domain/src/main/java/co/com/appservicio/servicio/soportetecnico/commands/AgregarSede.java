package co.com.appservicio.servicio.soportetecnico.commands;

import co.com.appservicio.servicio.soportetecnico.values.InformacionSede;
import co.com.appservicio.servicio.soportetecnico.values.SedeId;
import co.com.appservicio.servicio.soportetecnico.values.SoporteTecnicoId;
import co.com.sofka.domain.generic.Command;

public class AgregarSede extends Command {
    private final SoporteTecnicoId soporteTecnicoId;
    private final InformacionSede informacionSede;
    public AgregarSede(SoporteTecnicoId soporteTecnicoId, InformacionSede informacionSede) {
        this.soporteTecnicoId = soporteTecnicoId;
        this.informacionSede = informacionSede;
    }

    public SoporteTecnicoId getSoporteTecnicoId() {
        return soporteTecnicoId;
    }

    public InformacionSede getInformacionSede() {
        return informacionSede;
    }
}
