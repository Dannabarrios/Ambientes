import java.util.Random;

public class asignarAmbiente {
    private String[] nombresInstructor;
    private String[] ambienteFormacionAsignadas;
    private String[] descripcionesAsignadas;
    private String[] inventariosAsignados;
    private String[] horariosAsignados;

    private final String[] horariosDisponibles = {
        "6:00 AM - 12:00 PM",
        "12:00 PM - 6:00 PM",
        "6:00 PM - 12:00 AM"
    };

    public void asignarAmbientess(String[] instructores, ambiente amb, int idxLinea) {
        if (instructores == null || instructores.length == 0) {
            System.out.println("❌ No hay instructores registrados.");
            return;
        }

        String[] ambientesLinea = amb.getTipos()[idxLinea];
        String[] descripcionesLinea = amb.getDescripciones()[idxLinea];
        String[] inventariosLinea = amb.getInventarios()[idxLinea];

        if (ambientesLinea == null || ambientesLinea.length == 0) {
            System.out.println("❌ No hay ambientes registrados para esta línea.");
            return;
        }

        nombresInstructor = instructores;
        ambienteFormacionAsignadas = new String[instructores.length];
        descripcionesAsignadas = new String[instructores.length];
        inventariosAsignados = new String[instructores.length];
        horariosAsignados = new String[instructores.length];

        Random random = new Random();

        for (int i = 0; i < instructores.length; i++) {
            int indiceAmbiente = random.nextInt(ambientesLinea.length);
            int indiceHorario = random.nextInt(horariosDisponibles.length);

            ambienteFormacionAsignadas[i] = ambientesLinea[indiceAmbiente];
            descripcionesAsignadas[i] = descripcionesLinea[indiceAmbiente];
            inventariosAsignados[i] = inventariosLinea[indiceAmbiente];
            horariosAsignados[i] = horariosDisponibles[indiceHorario];
        }
    }

    public void mostrarAsignacionAmbiente() {
        if (nombresInstructor != null && ambienteFormacionAsignadas != null) {
            System.out.println("\n📋 Instructores con ambientes y horarios asignados:");
            for (int i = 0; i < nombresInstructor.length; i++) {
                System.out.println("Instructor: " + nombresInstructor[i]);
                System.out.println("  Ambiente: " + ambienteFormacionAsignadas[i]);
                System.out.println("  Descripción: " + descripcionesAsignadas[i]);
                System.out.println("  Inventario: " + inventariosAsignados[i]);
                System.out.println("  Horario: " + horariosAsignados[i]);
                System.out.println();
            }
        } else {
            System.out.println("⚠️ No hay asignaciones realizadas.");
        }
    }

    public String[] getNombres() {
        return nombresInstructor;
    }
}

