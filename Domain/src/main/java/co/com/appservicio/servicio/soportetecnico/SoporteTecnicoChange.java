package co.com.appservicio.servicio.soportetecnico;

import co.com.appservicio.servicio.soportetecnico.entities.Sede;
import co.com.appservicio.servicio.soportetecnico.entities.Tecnico;
import co.com.appservicio.servicio.soportetecnico.events.SedeAgregada;
import co.com.appservicio.servicio.soportetecnico.events.SoporteTecnicoActualizado;
import co.com.appservicio.servicio.soportetecnico.events.SoporteTecnicoCreado;
import co.com.appservicio.servicio.soportetecnico.events.TecnicoAgregado;
import co.com.sofka.domain.generic.EventChange;

import java.util.HashSet;

public class SoporteTecnicoChange extends EventChange {
    public SoporteTecnicoChange(SoporteTecnico soporteTecnico){
        apply((SoporteTecnicoCreado event)->{
            soporteTecnico.herramientaEspecializada=event.getHerramientaEspecializada();
            soporteTecnico.tecnicos = new HashSet<>();
            soporteTecnico.sede = soporteTecnico.getSede();

        });
        apply((SedeAgregada event)->{
            soporteTecnico.sede=new Sede(event.getSedeId(),event.getInformacionSede());

        });
        apply((TecnicoAgregado event)->{
            soporteTecnico.tecnicos.add(new Tecnico(event.getTecnicoId(), event.getInformacionTecnico(), event.getDesplazamientoEnSitio()));

        });
        apply((SoporteTecnicoActualizado event)->{
            soporteTecnico.herramientaEspecializada=soporteTecnico.getHerramientaEspecializada();
        });

    }


}
