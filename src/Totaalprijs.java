import java.util.ArrayList;

public class Totaalprijs {
    public static double berekenTotaalPrijs(Klant klant, Schip schip) { //importeren uit de andere classes

        ArrayList<Optie> opties = new ArrayList<Optie>();
        for (Optie optie : schip.opties){
            opties.add(optie);
        }

        double totaal = 0;
        for (Optie optie : opties) {
            totaal += (optie.getKosten() * (1 - (optie.getMilieuKortingsPercentage() / 100.0)));
        }

        Klanttype klanttype = klant.getKlanttype();
        double totaalprijs = totaal * (1 - (klanttype.getKortingsPercentage() / 100.0));  // if statement weggehaald en korting direct toegepast
        return totaalprijs; // dit is inclusief korting
    }
}