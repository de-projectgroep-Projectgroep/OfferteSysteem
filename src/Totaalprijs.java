import java.util.ArrayList;

public class Totaalprijs {
    public static double berekenTotaalPrijs() { //importeren uit de andere classes
        double totaal = 0;
        Klanttype klanttype = null;
        Klant klant = null;
        boolean klaar = false;
        while(!klaar) {
            String input = Vragen.vraagString("Wilt u een offerte voor een klant of klanttype weergeven?");

            if (input.equalsIgnoreCase("klant")) {
                klaar = true;
                klant = ObjectStorage.getKlant();
                if (klant != null) {
                    klanttype = klant.getKlanttype();
                }
            } else if (input.equalsIgnoreCase("klanttype")) {
                klaar = true;
                klanttype = ObjectStorage.getKlanttype();
            } else {
                System.out.println("U kunt alleen kiezen uit klant of klanttype.");
            }
        }

        if (klanttype != null) {
            Schip schip = ObjectStorage.getSchip();
            if (schip != null) {
                if (klant != null) {
                    klanttype = klant.getKlanttype();
                    System.out.println("--------------------------------------------------");
                    System.out.println("Klantgegevens:");
                    System.out.println("Naam: " + klant.getNaam());
                    System.out.println("Klanttype: " + klanttype.getType());
                    System.out.println("Email: " + klant.getEmail());
                    System.out.println("Telefoonnummer: " + klant.getTelefoonnummer());

                    if (klant.getContactPersoon() != null) {
                        System.out.println("Contactpersoon: " + klant.getContactPersoon().getVoornaam() + " " + klant.getContactPersoon().getAchternaam());
                    }
                }

                System.out.println("--------------------------------------------------");
                System.out.println("Schipgegevens:");
                System.out.println("Naam: " + schip.getNaam());
                System.out.println("Type: " + schip.getType());
                System.out.println("Beschrijving: " + schip.getBeschrijving());
                System.out.println("--------------------------------------------------");
                System.out.println("Onderdelen:");
                for (Optie optie : schip.opties) {
                    if (optie.getMilieuVriendelijk()) {
                        System.out.println(optie.getNaam() + ": €" + optie.getKosten() + " (" + optie.getMilieuKortingsPercentage() + "% korting)");
                    } else {
                        System.out.println(optie.getNaam() + ": €" + optie.getKosten());
                    }
                    totaal += (optie.getKosten() * (1 - (optie.getMilieuKortingsPercentage() / 100.0)));
                }
                System.out.println("--------------------------------------------------");
                double korting = klanttype.getKortingsPercentage();
                if(korting == 0) {
                    System.out.println("Totaalprijs: €" + totaal);
                }
                else {
                    System.out.println("Korting(" + klanttype.getType() + "): €" + korting+ "%");
                    totaal = totaal * (1 - (korting / 100));  // if statement weggehaald en korting direct toegepast
                    System.out.println("Totaalprijs: €" + totaal);
                }
                System.out.println("--------------------------------------------------");
            }
        }
        return totaal;
    }
}