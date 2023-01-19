package co.com.appservicio.servicio.soportetecnico.commands;

import co.com.appservicio.servicio.soportetecnico.values.InformacionSede;
import co.com.appservicio.servicio.soportetecnico.values.SedeId;
import co.com.sofka.domain.generic.Command;

public class AgregarSede extends Command {
    private final SedeId sedeId;
    private final InformacionSede informacionSede;
    public AgregarSede(SedeId sedeId, InformacionSede informacionSede) {
        this.sedeId = sedeId;
        this.informacionSede = informacionSede;
    }

    public SedeId getSedeId() {
        return sedeId;
    }

    public InformacionSede getInformacionSede() {
        return informacionSede;
    }
}
