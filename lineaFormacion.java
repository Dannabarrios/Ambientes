

import java.util.Scanner;

public class lineaFormacion {
    private String[] nombre;

    public void registrarLinea() {
        Scanner scanner = new Scanner(System.in);
        int cantidad;

        System.out.println("\n Registro de Linea de Formación:");

        do {
            System.out.print("Ingrese cuantas lineas de formacion desea registrar (1-3): ");
            cantidad = scanner.nextInt();
            scanner.nextLine(); 

            // 
            if (cantidad < 1 || cantidad > 3) {
                System.out.println("Debe ingresar un numero entre 1 y 3");
            }
        } while (cantidad < 1 || cantidad > 3);

        nombre = new String[cantidad];

        for(int i=0; i < cantidad; i++){
           System.out.println("Nombre de la linea " + (i + 1) + ":");
           nombre[i]= scanner.nextLine();
        }
    }

    // Método para mostrar la línea registrada
    public void mostrarLinea() {
        if (nombre != null && nombre.length > 0) {
            System.out.println("Lineas de formacion registradas:");
            for (int i = 0; i < nombre.length; i++) {
                System.out.println("Linea " + (i + 1) + ": " + nombre[i]);
            }
        } else {
            System.out.println("No hay lineas registradas");
        }
    }

    // Getters para acceder a los atributos si se necesitan en otras clases
    public String[] getNombre() {
        return nombre;
    }  
}
