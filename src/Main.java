public class Main {
    public static void main(String[] args) {
        ObjectStorage.klanttypes.add(new Klanttype("Basis", 0));
        Menu menu = new Menu();
        menu.start();
    }
}