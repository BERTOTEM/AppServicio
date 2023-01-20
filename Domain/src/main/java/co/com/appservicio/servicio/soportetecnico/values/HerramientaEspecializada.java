package co.com.appservicio.servicio.soportetecnico.values;

import co.com.appservicio.servicio.cliente.values.InformacionCliente;
import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class HerramientaEspecializada implements ValueObject<Boolean> {
    private final Boolean value;

    public HerramientaEspecializada(Boolean value) {
        this.value = Objects.requireNonNull(value);
    }

    public static HerramientaEspecializada of(Boolean value) {
        return new HerramientaEspecializada(value);
    }

    @Override
    public Boolean value() {
        return value;
    }

    public Boolean getValue() {
        return value;
    }
}
