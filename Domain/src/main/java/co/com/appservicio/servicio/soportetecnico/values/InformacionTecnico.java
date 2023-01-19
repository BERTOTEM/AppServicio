package co.com.appservicio.servicio.soportetecnico.values;

import co.com.appservicio.servicio.cliente.values.InformacionCliente;
import co.com.sofka.domain.generic.ValueObject;
import com.sun.jdi.Value;

public class InformacionTecnico implements ValueObject<InformacionTecnico.InfoT> {
    private final String nombre;
    private final String telefono;
    private final String cargo;

    public InformacionTecnico(String nombre, String telefono, String cargo) {
        this.nombre = nombre;
        this.telefono = telefono;
        this.cargo = cargo;
    }

    public static InformacionTecnico of(String nombre, String telefono,String cargo) {
        return new InformacionTecnico(nombre, telefono,cargo);
    }


    @Override
    public InfoT value() {
        return new InfoT() {
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



    public interface InfoT {
        String nombre();

        String telefono();
        String cargo();

    }
}
