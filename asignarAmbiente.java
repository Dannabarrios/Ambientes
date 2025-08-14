import java.util.Random;

public class asignarAmbiente {
    private String[] nombresInstructor;
    private String[] ambienteFormacionAsignadas;

    public void asignarAmbientes (String[] instructores, String[] ambiente, String[] descripciones, String[] inventarios) {
        if (instructores == null || instructores.length == 0) {
            System.out.println("No hay instructores registrados.");
            return;
        }

        if (ambiente == null || ambiente.length == 0) {
            System.out.println("No hay líneas de formación registradas.");
            return;
        }

        nombresInstructor = instructores;
        ambienteFormacionAsignadas= new String[instructores.length];

        Random random = new Random();

        for (int i = 0; i < instructores.length; i++) {
            int indice = random.nextInt(ambiente.length);
            ambienteFormacionAsignadas[i] = ambiente[indice];
        }
        
    }

    public void mostrarAsignacionAmbiente() {
        if (nombresInstructor != null && ambienteFormacionAsignadas != null) {
            System.out.println("Instructores con programas de formación asignadas:");
            for (int i = 0; i < nombresInstructor.length; i++) {
                System.out.println("Instructor: " + nombresInstructor[i] + " | Programa de formación: " + ambienteFormacionAsignadas[i]);
            }
        } else {
            System.out.println("No hay asignaciones realizadas.");
        }
    }
      public String[] getNombres() {
        return nombresInstructor;
    }
}

