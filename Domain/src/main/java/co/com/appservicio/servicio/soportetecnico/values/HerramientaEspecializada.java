package co.com.appservicio.servicio.soportetecnico.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class HerramientaEspecializada implements ValueObject<Boolean> {
    private final Boolean value;

    public HerramientaEspecializada(Boolean value) {
        this.value = Objects.requireNonNull(value);
    }

    @Override
    public Boolean value() {
        return value;
    }
}
