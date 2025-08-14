import java.util.ArrayList;

public class aprendiz {
    private String nombre;
    private String apellido;
    private String documento;
    private String ficha;

    public aprendiz(String nombre, String apellido, String documento, String ficha) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.documento = documento;
        this.ficha = ficha;
    }

    public String getDocumento() { return documento; }

    @Override
    public String toString() {
        return nombre + " " + apellido + " | Doc: " + documento + " | Ficha: " + ficha;
    }

    public String getNombre() {
        return nombre; 
    }

    public String getApellido() {
        return apellido;
    }

    public String getFicha() {
        return ficha;
    }

    private String horario = "Sin asignar";

public String getHorario() { return horario; }
public void setHorario(String horario) { this.horario = horario; }



    

}


    
