import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class KlantTest {

    @Test
    public void testGetNaam() {
        Klant klant = new Klant("John Doe", "johndoe@example.com", "1234567890", new Klanttype("Type A", 10));
        assertEquals("John Doe", klant.getNaam());
    }

    @Test
    public void testGetEmail() {
        Klant klant = new Klant("John Doe", "johndoe@example.com", "1234567890", new Klanttype("Type A", 10));
        assertEquals("johndoe@example.com", klant.getEmail());
    }

    @Test
    public void testGetTelefoonnummer() {
        Klant klant = new Klant("John Doe", "johndoe@example.com", "1234567890", new Klanttype("Type A", 10));
        assertEquals("1234567890", klant.getTelefoonnummer());
    }

    @Test
    public void testGetContactPersoon() {
        Persoon persoon = new Persoon("Jane", "Doe", "08-05-2005", "janedoe@example.com", "0987654321");
        Klant klant = new Klant(persoon, new Klanttype("Type A", 10));
        assertEquals(persoon, klant.getContactPersoon());
    }

    @Test
    public void testGetKlanttype() {
        Klanttype klanttype = new Klanttype("Type A", 10);
        Klant klant = new Klant("John Doe", "johndoe@example.com", "1234567890", klanttype);
        assertEquals(klanttype, klant.getKlanttype());
    }

    @Test
    public void testSetNaam() {
        Klant klant = new Klant("John Doe", "johndoe@example.com", "1234567890", new Klanttype("Type A", 10));
        klant.setNaam("Jane Doe");
        assertEquals("Jane Doe", klant.getNaam());
    }
}