public class Dossier {
    private String naam;
    private String landVanHerkomst;
    private boolean paspoortGetoond;
    private boolean asielaanvraagCompleet;
    private boolean rechterToegewezen;
    private String rechterUitspraak;
    private String plaatsingInEigenWoning;

    private boolean toegelatenTotSamenleving;
    private boolean terugkeerLandVanHerkomst;

    private AZC azc;
    private boolean verblijfsvergunning;

    public Dossier () {

    }
    public Dossier(String naam, String landVanHerkomst) {
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

    public boolean isPaspoortGetoond() {
        return paspoortGetoond;
    }

    public void setPaspoortGetoond(boolean paspoortGetoond) {
        this.paspoortGetoond = paspoortGetoond;
    }

    public boolean isAsielaanvraagCompleet() {
        return asielaanvraagCompleet;
    }

    public void setAsielaanvraagCompleet(boolean asielaanvraagCompleet) {
        this.asielaanvraagCompleet = asielaanvraagCompleet;
    }

    public boolean isRechterToegewezen() {
        return rechterToegewezen;
    }

    public void setRechterToegewezen(boolean rechterToegewezen) {
        this.rechterToegewezen = rechterToegewezen;
    }

    public String getRechterUitspraak() {
        return rechterUitspraak;
    }

    public void setRechterUitspraak(String rechterUitspraak) {
        this.rechterUitspraak = rechterUitspraak;
    }

    public String getPlaatsingInEigenWoning() {
        return plaatsingInEigenWoning;
    }

    public void setPlaatsingInEigenWoning(String plaatsingInEigenWoning) {
        this.plaatsingInEigenWoning = plaatsingInEigenWoning;
    }

    public void setToegelatenTotSamenleving(boolean toegelatenTotSamenleving) {
        this.toegelatenTotSamenleving = toegelatenTotSamenleving;
    }

    public void setTerugkeerLandVanHerkomst(boolean terugkeerLandVanHerkomst) {
        this.terugkeerLandVanHerkomst = terugkeerLandVanHerkomst;
    }
    public void setAZC(AZC azc) {
        this.azc = azc;
    }

    public void setVerblijfsvergunning(boolean verblijfsvergunning) {
        this.verblijfsvergunning = verblijfsvergunning;
    }
}
