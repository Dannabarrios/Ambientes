import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Bienvenidos");
        switch (scanner.nextInt()) {
            case 1:
                System.out.println("r");
                System.out.print("hello");
                break;
            case 2:
                System.out.println("b");
                break;
            case 3:
                System.out.println("clothess");
                break;
            default:
                System.out.println("invalido");
        }
    
        scanner.close();rata
    }
}
