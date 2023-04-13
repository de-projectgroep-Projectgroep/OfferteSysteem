import java.util.ArrayList;
import java.util.List;

public abstract class ObjectStorage {
    public static ArrayList<Klanttype> klanttypes = new ArrayList<Klanttype>();
    public static ArrayList<Persoon> personen = new ArrayList<Persoon>();
    public static ArrayList<Klant> klanten = new ArrayList<Klant>();
    public static ArrayList<Schip> schepen = new ArrayList<Schip>();

    public static void addKlanttype() {
        boolean uniekType = false;
        String type = null;
        while (!uniekType) {
            uniekType = true;
            type = Vragen.vraagString("Over wat voor klanttype gaat het?");
            for (Klanttype klanttype : klanttypes) {
                if (klanttype.getType().equalsIgnoreCase(type)) {
                    System.out.println("Dit klanttype staat al in ons systeem.");
                    uniekType = false;
                }
            }
        }
        int kortingsPercentage = Vragen.vraagInt("Hoeveel procent korting moet dit klanttype krijgen?");

        System.out.println("");
        System.out.println("Er is een nieuw klanttype aangemaakt met de volgende gegevens:");
        System.out.println("Type: " + type);
        System.out.println("Korting: " + kortingsPercentage + "%");
        System.out.println("");

        klanttypes.add(new Klanttype(type, kortingsPercentage));
    }

    public static void addPersoon() {

        String voornaam = Vragen.vraagString("Wat is de voornaam van de persoon?");
        String achternaam = Vragen.vraagString("Wat is de achternaam van de persoon?");
        String geboortedatum = Vragen.vraagString("Wat is de geboortedatum van de persoon?");

        boolean uniekType = false;
        String email = null;

        while (!uniekType) {
            uniekType = true;
            email = Vragen.vraagString("Wat is het emailadres van de persoon?");
            for (Persoon persoon : personen) {
                if (persoon.getEmail().equalsIgnoreCase(email)) {
                    System.out.println("Dit emailadres is al in gebruik.");
                    uniekType = false;
                }
            }
        }

        uniekType = false;
        String telefoonnummer = null;

        while (!uniekType) {
            telefoonnummer = Vragen.vraagString("Wat is het telefoonnummer van de persoon?");
            uniekType = true;
            for (Persoon persoon : personen) {
                if (persoon.getTelefoonnummer().equalsIgnoreCase(telefoonnummer)) {
                    System.out.println("Er staat al een persoon in ons systeem met dit telefoonnummer.");
                    uniekType = false;
                }
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
                    if (Vragen.vraagJaNee("Wilt u een nieuw persoon toevoegen aan ons systeem?")) {
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
                if ((klanten.get(i).getNaam().equalsIgnoreCase(persoonnaam))) {
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

        if (naam != null) {
            uniekType = false;

            while (!uniekType) {
                naam = Vragen.vraagString("Wat is de naam van de klant?");
                uniekType = true;
                for (Klant klant : klanten) {
                    if (klant.getNaam().equalsIgnoreCase(naam)) {
                        System.out.println("Er staat al een klant in ons systeem met deze naam.");
                        uniekType = false;
                    }
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
            String telefoonnummer = Vragen.vraagString("Wat is het telefoonnummer van de klant?");
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

    public static void addSchip() {
        boolean uniekNaam = false;
        String naam = null;
        while (!uniekNaam) {
            naam = Vragen.vraagString("Wat moet de naam van het schip worden?");
            boolean isUniek = true;
            for (Schip schip : schepen) {
                if (schip.getNaam().equalsIgnoreCase(naam)) {
                    System.out.println("Er staat al een schip met deze naam in ons systeem.");
                    isUniek = false;
                    break;
                }
            }
            if (isUniek) {
                uniekNaam = true;
            }
        }

        String type = Vragen.vraagString("Over wat voor type schip gaat het?");

        String beschrijving = Vragen.vraagString("Wat moet de beschrijving van het schip worden?");

        boolean extraOpties = Vragen.vraagJaNee("Wilt u opties toevoegen aan dit schip?");

        Schip nieuwSchip = new Schip(naam, type, beschrijving, new ArrayList<Optie>());

        // als er opties moeten worden toegevoegd, vraag ze dan en voeg ze toe aan het nieuwe schip
        if (extraOpties) {
            boolean klaar = false;
            while(!klaar) {
                nieuwSchip.addOptie();
                if (!Vragen.vraagJaNee("Wilt u nog een optie toevoegen?")){
                    klaar = true;
                }
            }
            ArrayList<Optie> opties = Schip.opties;
            Schip.opties = new ArrayList<Optie>();
            schepen.add(new Schip(nieuwSchip.getNaam(), nieuwSchip.getType(), nieuwSchip.getBeschrijving(), opties));
        } else {
            schepen.add(nieuwSchip);
        }

        System.out.println("");
        System.out.println("Er is een nieuw schip aangemaakt met de volgende gegevens:");
        System.out.println("Naam: " + naam);
        System.out.println("Beschrijving: " + beschrijving);
        Schip.printOpties(nieuwSchip);
    }

    public static Klanttype getKlanttype() {
        Klanttype klanttype = null;
        boolean match = false;
        while (!match) {
            String input = Vragen.vraagString("Over welk klanttype gaat het?");
            for (Klanttype x : klanttypes) {
                if ((x.getType().equalsIgnoreCase(input))) {
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
                if ((x.getEmail().equalsIgnoreCase(input))) {
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
        boolean match = false;

        while (!match) {
            String input = Vragen.vraagString("Wat is de naam van de klant?");
            for (Klant value : klanten) {
                if ((value.getNaam()).equalsIgnoreCase(input)) {
                    klant = value;
                    match = true;
                    break;
                }
            }

            if (!match) {
                System.out.println("Deze klant staat niet in ons systeem.");
                if (!Vragen.vraagJaNee("Wilt u nog een keer proberen de naam in te voeren?")) {
                    System.out.println("Het is niet gelukt om de klant te vinden.");
                    break;
                }
            }
        }
        return klant;
    }

    public static Schip getSchip() {
        Schip schip = null;
        while (true) {
            String input = Vragen.vraagString("Wat is de naam van het schip?");
            for (Schip s : schepen) {
                if ((s.getNaam()).equalsIgnoreCase(input)) {
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

    public static void editKlanttype() {
        boolean klaar = false;
        String input;
        Klanttype klanttype = getKlanttype();

        while (!klaar) {
            input = Vragen.vraagString("Wat wilt u aanpassen?");

            if (input.equalsIgnoreCase("type")) {
                klaar = true;
                String nieuweWaarde = "";

                boolean uniekType = false;
                while (!uniekType) {
                    uniekType = true;
                    nieuweWaarde = Vragen.vraagString("Wat moet het nieuwe klanttype worden?");
                    for (Klanttype x : klanttypes) {
                        if (x.getType().equalsIgnoreCase(nieuweWaarde)) {
                            System.out.println("Dit klanttype staat al in ons systeem.");
                            uniekType = false;
                        }
                    }
                }


                if (Vragen.vraagJaNee("Weet u zeker dat u dit type wilt wijzigen?")) {
                    klanttype.setType(nieuweWaarde);
                } else {
                    System.out.println("Het type is niet gewijzigd.");
                }
            }

            if (input.equalsIgnoreCase("korting")) {
                klaar = true;
                int nieuweWaarde = Vragen.vraagInt("Wat moet het nieuwe kortingspercentage worden?");

                if (Vragen.vraagJaNee("Weet u zeker dat u het kortingspercentage wilt wijzigen?")) {
                    klanttype.setKortingsPercentage(nieuweWaarde);
                } else {
                    System.out.println("Het kortingspercentage is niet gewijzigd.");
                }
            }

            if (!klaar) {
                System.out.println("Dit is geen gegeven dat u kan wijzigen.");
                System.out.println("U kunt de gegevens type en korting wijzigen.");
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

                if (input.equalsIgnoreCase("email")) {
                    klaar = true;
                    boolean uniekType = false;
                    String nieuweWaarde = null;

                    while (!uniekType) {
                        nieuweWaarde = Vragen.vraagString("Wat is de nieuwe email van de persoon?");
                        uniekType = true;
                        for (Persoon x : personen) {
                            if (persoon.getEmail().equalsIgnoreCase(nieuweWaarde)) {
                                System.out.println("Er staat al een persoon in ons systeem met dit emailadres.");
                                uniekType = false;
                            }
                        }
                    }

                    if (Vragen.vraagJaNee("Weet u zeker dat u dit emailadres wilt wijzigen?")) {
                        persoon.setEmail(nieuweWaarde);
                    } else {
                        System.out.println("Het emailadres is niet gewijzigd.");
                    }
                }

                if (input.equalsIgnoreCase("telefoonnummer")) {
                    klaar = true;
                    boolean uniekType = false;
                    String nieuweWaarde = null;

                    while (!uniekType) {
                        nieuweWaarde = Vragen.vraagString("Wat is het nieuwe telefoonnummer van de persoon?");
                        uniekType = true;
                        for (Persoon x : personen) {
                            if (persoon.getTelefoonnummer().equalsIgnoreCase(nieuweWaarde)) {
                                System.out.println("Er staat al een persoon in ons systeem met dit telefoonnummer.");
                                uniekType = false;
                            }
                        }
                    }

                    if (Vragen.vraagJaNee("Weet u zeker dat u dit telefoonnummer wilt wijzigen?")) {
                        persoon.setTelefoonnummer(nieuweWaarde);
                    } else {
                        System.out.println("Het telefoonnummer is niet gewijzigd.");
                    }
                }

                if (input.equalsIgnoreCase("voornaam")) {
                    klaar = true;
                    String nieuweWaarde = Vragen.vraagString("Wat moet de nieuwe voornaam worden?");

                    if (Vragen.vraagJaNee("Weet u zeker dat u de voornaam wilt wijzigen?")) {
                        persoon.setVoornaam(nieuweWaarde);
                    } else {
                        System.out.println("De voornaam is niet gewijzigd.");
                    }
                }

                if (input.equalsIgnoreCase("achternaam")) {
                    klaar = true;
                    String nieuweWaarde = Vragen.vraagString("Wat moet de nieuwe achternaam worden?");

                    if (Vragen.vraagJaNee("Weet u zeker dat u de achternaam wilt wijzigen?")) {
                        persoon.setAchternaam(nieuweWaarde);
                    } else {
                        System.out.println("De achternaam is niet gewijzigd.");
                    }
                }

                if (input.equalsIgnoreCase("geboortedatum")) {
                    klaar = true;
                    String nieuweWaarde = Vragen.vraagString("Wat moet de nieuwe geboortedatum worden?");

                    if (Vragen.vraagJaNee("Weet u zeker dat u de geboortedatum wilt wijzigen?")) {
                        persoon.setGeboortedatum(nieuweWaarde);
                    } else {
                        System.out.println("De geboortedatum is niet gewijzigd.");
                    }
                }

                if (input.equalsIgnoreCase("adres")) {
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
                    System.out.println("U kunt de gegevens voornaam, achternaam, geboortedatum, email, telefoonnummer en adres wijzigen.");
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

                if (input.equalsIgnoreCase("naam")) {
                    klaar = true;
                    boolean uniekType = false;
                    String nieuweWaarde = null;

                    while (!uniekType) {
                        nieuweWaarde = Vragen.vraagString("Wat is de nieuwe naam van de klant?");
                        uniekType = true;
                        for (Klant x : klanten) {
                            if (klant.getNaam().equalsIgnoreCase(nieuweWaarde)) {
                                System.out.println("Er staat al een klant in ons systeem met deze naam.");
                                uniekType = false;
                            }
                        }
                    }

                    if (Vragen.vraagJaNee("Weet u zeker dat u deze naam wilt wijzigen?")) {
                        klant.setNaam(nieuweWaarde);
                    } else {
                        System.out.println("De naam is niet gewijzigd.");
                    }
                }

                if (input.equalsIgnoreCase("email")) {
                    klaar = true;
                    String nieuweWaarde = Vragen.vraagString("Wat moet het nieuwe emailadres worden?");

                    if (Vragen.vraagJaNee("Weet u zeker dat u het emailadres wilt wijzigen?")) {
                        klant.setEmail(nieuweWaarde);
                    } else {
                        System.out.println("Het emailadres is niet gewijzigd.");
                    }
                }

                if (input.equalsIgnoreCase("telefoonnummer")) {
                    klaar = true;
                    String nieuweWaarde = Vragen.vraagString("Wat moet het nieuwe telefoonnummer worden?");

                    if (Vragen.vraagJaNee("Weet u zeker dat u het telefoonnummer wilt wijzigen?")) {
                        klant.setTelefoonnummer(nieuweWaarde);
                    } else {
                        System.out.println("Het telefoonnummer is niet gewijzigd.");
                    }
                }

                if (input.equalsIgnoreCase("klanttype")) {
                    klaar = true;
                    Klanttype nieuweWaarde = getKlanttype();

                    if (Vragen.vraagJaNee("Weet u zeker dat u het klanttype wilt wijzigen?")) {
                        klant.setKlanttype(nieuweWaarde);
                    } else {
                        System.out.println("Het klanttype is niet gewijzigd.");
                    }
                }

                if (input.equalsIgnoreCase("persoon") || input.equalsIgnoreCase("contactpersoon") || input.equalsIgnoreCase("(contact)persoon")) {
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
                    System.out.println("U kunt de gegevens klanttype, naam, email, telefoonnummer en (contact)persoon wijzigen.");
                    if (!Vragen.vraagJaNee("Wilt u een van deze gegevens wijzigen?")) {
                        klaar = true;
                    }
                }
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
                    String nieuweWaarde = null;

                    while (!uniekType) {
                        nieuweWaarde = Vragen.vraagString("Wat is de nieuwe naam van het schip?");
                        uniekType = true;
                        for (Schip x : schepen) {
                            if (schip.getNaam().equalsIgnoreCase(nieuweWaarde)) {
                                System.out.println("Er staat al een schip in ons systeem met deze naam.");
                                uniekType = false;
                            }
                        }
                    }

                    if (Vragen.vraagJaNee("Weet u zeker dat u deze naam wilt wijzigen?")) {
                        schip.setNaam(nieuweWaarde);
                    } else {
                        System.out.println("De naam is niet gewijzigd.");
                    }
                }

                if (input.equalsIgnoreCase("type")) {
                    klaar = true;
                    String nieuweWaarde = Vragen.vraagString("Wat moet het nieuwe type schip worden?");

                    if (Vragen.vraagJaNee("Weet u zeker dat u het type schip wilt wijzigen?")) {
                        schip.setBeschrijving(nieuweWaarde);
                    } else {
                        System.out.println("Het type schip is niet gewijzigd.");
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

                if (input.equalsIgnoreCase("optie") || input.equalsIgnoreCase("opties")) {
                    klaar = true;
                    boolean klaar2 = false;
                    System.out.println("Kies een optie:");
                    System.out.println("1. Optie toevoegen");
                    System.out.println("2. Optie aanpassen");
                    System.out.println("3. Optie verwijderen");
                    System.out.println("4. Klaar");
                    Schip.editOptie();

                    int keuze = Vragen.vraagInt("");

                    switch (keuze) {
                        case 1 -> {
                            schip.addOptie();
                        }
                        case 2 -> {
                            schip.editOptie();
                        }
                        case 3 -> {
                            schip.removeOptie();
                        }
                        case 4 -> {
                            break;
                        }
                        default -> System.out.println("Ongeldige keuze.");
                    }
                }

                if (!klaar) {
                    System.out.println("Dit is geen gegeven dat u kan wijzigen.");
                    System.out.println("U kan de gegevens naam en beschrijving wijzigen.");
                    if (!Vragen.vraagJaNee("Wilt u een van deze gegevens wijzigen?")) {
                        klaar = true;
                    }
                }
            }
        }
    }

    public static void printKlanttypes() {
        for (Klanttype klanttype : klanttypes) {
            System.out.println(klanttype.getType() + " - " + klanttype.getKortingsPercentage() + "%");
        }
    }
    public static void printPersonen() {
        for (Persoon persoon : personen) {
            System.out.println(persoon.getVoornaam() + " " + persoon.getAchternaam() + " - " + persoon.getGeboortedatum() + " - " + persoon.getEmail() + " - " + persoon.getTelefoonnummer() + " - " + persoon.getAdres());
        }
    }
    public static void printKlanten() {
        for (Klant klant : klanten) {
            System.out.println(klant.getNaam() + " - " + klant.getKlanttype().getType() + " - " + klant.getEmail() + " - " + klant.getTelefoonnummer());
        }
    }
    public static void printSchepen() {
        System.out.println("Schepen:");
        for (Schip schip : schepen) {
            System.out.println("");
            System.out.print(schip.getNaam() + " - " + schip.getType() + " - " + schip.getBeschrijving());
            ArrayList<Optie> opties = schip.getOpties();
            if (opties != null && !opties.isEmpty()) {
                System.out.println();
                Schip.printOpties(schip);
            } else {
                System.out.println(" - Geen opties beschikbaar");
            }
        }
    }
}
