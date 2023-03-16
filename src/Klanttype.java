class Klanttype {
    private String type;
    private int korting;

    Klanttype(String type, int korting) {
        this.type = type;
        this.korting = korting;
    }


    public String getType() {
        return this.type;
    }

    public int getKorting() {
        return this.korting;
    }


    public void setType(String type) {
        this.type = type;
    }

    public void setKorting(int korting) {
        this.korting = korting;
    }
}