package co.com.appservicio.servicio.ordenservicio.values;

import co.com.sofka.domain.generic.ValueObject;

public class Objetivo implements ValueObject<Objetivo.Info> {

    private final String objetivo;

    public Objetivo(String objetivo) {
        this.objetivo = objetivo;
    }

    @Override
    public Info value() {
        return new Info() {
            @Override
            public String objetivo() {
                return objetivo;
            }
        };
    }

    public interface Info {
        String objetivo();
    }


}
