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


class Persoon{
    private String voornaam;
    private String achternaam;
    private String geslacht;
    private String geboortedatum;
    private String telefoonnummer;
    private String email;
    private String adres;

    Persoon(String voornaam, String achternaam, String geslacht, String geboortedatum, String email, String telefoonnummer){
        this.voornaam = voornaam;
        this.achternaam = achternaam;
        this.geslacht = geslacht;
        this.geboortedatum = geboortedatum;
        this.email = email;
        this.telefoonnummer = telefoonnummer;
    }

    Persoon(String voornaam, String achternaam, String geslacht, String geboortedatum, String email, String telefoonnummer, String adres){
        this(voornaam, achternaam, geslacht, geboortedatum, email, telefoonnummer);
        this.adres = adres;
    }

    public String getVoornaam(){
        return this.voornaam;
    }

    public String getAchternaam(){
        return this.achternaam;
    }

    public String getGeslacht(){
        return this.geslacht;
    }

    public String getGeboortedatum(){
        return this.geboortedatum;
    }

    public String getEmail(){
        return this.email;
    }

    public String getTelefoonnummer(){
        return this.telefoonnummer;
    }
    public String getAdres(){
        return this.adres;
    }

    public void setVoornaam(String voornaam){
        this.voornaam = voornaam;
    }

    public void setAchternaam(String achternaam){
        this.achternaam = achternaam;
    }

    public void setGeslacht(String geslacht){
        this.geslacht = geslacht;
    }

    public void setGeboortedatum(String geboortedatum){
        this.geboortedatum = geboortedatum;
    }

    public void setEmail(String email){
        this.email = email;
    }

    public void setTelefoonnummer(String telefoonnummer){
        this.telefoonnummer = telefoonnummer;
    }

    public void setAdres(String adres){
        this.adres = adres;
    }
}

class Klanttype{
    private int korting;

    Klanttype(int korting){
        this.korting = korting;
    }

    public int getKorting(){
        return this.korting;
    }

    public void setKorting(int korting){
        this.korting = korting;
    }
}

