package co.com.appservicio.servicio.soportetecnico.values;

import co.com.sofka.domain.generic.ValueObject;

public class InformacionSede implements ValueObject<InformacionSede.InfoS> {
    private final String nombre;
    private final String direccion;
    private final String correo;
    private final String telefono;

    public InformacionSede(String nombre, String direccion, String correo, String telefono) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.correo = correo;
        this.telefono = telefono;
    }

    public static InformacionSede of(String nombre, String direccion,String correo,String telefono) {
        return new InformacionSede(nombre, direccion,correo,telefono);
    }

    @Override
    public InformacionSede.InfoS value(){
        return new InfoS() {
            @Override
            public String nombre() {return nombre;}
            @Override
            public String direccion() {return direccion;}
            @Override
            public String correo() {return correo;}
            @Override
            public String telefono() {return telefono;}
        };
    }

    public interface InfoS{
        String nombre();
        String direccion();
        String correo();
        String telefono();
    }
}
