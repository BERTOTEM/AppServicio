package co.com.appservicio.servicio.cliente.values;

import co.com.sofka.domain.generic.ValueObject;

import java.time.LocalDate;

public class Observaciones implements ValueObject<Observaciones.Info> {

    private final String observacion;

    private final LocalDate fecha;

    public Observaciones(String observacion, LocalDate fecha) {
        this.observacion = observacion;
        this.fecha = fecha;
    }

    public static Observaciones of(String observacion, LocalDate fecha) {
        return new Observaciones(observacion, fecha);
    }

    public Info value() {

        return new Info() {

            @Override
            public String oservacion() {
                return observacion;
            }

            @Override
            public LocalDate fecha() {
                return fecha;
            }
        };
    }

    public interface Info {
        String oservacion();

        LocalDate fecha();
    }

}
