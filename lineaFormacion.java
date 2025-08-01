

import java.util.Scanner;

public class lineaFormacion {
    private String nombre;
    

    // Constructor vacío
    public lineaFormacion() {}

    // Constructor completo
    public lineaFormacion(String nombre, String descripcion) {
        this.nombre = nombre;
    }

    // Método para registrar una línea de formación
    public void registrarLinea() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("\n Registro de Línea de Formación:");
        System.out.print("Nombre de la línea: ");
        nombre = scanner.nextLine();


        System.out.println("Línea de formación registrada\n");
    }

    // Método para mostrar la línea registrada
    public void mostrarLinea() {
        System.out.println(" Nombre: " + nombre);
       
    }

    // Getters para acceder a los atributos si se necesitan en otras clases
    public String getNombre() {
        return nombre;
    }  
}
