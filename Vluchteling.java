class Vluchteling extends Persoon {
    private boolean paspoortGetoond;
    private boolean asielaanvraagCompleet;
    private boolean rechterToegewezen;
    private boolean rechterUitspraak;
    private String plaatsingInEigenWoning;

    public Vluchteling(String naam, String landVanHerkomst) {
        super(naam, landVanHerkomst);
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

    public boolean isRechterUitspraak() {
        return rechterUitspraak;
    }

    public void setRechterUitspraak(boolean rechterUitspraak) {
        this.rechterUitspraak = rechterUitspraak;
    }

    public String getPlaatsingInEigenWoning() {
        return plaatsingInEigenWoning;
    }

    public void setPlaatsingInEigenWoning(String plaatsingInEigenWoning) {
        this.plaatsingInEigenWoning = plaatsingInEigenWoning;
    }

    public void setAdres(Adres nieuwAdres) {
        this.setAdres(nieuwAdres);
    }
}
