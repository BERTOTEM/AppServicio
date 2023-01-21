package co.com.appservicio.servicio.ordenservicio.values;

import co.com.sofka.domain.generic.ValueObject;

import java.time.LocalDate;

public class Fecha implements ValueObject<LocalDate> {
    private final LocalDate fecha;

    public Fecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public static Fecha of(LocalDate fecha){
        return new Fecha(fecha);
    }

    @Override
    public LocalDate value() {
        return fecha;
    }

    public LocalDate getFecha() {
        return fecha;
    }
}
