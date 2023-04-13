import java.util.Scanner;
public abstract class Vragen {
    public static Scanner scanner = new Scanner(System.in);
    public static boolean vraagJaNee(String vraag){
        boolean klaar = false;
        String input;
        boolean antwoord = false;
        while (!klaar){
            System.out.println(vraag);
            input = scanner.nextLine();
            if (input.equals("Ja") || input.equals("ja")){
                antwoord = true;
                klaar = true;
            } else if (input.equals("Nee") || input.equals("nee")) {
                antwoord = false;
                klaar = true;
            }
            else{
                System.out.println("Antwoord alleen met ja of met nee aub.");
            }
        }
        return antwoord;
    }

    public static int vraagInt(String vraag){
        boolean klaar = false;
        int antwoord = 0;
        while (!klaar){
            System.out.println(vraag);
            if (scanner.hasNextInt()) {
                antwoord = scanner.nextInt();
                klaar = true;
            }
            else{
                System.out.println("Geef een geheel getal aub.");
            }
            scanner.nextLine();
        }
        return antwoord;
    }

    public static double vraagDouble(String vraag){
        boolean klaar = false;
        double antwoord = 0;
        while (!klaar){
            System.out.println(vraag);
            if (scanner.hasNextDouble()) {
                antwoord = scanner.nextDouble();
                klaar = true;
            }
            else{
                System.out.println("Geef een (komma)getal aub.");
            }
            scanner.nextLine();
        }
        return antwoord;
    }

    public static String vraagString(String vraag){
        System.out.println(vraag);
        String antwoord = scanner.nextLine();
        return antwoord;
    }
}
