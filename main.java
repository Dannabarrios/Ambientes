import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        sede sede = new sede(); // objeto
        lineaFormacion linea = new lineaFormacion();
        programaFormacion programa = new programaFormacion();
        ambiente ambiente = new ambiente();
        instructor instructor = new instructor();
        asignarInstructor asignarInstructor = new asignarInstructor();
        asignarAmbiente asignarAmbiente = new asignarAmbiente();

        
        
        
        aprendiz aprendiz = new aprendiz();
    
        do{
        System.out.println("- - - - - - - - - - - ");   
        System.out.println("Bienvenido al sistema de gestión de ambientes");
        System.out.println("Seleccione una opción:");
        System.out.println("1. Registrar ubicación");
        System.out.println("2. Registrar linea de formación");
        System.out.println("3. Registar programa de formación");
        System.out.println("4. Registar ambiente");
        System.out.println("5. Registrar instructor");
        System.out.println("6. Mirar asignacion de instructor por linea");
        System.out.println("7. Mirar asignacion de instructor por ambiente");
        System.out.println("8. Registrar aprendiz");
        System.out.println("9. Asignar horario");
        System.out.println("10. Reportes");
        System.out.println("11. Validar restricciones");
        System.out.println("12. Salir");
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
                instructor.registrarInstructor();
                instructor.mostrarInstructor();
                break;
              
            case 6:
               asignarInstructor.asignarLineas(instructor.getNombres(), linea.getNombre());
               asignarInstructor.mostrarAsignacionInstructor();

                break;
            case 7:
                asignarAmbiente.asignarAmbientes(ambiente.getTipos,ambiente.getDescripciones,ambiente.getInventarios());
                asignarAmbiente.mostrarAsignacionAmbientesInstructor();
                break;
            case 8:
                aprendiz.registrarAprendiz();
                aprendiz.mostrarAprendiz();
                break;
            default:
                System.out.println("navidad");
        }
        }while(true);
    }
}
