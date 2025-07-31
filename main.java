import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        sede sede = new sede(); // objeto

        System.out.println("Bienvenido al sistema de gestión de ambientes");
        System.out.println("Seleccione una opción:");
        System.out.println("1. Registrar ubicación");
        System.out.println("2. Otra función");
        System.out.println("3. Otra función");
        System.out.print("Opción: ");
        int opcion = scanner.nextInt();

        switch (opcion) {
            case 1:
                sede.ingresarUbicacion(); // Llame el metodo
                sede.mostrarUbicacion();  
                break;
            case 2:
                System.out.println("eyy");
                break;
            case 3:
                System.out.println("kurule");
                break;
            default:
                System.out.println("navidad");
        }
    }
}