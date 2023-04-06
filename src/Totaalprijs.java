import java.util.ArrayList;

public class Totaalprijs {
    public static double berekenTotaalPrijs(Klant klant, Schip schip) { //importeren uit de andere classes
        ArrayList<Optie> opties = schip.getOpties();
        double totaal = 0;
        for (Optie optie : opties) {
            totaal += optie.getPrijs();
        }
        if (schip.getMilieuKlasse() == 1) {
            totaal *= 0.95;  // milleukorting kan hier aangepast worden
        }
        Klanttype klanttype = klant.getKlanttype();
        double totaalprijs = totaal * klanttype.getKorting();  // if statement weggehaald en korting direct toegepast
        return totaalprijs; // dit is inclusief korting
    }
}

