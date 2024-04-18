import java.util.ArrayList;

class AZC {
    private String naam;
    private Adres adres;
    private int capaciteit;
    private ArrayList<Vluchteling> gehuisvesteVluchtelingen;

    public AZC(String naam, Adres adres, int capaciteit) {
        this.naam = naam;
        this.adres = adres;
        this.capaciteit = capaciteit;
        this.gehuisvesteVluchtelingen = new ArrayList<>();
    }

    public String getNaam() {
        return naam;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }

    public Adres getAdres() {
        return adres;
    }

    public void setAdres(Adres adres) {
        this.adres = adres;
    }

    public int getCapaciteit() {
        return capaciteit;
    }

    public void setCapaciteit(int capaciteit) {
        this.capaciteit = capaciteit;
    }

    public ArrayList<Vluchteling> getGehuisvesteVluchtelingen() {
        return gehuisvesteVluchtelingen;
    }

    public void setGehuisvesteVluchtelingen(ArrayList<Vluchteling> gehuisvesteVluchtelingen) {
        this.gehuisvesteVluchtelingen = gehuisvesteVluchtelingen;
    }
}
