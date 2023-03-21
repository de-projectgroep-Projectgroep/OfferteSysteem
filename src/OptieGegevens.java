public class OptieGegevens {
    private String naam;
    private String beschrijving;
    private String categorie;
    private boolean milieuVriendelijk;
    public OptieGegevens(String naam, String beschrijving, String categorie) {
        this.naam = naam;
        this.beschrijving = beschrijving;
        this.categorie = categorie;
        this.milieuVriendelijk = false;
    }

    public String getNaam() {
        return naam;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }

    public String getBeschrijving() {
        return beschrijving;
    }

    public void setBeschrijving(String beschrijving) {
        this.beschrijving = beschrijving;
    }

    public boolean isMilieuVriendelijk() {
        return milieuVriendelijk;
    }

    public String getCategorie() {
        return categorie;
    }

    public void setCategorie(String categorie) {
        this.categorie = categorie;
    }
}

