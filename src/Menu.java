import java.util.Scanner;
public class Menu {
    Scanner scanner = new Scanner(System.in);
    public void start() {
        boolean doorgaan = true;
        System.out.println("Welkom bij de beheer applicatie.");
        while (doorgaan) {
            System.out.println("Kies een optie:");
            System.out.println("1. Klant beheren");
            System.out.println("2. Schip beheren");
            System.out.println("3. Persoon beheren");

            int keuze = scanner.nextInt();
            scanner.nextLine();

        }
    }
}
