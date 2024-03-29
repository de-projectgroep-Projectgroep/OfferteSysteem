import java.util.ArrayList;
import java.util.List;

public class Schip {
    public static ArrayList<Optie> opties = new ArrayList<Optie>();
    private static ArrayList<Schip> schepen = new ArrayList<Schip>();
    private String naam;
    private String type;
    private String beschrijving;

    public Schip(String naam, String type, String beschrijving, ArrayList<Optie> opties) {
        this.naam = naam;
        this.type = type;
        this.beschrijving = beschrijving;
        this.opties = opties;
    }

    public String getNaam() {
        return naam;
    }

    public String getType() {
        return type;
    }

    public String getBeschrijving() {
        return beschrijving;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setBeschrijving(String beschrijving) {
        this.beschrijving = beschrijving;
    }

    public ArrayList<Optie> getOpties() {
        return opties;
    }
    public void addOptie() {
        boolean uniekNaam = false;
        String naam = null;
        while (!uniekNaam) {
            naam = Vragen.vraagString("Wat moet de naam van de optie worden?");
            boolean isUniek = true;
            for (Optie optie : opties) {
                if (optie.getNaam().equals(naam)) {
                    System.out.println("Er staat al een optie met deze naam in ons systeem.");
                    isUniek = false;
                    break;
                }
            }
            if (isUniek) {
                uniekNaam = true;
            }
        }

        String beschrijving = Vragen.vraagString("Wat moet de beschrijving van de optie worden?");

        double kosten = Vragen.vraagDouble("Wat zijn de kosten voor deze optie?");

        boolean essentieel = Vragen.vraagJaNee("Is dit een essentiële optie?");

        boolean milieuVriendelijk = Vragen.vraagJaNee("Is deze optie milieuvriendelijk?");

        int milieuKortingspercentage = 0;
        if (milieuVriendelijk) {
            milieuKortingspercentage = Vragen.vraagInt("Wat is het percentage korting voor deze milieuvriendelijke optie?");
        }

        System.out.println("");
        System.out.println("Er is een nieuw optie aangemaakt met de volgende gegevens:");
        System.out.println("Naam: " + naam);
        System.out.println("Beschrijving: " + beschrijving);
        System.out.println("Kosten: €" + kosten);

        if (essentieel) {
            System.out.println("Categorie: " + "essentieël");
        } else {
            System.out.println("Categorie: " + "extra");
        }

        if (milieuVriendelijk) {
            System.out.println("Milieuvriendelijk: " + "ja");
            System.out.println("Korting: " + milieuKortingspercentage + "%");
        } else {
            System.out.println("Milieuvriendelijk: " + "nee");
        }

        System.out.println("");

        opties.add(new Optie(naam, beschrijving, kosten, essentieel, milieuVriendelijk, milieuKortingspercentage));
    }

    public static Optie getOptie() {
        Optie optie = null;
        boolean match = false;

        while (!match) {
            String input = Vragen.vraagString("Wat is de naam van de optie?");
            for (Optie x : opties) {
                if ((x.getNaam()).equalsIgnoreCase(input)) {
                    optie = x;
                    match = true;
                    break;
                }
            }

            if (!match) {
                System.out.println("Er is geen optie met de naam " + input + " in ons systeem gevonden.");
                if (!Vragen.vraagJaNee("Wilt u nog een keer proberen de naam van de optie in te voeren?")) {
                    System.out.println("Het is niet gelukt om de optie te vinden.");
                    break;
                }
            }
        }
        return optie;
    }

    public void removeOptie() {
        Optie optie = getOptie();
        if (optie != null) {
            if (Vragen.vraagJaNee("Weet u zeker dat u deze optie wilt verwijderen?")) {
                opties.remove(optie);
            } else {
                System.out.println("De optie is niet verwijderd.");
            }
        }
    }

    public static void editOptie() {
        Optie optie = getOptie();

        if (optie == null) {
            return;
        }

        while (true) {
            String input = Vragen.vraagString("Wat wilt u aanpassen?");

            switch (input.toLowerCase()) {
                case "naam" -> {
                    boolean uniekType = false;
                    int uniekCheck;
                    String nieuweNaam = null;
                    while (!uniekType) {
                        nieuweNaam = Vragen.vraagString("Wat is de nieuwe naam van de optie?");
                        uniekCheck = 0;
                        for (Optie x : opties) {
                            if (optie.getNaam().equals(nieuweNaam)) {
                                System.out.println("Er staat al een optie in ons systeem met deze naam.");
                                uniekCheck++;
                            }
                        }
                        if (uniekCheck == 0) {
                            uniekType = true;
                        }
                    }
                    if (Vragen.vraagJaNee("Weet u zeker dat u deze naam wilt wijzigen?")) {
                        optie.setNaam(nieuweNaam);
                    } else {
                        System.out.println("De naam is niet gewijzigd.");
                    }
                    return;
                }

                case "beschrijving" -> {
                    String nieuweBeschrijving = Vragen.vraagString("Wat moet de nieuwe beschrijving worden?");
                    if (Vragen.vraagJaNee("Weet u zeker dat u de beschrijving wilt wijzigen?")) {
                        optie.setBeschrijving(nieuweBeschrijving);
                    } else {
                        System.out.println("De beschrijving is niet gewijzigd.");
                    }
                    return;
                }

                case "categorie" -> {
                    boolean nieuweCategorie = Vragen.vraagJaNee("Moet dit een essentiële optie worden?");
                    if (Vragen.vraagJaNee("Weet u zeker dat u de categorie wilt wijzigen?")) {
                        optie.setEssentieel(nieuweCategorie);
                    } else {
                        System.out.println("De categorie is niet gewijzigd.");
                    }
                    return;
                }

                case "milieuvriendelijkheid" -> {
                    boolean nieuweMilieuVriendelijkheid = Vragen.vraagJaNee("Is deze optie millieuvriendelijk?");
                    if (Vragen.vraagJaNee("Weet u zeker dat u de milieuvriendelijkheid wilt wijzigen?")) {
                        optie.setMilieuVriendelijk(nieuweMilieuVriendelijkheid);
                    } else {
                        System.out.println("De milieuvriendelijkheid is niet gewijzigd.");
                    }
                    return;
                }

                case "milieukortingspercentage" -> {
                    if (optie.getMilieuVriendelijk()) {
                        int nieuweMilieuKorting = Vragen.vraagInt("Wat moet het nieuwe milieukortingspercentage worden?");
                        if (Vragen.vraagJaNee("Weet u zeker dat u het milieukortingspercentage wilt wijzigen?")) {
                            optie.setMilieuKortingsPercentage(nieuweMilieuKorting);
                        } else {
                            System.out.println("Het milieukortingspercentage is niet gewijzigd.");
                        }
                    } else {
                        System.out.println("Deze optie is niet milieuvriendelijk.");
                    }
                    return;
                }

                default -> {
                    System.out.println("Dit is geen gegeven dat u kan wijzigen.");
                    System.out.println("U kan de gegevens naam, beschrijving, categorie, milieuvriendelijkheid en milieukortingspercentage wijzigen.");
                    if (!Vragen.vraagJaNee("Wilt u een van deze gegevens wijzigen?")) {
                        return;
                    }
                }
            }
        }
    }

    public static void printOpties(Schip schip) {
        List<Optie> essentieleOpties = new ArrayList<>();
        List<Optie> extraOpties = new ArrayList<>();

        for (Optie optie : schip.getOpties()) {
            if (optie.getEssentieel()) {
                essentieleOpties.add(optie);
            } else {
                extraOpties.add(optie);
            }
        }

        if (!essentieleOpties.isEmpty()) {
            System.out.println("Essentiële opties:");
            for (Optie optie : essentieleOpties) {
                System.out.println(optie.getNaam() + " - " + optie.getBeschrijving() + " - €" + optie.getKosten());
            }
        }

        if (!extraOpties.isEmpty()) {
            System.out.println("Extra opties:");
            for (Optie optie : extraOpties) {
                System.out.println(optie.getNaam() + " - " + optie.getBeschrijving() + " - €" + optie.getKosten());
            }
        }

        if (essentieleOpties.isEmpty() && extraOpties.isEmpty()) {
            System.out.println("Geen opties beschikbaar voor " + schip.getNaam());
        }
    }
}
