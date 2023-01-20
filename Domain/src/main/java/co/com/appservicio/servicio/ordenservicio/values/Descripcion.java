package co.com.appservicio.servicio.ordenservicio.values;



import co.com.sofka.domain.generic.ValueObject;

public class Descripcion implements ValueObject<Descripcion> {
    private final String descripcion;
    private final String cantidad;

    public Descripcion(String descripcion, String cantidad){
        this.descripcion = descripcion;
        this.cantidad = cantidad;
    }


    @Override
    public Descripcion value() {
        return null;
    }
}