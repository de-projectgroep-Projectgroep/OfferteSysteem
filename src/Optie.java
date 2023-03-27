import java.util.ArrayList;
import java.util.List;

public class Optie {
    private String naam;
    private String beschrijving;

    private double kosten;
    private boolean essentieel;
    private boolean milieuVriendelijk;

    public Optie(String naam, String beschrijving, double kosten, boolean essentieel, boolean milieuVriendelijk) {

        this.naam = naam;
        this.beschrijving = beschrijving;
        this.kosten = kosten;
        this.essentieel = essentieel;
        this.milieuVriendelijk = milieuVriendelijk;
    }

    public String getNaam() {
        return naam;
    }

    public String getBeschrijving() {
        return beschrijving;
    }

    public double getKosten() {
        return kosten;
    }

    public boolean getEssentieel() {
        return essentieel;
    }

    public boolean getMilieuVriendelijk() {
        return milieuVriendelijk;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }

    public void setBeschrijving(String beschrijving) {
        this.beschrijving = beschrijving;
    }

    public void setKosten(double kosten) {
        this.kosten = kosten;
    }

    public void setEssentieel(boolean essentieel) {
        this.essentieel = essentieel;
    }
    public void setMilieuVriendelijk(boolean milieuVriendelijk) {
        this.milieuVriendelijk = milieuVriendelijk;
    }

    public static double milieuKorting() {
        double korting = 0.0;
        for (Optie optie : ObjectStorage.opties) {
            if (optie.getMilieuVriendelijk()) {
                korting += 0.1;
            }
        }
        return korting;
    }

    public static void printOpties() {
        List<Optie> essentieleOpties = new ArrayList<>();
        List<Optie> extraOpties = new ArrayList<>();

        for (Optie optie : ObjectStorage.opties) {
            if (optie.getEssentieel()) {
                essentieleOpties.add(optie);
            } else {
                extraOpties.add(optie);
            }
        }

        System.out.println("Essentiële opties:");
        for (Optie optie : essentieleOpties) {
            System.out.println(optie.getNaam() + " - " + optie.getBeschrijving() + " - €" + optie.getKosten());
        }

        System.out.println("Extra opties:");
        for (Optie optie : extraOpties) {
            System.out.println(optie.getNaam() + " - " + optie.getBeschrijving() + " - €" + optie.getKosten());
        }
    }
}