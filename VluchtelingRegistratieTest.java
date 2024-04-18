
import org.junit.jupiter.api.Test;

import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertTrue;

class VluchtelingRegistratieTest {

    @Test
    public void testRegistrerenVluchteling() {
        // Maak een nieuwe scanner voor de test
        Scanner scanner = new Scanner("John Doe\nSyrië\nja\n");

        // Voer de registratie uit
        Main.registrerenVluchtelingen(scanner);

        // Controleer of de vluchteling is geregistreerd
        assertTrue(Main.isVluchtelingGeregistreerd("John Doe"));
    }
}