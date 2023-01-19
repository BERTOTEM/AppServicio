package co.com.appservicio.servicio.ordenservicio.values;

import co.com.sofka.domain.generic.ValueObject;

public class Descripcion implements ValueObject<Descripcion.Info> {
    private final String descripcion;
    private final String cantidad;

    public Descripcion(String descripcion, String cantidad){
        this.descripcion = descripcion;
        this.cantidad = cantidad;
    }

    public static Descripcion of(String descripcion, String cantidad){
        return new Descripcion(descripcion, cantidad);
    }

    public Info value(){
        return new Info() {
            @Override
            public String descripcion(String descripcion) {
                return descripcion;
            }

            @Override
            public String cantidad(String cantidad) {
                return cantidad;
            }


        };
    }

    public interface Info{
        String descripcion(String descripcion);
        String cantidad(String cantidad);
    }
}
