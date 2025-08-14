import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.util.ArrayList;

public class ambienteAprendices {
    private final ArrayList<aprendiz> asignados = new ArrayList<>();
    private final HashSet<String> documentosAsignados = new HashSet<>();

    public void asignarAprendices(lineaFormacion lf, programaFormacion pf, ambiente am) {
        Scanner sc = new Scanner(System.in);

        // 1) Validaciones básicas
        String[] lineas = lf.getNombre();
        if (lineas == null || lineas.length == 0) {
            System.out.println("Primero registre lineas de formación.");
            return;
        }

        String[] programas = pf.getNombre();
        if (programas == null || programas.length == 0) {
            System.out.println("Primero registre programas de formación.");
            return;
        }

        boolean seguir;
        do {
            // 2) Elegir línea
            System.out.println("\n=== LINEAS REGISTRADAS ===");
            for (int i = 0; i < lineas.length; i++) {
                System.out.println((i + 1) + ". " + lineas[i]);
            }
            System.out.print("Seleccione una línea (1-" + lineas.length + "): ");
            int idxLinea = leerOpcion(sc, 1, lineas.length) - 1;
            String nombreLinea = lineas[idxLinea];

            // 3) Elegir programa (de los ya registrados)
            System.out.println("\n=== PROGRAMAS REGISTRADOS ===");
            for (int i = 0; i < programas.length; i++) {
                System.out.println((i + 1) + ". " + programas[i]);
            }
            System.out.print("Seleccione un programa (1-" + programas.length + "): ");
            int idxProg = leerOpcion(sc, 1, programas.length) - 1;
            String nombrePrograma = programas[idxProg];

            // 4) Elegir ambiente de la línea

            String[] ambientesDeLinea = am.getAmbientesPorLinea(idxLinea);
            if (ambientesDeLinea == null || ambientesDeLinea.length == 0) {
                System.out.println("No hay ambientes registrados para la línea seleccionada.");
                return;
            }
            System.out.println("\n=== AMBIENTES DE LA LÍNEA '" + nombreLinea + "' ===");
            for (int i = 0; i < ambientesDeLinea.length; i++) {
                System.out.println((i + 1) + ". " + ambientesDeLinea[i]);
            }
            int idxAmb = leerOpcion(sc, 1, ambientesDeLinea.length) - 1;
            String nombreAmbiente = ambientesDeLinea[idxAmb];

            // 5) Cantidad de aprendices (1-3)
            System.out.print("\n¿Cuántos aprendices desea registrar en este ambiente? (1-3): ");
            int cantidad = leerOpcion(sc, 1, 3);
            sc.nextLine(); // limpiar salto

            // 6) Registro de aprendices (sin repetir documento)
            for (int i = 0; i < cantidad; i++) {
                System.out.println("\nAprendiz #" + (i + 1));
                System.out.print("Nombre: ");
                String nombre = sc.nextLine();
                System.out.print("Apellido: ");
                String apellido = sc.nextLine();

                String documento;
                while (true) {
                    System.out.print("Documento: ");
                    documento = sc.nextLine().trim();
                    if (documento.isEmpty()) {
                        System.out.println("Documento no puede estar vacío.");
                        continue;
                    }
                    if (documentosAsignados.contains(documento)) {
                        System.out.println("Este documento ya fue asignado a otra línea/programa/ambiente.");
                        continue;
                    }
                    break;
                }

                System.out.print("Ficha: ");
                String ficha = sc.nextLine();

                asignados.add(new aprendiz(nombre, apellido, documento, ficha));
                documentosAsignados.add(documento);
            }

            System.out.println("\nAsignación realizada:");
            System.out.println("  Línea: " + nombreLinea);
            System.out.println("  Programa: " + nombrePrograma);
            System.out.println("  Ambiente: " + nombreAmbiente);
            System.out.println("  Total aprendices asignados: " + asignados.size());

            System.out.print("\n¿Desea asignar aprendices a otro ambiente? (s/n): ");
            String resp = sc.next().trim().toLowerCase();
            seguir = resp.equals("s");
            sc.nextLine(); // limpiar buffer

        } while (seguir);
    }

    // Utilidad para leer opción numérica con rango
    private int leerOpcion(Scanner sc, int min, int max) {
        int op;
        do {
            while (!sc.hasNextInt()) {
                sc.next(); // descartar
                System.out.print("Ingrese un número válido (" + min + "-" + max + "): ");
            }
            op = sc.nextInt();
            if (op < min || op > max) {
                System.out.print("Ingrese un número válido (" + min + "-" + max + "): ");
            }
        } while (op < min || op > max);
        return op;
    }

    public ArrayList<aprendiz> getAprendicesPorAmbiente(int idxLinea, int idxAmbiente) {
    return new ArrayList<>(asignados);
    }

    public void mostrarAprendicesRegistrados() {
    if (asignados.isEmpty()) {
        System.out.println("No hay aprendices registrados.");
        return;
    }
    for (aprendiz a : asignados) {
        System.out.println(a);
    }
}

}
