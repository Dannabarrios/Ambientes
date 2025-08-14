import java.util.ArrayList;
import java.util.Scanner;

public class horarioAprendiz {

    // Lista de horarios disponibles
    private final String[] horarios = {"Mañana (6-12)", "Tarde (12-18)", "Noche (18-24)"};

    // Método principal para asignar horario a aprendices de un ambiente
    public void asignarHorarioAprendices(
            lineaFormacion lf,
            programaFormacion pf,
            ambiente am,
            ambienteAprendices aa
    ) {
        Scanner sc = new Scanner(System.in);

        System.out.println("=== ASIGNAR HORARIO A APRENDICES DE UN AMBIENTE ===");

        // 1) Selección de línea
        String[] lineas = lf.getNombre();
        if (lineas == null || lineas.length == 0) {
            System.out.println("No hay líneas registradas.");
            return;
        }
        int idxLinea = seleccionarOpcion(sc, lineas, "LÍNEAS REGISTRADAS");

        // 2) Selección de programa
        String[] programas = pf.getNombre();
        if (programas == null || programas.length == 0) {
            System.out.println("No hay programas registrados.");
            return;
        }
        int idxPrograma = seleccionarOpcion(sc, programas, "PROGRAMAS REGISTRADOS");

        // 3) Selección de ambiente
        String[] ambientes = am.getAmbientesPorLinea(idxLinea);
        if (ambientes == null || ambientes.length == 0) {
            System.out.println("No hay ambientes registrados para esta línea.");
            return;
        }
        int idxAmbiente = seleccionarOpcion(sc, ambientes, "AMBIENTES REGISTRADOS DEL PROGRAMA '" + programas[idxPrograma] + "'");

        // 4) Mostrar aprendices registrados en el ambiente
        ArrayList<aprendiz> aprendices = aa.getAprendicesPorAmbiente(idxLinea, idxAmbiente);
        if (aprendices == null || aprendices.isEmpty()) {
            System.out.println("No hay aprendices registrados en este ambiente.");
            return;
        }

        System.out.println("\n=== APRENDICES DEL AMBIENTE '" + ambientes[idxAmbiente] + "' ===");
        for (aprendiz a : aprendices) {
            System.out.println("- " + a.toString() + " | Horario: " + a.getHorario());
        }

        // 5) Selección de horario
        int idxHorario = seleccionarOpcion(sc, horarios, "Seleccione el horario para estos aprendices");

        // 6) Asignar horario a todos los aprendices del ambiente
        for (aprendiz a : aprendices) {
            a.setHorario(horarios[idxHorario]);
        }

        System.out.println("\nHorario '" + horarios[idxHorario] + "' asignado a todos los aprendices del ambiente '" + ambientes[idxAmbiente] + "'.");
    }

    // Método auxiliar para mostrar un menú y seleccionar opción
    private int seleccionarOpcion(Scanner sc, String[] opciones, String titulo) {
        System.out.println("\n=== " + titulo + " ===");
        for (int i = 0; i < opciones.length; i++) {
            System.out.println((i + 1) + ". " + opciones[i]);
        }
        System.out.print("Seleccione una opción: ");
        int opcion;
        do {
            while (!sc.hasNextInt()) {
                sc.next(); // descartar entrada inválida
                System.out.print("Ingrese un número válido: ");
            }
            opcion = sc.nextInt();
            if (opcion < 1 || opcion > opciones.length) {
                System.out.print("Opción inválida, intente de nuevo: ");
            }
        } while (opcion < 1 || opcion > opciones.length);
        sc.nextLine(); // limpiar buffer
        return opcion - 1; // devolver índice
    }
}

