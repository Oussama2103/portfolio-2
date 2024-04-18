import java.util.ArrayList;
import java.util.Scanner;

public class Main implements Menu{

    private static ArrayList<Land> landen = new ArrayList<>();
    private static ArrayList<Gemeente> gemeentes = new ArrayList<>();
    private static ArrayList<AZC> azcs = new ArrayList<>();
    private static ArrayList<Dossier> dossiers = new ArrayList<>();


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        hoofdMenu(scanner);
    }
    public void weergevenMenu(Scanner scanner) {
        hoofdMenu(scanner);
    }
    public static void hoofdMenu(Scanner scanner) {

        while (true) {
            System.out.println("Hoofdmenu:");
            System.out.println("1. Beheerder");
            System.out.println("2. COA-medewerker");
            System.out.println("3. Asielzoeker");
            System.out.println("4. Exit");
            System.out.print("Voer uw keuze in: ");

            int keuze = scanner.nextInt();
            scanner.nextLine();

            switch (keuze) {
                case 1:
                    beheerderMenu(scanner);
                    break;
                case 2:
                    coaMedewerkerMenu(scanner);
                    break;
                case 3:
                    vluchtelingMenu(scanner);
                    break;
                case 4:
                    System.out.println("Programma wordt afgesloten...");
                    return;
                default:
                    System.out.println("Ongeldige keuze. Probeer opnieuw.");
                    break;
            }
        }
    }

    public static void beheerderMenu(Scanner scanner) {
        while (true) {
            System.out.println("Beheerder Menu:");
            System.out.println("1. Beheer landen");
            System.out.println("2. Beheer gemeentes");
            System.out.println("3. Beheer AZC's");
            System.out.println("4. Rapportage uitkeringen aan gemeentes");
            System.out.println("5. Terug naar hoofdmenu");
            System.out.print("Voer uw keuze in: ");

            int keuze = scanner.nextInt();
            scanner.nextLine();

            switch (keuze) {
                case 1:
                    beheerLanden(scanner);
                    break;
                case 2:
                    beheerGemeentes(scanner);
                    break;
                case 3:
                    beheerAZCs(scanner);
                    break;
                case 4:
                    rapportageUitkeringen();
                    break;
                case 5:
                    return;
                default:
                    System.out.println("Ongeldige keuze. Probeer opnieuw.");
                    break;
            }
        }
    }

    public static void beheerLanden(Scanner scanner) {
        while (true) {
            System.out.println("Landen Beheer Menu:");
            System.out.println("1. Voeg nieuw land toe");
            System.out.println("2. Wijzig veiligheid van een land");
            System.out.println("3. Terug naar vorig menu");
            System.out.print("Voer uw keuze in: ");

            int keuze = scanner.nextInt();
            scanner.nextLine();

            switch (keuze) {
                case 1:
                    voegNieuwLandToe(scanner);
                    break;
                case 2:
                    wijzigVeiligheidLand(scanner);
                    break;
                case 3:
                    return;
                default:
                    System.out.println("Ongeldige keuze. Probeer opnieuw.");
                    break;
            }
        }
    }

    public static void voegNieuwLandToe(Scanner scanner) {
        System.out.print("Voer de naam van het land in: ");
        String naam = scanner.nextLine();

        // Controleer of het land al is toegevoegd
        if (isLandToegevoegd(naam)) {
            System.out.println("Dit land is al toegevoegd.");
            return;
        }

        System.out.print("Is het land veilig? (ja/nee): ");
        boolean veilig = scanner.nextLine().equalsIgnoreCase("ja");
        landen.add(new Land(naam, veilig));
        System.out.println("Land " + naam + " is toegevoegd.");
    }

    // Methode om te controleren of een land al is toegevoegd
    public static boolean isLandToegevoegd(String naam) {
        for (Land land : landen) {
            if (land.getNaam().equalsIgnoreCase(naam)) {
                return true;
            }
        }
        return false;
    }

    public static void wijzigVeiligheidLand(Scanner scanner) {
        if (landen.isEmpty()) {
            System.out.println("Er zijn geen landen om veiligheid van te wijzigen.");
            return;
        }

        System.out.println("Beschikbare landen:");
        for (int i = 0; i < landen.size(); i++) {
            System.out.println((i + 1) + ". " + landen.get(i).getNaam());
        }

        System.out.print("Kies het nummer van het land waarvan u de veiligheid wilt wijzigen: ");
        int keuze = scanner.nextInt();
        scanner.nextLine(); // consumeer de new line karakter

        if (keuze < 1 || keuze > landen.size()) {
            System.out.println("Ongeldige keuze. Probeer opnieuw.");
            return;
        }

        Land land = landen.get(keuze - 1);
        System.out.print("Is het land veilig? (ja/nee): ");
        boolean veilig = scanner.nextLine().equalsIgnoreCase("ja");
        land.setVeilig(veilig);
        System.out.println("Veiligheid van land " + land.getNaam() + " is gewijzigd.");
    }

    public static void beheerGemeentes(Scanner scanner) {
        while (true) {
            System.out.println("Gemeentes Beheer Menu:");
            System.out.println("1. Voeg nieuwe gemeente toe");
            System.out.println("2. Wijzig aantal plaatsen in een gemeente");
            System.out.println("3. Terug naar vorig menu");
            System.out.print("Voer uw keuze in: ");

            int keuze = scanner.nextInt();
            scanner.nextLine(); // consumeer de new line karakter

            switch (keuze) {
                case 1:
                    voegNieuweGemeenteToe(scanner);
                    break;
                case 2:
                    wijzigAantalPlaatsen(scanner);
                    break;
                case 3:
                    return;
                default:
                    System.out.println("Ongeldige keuze. Probeer opnieuw.");
                    break;
            }
        }
    }

    public static void voegNieuweGemeenteToe(Scanner scanner) {
        System.out.print("Voer de naam van de gemeente in: ");
        String naam = scanner.nextLine();

        // Controleer of de gemeente al is toegevoegd
        if (isGemeenteToegevoegd(naam)) {
            System.out.println("Deze gemeente is al toegevoegd.");
            return;
        }

        System.out.print("Voer het aantal inwoners van de gemeente in: ");
        int inwoners = scanner.nextInt();
        System.out.print("Voer het aantal beschikbare plekken in de gemeente in: ");
        int beschikbarePlekken = scanner.nextInt();
        scanner.nextLine(); // consumeer de new line karakter
        gemeentes.add(new Gemeente(naam, inwoners, beschikbarePlekken));
        System.out.println("Gemeente " + naam + " is toegevoegd.");
    }

    // Methode om te controleren of een gemeente al is toegevoegd
    public static boolean isGemeenteToegevoegd(String naam) {
        for (Gemeente gemeente : gemeentes) {
            if (gemeente.getNaam().equalsIgnoreCase(naam)) {
                return true;
            }
        }
        return false;
    }

    public static void wijzigAantalPlaatsen(Scanner scanner) {
        if (gemeentes.isEmpty()) {
            System.out.println("Er zijn geen gemeentes om het aantal plaatsen van te wijzigen.");
            return;
        }

        System.out.println("Beschikbare gemeentes:");
        for (int i = 0; i < gemeentes.size(); i++) {
            System.out.println((i + 1) + ". " + gemeentes.get(i).getNaam());
        }

        System.out.print("Kies het nummer van de gemeente waarvan u het aantal plaatsen wilt wijzigen: ");
        int keuze = scanner.nextInt();
        scanner.nextLine(); // consumeer de new line karakter

        if (keuze < 1 || keuze > gemeentes.size()) {
            System.out.println("Ongeldige keuze. Probeer opnieuw.");
            return;
        }

        Gemeente gemeente = gemeentes.get(keuze - 1);
        System.out.print("Voer het nieuwe aantal plaatsen in voor gemeente " + gemeente.getNaam() + ": ");
        int aantalPlaatsen = scanner.nextInt();
        scanner.nextLine(); // consumeer de new line karakter
        gemeente.setBeschikbarePlekken(aantalPlaatsen);
        System.out.println("Aantal plaatsen voor gemeente " + gemeente.getNaam() + " is gewijzigd naar " + aantalPlaatsen + ".");
    }

    public static void beheerAZCs(Scanner scanner) {
        while (true) {
            System.out.println("AZC's Beheer Menu:");
            System.out.println("1. Voeg nieuw AZC toe");
            System.out.println("2. Wijzig AZC");
            System.out.println("3. Verwijder AZC");
            System.out.println("4. Terug naar vorig menu");
            System.out.print("Voer uw keuze in: ");

            int keuze = scanner.nextInt();
            scanner.nextLine(); // consumeer de new line karakter

            switch (keuze) {
                case 1:
                    voegNieuwAZCToe(scanner);
                    break;
                case 2:
                    wijzigAZC(scanner);
                    break;
                case 3:
                    verwijderAZC(scanner);
                    break;
                case 4:
                    return;
                default:
                    System.out.println("Ongeldige keuze. Probeer opnieuw.");
                    break;
            }
        }
    }

    public static void voegNieuwAZCToe(Scanner scanner) {
        System.out.print("Voer de naam van het AZC in: ");
        String naam = scanner.nextLine();

        // Controleer of het AZC al is toegevoegd
        if (isAZCToegevoegd(naam)) {
            System.out.println("Dit AZC is al toegevoegd.");
            return;
        }

        System.out.print("Voer de straatnaam van het AZC in: ");
        String straat = scanner.nextLine();
        System.out.print("Voer het huisnummer van het AZC in: ");
        String huisnummer = scanner.nextLine();
        System.out.print("Voer de postcode van het AZC in: ");
        String postcode = scanner.nextLine();
        System.out.print("Voer de gemeente van het AZC in: ");
        String gemeente = scanner.nextLine();
        System.out.print("Voer de capaciteit van het AZC in: ");
        int capaciteit = scanner.nextInt();
        Adres adres = new Adres(straat, huisnummer, postcode, gemeente);
        azcs.add(new AZC(naam, adres, capaciteit));
        System.out.println("AZC " + naam + " is toegevoegd.");
    }

    // Methode om te controleren of een AZC al is toegevoegd
    public static boolean isAZCToegevoegd(String naam) {
        for (AZC azc : azcs) {
            if (azc.getNaam().equalsIgnoreCase(naam)) {
                return true;
            }
        }
        return false;
    }

    public static void wijzigAZC(Scanner scanner) {
        if (azcs.isEmpty()) {
            System.out.println("Er zijn geen AZC's om te wijzigen.");
            return;
        }

        System.out.println("Beschikbare AZC's:");
        for (int i = 0; i < azcs.size(); i++) {
            System.out.println((i + 1) + ". " + azcs.get(i).getNaam());
        }

        System.out.print("Kies het nummer van het AZC dat u wilt wijzigen: ");
        int keuze = scanner.nextInt();
        scanner.nextLine(); // consumeer de new line karakter

        if (keuze < 1 || keuze > azcs.size()) {
            System.out.println("Ongeldige keuze. Probeer opnieuw.");
            return;
        }

        AZC azc = azcs.get(keuze - 1);
        System.out.println("Huidige gegevens van AZC " + azc.getNaam() + ":");
        System.out.println("Naam: " + azc.getNaam());
        System.out.println("Adres: " + azc.getAdres().getStraat() + " " + azc.getAdres().getHuisnummer() + ", " + azc.getAdres().getPostcode() + ", " + azc.getAdres().getGemeente());

        System.out.println("Voer nieuwe gegevens in:");

        System.out.print("Nieuwe naam: ");
        String nieuweNaam = scanner.nextLine();
        azc.setNaam(nieuweNaam);

        System.out.print("Nieuwe straatnaam: ");
        String nieuweStraat = scanner.nextLine();
        azc.getAdres().setStraat(nieuweStraat);

        System.out.print("Nieuw huisnummer: ");
        String nieuwHuisnummer = scanner.nextLine();
        azc.getAdres().setHuisnummer(nieuwHuisnummer);

        System.out.print("Nieuwe postcode: ");
        String nieuwePostcode = scanner.nextLine();
        azc.getAdres().setPostcode(nieuwePostcode);

        System.out.print("Nieuwe gemeente: ");
        String nieuweGemeente = scanner.nextLine();
        azc.getAdres().setGemeente(nieuweGemeente);

        System.out.println("AZC " + azc.getNaam() + " is gewijzigd.");
    }

    public static void verwijderAZC(Scanner scanner) {
        if (azcs.isEmpty()) {
            System.out.println("Er zijn geen AZC's om te verwijderen.");
            return;
        }

        System.out.println("Beschikbare AZC's:");
        for (int i = 0; i < azcs.size(); i++) {
            System.out.println((i + 1) + ". " + azcs.get(i).getNaam());
        }

        System.out.print("Kies het nummer van het AZC dat u wilt verwijderen: ");
        int keuze = scanner.nextInt();
        scanner.nextLine(); // consumeer de new line karakter

        if (keuze < 1 || keuze > azcs.size()) {
            System.out.println("Ongeldige keuze. Probeer opnieuw.");
            return;
        }

        AZC azc = azcs.get(keuze - 1);
        if (!azc.getGehuisvesteVluchtelingen().isEmpty()) {
            System.out.println("Het AZC kan niet worden verwijderd omdat er nog vluchtelingen gehuisvest zijn.");
            return;
        }

        azcs.remove(azc);
        System.out.println("AZC " + azc.getNaam() + " is verwijderd.");
    }

    public static void rapportageUitkeringen() {
        System.out.println("Rapportage uitkeringen aan gemeentes:");
        for (Gemeente gemeente : gemeentes) {
            int aantalInwoners = gemeente.getInwoners();
            double uitkering;
            if (aantalInwoners > 100) {
                uitkering = 2000;
            } else {
                uitkering = 1000;
            }
            System.out.println("Gemeente: " + gemeente.getNaam() + ", Inwoners: " + aantalInwoners + ", Uitkering: €" + uitkering);
        }
    }

    public static void coaMedewerkerMenu(Scanner scanner) {

     while (true) {
        System.out.println("COA-medewerker Menu:");
        System.out.println("1. Registreren van vluchtelingen");
        System.out.println("2. Afhandeling van asielaanvragen");
        System.out.println("3. bijweken van de dossier");
        System.out.println("4. Terug naar hoofdmenu");
        System.out.print("Maak een keuze: ");

        int keuze = Integer.parseInt(scanner.nextLine());

        switch (keuze) {
            case 1:
                registrerenVluchtelingen(scanner);
                break;
            case 2:
                plaatsingInGemeente(scanner);
                break;
            case 3:
                bijwerkenDossier(scanner);
                break;
            case 4:
                return;
            default:
                System.out.println("Ongeldige keuze. Probeer opnieuw.");
                break;
        }
    }
}

    public static void registrerenVluchtelingen(Scanner scanner) {
        System.out.println("Registreren van vluchtelingen:");

        System.out.print("Voer de naam van de vluchteling in: ");
        String naam = scanner.nextLine();

        if (isVluchtelingGeregistreerd(naam)) {
            System.out.println("Deze vluchteling is al geregistreerd in het systeem.");
            return;
        }

        System.out.print("Voer het land van herkomst in: ");
        String landVanHerkomst = scanner.nextLine();

        System.out.print("Kan de vluchteling een paspoort tonen? (ja/nee): ");
        boolean paspoortGetoond = scanner.nextLine().equalsIgnoreCase("ja");

        Dossier dossier = new Dossier();
        dossier.setPaspoortGetoond(paspoortGetoond);
        dossier.setNaam(naam);
        dossier.setLandVanHerkomst(landVanHerkomst);
        dossier.setAZC(null);
        dossier.setVerblijfsvergunning(false);

        dossiers.add(dossier);

        System.out.println("Vluchteling " + naam + " geregistreerd.");
    }

    public static boolean isVluchtelingGeregistreerd(String naam) {
        for (Dossier dossier : dossiers) {
            if (dossier.getNaam().equalsIgnoreCase(naam)) {
                return true;
            }
        }
        return false;
    }

    public static void plaatsingInGemeente(Scanner scanner) {
        System.out.println("Plaatsing van vluchteling in gemeente:");

        System.out.print("Voer de naam van de vluchteling in: ");
        String naamVluchteling = scanner.nextLine();

        // Zoek het dossier van de vluchteling
        Dossier dossier = zoekDossier(naamVluchteling);

        if (dossier != null) {
            Gemeente gekozenGemeente = bepaalGekozenGemeente();

            if (gekozenGemeente != null) {
                System.out.println("Asielzoeker " + naamVluchteling + " wordt voorgesteld om te plaatsen in gemeente: " + gekozenGemeente.getNaam());
            } else {
                System.out.println("Geen geschikte gemeente gevonden voor plaatsing van asielzoeker " + naamVluchteling + ".");
            }
        } else {
            System.out.println("Dossier van vluchteling " + naamVluchteling + " niet gevonden.");
        }
    }

    public static Gemeente bepaalGekozenGemeente() {
        Gemeente gekozenGemeente = null;
        double hoogsteBeschikbarePlekken = 0;
        double laagsteRelatievePlekken = Double.MAX_VALUE;

        for (Gemeente gemeente : gemeentes) {
            double relatievePlekken = (double) gemeente.getBeschikbarePlekken() / gemeente.getInwoners();

            if (gemeente.getBeschikbarePlekken() > 0) {
                if (gemeente.getBeschikbarePlekken() > hoogsteBeschikbarePlekken) {
                    hoogsteBeschikbarePlekken = gemeente.getBeschikbarePlekken();
                    gekozenGemeente = gemeente;
                }
                if (relatievePlekken < laagsteRelatievePlekken) {
                    laagsteRelatievePlekken = relatievePlekken;
                    gekozenGemeente = gemeente;
                }
            }
        }

        return gekozenGemeente;
    }

    public static void bijwerkenDossier(Scanner scanner) {
        System.out.println("Bijwerken van dossier:");

        System.out.print("Voer de naam van de vluchteling in: ");
        String naam = scanner.nextLine();

        Dossier dossier = zoekDossier(naam);

        if (dossier != null) {
            System.out.println("Dossier van vluchteling " + naam + " gevonden.");

            System.out.print("Is een paspoort getoond? (ja/nee): ");
            boolean paspoortGetoond = scanner.nextLine().equalsIgnoreCase("ja");
            dossier.setPaspoortGetoond(paspoortGetoond);

            System.out.print("Is een asielaanvraag compleet aangeleverd? (ja/nee): ");
            boolean asielaanvraagCompleet = scanner.nextLine().equalsIgnoreCase("ja");
            dossier.setAsielaanvraagCompleet(asielaanvraagCompleet);

            System.out.print("Is een rechter toegewezen? (ja/nee): ");
            boolean rechterToegewezen = scanner.nextLine().equalsIgnoreCase("ja");
            dossier.setRechterToegewezen(rechterToegewezen);

            if (rechterToegewezen) {
                System.out.print("Heeft de rechter een uitspraak gedaan? (ja/nee): ");
                boolean rechterUitspraak = scanner.nextLine().equalsIgnoreCase("ja");
                dossier.setRechterUitspraak(rechterUitspraak ? "Ja" : "Nee");

                if (rechterUitspraak) {
                    System.out.print("Is de vluchteling toegelaten tot de Nederlandse samenleving? (ja/nee): ");
                    boolean toegelatenTotSamenleving = scanner.nextLine().equalsIgnoreCase("ja");
                    dossier.setToegelatenTotSamenleving(toegelatenTotSamenleving);
                }
            }

            System.out.print("Is de vluchteling teruggekeerd naar het land van herkomst? (ja/nee): ");
            boolean terugkeerLandVanHerkomst = scanner.nextLine().equalsIgnoreCase("ja");
            dossier.setTerugkeerLandVanHerkomst(terugkeerLandVanHerkomst);

            System.out.println("Dossier van vluchteling " + naam + " bijgewerkt.");
        } else {
            System.out.println("Dossier van vluchteling " + naam + " niet gevonden.");
        }
    }

    public static Dossier zoekDossier(String naam) {
        for (Dossier dossier : dossiers) {
            if (dossier.getNaam().equalsIgnoreCase(naam)) {
                return dossier;
            }
        }
        return null;
    }

    public static void vluchtelingMenu (Scanner scanner) {
        while (true) {
            System.out.println("\nVluchteling Menu:");
            System.out.println("1. Gegevens opvragen");
            System.out.println("2. Status dossier opvragen");
            System.out.println("3. Registreren van nieuw adres");
            System.out.println("4. Terug naar hoofdmenu");

            System.out.print("\nKies een optie: ");
            int keuze = scanner.nextInt();

            switch (keuze) {
                case 1:
                    gegevensOpvragen(scanner);
                    break;
                case 2:
                    statusDossierOpvragen(scanner);
                    break;
                case 3:
                    //registrerenNieuwAdres(scanner);
                    break;
                case 4:
                    return;
                default:
                    System.out.println("Ongeldige keuze. Probeer opnieuw.");
                    break;
            }
        }
    }

    public static void gegevensOpvragen(Scanner scanner) {
        System.out.println("\nGeregistreerde gegevens worden opgevraagd...");

        System.out.print("Voer je naam in: ");
        String naam = scanner.next();

        // Zoek het dossier van de vluchteling op basis van de naam
        Dossier dossier = zoekDossier(naam);

        if (dossier != null) {
            System.out.println("Naam: " + dossier.getNaam());
            System.out.println("Land van herkomst: " + dossier.getLandVanHerkomst());
            System.out.println("Paspoort getoond: " + (dossier.isPaspoortGetoond() ? "Ja" : "Nee"));
            // Aanvullen met andere gegevens uit het dossier indien nodig
        } else {
            System.out.println("Vluchteling met de opgegeven naam niet gevonden.");
        }
    }

    public static void statusDossierOpvragen(Scanner scanner) {
        System.out.println("\nStatus van het dossier wordt opgevraagd...");

        System.out.print("Voer je naam in: ");
        String naam = scanner.next();

        // Zoek het dossier van de vluchteling op basis van de naam
        Dossier dossier = zoekDossier(naam);

        if (dossier != null) {
            System.out.println("Paspoort getoond: " + (dossier.isPaspoortGetoond() ? "Ja" : "Nee"));
            System.out.println("Asielaanvraag compleet: " + (dossier.isAsielaanvraagCompleet() ? "Ja" : "Nee"));
            System.out.println("Rechter toegewezen: " + (dossier.isRechterToegewezen() ? "Ja" : "Nee"));
            System.out.println("Rechter heeft uitspraak gedaan: " + (dossier.getRechterUitspraak() != null ? dossier.getRechterUitspraak() : "Nee"));
            System.out.println("Plaatsing in eigen woning: " + dossier.getPlaatsingInEigenWoning());
        } else {
            System.out.println("Vluchteling met de opgegeven naam niet gevonden.");
        }
    }

    public static void registrerenNieuwAdres(Scanner scanner, Vluchteling vluchteling) {
        if (!vluchteling.isRechterUitspraak() || !vluchteling.getPlaatsingInEigenWoning().equals("Ja")) {
            System.out.println("U kunt uw adres niet registreren omdat de asielaanvraag niet is geaccepteerd of de plaatsing in een eigen woning nog niet is gestart.");
            return;
        }

        System.out.println("Registreren van nieuw adres:");

        System.out.print("Voer de straatnaam in: ");
        String straat = scanner.nextLine();

        System.out.print("Voer het huisnummer in: ");
        String huisnummer = scanner.nextLine();

        System.out.print("Voer de postcode in: ");
        String postcode = scanner.nextLine();

        System.out.print("Voer de gemeente in: ");
        String gemeente = scanner.nextLine();

        // Maak een nieuw adres object
        Adres nieuwAdres = new Adres(straat, huisnummer, postcode, gemeente);

        // Stel het nieuwe adres in voor de vluchteling
        vluchteling.setAdres(nieuwAdres);

        System.out.println("Nieuw adres geregistreerd.");
    }
}
