import java.util.Scanner;

public class ambiente {
    private String[][] tipos;        
    private String[][] descripciones;
    private String[][] inventarios;

    // Método principal para asignar ambientes a una línea
    public void asignarAmbientes(lineaFormacion lf) {
        Scanner sc = new Scanner(System.in);
        String[] lineas = lf.getNombre();

        if (lineas == null || lineas.length == 0) {
            System.out.println("No hay lineas registradas.");
            return;
        }

        if (tipos == null) {
            tipos = new String[lineas.length][];
            descripciones = new String[lineas.length][];
            inventarios = new String[lineas.length][];
        }

        boolean continuar;
        do {
            mostrarLineas(lineas);

            int idxLinea = seleccionarLinea(sc, lineas.length);
            int cantidad = seleccionarCantidadAmbientes(sc);

            tipos[idxLinea] = new String[cantidad];
            descripciones[idxLinea] = new String[cantidad];
            inventarios[idxLinea] = new String[cantidad];

            for (int i = 0; i < cantidad; i++) {
                registrarAmbiente(sc, idxLinea, i);
            }

            mostrarAmbientesDeLinea(idxLinea, lineas[idxLinea]);

            continuar = preguntarContinuar(sc);

        } while (continuar);
    }

    // Muestra todas las líneas disponibles
    private void mostrarLineas(String[] lineas) {
        System.out.println("\n=== LÍNEAS DISPONIBLES ===");
        for (int i = 0; i < lineas.length; i++) {
            System.out.println((i + 1) + ". " + lineas[i]);
        }
    }

    // Selecciona la línea
    private int seleccionarLinea(Scanner sc, int totalLineas) {
        int idx;
        do {
            System.out.print("Seleccione la línea (1-" + totalLineas + "): ");
            while (!sc.hasNextInt()) {
                sc.nextLine();
                System.out.print("Ingrese un número válido: ");
            }
            idx = sc.nextInt();
            sc.nextLine();
        } while (idx < 1 || idx > totalLineas);
        return idx - 1;
    }

    // Cantidad de ambientes
    private int seleccionarCantidadAmbientes(Scanner sc) {
        int cantidad;
        do {
            System.out.print("¿Cuántos ambientes desea registrar? (1-3): ");
            while (!sc.hasNextInt()) {
                sc.nextLine();
                System.out.print("Ingrese un número válido (1-3): ");
            }
            cantidad = sc.nextInt();
            sc.nextLine();
        } while (cantidad < 1 || cantidad > 3);
        return cantidad;
    }

    // Registro de un ambiente específico
    private void registrarAmbiente(Scanner sc, int idxLinea, int idxAmbiente) {
        System.out.println("\nAmbiente " + (idxAmbiente + 1));

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

        tipos[idxLinea][idxAmbiente] = switch (tipoOpcion) {
            case 1 -> "Maquinaria";
            case 2 -> "Especializado";
            default -> "Normal";
        };

        System.out.print("Descripción del ambiente: ");
        descripciones[idxLinea][idxAmbiente] = sc.nextLine();

        System.out.print("Inventario breve: ");
        inventarios[idxLinea][idxAmbiente] = sc.nextLine();
    }

    // Mostrar ambientes de una línea específica
    public void mostrarAmbientesDeLinea(int idxLinea, String nombreLinea) {
        System.out.println("\nAmbientes para la línea: " + nombreLinea);
        if (tipos[idxLinea] != null) {
            for (int i = 0; i < tipos[idxLinea].length; i++) {
                System.out.println("  - Ambiente " + (i + 1) + ": " + tipos[idxLinea][i]);
                System.out.println("    Descripción: " + descripciones[idxLinea][i]);
                System.out.println("    Inventario: " + inventarios[idxLinea][i]);
            }
        } else {
            System.out.println("No hay ambientes registrados para esta línea.");
        }
    }

    // Mostrar todos los ambientes de todas las líneas
    public void mostrarAmbientes(lineaFormacion lf) {
        String[] lineas = lf.getNombre();
        for (int i = 0; i < lineas.length; i++) {
            mostrarAmbientesDeLinea(i, lineas[i]);
        }
    }

    // Preguntar si continuar
    private boolean preguntarContinuar(Scanner sc) {
        System.out.print("\n¿Desea asignar ambientes a otra línea (s/n): ");
        return sc.nextLine().trim().equalsIgnoreCase("s");
    }

    // Getter opcional para obtener ambientes por línea
    public String[] getAmbientesPorLinea(int idxLinea) {
    if (tipos == null || idxLinea < 0 || idxLinea >= tipos.length || tipos[idxLinea] == null) {
        return new String[0];
    }
    String[] result = new String[tipos[idxLinea].length];
    for (int i = 0; i < result.length; i++) {
        String tipo = tipos[idxLinea][i] != null ? tipos[idxLinea][i] : "Sin tipo";
        String desc = (descripciones != null && descripciones[idxLinea] != null && descripciones[idxLinea][i] != null)
                      ? descripciones[idxLinea][i] : "";
        result[i] = "Ambiente " + (i + 1) + " - " + tipo + (desc.isEmpty() ? "" : " (" + desc + ")");
    }
    return result;
}


    public String getDescripciones() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getDescripciones'");
    }

    public Object getTipos() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getTipos'");
    }
}
