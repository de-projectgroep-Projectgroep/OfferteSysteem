import org.junit.*;
import static org.junit.Assert.*;

public class OptieTest {

    private Optie optie;

    @Before
    public void setUp() {
        optie = new Optie("GPS", "Global positioning system", 10.50, true, true, 10);
    }

    @Test
    public void testGetNaam() {
        assertEquals("GPS", optie.getNaam());
    }

    @Test
    public void testGetBeschrijving() {
        assertEquals("Global positioning system", optie.getBeschrijving());
    }

    @Test
    public void testGetKosten() {
        assertEquals(10.50, optie.getKosten(), 0.001);
    }

    @Test
    public void testGetEssentieel() {
        assertTrue(optie.getEssentieel());
    }

    @Test
    public void testGetMilieuVriendelijk() {
        assertTrue(optie.getMilieuVriendelijk());
    }

    @Test
    public void testGetMilieuKortingsPercentage() {
        assertEquals(10, optie.getMilieuKortingsPercentage());
    }

    @Test
    public void testSetNaam() {
        optie.setNaam("Wifi");
        assertEquals("Wifi", optie.getNaam());
    }

    @Test
    public void testSetBeschrijving() {
        optie.setBeschrijving("Wireless internet");
        assertEquals("Wireless internet", optie.getBeschrijving());
    }

    @Test
    public void testSetKosten() {
        optie.setKosten(8.99);
        assertEquals(8.99, optie.getKosten(), 0.001);
    }

    @Test
    public void testSetEssentieel() {
        optie.setEssentieel(false);
        assertFalse(optie.getEssentieel());
    }

    @Test
    public void testSetMilieuVriendelijk() {
        optie.setMilieuVriendelijk(false);
        assertFalse(optie.getMilieuVriendelijk());
    }

    @Test
    public void testSetMilieuKortingsPercentage() {
        optie.setMilieuKortingsPercentage(5);
        assertEquals(5, optie.getMilieuKortingsPercentage());
    }
}
