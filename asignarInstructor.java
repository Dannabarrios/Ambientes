import java.util.Random;

public class asignarInstructor {
    private String[] nombresInstructor;
    private String[] lineasFormacionAsignadas;

    public void asignarLineas(String[] instructores, String[] lineaFormacion) {
        if (instructores == null || instructores.length == 0) {
            System.out.println("No hay instructores registrados.");
            return;
        }

        if (lineaFormacion == null || lineaFormacion.length == 0) {
            System.out.println("No hay líneas de formación registradas.");
            return;
        }

        nombresInstructor = instructores;
        lineasFormacionAsignadas = new String[instructores.length];

        Random random = new Random();

        for (int i = 0; i < instructores.length; i++) {
            int indice = random.nextInt(lineaFormacion.length);
            lineasFormacionAsignadas[i] = lineaFormacion[indice];
        }
        
    }

    public void mostrarAsignacionInstructor() {
        if (nombresInstructor != null && lineasFormacionAsignadas != null) {
            System.out.println("Instructores con líneas de formación asignadas:");
            for (int i = 0; i < nombresInstructor.length; i++) {
                System.out.println("Instructor: " + nombresInstructor[i] + " | Línea de formación: " + lineasFormacionAsignadas[i]);
            }
        } else {
            System.out.println("No hay asignaciones realizadas.");
        }
    }
      public String[] getNombres() {
        return nombresInstructor;
    }
}
