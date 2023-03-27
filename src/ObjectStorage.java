import java.util.ArrayList;
import java.util.List;

public class ObjectStorage {
    public static ArrayList<Klanttype> klanttypes = new ArrayList<Klanttype>();
    public static ArrayList<Persoon> personen = new ArrayList<Persoon>();
    public static ArrayList<Klant> klanten = new ArrayList<Klant>();
    public static ArrayList<Optie> opties = new ArrayList<Optie>();

    public static void addKlanttype() {
        boolean uniekType = false;
        String type = null;
        int uniekCheck;
        while (!uniekType) {
            type = Vragen.vraagString("Over wat voor klanttype gaat het?");
            uniekCheck = 0;
            for (Klanttype klanttype : klanttypes) {
                if (klanttype.getType().equals(type)) {
                    System.out.println("Dit klanttype staat al in ons systeem.");
                    uniekCheck++;
                }
            }
            if (uniekCheck == 0) {
                uniekType = true;
            }
        }
        int korting = Vragen.vraagInt("Hoeveel procent korting moet dit klanttype krijgen?");

        System.out.println("");
        System.out.println("Er is een nieuw klanttype aangemaakt met de volgende gegevens:");
        System.out.println("Type: " + type);
        System.out.println("Korting: " + korting + "%");
        System.out.println("");

        klanttypes.add(new Klanttype(type, korting));
    }

    public static void addPersoon() {

        String voornaam = Vragen.vraagString("Wat is de voornaam van de persoon?");
        String achternaam = Vragen.vraagString("Wat is de achternaam van de persoon?");
        String geboortedatum = Vragen.vraagString("Wat is de geboortedatum van de persoon?");

        boolean uniekType = false;
        int uniekCheck;
        String email = null;

        while (!uniekType) {
            email = Vragen.vraagString("Wat is de email van de persoon?");
            uniekCheck = 0;
            for (Persoon persoon : personen) {
                if (persoon.getEmail().equals(email)) {
                    System.out.println("Er staat al een persoon in ons systeem met dit emailadres.");
                    uniekCheck++;
                }
            }
            if (uniekCheck == 0) {
                uniekType = true;
            }
        }

        uniekType = false;
        String telefoonnummer = null;

        while (!uniekType) {
            telefoonnummer = Vragen.vraagString("Wat is het telefoonnummer van de persoon?");
            uniekCheck = 0;
            for (Persoon persoon : personen) {
                if (persoon.getTelefoonnummer().equals(telefoonnummer)) {
                    System.out.println("Er staat al een persoon in ons systeem met dit telefoonnummer.");
                    uniekCheck++;
                }
            }
            if (uniekCheck == 0) {
                uniekType = true;
            }
        }

        String adres;
        if (Vragen.vraagJaNee("Wilt u ook een adres opgeven?")) {
            adres = Vragen.vraagString("Wat is het adres?");

            System.out.println("");
            System.out.println("Er is een nieuw persoon aangemaakt met de volgende persoongegevens:");
            System.out.println("Voornaam: " + voornaam);
            System.out.println("Achternaam: " + achternaam);
            System.out.println("Geboortedatum: " + geboortedatum);
            System.out.println("Email: " + email);
            System.out.println("Telefoonnummer: " + telefoonnummer);
            System.out.println("Adres: " + adres);
            System.out.println("");

            personen.add(new Persoon(voornaam, achternaam, geboortedatum, email, telefoonnummer, adres));
        } else {
            System.out.println("");
            System.out.println("Er is een nieuw persoon aangemaakt met de volgende persoongegevens:");
            System.out.println("Voornaam: " + voornaam);
            System.out.println("Achternaam: " + achternaam);
            System.out.println("Geboortedatum: " + geboortedatum);
            System.out.println("Email: " + email);
            System.out.println("Telefoonnummer: " + telefoonnummer);
            System.out.println("Adres: " + "n.v.t.");
            System.out.println("");

            personen.add(new Persoon(voornaam, achternaam, geboortedatum, email, telefoonnummer));
        }
    }

    public static void addKlant() {
        Persoon persoon = null;
        String persoonnaam = null;
        if (Vragen.vraagJaNee("Wilt u een (contact)persoon opgeven voor deze klant?")) {
            if (Vragen.vraagJaNee("Staat deze persoon al in ons systeem?")) {
                persoon = getPersoon();
                if (persoon == null) {
                    if (Vragen.vraagJaNee("Wilt u een nieuwe persoon toevoegen aan ons systeem?")) {
                        addPersoon();
                        persoon = personen.get(personen.size() - 1);
                        persoonnaam = persoon.getVoornaam() + " " + persoon.getAchternaam();
                    }
                } else {
                    persoonnaam = persoon.getVoornaam() + " " + persoon.getAchternaam();
                }
            } else {
                addPersoon();
                persoon = personen.get(personen.size() - 1);
                persoonnaam = persoon.getVoornaam() + " " + persoon.getAchternaam();
            }
        }

        boolean uniekNaam = true;

        if (persoon != null) {
            for (int i = 0; i < klanten.size(); i++) {
                if ((klanten.get(i).getNaam().equals(persoonnaam))) {
                    uniekNaam = false;
                }
            }
        }

        String naam = null;
        if (persoon != null) {
            if (uniekNaam) {
                if (!Vragen.vraagJaNee("Wilt u dat de naam van de klant hetzelfde is als de naam van de (contact)persoon?")) {
                    naam = "temp";
                }
            } else {
                naam = "temp";
            }
        }

        boolean uniekType;
        int uniekCheck;

        if (naam != null) {
            uniekType = false;

            while (!uniekType) {
                naam = Vragen.vraagString("Wat is de naam van de klant?");
                uniekCheck = 0;
                for (Klant klant : klanten) {
                    if (klant.getNaam().equals(naam)) {
                        System.out.println("Er staat al een klant in ons systeem met deze naam.");
                        uniekCheck++;
                    }
                }
                if (uniekCheck == 0) {
                    uniekType = true;
                }
            }
        }

        Klanttype klanttype = getKlanttype();

        if (persoon != null) {
            if (naam != null) {
                klanten.add(new Klant(naam, persoon, klanttype));
            } else {
                klanten.add(new Klant(persoon, klanttype));
            }
        } else {
            naam = Vragen.vraagString("Wat is de naam van de klant?");
            String email = Vragen.vraagString("Wat is de email van de klant?");
            String telefoonnummer = Vragen.vraagString("Wat is de telefoonnummer van de klant?");
            klanten.add(new Klant(naam, email, telefoonnummer, klanttype));
        }

        System.out.println("");
        System.out.println("Er is een nieuw persoon aangemaakt met de volgende persoongegevens:");
        System.out.println("Klanttype: " + klanten.get(klanten.size() - 1).getKlanttype().getType());
        System.out.println("Naam: " + klanten.get(klanten.size() - 1).getNaam());
        System.out.println("Email: " + klanten.get(klanten.size() - 1).getEmail());
        System.out.println("Telefoonnummer: " + klanten.get(klanten.size() - 1).getTelefoonnummer());
        if (persoon != null) {
            System.out.println("(Contact)persoon: " + klanten.get(klanten.size() - 1).getContactPersoon().getVoornaam() + " " + klanten.get(klanten.size() - 1).getContactPersoon().getAchternaam());
        } else {
            System.out.println("(Contact)persoon: n.v.t.");
        }
        System.out.println("");
    }

    public static void addOptie() {
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
        System.out.println("");

        opties.add(new Optie(naam, beschrijving, essentieel, milieuVriendelijk));
    }

    public static Klanttype getKlanttype() {
        Klanttype klanttype = null;
        boolean match = false;
        while (!match) {
            String input = Vragen.vraagString("Over welk klanttype gaat het?");
            for (Klanttype x : klanttypes) {
                if ((x.getType().equals(input))) {
                    klanttype = x;
                    match = true;
                }
            }
            if (klanttype == null) {
                System.out.println("Dit klanttype staat niet in dit systeem.");
                System.out.println("De volgende klanttypes staan in dit systeem:");
                for (Klanttype x : klanttypes) {
                    System.out.println(x.getType());
                }
                System.out.println("");
            }
        }
        return klanttype;
    }

    public static Persoon getPersoon() {
        Persoon persoon = null;
        boolean match = false;

        while (!match) {
            String input = Vragen.vraagString("Wat is de email van de persoon?");
            for (Persoon x : personen) {
                if ((x.getEmail().equals(input))) {
                    persoon = x;
                }
            }

            if (persoon == null) {
                System.out.println("Deze persoon staat niet in ons systeem.");
                if (!Vragen.vraagJaNee("Wilt u nog een keer proberen de email in te voeren?")) {
                    match = true;
                    System.out.println("Het is niet gelukt om de persoon te vinden.");
                }
            } else {
                match = true;
            }
        }
        return persoon;
    }

    public static Klant getKlant() {
        Klant klant = null;
        String input = null;
        boolean match = false;

        while (!match) {
            input = Vragen.vraagString("Wat is de naam van de klant?");
            for (int i = 0; i < klanten.size(); i++) {
                if ((klanten.get(i).getNaam()).equals(input)) {
                    klant = klanten.get(i);
                }
            }

            if (klant == null) {
                System.out.println("Deze klant staat niet in ons systeem.");
                if (!Vragen.vraagJaNee("Wilt u nog een keer proberen de naam in te voeren?")) {
                    match = true;
                    System.out.println("Het is niet gelukt om de klant te vinden.");
                }
            } else {
                match = true;
            }
        }
        return klant;
    }

    public static Optie getOptie() {
        Optie optie = null;
        while (true) {
            String input = Vragen.vraagString("Wat is de naam van de optie?");
            for (Optie x : opties) {
                if ((x.getNaam()).equals(input)) {
                    optie = x;
                    break;
                }
            }

            if (optie != null) {
                break;
            } else {
                System.out.println("Er is geen optie met de naam " + input + " in ons systeem gevonden.");
                if (!Vragen.vraagJaNee("Wilt u nog een keer proberen de naam van de optie in te voeren?")) {
                    System.out.println("Het is niet gelukt om de optie te vinden.");
                    break;
                }
            }
        }
        return optie;
    }

    public static void removeKlanttype() {
        Klanttype klanttype = getKlanttype();
        if (klanttype != null) {
            if (Vragen.vraagJaNee("Weet u zeker dat u dit klanttype wilt verwijderen?")) {
                klanttypes.remove(klanttype);
            } else {
                System.out.println("Het klanttype is niet verwijderd.");
            }
        }
    }

    public static void removePersoon() {
        Persoon persoon = getPersoon();
        if (persoon != null) {
            if (Vragen.vraagJaNee("Weet u zeker dat u deze persoon wilt verwijderen?")) {
                personen.remove(persoon);
            } else {
                System.out.println("De persoon is niet verwijderd.");
            }
        }
    }

    public static void removeKlant() {
        Klant klant = getKlant();
        if (klant != null) {
            if (Vragen.vraagJaNee("Weet u zeker dat u deze klant wilt verwijderen?")) {
                klanten.remove(klant);
            } else {
                System.out.println("De klant is niet verwijderd.");
            }
        }
    }

    public static void removeOptie() {
        Optie optie = getOptie();
        if (optie != null) {
            if (Vragen.vraagJaNee("Weet u zeker dat u deze optie wilt verwijderen?")) {
                opties.remove(optie);
            } else {
                System.out.println("De optie is niet verwijderd.");
            }
        }
    }

    public static void editKlanttype() {
        boolean klaar = false;
        String input;
        Klanttype klanttype = getKlanttype();

        while (!klaar) {
            input = Vragen.vraagString("Wat wilt u aanpassen?");

            if (input.equals("type") || input.equals("Type")) {
                klaar = true;
                String nieuweWaarde = "";

                boolean uniekType = false;
                int uniekCheck;
                while (!uniekType) {
                    nieuweWaarde = Vragen.vraagString("Wat moet het nieuwe klanttype worden?");
                    uniekCheck = 0;
                    for (Klanttype x : klanttypes) {
                        if (x.getType().equals(nieuweWaarde)) {
                            System.out.println("Dit klanttype staat al in ons systeem.");
                            uniekCheck++;
                        }
                    }
                    if (uniekCheck == 0) {
                        uniekType = true;
                    }
                }


                if (Vragen.vraagJaNee("Weet u zeker dat u dit type wilt wijzigen?")) {
                    klanttype.setType(nieuweWaarde);
                } else {
                    System.out.println("Het type is niet gewijzigd.");
                }
            }

            if (input.equals("korting") || input.equals("Korting")) {
                klaar = true;
                int nieuweWaarde = Vragen.vraagInt("Wat moet het nieuwe kortingspercentage worden?");

                if (Vragen.vraagJaNee("Weet u zeker dat u het kortingspercentage wilt wijzigen?")) {
                    klanttype.setKorting(nieuweWaarde);
                } else {
                    System.out.println("Het kortingspercentage is niet gewijzigd.");
                }
            }

            if (!klaar) {
                System.out.println("Dit is geen gegeven dat u kan wijzigen.");
                System.out.println("U kan de gegevens type en korting wijzigen.");
                if (!Vragen.vraagJaNee("Wilt u een van deze gegevens wijzigen?")) {
                    klaar = true;
                }
            }
        }
    }

    public static void editPersoon() {
        boolean klaar = false;
        String input;
        Persoon persoon = getPersoon();

        if (persoon != null) {
            while (!klaar) {
                input = Vragen.vraagString("Wat wilt u aanpassen?");

                if (input.equals("email") || input.equals("Email")) {
                    klaar = true;
                    boolean uniekType = false;
                    int uniekCheck;
                    String nieuweWaarde = null;

                    while (!uniekType) {
                        nieuweWaarde = Vragen.vraagString("Wat is de nieuwe email van de persoon?");
                        uniekCheck = 0;
                        for (Persoon x : personen) {
                            if (persoon.getEmail().equals(nieuweWaarde)) {
                                System.out.println("Er staat al een persoon in ons systeem met dit emailadres.");
                                uniekCheck++;
                            }
                        }
                        if (uniekCheck == 0) {
                            uniekType = true;
                        }
                    }

                    if (Vragen.vraagJaNee("Weet u zeker dat u dit emailadres wilt wijzigen?")) {
                        persoon.setEmail(nieuweWaarde);
                    } else {
                        System.out.println("Het emailadres is niet gewijzigd.");
                    }
                }

                if (input.equals("telefoonnummer") || input.equals("Telefoonnummer")) {
                    klaar = true;
                    boolean uniekType = false;
                    int uniekCheck;
                    String nieuweWaarde = null;

                    while (!uniekType) {
                        nieuweWaarde = Vragen.vraagString("Wat is het nieuwe telefoonnummer van de persoon?");
                        uniekCheck = 0;
                        for (Persoon x : personen) {
                            if (persoon.getTelefoonnummer().equals(nieuweWaarde)) {
                                System.out.println("Er staat al een persoon in ons systeem met dit telefoonnummer.");
                                uniekCheck++;
                            }
                        }
                        if (uniekCheck == 0) {
                            uniekType = true;
                        }
                    }

                    if (Vragen.vraagJaNee("Weet u zeker dat u dit telefoonnummer wilt wijzigen?")) {
                        persoon.setTelefoonnummer(nieuweWaarde);
                    } else {
                        System.out.println("Het telefoonnummer is niet gewijzigd.");
                    }
                }

                if (input.equals("voornaam") || input.equals("Voornaam")) {
                    klaar = true;
                    String nieuweWaarde = Vragen.vraagString("Wat moet de nieuwe voornaam worden?");

                    if (Vragen.vraagJaNee("Weet u zeker dat u de voornaam wilt wijzigen?")) {
                        persoon.setVoornaam(nieuweWaarde);
                    } else {
                        System.out.println("De voornaam is niet gewijzigd.");
                    }
                }

                if (input.equals("achternaam") || input.equals("Achternaam")) {
                    klaar = true;
                    String nieuweWaarde = Vragen.vraagString("Wat moet de nieuwe achternaam worden?");

                    if (Vragen.vraagJaNee("Weet u zeker dat u de achternaam wilt wijzigen?")) {
                        persoon.setAchternaam(nieuweWaarde);
                    } else {
                        System.out.println("De achternaam is niet gewijzigd.");
                    }
                }

                if (input.equals("geboortedatum") || input.equals("Geboortedatum")) {
                    klaar = true;
                    String nieuweWaarde = Vragen.vraagString("Wat moet de nieuwe geboortedatum worden?");

                    if (Vragen.vraagJaNee("Weet u zeker dat u de geboortedatum wilt wijzigen?")) {
                        persoon.setGeboortedatum(nieuweWaarde);
                    } else {
                        System.out.println("De geboortedatum is niet gewijzigd.");
                    }
                }

                if (input.equals("adres") || input.equals("Adres")) {
                    klaar = true;
                    String nieuweWaarde = Vragen.vraagString("Wat moet het nieuwe adres worden?");

                    if (Vragen.vraagJaNee("Weet u zeker dat u het adres wilt wijzigen?")) {
                        persoon.setAdres(nieuweWaarde);
                    } else {
                        System.out.println("Het adres is niet gewijzigd.");
                    }
                }

                if (!klaar) {
                    System.out.println("Dit is geen gegeven dat u kan wijzigen.");
                    System.out.println("U kan de gegevens voornaam, achternaam, geboortedatum, email, telefoonnummer en adres wijzigen.");
                    if (!Vragen.vraagJaNee("Wilt u een van deze gegevens wijzigen?")) {
                        klaar = true;
                    }
                }
            }
        }
    }

    public static void editKlant() {
        boolean klaar = false;
        String input;
        Klant klant = getKlant();

        if (klant != null) {
            while (!klaar) {
                input = Vragen.vraagString("Wat wilt u aanpassen?");

                if (input.equals("naam") || input.equals("Naam")) {
                    klaar = true;
                    boolean uniekType = false;
                    int uniekCheck;
                    String nieuweWaarde = null;

                    while (!uniekType) {
                        nieuweWaarde = Vragen.vraagString("Wat is de nieuwe naam van de klant?");
                        uniekCheck = 0;
                        for (Klant x : klanten) {
                            if (klant.getNaam().equals(nieuweWaarde)) {
                                System.out.println("Er staat al een klant in ons systeem met deze naam.");
                                uniekCheck++;
                            }
                        }
                        if (uniekCheck == 0) {
                            uniekType = true;
                        }
                    }

                    if (Vragen.vraagJaNee("Weet u zeker dat u deze naam wilt wijzigen?")) {
                        klant.setNaam(nieuweWaarde);
                    } else {
                        System.out.println("De naam is niet gewijzigd.");
                    }
                }

                if (input.equals("email") || input.equals("Email")) {
                    klaar = true;
                    String nieuweWaarde = Vragen.vraagString("Wat moet het nieuwe emailadres worden?");

                    if (Vragen.vraagJaNee("Weet u zeker dat u het emailadres wilt wijzigen?")) {
                        klant.setEmail(nieuweWaarde);
                    } else {
                        System.out.println("Het emailadres is niet gewijzigd.");
                    }
                }

                if (input.equals("telefoonnummer") || input.equals("Telefoonnummer")) {
                    klaar = true;
                    String nieuweWaarde = Vragen.vraagString("Wat moet het nieuwe telefoonnummer worden?");

                    if (Vragen.vraagJaNee("Weet u zeker dat u het telefoonnummer wilt wijzigen?")) {
                        klant.setTelefoonnummer(nieuweWaarde);
                    } else {
                        System.out.println("Het telefoonnummer is niet gewijzigd.");
                    }
                }

                if (input.equals("klanttype") || input.equals("Klanttype")) {
                    klaar = true;
                    Klanttype nieuweWaarde = getKlanttype();

                    if (Vragen.vraagJaNee("Weet u zeker dat u het klanttype wilt wijzigen?")) {
                        klant.setKlanttype(nieuweWaarde);
                    } else {
                        System.out.println("Het klanttype is niet gewijzigd.");
                    }
                }

                if (input.equals("persoon") || input.equals("Persoon") || input.equals("contactpersoon") || input.equals("Contactpersoon") || input.equals("(contact)persoon") || input.equals("(Contact)persoon")) {
                    klaar = true;
                    Persoon nieuweWaarde;

                    if (Vragen.vraagJaNee("Staat deze persoon al in ons systeem?")) {
                        nieuweWaarde = getPersoon();
                        if (nieuweWaarde == null) {
                            if (Vragen.vraagJaNee("Wilt u een nieuwe persoon toevoegen aan ons systeem?")) {
                                addPersoon();
                                nieuweWaarde = personen.get(personen.size() - 1);
                            }
                        }
                    } else {
                        addPersoon();
                        nieuweWaarde = personen.get(personen.size() - 1);
                    }

                    if (nieuweWaarde != null) {
                        if (Vragen.vraagJaNee("Weet u zeker dat u de (contact)persoon wilt wijzigen?")) {
                            klant.setContactpersoon(nieuweWaarde);
                        } else {
                            System.out.println("De (contact)persoon is niet gewijzigd.");
                        }
                    }
                }

                if (!klaar) {
                    System.out.println("Dit is geen gegeven dat u kan wijzigen.");
                    System.out.println("U kan de gegevens klanttype, naam, email, telefoonnummer en (contact)persoon wijzigen.");
                    if (!Vragen.vraagJaNee("Wilt u een van deze gegevens wijzigen?")) {
                        klaar = true;
                    }
                }
            }
        }
    }

    public static void editOptie() {
        boolean klaar = false;
        Optie optie = getOptie();

        if (optie != null) {
            while (!klaar) {
                String input = Vragen.vraagString("Wat wilt u aanpassen?");

                if (input.equalsIgnoreCase("naam")) {
                    klaar = true;
                    boolean uniekType = false;
                    int uniekCheck;
                    String nieuweWaarde = null;

                    while (!uniekType) {
                        nieuweWaarde = Vragen.vraagString("Wat is de nieuwe naam van de optie?");
                        uniekCheck = 0;
                        for (Optie x : opties) {
                            if (optie.getNaam().equals(nieuweWaarde)) {
                                System.out.println("Er staat al een optie in ons systeem met deze naam.");
                                uniekCheck++;
                            }
                        }
                        if (uniekCheck == 0) {
                            uniekType = true;
                        }
                    }

                    if (Vragen.vraagJaNee("Weet u zeker dat u deze naam wilt wijzigen?")) {
                        optie.setNaam(nieuweWaarde);
                    } else {
                        System.out.println("De naam is niet gewijzigd.");
                    }
                }

                if (input.equalsIgnoreCase("kosten")) {
                    klaar = true;
                    double nieuweWaarde = Vragen.vraagDouble("Wat moeten de nieuwe kosten worden?");

                    if (Vragen.vraagJaNee("Weet u zeker dat u de kosten wilt wijzigen?")) {
                        optie.setKosten(nieuweWaarde);
                    } else {
                        System.out.println("De kosten zijn niet gewijzigd.");
                    }
                }

                if (input.equalsIgnoreCase("beschrijving")) {
                    klaar = true;
                    String nieuweWaarde = Vragen.vraagString("Wat moet de nieuwe beschrijving worden?");

                    if (Vragen.vraagJaNee("Weet u zeker dat u de beschrijving wilt wijzigen?")) {
                        optie.setBeschrijving(nieuweWaarde);
                    } else {
                        System.out.println("De beschrijving is niet gewijzigd.");
                    }
                }

                if (input.equalsIgnoreCase("categorie")) {
                    klaar = true;
                    boolean nieuweWaarde = Vragen.vraagJaNee("Moet dit een essentiële optie worden?");

                    if (Vragen.vraagJaNee("Weet u zeker dat u de categorie wilt wijzigen?")) {
                        optie.setEssentieel(nieuweWaarde);
                    } else {
                        System.out.println("De categorie is niet gewijzigd.");
                    }
                }

                if (input.equalsIgnoreCase("milieuvriendelijkheid")) {
                    klaar = true;
                    boolean nieuweWaarde = Vragen.vraagJaNee("Is deze optie millieuvriendelijk?");

                    if (Vragen.vraagJaNee("Weet u zeker dat u de milieuvriendelijkheid wilt wijzigen?")) {
                        optie.setMilieuVriendelijk(nieuweWaarde);
                    } else {
                        System.out.println("De milieuvriendelijkheid is niet gewijzigd.");
                    }
                }

                if (!klaar) {
                    System.out.println("Dit is geen gegeven dat u kan wijzigen.");
                    System.out.println("U kan de gegevens naam, beschrijving, kosten, categorie en millieuvriendelijkheid wijzigen.");
                    if (!Vragen.vraagJaNee("Wilt u een van deze gegevens wijzigen?")) {
                        klaar = true;
                    }
                }
            }
        }
    }
}