import java.util.ArrayList;

class COAMedewerker extends Persoon {
    private ArrayList<AZC> azcs;

    public COAMedewerker(String naam, String landVanHerkomst) {
        super(naam, landVanHerkomst);
        this.azcs = new ArrayList<>();
    }

    public ArrayList<AZC> getAzcs() {
        return azcs;
    }

    public void setAzcs(ArrayList<AZC> azcs) {
        this.azcs = azcs;
    }
}
