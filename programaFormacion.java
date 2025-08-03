import java.util.Scanner;

public class programaFormacion {
    private String[] nombre;

    public void registrarPrograma(String[] lineasDisponibles) {
        Scanner scanner = new Scanner(System.in);

        // Mostrar opciones de línea de formación
        if (lineasDisponibles == null || lineasDisponibles.length == 0) {
            System.out.println("No hay líneas de formación registradas");
            return;
        }

        System.out.println("\nSeleccione una línea de formacion:");

        for (int i = 0; i < lineasDisponibles.length; i++) {
            System.out.println((i + 1) + ". " + lineasDisponibles[i]);
        }

        int seleccion;
        do {
            System.out.print("Ingrese el numero de la línea que desea usar: ");
            seleccion = scanner.nextInt();
            scanner.nextLine(); 

            if (seleccion < 1 || seleccion > lineasDisponibles.length) {
                System.out.println("Debe seleccionar un número válido.");
            }
        } while (seleccion < 1 || seleccion > lineasDisponibles.length);

        String lineaSeleccionada = lineasDisponibles[seleccion - 1];
        System.out.println("Línea seleccionada: " + lineaSeleccionada);

        // Registro de programas asociados
        int cantidad;
        do {
            System.out.print("Ingrese cuantos programas desea registrar para esta línea (1-3): ");
            cantidad = scanner.nextInt();
            scanner.nextLine();

            if (cantidad < 1 || cantidad > 3) {
                System.out.println("Debe ingresar un numero entre 1 - 3.");
            }
        } while (cantidad < 1 || cantidad > 3);

        nombre = new String[cantidad];

        for (int i = 0; i < cantidad; i++) {
            System.out.print("Nombre del programa " + (i + 1) + ": ");
            nombre[i] = scanner.nextLine();
        }

        System.out.println("Programas registrados para la línea '" + lineaSeleccionada + "'.");
    }

    public void mostrarPrograma() {
        if (nombre != null && nombre.length > 0) {
            System.out.println("Programas de formación registrados:");
            for (int i = 0; i < nombre.length; i++) {
                System.out.println("Programa " + (i + 1) + ": " + nombre[i]);
            }
        } else {
            System.out.println("No hay programas registrados");
        }
    }

    public String[] getNombre() {
        return nombre;
    }
}
