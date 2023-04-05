import java.util.ArrayList;
import java.util.List;

public class Optie {
    private String naam;
    private String beschrijving;

    private double kosten;
    private boolean essentieel;
    private boolean milieuVriendelijk;
    private int milieuKorting;

    public Optie(String naam, String beschrijving, double kosten, boolean essentieel, boolean milieuVriendelijk, int milieuKorting) {

        this.naam = naam;
        this.beschrijving = beschrijving;
        this.kosten = kosten;
        this.essentieel = essentieel;
        this.milieuVriendelijk = milieuVriendelijk;
        this.milieuKorting = milieuKorting;
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

    public int getMilieuKorting() {
        return milieuKorting;
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
    public void setMilieuKorting(int milieuKorting) {
        this.milieuKorting = milieuKorting;
    }
}