class Gemeente {
    private String naam;
    private int inwoners;
    private int beschikbarePlekken;

    public Gemeente(String naam, int inwoners, int beschikbarePlekken) {
        this.naam = naam;
        this.inwoners = inwoners;
        this.beschikbarePlekken = beschikbarePlekken;
    }

    public String getNaam() {
        return naam;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }

    public int getInwoners() {
        return inwoners;
    }

    public void setInwoners(int inwoners) {
        this.inwoners = inwoners;
    }

    public int getBeschikbarePlekken() {
        return beschikbarePlekken;
    }

    public void setBeschikbarePlekken(int beschikbarePlekken) {
        this.beschikbarePlekken = beschikbarePlekken;
    }
}

