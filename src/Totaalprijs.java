///public class Totaalprijs {
    /*
     totaalprijs
     automatisch berekenen op basis klanttype en geselecteerde opties
     gemakkelijke interface
     korting: klanttype.java
    */
}


public class Totaalprijs {

    private Klanttype klanttype;
    private Set<Option> geselecteerdeOpties;

    public Totaalprijs(Klanttype klanttype, Set<Option> geselecteerdeOpties) {
        this.klanttype = klanttype;
        this.geselecteerdeOpties = geselecteerdeOpties;
    }

    public double berekenTotaalprijs() {
        double totaalprijs = 0.0;
        double optieprijs = 0.0;

        for (Option optie : geselecteerdeOpties) {
            optieprijs += optie.getPrijs();
        }

        if (klanttype instanceof Bedrijfsklant) {
            totaalprijs += optieprijs * 0.9; // 10% korting voor bedrijfsklanten
        } else if (klanttype instanceof ParticuliereKlant) {
            totaalprijs += optieprijs;
        }

        return totaalprijs;
    }

}
