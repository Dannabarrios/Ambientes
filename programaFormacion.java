import java.util.Scanner;

public class programaFormacion {
    private String nombre;

    public programaFormacion() {}

    public programaFormacion(String nombre) {
        this.nombre = nombre;
    }

    public void registrarPrograma() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\nRegistro de Programa de Formación:");
        System.out.print(" Ingrese el nombre del programa: ");
        nombre = scanner.nextLine();
        System.out.println("Programa registrado correctamente.\n");
    }

    public void mostrarPrograma() {
        System.out.println("📘 Nombre del programa: " + nombre);
    }

    public String getNombre() {
        return nombre;
    }
}
