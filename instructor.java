import java.util.Scanner;

public class instructor{
    private String[] nombre;
    // Método para registrar los aprendices
    public void registrarInstructor() {
        Scanner scanner = new Scanner(System.in);
        int cantidad;

        System.out.println("\n Registro de Instructor:");

        do {
            System.out.print("Ingrese cuantos instructores desea registrar (1-3): ");
            cantidad = scanner.nextInt();
            scanner.nextLine(); 

            // 
            if (cantidad < 1 || cantidad > 3) {
                System.out.println("Debe ingresar un numero entre 1 y 3");
            }
        } while (cantidad < 1 || cantidad > 3);

        nombre = new String[cantidad];
         for(int i=0; i < cantidad; i++){
           System.out.println("Nombre del instructor" + (i + 1) + ":");
           nombre[i]= scanner.nextLine();
        }

        System.out.println("Instructores registrados correctamente: ");
    }

    // Método para mostrar el instructor registrado
    public void mostrarInstructor() {
        if (nombre != null && nombre.length > 0) {
            System.out.println("Instructores registrados:");
            for (int i = 0; i < nombre.length; i++) {
                System.out.println("Instructor " + (i + 1) + ": " + nombre[i]);
            }
        } else {
            System.out.println("No hay instructores registrados");
        }
    }
      public String[] getNombres() {
        return nombre;
    }
}

