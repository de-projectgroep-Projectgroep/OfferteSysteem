import java.util.Scanner;
public class Menu {
    Scanner scanner = new Scanner(System.in);
    public void start() {
        boolean doorgaan = true;
        System.out.println("Welkom bij de beheerapplicatie.");
        while (doorgaan) {
            System.out.println("Kies een optie:");
            System.out.println("1. Klanten beheren");
            System.out.println("2. Schepen beheren");
            System.out.println("3. Personen beheren");
            System.out.println("4. Klanttypes beheren");
            System.out.println("5. Totaalprijs berekenen");
            System.out.println("6. Afsluiten");

            int keuze;
            try {
                keuze = scanner.nextInt();
                scanner.nextLine();
            } catch (Exception e) {
                System.out.println("Ongeldige invoer. Kies een nummer.");
                scanner.nextLine();
                continue;
            }

            switch (keuze) {
                case 1 -> {
                    System.out.println("Kies een optie:");
                    System.out.println("1. Klant toevoegen");
                    System.out.println("2. Klant wijzigen");
                    System.out.println("3. Klant verwijderen");
                    System.out.println("4. Klant zoeken");
                    System.out.println("5. Klanten printen");
                    System.out.println("6. Terug naar hoofdmenu");

                    int keuzeKlant;
                    try {
                        keuzeKlant = scanner.nextInt();
                        scanner.nextLine();
                    } catch (Exception e) {
                        System.out.println("Ongeldige invoer. Kies een nummer.");
                        scanner.nextLine();
                        continue;
                    }

                    switch (keuzeKlant) {
                        case 1 -> {
                            ObjectStorage.addKlant();
                            System.out.println("");
                        }
                        case 2 -> {
                            ObjectStorage.editKlant();
                            System.out.println("");
                        }
                        case 3 -> {
                            ObjectStorage.removeKlant();
                            System.out.println("");
                        }
                        case 4 -> {
                            ObjectStorage.getKlant();
                            System.out.println("");
                        }
                        case 5 -> {
                            ObjectStorage.printKlanten();
                            System.out.println("");
                        }
                        case 6 -> {
                            System.out.println("");
                            break;
                        }
                        default -> System.out.println("Ongeldige keuze");
                    }
                }
                case 2 -> {
                    System.out.println("Kies een optie:");
                    System.out.println("1. Schip toevoegen");
                    System.out.println("2. Schip wijzigen");
                    System.out.println("3. Schip verwijderen");
                    System.out.println("4. Schip zoeken");
                    System.out.println("5. Schepen printen");
                    System.out.println("6. Terug naar hoofdmenu");

                    int keuzeSchip;
                    try {
                        keuzeSchip = scanner.nextInt();
                        scanner.nextLine();
                    } catch (Exception e) {
                        System.out.println("Ongeldige invoer. Kies een nummer.");
                        scanner.nextLine();
                        continue;
                    }

                    switch (keuzeSchip) {
                        case 1 -> {
                            ObjectStorage.addSchip();
                            System.out.println("");}
                        case 2 -> {
                            ObjectStorage.editSchip();
                            System.out.println("");
                        }
                        case 3 -> {
                            ObjectStorage.removeSchip();
                            System.out.println("");
                        }
                        case 4 -> {
                            ObjectStorage.getSchip();
                            System.out.println("");
                        }
                        case 5 -> {
                            ObjectStorage.printSchepen();
                            System.out.println("");
                        }
                        case 6 -> {
                            System.out.println("");
                            break;
                        }
                        default -> System.out.println("Ongeldige keuze");
                    }
                }
                case 3 -> {
                    System.out.println("Kies een optie:");
                    System.out.println("1. Persoon toevoegen");
                    System.out.println("2. Persoon wijzigen");
                    System.out.println("3. Persoon verwijderen");
                    System.out.println("4. Persoon zoeken");
                    System.out.println("5. Personen printen");
                    System.out.println("6. Terug naar hoofdmenu");


                    int keuzePersoon;
                    try {
                        keuzePersoon = scanner.nextInt();
                        scanner.nextLine();
                    } catch (Exception e) {
                        System.out.println("Ongeldige invoer. Kies een nummer.");
                        scanner.nextLine();
                        continue;
                    }

                    switch (keuzePersoon) {
                        case 1 -> {
                            ObjectStorage.addPersoon();
                            System.out.println("");
                        }
                        case 2 -> {
                            ObjectStorage.editPersoon();
                            System.out.println("");
                        }
                        case 3 -> {
                            ObjectStorage.removePersoon();
                            System.out.println("");
                        }
                        case 4 -> {
                            ObjectStorage.getPersoon();
                            System.out.println("");
                        }

                        case 5 -> {
                            ObjectStorage.printPersonen();
                            System.out.println("");
                        }
                        case 6 -> {
                            break;
                        }
                        default -> System.out.println("Ongeldige keuze");
                    }
                }
                case 4 -> {
                    System.out.println("Kies een optie:");
                    System.out.println("1. Klanttype toevoegen");
                    System.out.println("2. Klanttype wijzigen");
                    System.out.println("3. Klanttype verwijderen");
                    System.out.println("4. Klanttype zoeken");
                    System.out.println("5. Klanttypes printen");
                    System.out.println("6. Terug naar hoofdmenu");


                    int keuzeKlanttype;
                    try {
                        keuzeKlanttype = scanner.nextInt();
                        scanner.nextLine();
                    } catch (Exception e) {
                        System.out.println("Ongeldige invoer. Kies een nummer.");
                        scanner.nextLine();
                        continue;
                    }

                    switch (keuzeKlanttype) {
                        case 1 -> {
                            ObjectStorage.addKlanttype();
                            System.out.println("");
                        }
                        case 2 -> {
                            ObjectStorage.editKlanttype();
                            System.out.println("");
                        }
                        case 3 -> {
                            ObjectStorage.removeKlanttype();
                            System.out.println("");
                        }
                        case 4 -> {
                            ObjectStorage.getKlanttype();
                            System.out.println("");
                        }
                        case 5 -> {
                            ObjectStorage.printKlanttypes();
                            System.out.println("");
                        }
                        case 6 -> {
                            break;
                        }
                        default -> System.out.println("Ongeldige keuze");
                    }
                }

                case 5 -> {
                    Totaalprijs.berekenTotaalPrijs();
                }

                case 6 -> {
                    System.out.println("Afsluiten");
                    doorgaan = false;
                }
                default -> System.out.println("Ongeldige keuze");
            }
        }
    }
}
