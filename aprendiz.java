import java.util.Scanner;

public class aprendiz{
    private String[] nombre;
    // Método para registrar los aprendices
    public void registrarAprendiz() {
        Scanner scanner = new Scanner(System.in);
        int cantidad;

        System.out.println("\n Registro de Aprendiz:");

        do {
            System.out.print("Ingrese cuantos aprendices desea registrar (1-3): ");
            cantidad = scanner.nextInt();
            scanner.nextLine(); 

            // 
            if (cantidad < 1 || cantidad > 3) {
                System.out.println("Debe ingresar un numero entre 1 y 3");
            }
        } while (cantidad < 1 || cantidad > 3);

        nombre = new String[cantidad];
         for(int i=0; i < cantidad; i++){
           System.out.println("Nombre del aprendiz" + (i + 1) + ":");
           nombre[i]= scanner.nextLine();
        }

        System.out.println("Aprendices  registrados correctamente: ");
    }

    // Método para mostrar el aprendiz registrado
    public void mostrarAprendiz() {
        if (nombre != null && nombre.length > 0) {
            System.out.println("Aprendices registrados:");
            for (int i = 0; i < nombre.length; i++) {
                System.out.println("Aprendiz " + (i + 1) + ": " + nombre[i]);
            }
        } else {
            System.out.println("No hay aprendicesregistrados");
        }
    }
}

