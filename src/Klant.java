class Klant{

    private String naam;
    private String email;
    private String telefoonnummer;

    private Persoon contactpersoon;
    private Klanttype klanttype;

    Klant(String naam, String email, Klanttype klanttype){
        this.naam = naam;
        this.email = email;
        this.klanttype = klanttype;
    }

    Klant(String naam, String email, String telefoonnummer, Klanttype klanttype){
        this(naam, email, klanttype);
        this.telefoonnummer = telefoonnummer;
    }

    Klant(Persoon contactpersoon, Klanttype klanttype){
        this.naam = contactpersoon.getVoornaam() + " " + contactpersoon.getAchternaam();
        this.email = contactpersoon.getEmail();
        this.telefoonnummer = contactpersoon.getTelefoonnummer();
        this.klanttype = klanttype;
    }

    Klant(String naam, Persoon contactpersoon, Klanttype klanttype){
        this.naam = naam;
        this.email = contactpersoon.getEmail();
        this.telefoonnummer = contactpersoon.getTelefoonnummer();
        this.klanttype = klanttype;
    }

    public String getNaam(){
        return this.naam;
    }

    public String getEmail(){
        return this.email;
    }

    public String getTelefoonnummer(){
        return this.telefoonnummer;
    }
    public Persoon getContactPersoon(){
        return this.contactpersoon;
    }
    public Klanttype getKlanttype(){
        return this.klanttype;
    }

    public void setNaam(String naam){
        this.naam = naam;
    }

    public void setEmail(String email){
        this.email = email;
    }

    public void setTelefoonnummer(String telefoonnummer){
        this.telefoonnummer = telefoonnummer;
    }

    public void setContactpersoon(Persoon contactpersoon){
        this.contactpersoon = contactpersoon;
    }

    public void setKlanttype(Klanttype klanttype){
        this.klanttype = klanttype;
    }
}