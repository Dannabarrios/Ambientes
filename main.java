import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        sede sede = new sede(); // objeto

        System.out.println("Bienvenido al sistema de gestión de ambientes");
        System.out.println("Seleccione una opción:");
        System.out.println("1. Registrar ubicación");
        System.out.println("2. Registrar linea de formación");
        System.out.println("3. Registar programa de formación");
        System.out.println("4. Registar ambiente");
        System.out.println("5. Registrar instructor");
        System.out.println("6. Registrar aprendiz");
        System.out.println("7. Asignar horario");
        System.out.println("8. Reportes");
        System.out.println("9. Validar restricciones");
        System.out.println("10. Salir");
        System.out.print("Opción: ");
        int opcion = scanner.nextInt();

        switch (opcion) {
            case 1:
                sede.ingresarUbicacion(); // Llame el metodo
                sede.mostrarUbicacion();  
                break;
            case 2:
                lineaFormacion linea = new lineaFormacion();
                linea.registrarLinea();
                linea.mostrarLinea();
                break;
            case 3:
               programaFormacion programa = new programaFormacion();
               programa.registrarPrograma();
               programa.mostrarPrograma();
                break;
            default:
                System.out.println("navidad");
        }
    }
}
