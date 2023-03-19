import java.util.ArrayList;
import java.util.List;
public class Main {
    public static void main(String[] args) {
        ObjectStorage.klanttypes.add(new Klanttype("Particulier", 0));
        ObjectStorage.personen.add(new Persoon("John", "Smith", "Oktober", "John@Email.com", "555"));
        ObjectStorage.klanten.add(new Klant(ObjectStorage.personen.get(0), ObjectStorage.klanttypes.get(0)));

        ObjectStorage.addKlant();

        System.out.println(ObjectStorage.klanten.get(ObjectStorage.klanten.size()-1).getNaam());
    }
}