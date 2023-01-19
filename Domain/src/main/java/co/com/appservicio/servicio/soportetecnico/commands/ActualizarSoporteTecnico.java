package co.com.appservicio.servicio.soportetecnico.commands;

import co.com.appservicio.servicio.soportetecnico.values.HerramientaEspecializada;
import co.com.appservicio.servicio.soportetecnico.values.SoporteTecnicoId;
import co.com.sofka.domain.generic.Command;

public class ActualizarSoporteTecnico  extends Command {
    private final SoporteTecnicoId soporteTecnicoId;
    private final HerramientaEspecializada herramientaEspecializada;
    public ActualizarSoporteTecnico(SoporteTecnicoId soporteTecnicoId, HerramientaEspecializada herramientaEspecializada) {

        this.soporteTecnicoId=soporteTecnicoId;
        this.herramientaEspecializada=herramientaEspecializada;
    }

    public SoporteTecnicoId getSoporteTecnicoId() {
        return soporteTecnicoId;
    }

    public HerramientaEspecializada getHerramientaEspecializada() {
        return herramientaEspecializada;
    }
}
