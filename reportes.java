import java.util.Scanner;

public class reportes {

    private ambienteAprendices aprendices;
    private ambiente ambientes;

    public reportes(ambienteAprendices aprendices, ambiente ambientes) {
        this.aprendices = aprendices;
        this.ambientes = ambientes;
    }

    public void mostrarMenuReportes() {
        Scanner sc = new Scanner(System.in);
        int opcion;
        do {
            System.out.println("\n=== REPORTES ===");
            System.out.println("1. Reporte de instructores por sede, línea, programa o total");
            System.out.println("2. Reporte de aprendices por sede, línea, programa o total");
            System.out.println("3. Reporte de ambientes por especialidad o programa");
            System.out.println("4. Reporte de horarios por jornada, cantidad de grupos e instructores");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = sc.nextInt();
            sc.nextLine();

            switch(opcion) {
                case 1:
                    System.out.println("Reporte de instructores aún no implementado.");
                    break;
                case 2:
                    reporteAprendices();
                    break;
                case 3:
                    reporteAmbientes();
                    break;
                case 4:
                    System.out.println("Reporte de horarios aún no implementado.");
                    break;
                case 5:
                    System.out.println("Saliendo de reportes...");
                    break;
                default:
                    System.out.println("Opción inválida.");
            }
        } while(opcion != 5);
    }

    // ======= REPORTE 2: Aprendices =======
    private void reporteAprendices() {
        System.out.println("\n--- REPORTE DE APRENDICES ---");
        // Por ahora mostramos todos los aprendices registrados
        if (aprendices == null) {
            System.out.println("No hay aprendices registrados.");
            return;
        }

        aprendices.mostrarAprendicesRegistrados();
    }

    // ======= REPORTE 3: Ambientes =======
    private void reporteAmbientes() {
        System.out.println("\n--- REPORTE DE AMBIENTES ---");
        if (ambientes == null) {
            System.out.println("No hay ambientes registrados.");
            return;
        }

        ambientes.mostrarTodosAmbientes();
    }
}

