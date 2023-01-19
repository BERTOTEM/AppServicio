package co.com.appservicio.servicio.soportetecnico.events;

import co.com.appservicio.servicio.soportetecnico.values.InformacionSede;
import co.com.appservicio.servicio.soportetecnico.values.SedeId;
import co.com.sofka.domain.generic.DomainEvent;

public class SedeAgregada extends DomainEvent {

    private final  SedeId sedeId;
    private final InformacionSede informacionSede;
    public SedeAgregada(SedeId sedeId, InformacionSede informacionSede) {
        super("co.com.appservicio.servicio.soportetecnico.events.SedeAgregada");
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
