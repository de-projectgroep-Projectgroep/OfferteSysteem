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