package co.com.appservicio.servicio.cliente.values;

import co.com.sofka.domain.generic.ValueObject;

public class InformacionCliente  implements ValueObject<InformacionCliente.Info> {
    private final String nombre;
    private  final  String telefono;

    public InformacionCliente(String nombre, String telefono) {
        this.nombre = nombre;
        this.telefono = telefono;
    }

    public static  InformacionCliente of(String nombre, String telefono){
        return new InformacionCliente(nombre,telefono);
    }

    public Info value(){
        return  new Info() {
            @Override
            public String nombre() {return nombre;}
            @Override
            public String telefono() {return telefono;}
        };
    }

    public interface Info {
       String nombre();
       String telefono();
    }
}
