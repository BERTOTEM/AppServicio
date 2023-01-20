package co.com.appservicio.servicio.ordenservicio.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public  class RequiereRepuesto implements ValueObject<Descripcion> {
    private final Boolean value;
    private final Descripcion descripcion;

    public RequiereRepuesto(Boolean value, Descripcion descripcion){
        this.value = Objects.requireNonNull(value);
        this.descripcion = descripcion;
    }

    public Descripcion value() {
//        if (!value.booleanValue()){
//            descripcion.value().descripcion("No usa");
//            descripcion.value().cantidad("0");
//        }
        return descripcion;
    }

    public Boolean getValue() {
        return value;
    }
}
