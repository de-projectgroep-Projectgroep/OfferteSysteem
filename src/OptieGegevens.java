public class OptieGegevens {
    private String naam;
    private String beschrijving;
    private String categorie;

    public OptieGegevens(String naam, String beschrijving, String categorie) {
        this.naam = naam;
        this.beschrijving = beschrijving;
        this.categorie = categorie;
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

    public String getCategorie() {
        return categorie;
    }

    public void setCategorie(String categorie) {
        this.categorie = categorie;
    }
}

