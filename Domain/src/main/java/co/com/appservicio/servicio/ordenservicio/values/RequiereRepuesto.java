package co.com.appservicio.servicio.ordenservicio.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public  class RequiereRepuesto implements ValueObject<RequiereRepuesto.info> {
    private  Boolean value;
    private  String descripcion;
    private  String cantidad;


    public RequiereRepuesto(Boolean value, String descripcion, String cantidad){
        this.value = Objects.requireNonNull(value);
        this.descripcion = descripcion;
        this.cantidad = cantidad;
    }

    public static Descripcion of(Boolean value,String descripcion, String cantidad){
        return new Descripcion(descripcion, cantidad);
    }

    public RequiereRepuesto.info value() {
        if (value.booleanValue()) {
            return new RequiereRepuesto.info() {
                @Override
                public String descripcion() {
                    return descripcion;
                }
                @Override
                public String cantidad() {
                    return cantidad;
                }
            };
        }
        if (!value.booleanValue()) {
            return new RequiereRepuesto.info() {
                @Override
                public String descripcion() {
                    return descripcion="";
                }
                @Override
                public String cantidad() {
                    return cantidad="";
                }
            };
        }
    return null;
    }
    public interface info{
        String descripcion();
        String cantidad();

    }

}
