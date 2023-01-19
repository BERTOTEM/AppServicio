package co.com.appservicio.servicio.ordenservicio.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class RequiereRepuesto implements ValueObject<Boolean> {
    private final Boolean value;

    public RequiereRepuesto(Boolean value){
        this.value = Objects.requireNonNull(value);
    }

    @Override
    public Boolean value() {
        return null;
    }
}
