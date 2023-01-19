package co.com.appservicio.servicio.ordenservicio.values;

import co.com.sofka.domain.generic.ValueObject;

public class Descripcion implements ValueObject<Descripcion.Info> {
    private final String descripcion;
    private final Integer cantidad;

    public Descripcion(String descripcion, Integer cantidad){
        this.descripcion = descripcion;
        this.cantidad = cantidad;
    }

    public static Descripcion of(String descripcion, Integer cantidad){
        return new Descripcion(descripcion, cantidad);
    }

    public Info value(){
        return new Info() {
            @Override
            public String descripcion() {
                return descripcion;
            }

            @Override
            public Integer cantidad() {
                return cantidad;
            }
        };
    }

    public interface Info{
        String descripcion();
        Integer cantidad();
    }
}
