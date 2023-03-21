import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Optie {
    private final OptieGegevens gegevens;

    public Optie(OptieGegevens gegevens) {
        this.gegevens = gegevens;
    }

    public OptieGegevens getGegevens() {
        return gegevens;
    }

    public static double milieuKorting(List<Optie> opties) {
        double korting = 0.0;
        for (Optie optie : opties) {
            if (optie.getGegevens().isMilieuVriendelijk()) {
                korting += 0.1;
            }
        }
        return korting;
    }

    public static void toonOpties(List<Optie> opties) {
        List<Optie> essentieleOpties = new ArrayList<>();
        List<Optie> extraOpties = new ArrayList<>();

        for (Optie optie : opties) {
            if (optie.getGegevens().getCategorie().equals("Essentieel")) {
                essentieleOpties.add(optie);
            } else {
                extraOpties.add(optie);
            }
        }

        System.out.println("Essentiële opties:");
        for (Optie optie : essentieleOpties) {
            System.out.println(optie.getGegevens().getNaam() + " - " + optie.getGegevens().getBeschrijving());
        }

        System.out.println("Extra opties:");
        for (Optie optie : extraOpties) {
            System.out.println(optie.getGegevens().getNaam() + " - " + optie.getGegevens().getBeschrijving());
        }
    }

    public static void voegOptieToe(List<Optie> opties) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Wil je een nieuwe optie toevoegen? (ja/nee)");
        String keuze = scanner.nextLine().toLowerCase();

        if (keuze.equals("ja")) {
            System.out.println("Wat is de naam van de optie?");
            String naam = scanner.nextLine();

            System.out.println("Wat is de beschrijving van de optie?");
            String beschrijving = scanner.nextLine();

            System.out.println("In welke categorie hoort de optie? (Essentieel/Extra)");
            String categorie = scanner.nextLine();

            System.out.println("Is de optie milieuvriendelijk? (ja/nee)");
            String milieu = scanner.nextLine().toLowerCase();

            OptieGegevens gegevens = new OptieGegevens(naam, beschrijving, categorie);
            Optie optie = new Optie(gegevens);

            opties.add(optie);

            System.out.println("Je hebt een nieuwe optie toegevoegd!");
        } else {
            System.out.println("Geen nieuwe optie toegevoegd.");
        }
    }

    public static void verwijderOptie(List<Optie> opties) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welke optie wil je verwijderen?");
        String naam = scanner.nextLine();

        Optie optie = null;
        for (Optie o : opties) {
            if (o.getGegevens().getNaam().equalsIgnoreCase(naam)) {
                optie = o;
                break;
            }
        }

        if (optie != null) {
            opties.remove(optie);
            System.out.println("Je hebt de optie \"" + naam + "\" verwijderd.");
        } else {
            System.out.println("De optie \"" + naam + "\" bestaat niet.");
        }
    }

    public static void bewerkOptie(List<Optie> opties) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welke optie wil je bewerken?");
        String naam = scanner.nextLine();

        Optie optie = null;
        for (Optie o : opties) {
            if (o.getGegevens().getNaam().equalsIgnoreCase(naam)) {
                optie = o;
                break;
            }
        }

        if (optie != null) {
            System.out.println("Wat wil je bewerken?");
            System.out.println("1. Naam");
            System.out.println("2. Beschrijving");
            System.out.println("3. Categorie");
            int keuze = scanner.nextInt();
            scanner.nextLine();

            switch (keuze) {
                case 1 -> {
                    System.out.println("Wat is de nieuwe naam?");
                    String nieuweNaam = scanner.nextLine();
                    optie.getGegevens().setNaam(nieuweNaam);
                    System.out.println("De naam is gewijzigd naar \"" + nieuweNaam + "\".");
                }
                case 2 -> {
                    System.out.println("Wat is de nieuwe beschrijving?");
                    String nieuweBeschrijving = scanner.nextLine();
                    optie.getGegevens().setBeschrijving(nieuweBeschrijving);
                    System.out.println("De beschrijving is gewijzigd naar \"" + nieuweBeschrijving + "\".");
                }
                case 3 -> {
                    System.out.println("In welke categorie hoort de optie? (Essentieel/Extra)");
                    String nieuweCategorie = scanner.nextLine();
                    optie.getGegevens().setCategorie(nieuweCategorie);
                    System.out.println("De categorie is gewijzigd naar \"" + nieuweCategorie + "\".");
                }
                default -> System.out.println("Ongeldige keuze.");
            }
        } else {
            System.out.println("De optie \"" + naam + "\" bestaat niet.");
        }
    }
}
