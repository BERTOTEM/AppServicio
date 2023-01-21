package co.com.appservicio.servicio.ordenservicio.values;

import co.com.sofka.domain.generic.Identity;

public class OrdenSevicioID extends Identity {
    public OrdenSevicioID(String id){
        super(id);
    }
    public static OrdenSevicioID of(String id){
        return new OrdenSevicioID(id);
    }
}
