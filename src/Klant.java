class Klant{

    private String voornaam;
    private String achternaam;
    private String geslacht;
    private String geboortedatum;
    private String email;
    private String telefoonnummer;

    Klant(String voornaam, String achternaam, String geslacht, String geboortedatum, String email){
        this.voornaam = voornaam;
        this.achternaam = achternaam;
        this.geslacht = geslacht;
        this.geboortedatum = geboortedatum;
        this.email = email;
    }

    Klant(String voornaam, String achternaam, String geslacht, String geboortedatum, String email, String telefoonnummer){
        this(voornaam, achternaam, geslacht, geboortedatum, email);
        this.telefoonnummer = telefoonnummer;
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
}

class Particulier extends Klant{
    static double korting;
    Particulier(String voornaam, String achternaam, String geslacht, String geboortedatum, String email) {
        super(voornaam, achternaam, geslacht, geboortedatum, email);
        this.korting = 5.0;
    }

    Particulier(String voornaam, String achternaam, String geslacht, String geboortedatum, String email, String telefoonnummer) {
        super(voornaam, achternaam, geslacht, geboortedatum, email, telefoonnummer);
        korting = 5.0;
    }

    public double getKorting() {
        return korting;
    }

    public void setKorting(double korting){
        this.korting = korting;
    }
}

class Bedrijf extends Klant{
    private String bedrijfsnaam;
    static double korting;
    Bedrijf(String bedrijfsnaam, String voornaam, String achternaam, String geslacht, String geboortedatum, String email) {
        super(voornaam, achternaam, geslacht, geboortedatum, email);
        korting = 10.0;
        this.bedrijfsnaam = bedrijfsnaam;
    }

    Bedrijf(String bedrijfsnaam, String voornaam, String achternaam, String geslacht, String geboortedatum, String email, String telefoonnummer) {
        super(voornaam, achternaam, geslacht, geboortedatum, email, telefoonnummer);
        korting = 10.0;
        this.bedrijfsnaam = bedrijfsnaam;
    }

    public double getKorting() {
        return korting;
    }

    public void setKorting(double korting){
        this.korting = korting;
    }

    public String getBedrijfsnaam() {
        return this.bedrijfsnaam;
    }

    public void setBedrijfsnaam(String bedrijfsnaam){
        this.bedrijfsnaam = bedrijfsnaam;
    }
}

class Overheid extends Klant{
    static double korting;
    Overheid(String voornaam, String achternaam, String geslacht, String geboortedatum, String email) {
        super(voornaam, achternaam, geslacht, geboortedatum, email);
        korting = 15.0;
    }

    Overheid(String voornaam, String achternaam, String geslacht, String geboortedatum, String email, String telefoonnummer) {
        super(voornaam, achternaam, geslacht, geboortedatum, email, telefoonnummer);
        korting = 15.0;
    }

    static double getKorting() {
        return korting;
    }

    public void setKorting(double korting){
        this.korting = korting;
    }
}
