package co.com.appservicio.servicio.cliente.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Calificacion implements ValueObject<Integer> {
    private final Integer calificacion;

    public Calificacion(Integer calificacion) {
        this.calificacion = Objects.requireNonNull(calificacion);
    }

    @Override
    public Integer value() {
        return calificacion;
    }
}
