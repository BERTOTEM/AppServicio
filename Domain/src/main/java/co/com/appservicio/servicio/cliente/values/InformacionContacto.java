package co.com.appservicio.servicio.cliente.values;

import co.com.sofka.domain.generic.ValueObject;

public class InformacionContacto implements ValueObject<InformacionContacto.Info> {
    private final String nombre;
    private final String telefono;
    private final String cargo;

    public InformacionContacto(String nombre, String telefono, String cargo) {
        this.nombre = nombre;
        this.telefono = telefono;
        this.cargo = cargo;
    }

    public static InformacionContacto of(String nombre, String telefono, String cargo) {
        return new InformacionContacto(nombre, telefono, cargo);
    }

    public InformacionContacto.Info value() {
        return new InformacionContacto.Info() {
            @Override
            public String nombre() {
                return nombre;
            }

            @Override
            public String telefono() {
                return telefono;
            }

            @Override
            public String cargo() {
                return cargo;
            }
        };
    }

    public interface Info {
        String nombre();
        String telefono();
        String cargo();
    }
}
