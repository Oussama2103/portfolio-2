import static org.junit.jupiter.api.Assertions.assertTrue;


import org.junit.jupiter.api.Test;

import java.util.Scanner;

public class GemeenteToevoegenTest {

    @Test
    public void testToevoegenGemeente() {

        Scanner scanner = new Scanner("Amsterdam\n1000000\n500000\n");


        Main.voegNieuweGemeenteToe(scanner);


        assertTrue(Main.isGemeenteToegevoegd("Amsterdam"));
    }
}
