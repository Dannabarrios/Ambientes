import java.util.ArrayList;
import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        sede sede = new sede(); // objeto
        lineaFormacion linea = new lineaFormacion();
        programaFormacion programa = new programaFormacion();
        ambiente ambiente = new ambiente();
        ambientesAprendices aa = new ambientesAprendices();
        horarioAprendiz ha = new horarioAprendiz();
        aprendiz aprendiz = new aprendiz(null, null, null, null);
        reportes reportes = new reportes(aa, ambiente);
        instructor instructor = new instructor();
        asignarInstructor asignarInstructor = new asignarInstructor();
        asignarAmbiente asignar = new asignarAmbiente();
        asignarAmbiente asignador = new asignarAmbiente();
        ArrayList<coordinador> coordinadores = new ArrayList<>();
        asignar.mostrarAsignacionAmbiente();
        asignarAmbiente asignarAmbiente = new asignarAmbiente();
    
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
        System.out.println("8. Registrar aprendiz y asignar ambientes");
        System.out.println("9. Asignar horario");
        System.out.println("10. Asignar horario a aprendices por ambiente");
        System.out.println("11. Validar restricciones");
        System.out.println("12. Coordinador");
        System.out.println("13.  reportes");
        System.out.println("14. Salir");
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
                asignador.asignarAmbientess(instructor.getNombres(), ambiente, 0);
                asignador.mostrarAsignacionAmbiente();
                break;

            case 8:
               aa.asignarAprendices(linea, programa, ambiente);
                break;
            case 9:
                System.err.println("");
                break;
            case 10:
                reportes.mostrarMenuReportes();
                break;
            case 11:
                System.out.println("Validación de restricciones no implementada aún.");
                break;
            case 12:
                System.out.println("\n--- Gestión de Coordinadores ---");
                System.out.println("1. Registrar coordinador");
                System.out.println("2. Asignar instructores a coordinador");
                System.out.println("3. Mostrar coordinadores");
                System.out.print("Seleccione opción: ");
                int opcCoord = scanner.nextInt();
                scanner.nextLine(); // limpiar buffer

                switch (opcCoord) {
                case 1:
                System.out.print("Ingrese nombre del coordinador: ");
                String nombreCoord = scanner.nextLine();
                coordinador c = new coordinador(nombreCoord);
                coordinadores.add(c);
                System.out.println("Coordinador creado.");
                break;

                case 2:
                if (coordinadores.isEmpty()) {
                System.out.println("No hay coordinadores registrados.");
                break;
               }
                System.out.println("Seleccione coordinador:");
                for (int i = 0; i < coordinadores.size(); i++) {
                System.out.println((i + 1) + ". " + coordinadores.get(i).getNombre());
              }
                int idxCoord = scanner.nextInt() - 1;
                scanner.nextLine();

                if (idxCoord < 0 || idxCoord >= coordinadores.size()) {
                System.out.println("Opción inválida.");
                break;
                }
                coordinador coordSeleccionado = coordinadores.get(idxCoord);

                String[] nombresInst = instructor.getNombres();
                if (nombresInst == null || nombresInst.length == 0) {
                System.out.println("No hay instructores registrados.");
                break;
                }
                System.out.println("Instructores disponibles:");
                for (int i = 0; i < nombresInst.length; i++) {
                System.out.println((i + 1) + ". " + nombresInst[i]);
                }

                System.out.print("Ingrese número del instructor a asignar: ");
                int idxInst = scanner.nextInt() - 1;
                scanner.nextLine();

                if (idxInst < 0 || idxInst >= nombresInst.length) {
                System.out.println("Opción inválida.");
                break;
                }
                coordSeleccionado.asignarInstructor(nombresInst[idxInst]);
                System.out.println("Instructor asignado al coordinador.");
                break;

                case 3:
                if (coordinadores.isEmpty()) {
                System.out.println("No hay coordinadores registrados.");
                } else {
                for (coordinador co : coordinadores) {
                    co.mostrarInstructores();
                    System.out.println();
                }
            }
            break;

        default:
            System.out.println("Opción inválida.");
    }
    break;
                
            default:
                System.out.println("navidad");
        }
        }while(true);
    }
}
