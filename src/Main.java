import java.util.ArrayList;
import java.util.List;
public class Main {
    public static void main(String[] args) {
        ObjectStorage.addKlanttype();

        //testOptie
        List<Optie> opties = new ArrayList<>();
        Optie.voegOptieToe(opties);
        opties.add(new Optie(new OptieGegevens("Airco", "Een airconditioning systeem", "Essentieel")));
        System.out.println();
        Optie.toonOpties(opties);
        System.out.println();
        Optie.verwijderOptie(opties);
        System.out.println();
        Optie.toonOpties(opties);
        System.out.println();
        Optie.bewerkOptie(opties);
        System.out.println();
        Optie.toonOpties(opties);

    }
}