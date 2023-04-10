import java.util.ArrayList;

public class Totaalprijs {
    public static double berekenTotaalPrijs(Klant klant, Schip schip) { //importeren uit de andere classes

        double totaal = 0;
        for (Optie optie : schip.opties) {
            totaal += (optie.getKosten() * (1 - (optie.getMilieuKortingsPercentage() / 100.0)));
        }

        Klanttype klanttype = klant.getKlanttype();
        double totaalprijs = totaal * (1 - (klanttype.getKortingsPercentage() / 100.0));  // if statement weggehaald en korting direct toegepast
        return totaalprijs; // dit is inclusief korting
    }
}