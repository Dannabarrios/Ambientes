import java.util.Scanner;

public class sede {
    private String tipoUbicacion; // Región,centro y dede
    private String ciudad;

    public void ingresarUbicacion() {
        Scanner scanner = new Scanner(System.in);
        int opcion;

        System.out.println("Seleccione la ubicación");
        System.out.println("1. Región");
        System.out.println("2. Centro");
        System.out.println("3. Sede");
        System.out.print("Opción: ");
        opcion = scanner.nextInt();
        scanner.nextLine();

        switch (opcion) {
            case 1:
                tipoUbicacion = "Región";
                break;
            case 2:
                tipoUbicacion = "Centro";
                break;
            case 3:
                tipoUbicacion = "Sede";
                break;
            default:
                System.out.println("Opción inválida.");
                return;
        }

        System.out.print("Ingrese el nombre de la ciudad para " + tipoUbicacion + ": ");
        ciudad = scanner.nextLine();
        System.out.println("\n Ubicación registrada: " + tipoUbicacion + " en " + ciudad);
    }

    // Método opcional para mostrar los datos luego
    public void mostrarUbicacion() {
        System.out.println("\nTipo: " + tipoUbicacion);
        System.out.println("Ciudad: " + ciudad);
    }
}