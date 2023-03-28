class Klanttype {
    private String type;
    private int kortingsPercentage;

    Klanttype(String type, int kortingsPercentage) {
        this.type = type;
        this.kortingsPercentage = kortingsPercentage;
    }


    public String getType() {
        return this.type;
    }

    public int getKortingsPercentage() {
        return this.kortingsPercentage;
    }


    public void setType(String type) {
        this.type = type;
    }

    public void setKortingsPercentage(int korting) {
        this.kortingsPercentage = kortingsPercentage;
    }
}