import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        sede sede = new sede(); // objeto
        lineaFormacion linea = new lineaFormacion();
        programaFormacion programa = new programaFormacion();
        ambiente ambiente = new ambiente();
    
        do{
        System.out.println("_____________________________________________");   
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
                linea.registrarLinea();
                linea.mostrarLinea();
                break;
            case 3:
               programa.registrarPrograma(linea.getNombre());
               programa.mostrarPrograma();
                break;
            case 4:
                ambiente.asignarAmbientes(linea);
                break;
            case 5:
                System.out.println("pequeña.");
                break;  
            case 6:
                aprendiz aprendiz = new aprendiz();
                aprendiz.registrarAprendiz();
                aprendiz.mostrarAprendiz();
                break;
            default:
                System.out.println("navidad");
        }
        }while(true);
    }
}
