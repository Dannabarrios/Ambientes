import java.util.Scanner;

public class ambiente {
    private String[][] tipos;        // tipos por línea
    private String[][] descripciones;
    private String[][] inventarios;

    public void asignarAmbientes(lineaFormacion lf) {
        Scanner sc = new Scanner(System.in);
        String[] lineas = lf.getNombre();

        if (lineas == null || lineas.length == 0) {
            System.out.println("No hay líneas registradas.");
            return;
        }

        // Arreglos por línea (se crean cuando se usa cada línea)
        tipos = new String[lineas.length][];
        descripciones = new String[lineas.length][];
        inventarios = new String[lineas.length][];

        boolean continuar;

        do {
            // 1) Mostrar líneas
            System.out.println("\n=== LÍNEAS DISPONIBLES ===");
            for (int i = 0; i < lineas.length; i++) {
                System.out.println((i + 1) + ". " + lineas[i]);
            }

            // 2) Elegir línea (con validación)
            int idxLinea;
            do {
                System.out.print("Seleccione la línea (1-" + lineas.length + "): ");
                while (!sc.hasNextInt()) { // valida que sea número
                    sc.nextLine();
                    System.out.print("Ingrese un número válido: ");
                }
                idxLinea = sc.nextInt();
                sc.nextLine(); // limpiar salto
            } while (idxLinea < 1 || idxLinea > lineas.length);
            idxLinea--; // a índice base 0

            // 3) Cantidad de ambientes (1-3)
            int cantidad;
            do {
                System.out.print("¿Cuántos ambientes desea registrar para esta línea? (1-3): ");
                while (!sc.hasNextInt()) {
                    sc.nextLine();
                    System.out.print("Ingrese un número válido (1-3): ");
                }
                cantidad = sc.nextInt();
                sc.nextLine();
            } while (cantidad < 1 || cantidad > 3);

            // Inicializar arreglos para esta línea
            tipos[idxLinea] = new String[cantidad];
            descripciones[idxLinea] = new String[cantidad];
            inventarios[idxLinea] = new String[cantidad];

            // 4) Registrar cada ambiente
            for (int i = 0; i < cantidad; i++) {
                System.out.println("\nAmbiente " + (i + 1));
                int tipoOpcion;
                do {
                    System.out.println("Tipo de ambiente:");
                    System.out.println("1. Maquinaria");
                    System.out.println("2. Especializado");
                    System.out.println("3. Normal");
                    System.out.print("Seleccione (1-3): ");
                    while (!sc.hasNextInt()) {
                        sc.nextLine();
                        System.out.print("Ingrese un número válido (1-3): ");
                    }
                    tipoOpcion = sc.nextInt();
                    sc.nextLine();
                } while (tipoOpcion < 1 || tipoOpcion > 3);

                tipos[idxLinea][i] = switch (tipoOpcion) {
                    case 1 -> "Maquinaria";
                    case 2 -> "Especializado";
                    default -> "Normal";
                };

                System.out.print("Descripción del ambiente: ");
                descripciones[idxLinea][i] = sc.nextLine();

                System.out.print("Inventario breve: ");
                inventarios[idxLinea][i] = sc.nextLine();
            }

            // 5) Mostrar lo registrado para esa línea
            System.out.println("\nAmbientes para la línea: " + lineas[idxLinea]);
            for (int i = 0; i < tipos[idxLinea].length; i++) {
                System.out.println("  - Ambiente " + (i + 1) + ": " + tipos[idxLinea][i]);
                System.out.println("    Descripción: " + descripciones[idxLinea][i]);
                System.out.println("    Inventario: " + inventarios[idxLinea][i]);
            }

            // 6) Preguntar si desea continuar
            System.out.print("\n¿Desea asignar ambientes a otra línea? (s/n): ");
            String resp = sc.nextLine().trim().toLowerCase();
            continuar = resp.equals("s");

        } while (continuar);
    }
    public String[][] getTipos() {
    return tipos;
    }

    public String[][] getDescripciones() {
    return descripciones;
   }

    public String[][] getInventarios() {
    return inventarios;
    }
}

