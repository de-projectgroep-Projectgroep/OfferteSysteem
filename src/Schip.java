import java.util.ArrayList;
import java.util.List;

public class Schip {
    private ArrayList<Optie> opties = new ArrayList<Optie>();
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

        int milieuKorting = 0;
        if (milieuVriendelijk) {
            milieuKorting = Vragen.vraagInt("Wat is het percentage korting voor deze milieuvriendelijke optie?");
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
        } else {
            System.out.println("Milieuvriendelijk: " + "nee");
        }

        if (milieuVriendelijk) {
            System.out.println("Korting: " + milieuKorting + "%");
        }
        System.out.println("");

        opties.add(new Optie(naam, beschrijving, kosten, essentieel, milieuVriendelijk, milieuKorting));
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

                case "milieu korting" -> {
                    if (optie.getMilieuVriendelijk()) {
                        int nieuweMilieuKorting = Vragen.vraagInt("Wat moet de nieuwe milieu korting worden?");
                        if (Vragen.vraagJaNee("Weet u zeker dat u de milieu korting wilt wijzigen?")) {
                            optie.setMilieuKorting(nieuweMilieuKorting);
                        } else {
                            System.out.println("De milieu korting is niet gewijzigd.");
                        }
                    } else {
                        System.out.println("Deze optie is niet milieuvriendelijk.");
                    }
                    return;
                }

                default -> {
                    System.out.println("Dit is geen gegeven dat u kan wijzigen.");
                    System.out.println("U kan de gegevens naam, beschrijving, categorie en milieuvriendelijkheid wijzigen.");
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

    // Manage schepen

    public static void addSchip() {
        boolean uniekNaam = false;
        String naam = null;
        while (!uniekNaam) {
            naam = Vragen.vraagString("Wat moet de naam van het schip worden?");
            boolean isUniek = true;
            for (Schip schip : schepen) {
                if (schip.getNaam().equals(naam)) {
                    System.out.println("Er staat al een schip met deze naam in ons systeem.");
                    isUniek = false;
                    break;
                }
            }
            if (isUniek) {
                uniekNaam = true;
            }
        }

        String beschrijving = Vragen.vraagString("Wat moet de beschrijving van het schip worden?");
        String motor = Vragen.vraagString("Wat moet de naam van de motor van het schip worden?");

        System.out.println("");
        System.out.println("Er is een nieuw schip aangemaakt met de volgende gegevens:");
        System.out.println("Naam: " + naam);
        System.out.println("Beschrijving: " + beschrijving);
        System.out.println("Motor: " + motor);

        schepen.add(new Schip(naam, beschrijving, motor));
    }

    public static Schip getSchip() {
        Schip schip = null;
        while (true) {
            String input = Vragen.vraagString("Wat is de naam van het schip?");
            for (Schip s : schepen) {
                if ((s.getNaam()).equals(input)) {
                    schip = s;
                    break;
                }
            }

            if (schip != null) {
                break;
            } else {
                System.out.println("Er is geen schip met de naam " + input + " in ons systeem gevonden.");
                if (!Vragen.vraagJaNee("Wilt u nog een keer proberen de naam van de schip in te voeren?")) {
                    System.out.println("Het is niet gelukt om het schip te vinden.");
                    break;
                }
            }
        }
        return schip;
    }

    public static void removeSchip() {
        Schip schip = getSchip();
        if (schip != null) {
            if (Vragen.vraagJaNee("Weet u zeker dat u deze optie wilt verwijderen?")) {
                schepen.remove(schip);
            } else {
                System.out.println("De optie is niet verwijderd.");
            }
        }
    }

    public static void editSchip() {
        boolean klaar = false;
        Schip schip = getSchip();

        if (schip != null) {
            while (!klaar) {
                String input = Vragen.vraagString("Wat wilt u aanpassen?");

                if (input.equalsIgnoreCase("naam")) {
                    klaar = true;
                    boolean uniekType = false;
                    int uniekCheck;
                    String nieuweWaarde = null;

                    while (!uniekType) {
                        nieuweWaarde = Vragen.vraagString("Wat is de nieuwe naam van het schip?");
                        uniekCheck = 0;
                        for (Schip x : schepen) {
                            if (schip.getNaam().equals(nieuweWaarde)) {
                                System.out.println("Er staat al een schip in ons systeem met deze naam.");
                                uniekCheck++;
                            }
                        }
                        if (uniekCheck == 0) {
                            uniekType = true;
                        }
                    }

                    if (Vragen.vraagJaNee("Weet u zeker dat u deze naam wilt wijzigen?")) {
                        schip.setNaam(nieuweWaarde);
                    } else {
                        System.out.println("De naam is niet gewijzigd.");
                    }
                }

                if (input.equalsIgnoreCase("beschrijving")) {
                    klaar = true;
                    String nieuweWaarde = Vragen.vraagString("Wat moet de nieuwe beschrijving worden?");

                    if (Vragen.vraagJaNee("Weet u zeker dat u de beschrijving wilt wijzigen?")) {
                        schip.setBeschrijving(nieuweWaarde);
                    } else {
                        System.out.println("De beschrijving is niet gewijzigd.");
                    }
                }

                if (input.equalsIgnoreCase("motor")) {
                    klaar = true;
                    String nieuweWaarde = Vragen.vraagString("Wat moet de nieuwe motor worden?");

                    if (Vragen.vraagJaNee("Weet u zeker dat u de motor wilt wijzigen?")) {
                        schip.setMotor(nieuweWaarde);
                    } else {
                        System.out.println("De motor is niet gewijzigd.");
                    }
                }

                if (!klaar) {
                    System.out.println("Dit is geen gegeven dat u kan wijzigen.");
                    System.out.println("U kan de gegevens naam, beschrijving, en motor wijzigen.");
                    if (!Vragen.vraagJaNee("Wilt u een van deze gegevens wijzigen?")) {
                        klaar = true;
                    }
                }
            }
        }
    }

    public void printSchepen() {
        System.out.println("Schepen:");
        for (Schip schip : schepen) {
            System.out.println(schip.getNaam() + " - " + schip.getBeschrijving() + " - " + schip.getMotor());
        }
    }
}