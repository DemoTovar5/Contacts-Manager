import java.util.NoSuchElementException;
import java.util.Scanner;

public class ContactsManagerApp {
    public static void main(String[] args)
    {
        final Scanner scanner = new Scanner(System.in);
        while (true) {

            System.out.println("   ~ Contact List ~");
            System.out.println("+-------------------------+");
            System.out.println(" 1. Lists contacts");
            System.out.println(" 2. Add contacts");
            System.out.println(" 3. Search contacts");
            System.out.println(" 4. Delete contacts");
            System.out.println(" 5. Exit");
            System.out.println("+-------------------------+");
            scanner.useDelimiter("\n");
           Integer choice = scanner.nextInt();


            if (choice <= 0 || choice > 5) {
                System.out.println("Invalid selection. ");

                List<String> currentList = new ArrayList<>();













            }
        }

    }





}


