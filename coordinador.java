import java.util.ArrayList;

public class coordinador {
    private String nombre;
    private ArrayList<String> instructoresAsignados;

    public coordinador(String nombre) {
        this.nombre = nombre;
        this.instructoresAsignados = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public void asignarInstructor(String nombreInstructor) {
        if (!instructoresAsignados.contains(nombreInstructor)) {
            instructoresAsignados.add(nombreInstructor);
        }
    }

    public void mostrarInstructores() {
        System.out.println("Coordinador: " + nombre);
        System.out.println("Instructores asignados:");
        for (String inst : instructoresAsignados) {
            System.out.println(" - " + inst);
        }
    }

    public static boolean isEmpty() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'isEmpty'");
    }
}
