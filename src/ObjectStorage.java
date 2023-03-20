import java.util.ArrayList;

public class ObjectStorage {
    public static ArrayList<Klanttype> klanttypes = new ArrayList<Klanttype>();
    public static ArrayList<Persoon> personen = new ArrayList<Persoon>();
    public static ArrayList<Klant> klanten = new ArrayList<Klant>();

    public static void addKlanttype(){
        boolean uniekType = false;
        String type = null;
        int uniekCheck;
        while (!uniekType) {
            type = Vragen.vraagString("Over wat voor klanttype gaat het?");
            uniekCheck = 0;
            for (Klanttype klanttype : klanttypes){
                if (klanttype.getType().equals(type)){
                    System.out.println("Dit klanttype staat al in ons systeem.");
                    uniekCheck++;
                }
            }
            if (uniekCheck == 0){
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

    public static void addPersoon(){
        String voornaam = Vragen.vraagString("Wat is de voornaam van de persoon?");
        String achternaam = Vragen.vraagString("Wat is de achternaam van de persoon?");
        String geboortedatum = Vragen.vraagString("Wat is de geboortedatum van de persoon?");
        String email = Vragen.vraagString("Wat is de email van de persoon?");
        String telefoonnummer = Vragen.vraagString("Wat is de telefoonnummer van de persoon?");
        String adres;

        if(Vragen.vraagJaNee("Wilt u ook een adres opgeven?")){
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
        }

        else{
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

    public static Klanttype getKlanttype() {
        Klanttype klanttype = null;
        String input = null;
        boolean match = false;
        while (!match) {
            input = Vragen.vraagString("Over wat voor klanttype gaat het?");
            for (int i = 0; i < klanttypes.size(); i++) {
                if ((klanttypes.get(i).getType().equals(input))) {
                    klanttype = klanttypes.get(i);
                    match = true;
                }
            }
            if (klanttype == null){
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
    public static int getPersoon(){
        int persoon = -1;
        String input = null;
        ArrayList<Integer> zoekResultaten = new ArrayList<Integer>();
        boolean match1 = false;
        boolean match2 = false;

        while (!match1){
            input = Vragen.vraagString("Wat is de naam van de persoon?");
            for(int i = 0; i <personen.size(); i++){
                if((personen.get(i).getVoornaam() + " " +  personen.get(i).getAchternaam()).equals(input)){
                    zoekResultaten.add(i);
                }
            }

            if (zoekResultaten.size() == 0){
                System.out.println("Deze persoon staat niet in ons systeem.");
                System.out.println("Vul zowel de voornaam als achternaam van de persoon in.");
                if(!Vragen.vraagJaNee("Wilt u nog een keer proberen de naam in te voeren?")){
                    match1 = true;
                    System.out.println("Het is niet gelukt om de persoon te vinden.");
                }
            }

            if (zoekResultaten.size() == 1){
                persoon = zoekResultaten.get(0);
                match1 = true;
            }

            if (zoekResultaten.size() > 1) {
                while (!match2) {
                        int resultaat = 0;
                        int teller = 0;
                        System.out.println("Meerdere personen in ons systeem hebben deze naam.");
                        input = Vragen.vraagString("Wat is de email van de persoon?");

                        for(int i = 0; i <zoekResultaten.size(); i++){
                            if((personen.get(zoekResultaten.get(i)).getEmail().equals(input))){
                                resultaat = zoekResultaten.get(i);
                                teller++;
                            }
                        }

                        if (teller > 1){
                            System.out.println("Het ziet er naar uit dat deze persoon meerdere keren in ons systeem staat geregistreerd");
                            System.out.println("Los dit probleem op en probeer vervolgens opnieuw de persoon toe te voegen.");
                            persoon = -2;
                            match2 = true;
                            match1 = true;
                    }

                    if (teller == 1){
                        persoon = resultaat;
                        match2 = true;
                        match1 = true;
                    }

                    if (teller == 0){
                        System.out.println("Geen van de twee klanten met de gegeven naam hebben deze email.");
                        if(!Vragen.vraagJaNee("Wilt u nog een keer proberen de email in te voeren?")){
                            match2 = true;
                            if(!Vragen.vraagJaNee("Wilt u nog een keer proberen de naam in te voeren?")){
                                match1 = true;
                                System.out.println("Het is niet gelukt om de persoon te vinden.");
                            }
                        }
                    }
                }
            }
        }
        return persoon;
    }

    public static int getKlant(){
        int klant = -1;
        String input = null;
        ArrayList<Integer> zoekResultaten = new ArrayList<Integer>();
        boolean match1 = false;
        boolean match2 = false;

        while (!match1){
            input = Vragen.vraagString("Wat is de naam van de klant?");
            for(int i = 0; i <klanten.size(); i++){
                if((klanten.get(i).getNaam()).equals(input)){
                    zoekResultaten.add(i);
                }
            }

            if (zoekResultaten.size() == 0){
                System.out.println("Deze klant staat niet in ons systeem.");
                if(!Vragen.vraagJaNee("Wilt u nog een keer proberen de naam in te voeren?")){
                    match1 = true;
                    System.out.println("Het is niet gelukt om de klant te vinden.");
                }
            }

            if (zoekResultaten.size() == 1){
                klant = zoekResultaten.get(0);
                match1 = true;
            }

            if (zoekResultaten.size() > 1) {
                while (!match2) {
                    int resultaat = 0;
                    int teller = 0;
                    System.out.println("Meerdere klanten in ons systeem hebben deze naam.");
                    input = Vragen.vraagString("Wat is de email van de klant?");

                    for(int i = 0; i <zoekResultaten.size(); i++){
                        if((klanten.get(zoekResultaten.get(i)).getEmail().equals(input))){
                            resultaat = zoekResultaten.get(i);
                            teller++;
                        }
                    }

                    if (teller > 1){
                        System.out.println("Het ziet er naar uit dat deze persoon meerdere keren in ons systeem staat geregistreerd");
                        System.out.println("Los dit probleem op en probeer vervolgens opnieuw de persoon toe te voegen.");
                        klant = -2;
                        match2 = true;
                        match1 = true;
                    }

                    if (teller == 1){
                        klant = resultaat;
                        match2 = true;
                        match1 = true;
                    }

                    if (teller == 0){
                        System.out.println("Geen van de twee klanten met de gegeven naam hebben deze email.");
                        if(!Vragen.vraagJaNee("Wilt u nog een keer proberen de email in te voeren?")){
                            match2 = true;
                            if(!Vragen.vraagJaNee("Wilt u nog een keer proberen de naam in te voeren?")){
                                match1 = true;
                                System.out.println("Het is niet gelukt om de persoon te vinden.");
                            }
                        }
                    }
                }
            }
        }
        return klant;
    }
    public static void addKlant() {
        Persoon persoon = null;
        int persoonid;
        if (Vragen.vraagJaNee("Wilt u een (contact)persoon opgeven voor deze klant?")) {
            if (Vragen.vraagJaNee("Staat deze persoon al in ons systeem?")) {
                persoonid = getPersoon();
                if (persoonid == -1) {
                    if (Vragen.vraagJaNee("Wilt u een nieuwe persoon toevoegen aan ons systeem?")) {
                        addPersoon();
                        persoon = personen.get(personen.size() - 1);
                    }
                }
                if (persoonid >= 0) {
                    persoon = personen.get(persoonid);
                }
            } else {
                addPersoon();
                persoon = personen.get(personen.size() - 1);
            }
        }

        String naam = null;
        if (persoon != null) {
            if (!Vragen.vraagJaNee("Wilt u dat de naam van de klant hetzelfde is als de naam van de (contact)persoon?")) {
                naam = Vragen.vraagString("Wat moet de naam van de klant worden?");
            }
        }

        Klanttype klanttype = getKlanttype();

        if (persoon != null) {
            if (naam != null) {
                klanten.add(new Klant(naam, persoon, klanttype));
            } else {
                klanten.add(new Klant(persoon, klanttype));
            }
        }
        else {
            naam = Vragen.vraagString("Wat is de naam van de klant?");
            String email = Vragen.vraagString("Wat is de email van de klant?");
            String telefoonnummer = Vragen.vraagString("Wat is de telefoonnummer van de klant?");
            klanten.add(new Klant(naam, email, telefoonnummer, klanttype));
        }

        System.out.println("");
        System.out.println("Er is een nieuw persoon aangemaakt met de volgende persoongegevens:");
        System.out.println("Klanttype: " + klanten.get(klanten.size()-1).getKlanttype().getType());
        System.out.println("Naam: " + klanten.get(klanten.size()-1).getNaam());
        System.out.println("Email: " + klanten.get(klanten.size()-1).getEmail());
        System.out.println("Telefoonnummer: " + klanten.get(klanten.size()-1).getTelefoonnummer());
        if (persoon != null){
            System.out.println("(Contact)persoon: " + klanten.get(klanten.size()-1).getContactPersoon().getVoornaam() + " " + klanten.get(klanten.size()-1).getContactPersoon().getAchternaam());
        }
        else{
            System.out.println("(Contact)persoon: n.v.t.");
        }
        System.out.println("");
    }
}