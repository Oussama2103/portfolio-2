import java.util.ArrayList;

class Beheerder extends Persoon {
    private ArrayList<Gemeente> gemeentes;

    public Beheerder(String naam, String landVanHerkomst) {
        super(naam, landVanHerkomst);
        this.gemeentes = new ArrayList<>();
    }

    public ArrayList<Gemeente> getGemeentes() {
        return gemeentes;
    }

    public void setGemeentes(ArrayList<Gemeente> gemeentes) {
        this.gemeentes = gemeentes;
    }
}
