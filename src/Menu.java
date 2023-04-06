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
            System.out.println("4. Klanttype beheren");
            System.out.println("5. Afsluiten");
            int keuze = scanner.nextInt();
            scanner.nextLine();

            switch (keuze) {
                case 1 -> {
                    System.out.println("Kies een optie:");
                    System.out.println("1. Klant toevoegen");
                    System.out.println("2. Klant wijzigen");
                    System.out.println("3. Klant verwijderen");
                    System.out.println("4. Klant zoeken");

                    int keuzeKlant = scanner.nextInt();
                    scanner.nextLine();

                    switch (keuzeKlant) {
                        case 1 -> ObjectStorage.addKlant();
                        case 2 -> ObjectStorage.editKlant();
                        case 3 -> ObjectStorage.removeKlant();
                        case 4 -> ObjectStorage.getKlant();
                        default -> System.out.println("Ongeldige keuze");
                    }
                }
                case 2 -> {
                    System.out.println("Kies een optie:");
                    System.out.println("1. Schip toevoegen");
                    System.out.println("2. Schip wijzigen");
                    System.out.println("3. Schip verwijderen");
                    System.out.println("4. Schip zoeken");

                    int keuzeSchip = scanner.nextInt();
                    scanner.nextLine();

                    switch (keuzeSchip) {
                        case 1 -> ObjectStorage.addSchip();
                        case 2 -> ObjectStorage.editSchip();
                        case 3 -> ObjectStorage.removeSchip();
                        case 4 -> ObjectStorage.getSchip();
                        default -> System.out.println("Ongeldige keuze");
                    }
                }
                case 3 -> {
                    System.out.println("Kies een optie:");
                    System.out.println("1. Persoon toevoegen");
                    System.out.println("2. Persoon wijzigen");
                    System.out.println("3. Persoon verwijderen");
                    System.out.println("4. Persoon zoeken");

                    int keuzePersoon = scanner.nextInt();
                    scanner.nextLine();

                    switch (keuzePersoon) {
                        case 1 -> ObjectStorage.addPersoon();
                        case 2 -> ObjectStorage.editPersoon();
                        case 3 -> ObjectStorage.removePersoon();
                        case 4 -> ObjectStorage.getPersoon();
                        default -> System.out.println("Ongeldige keuze");
                    }
                }
                case 4 -> {
                    System.out.println("Kies een optie:");
                    System.out.println("1. Klanttype toevoegen");
                    System.out.println("2. Klanttype wijzigen");
                    System.out.println("3. Klanttype verwijderen");
                    System.out.println("4. Klanttype zoeken");

                    int keuzeKlanttype = scanner.nextInt();
                    scanner.nextLine();

                    switch (keuzeKlanttype) {
                        case 1 -> ObjectStorage.addKlanttype();
                        case 2 -> ObjectStorage.editKlanttype();
                        case 3 -> ObjectStorage.removeKlanttype();
                        case 4 -> ObjectStorage.getKlanttype();
                        default -> System.out.println("Ongeldige keuze");
                    }
                }
                case 5 -> {
                    System.out.println("Afsluiten");
                    doorgaan = false;
                }
                default -> System.out.println("Ongeldige keuze");
            }

        }
    }
}
