import java.util.ArrayList;

class Persoon {
    private String naam;
    private String landVanHerkomst;

    public Persoon(String naam, String landVanHerkomst) {
        this.naam = naam;
        this.landVanHerkomst = landVanHerkomst;
    }

    public String getNaam() {
        return naam;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }

    public String getLandVanHerkomst() {
        return landVanHerkomst;
    }

    public void setLandVanHerkomst(String landVanHerkomst) {
        this.landVanHerkomst = landVanHerkomst;
    }
}

