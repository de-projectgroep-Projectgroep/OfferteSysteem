import java.util.ArrayList;
import java.util.List;

public class Schip {
    public ArrayList<Optie> opties = new ArrayList<Optie>();
    private static ArrayList<Schip> schepen = new ArrayList<Schip>();
    private String naam;
    private String beschrijving;
    private String motor;

    public Schip(String naam, String beschrijving, String motor) {
        this.naam = naam;
        this.beschrijving = beschrijving;
        this.motor = motor;
    }

    public String getNaam() {
        return naam;
    }

    public String getBeschrijving() {
        return beschrijving;
    }

    public String getMotor() {
        return motor;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }

    public void setBeschrijving(String beschrijving) {
        this.beschrijving = beschrijving;
    }

    public void setMotor(String motor) {
        this.motor = motor;
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

    public Optie getOptie() {
        Optie optie = null;
        boolean match = false;

        while (!match) {
            String input = Vragen.vraagString("Wat is de naam van de optie?");
            for (Optie x : opties) {
                if ((x.getNaam()).equals(input)) {
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

    public void editOptie() {
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

    public void printOpties() {
        List<Optie> essentieleOpties = new ArrayList<>();
        List<Optie> extraOpties = new ArrayList<>();

        for (Optie optie : opties) {
            if (optie.getEssentieel()) {
                essentieleOpties.add(optie);
            } else {
                extraOpties.add(optie);
            }
        }

        System.out.println("Essentiële opties:");
        for (Optie optie : essentieleOpties) {
            System.out.println(optie.getNaam() + " - " + optie.getBeschrijving() + " - €" + optie.getKosten());
        }

        System.out.println("Extra opties:");
        for (Optie optie : extraOpties) {
            System.out.println(optie.getNaam() + " - " + optie.getBeschrijving() + " - €" + optie.getKosten());
        }
    }

    public void printSchepen() {
        System.out.println("Schepen:");
        for (Schip schip : schepen) {
            System.out.println(schip.getNaam() + " - " + schip.getBeschrijving() + " - " + schip.getMotor());
        }
    }
}