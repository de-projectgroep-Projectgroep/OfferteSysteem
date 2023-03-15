import java.util.ArrayList;

public class ObjectStorage {
    public static ArrayList<Klanttype> klanttypes = new ArrayList<Klanttype>();
    public static ArrayList<Persoon> personen = new ArrayList<Persoon>();
    public static ArrayList<Klant> klanten = new ArrayList<Klant>();

    public static void addKlanttype(){
        String type = Vragen.vraagString("Over wat voor type klant gaat het?");
        int korting = Vragen.vraagInt("Hoeveel procent korting moet dit klanttype krijgen?");

        System.out.println("");
        System.out.println("Er is een nieuw klanttype aangemaakt met de volgende gegevens:");
        System.out.println("Type: " + type);
        System.out.println("Korting: " + korting + "%");
        klanttypes.add(new Klanttype(type, korting));
        System.out.println("Id: " + (klanttypes.size() -1));
        System.out.println("");
    }

    public static void addPersoon(){
        String voornaam = Vragen.vraagString("Wat is uw voornaam?");
        String achternaam = Vragen.vraagString("Wat is uw achternaam?");
        String geboortedatum = Vragen.vraagString("Wat is uw geboortedatum?");
        String telefoonnummer = Vragen.vraagString("Wat is uw telefoonnummer?");
        String email = Vragen.vraagString("Wat is uw email?");
        String adres;

        if(Vragen.vraagJaNee("Wilt u ook uw adres opgeven?")){
            adres = Vragen.vraagString("Wat is uw adres?");

            System.out.println("");
            System.out.println("Er is een nieuw persoon aangemaakt met de volgende persoongegevens:");
            System.out.println("Voornaam: " + voornaam);
            System.out.println("Achternaam: " + achternaam);
            System.out.println("Geboortedatum: " + geboortedatum);
            System.out.println("Telefoonnummer: " + telefoonnummer);
            System.out.println("Email: " + email);
            System.out.println("Adres: " + adres);
            personen.add(new Persoon(voornaam, achternaam, geboortedatum, telefoonnummer, email, adres));
            System.out.println("Id: " + (personen.size() -1));
            System.out.println("");
        }

        else{
            System.out.println("");
            System.out.println("Er is een nieuw persoon aangemaakt met de volgende persoongegevens:");
            System.out.println("Voornaam: " + voornaam);
            System.out.println("Achternaam: " + achternaam);
            System.out.println("Geboortedatum: " + geboortedatum);
            System.out.println("Telefoonnummer: " + telefoonnummer);
            System.out.println("Email: " + email);
            System.out.println("Adres: " + "n.v.t.");
            personen.add(new Persoon(voornaam, achternaam, geboortedatum, telefoonnummer, email));
            System.out.println("Id: " + (personen.size() -1));
            System.out.println("");
        }
    }

    public static void addKlant(){
    }
}
