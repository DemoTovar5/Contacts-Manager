import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.*;

@SuppressWarnings("all")
public class Main extends Input {

    //   Method to display contacts in the terminal
    public static void viewContacts() {
        Path toOurDataPlace = Paths.get("src/content");
        Path toOurDataFile = Paths.get(String.valueOf(toOurDataPlace), "contacts.txt");
        List<String> currentList = new ArrayList<>();
        try {
//    Reads each line on our contacts.txt file
            currentList = Files.readAllLines(toOurDataFile);
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
//    Loop to print out each contact line
        for (String line : currentList) {
            System.out.println(line);
        }
    }


    //    Method to add contact name and number to contacts list
    public static void addContact(Input in) {
        Path toOurDataPlace = Paths.get("src/content");
        Path toOurDataFile = Paths.get(String.valueOf(toOurDataPlace), "contacts.txt");
        List<String> Contacts = new ArrayList<>();
//    Accepts user entered name and number
        String name = in.getString("Please enter the name of the Person:");
        long phoneNumber = in.getInt("Please enter Phone Number:");
        long i = phoneNumber;
//    Formats the phone number to include dashes
        String s = Long.toString(i).replaceFirst("(\\d{3})(\\d{3})(\\d+)", "($1)-$2-$3");
//    Formats each contact so they all line up
        String format = "| %1$-17s| %2$-17s|";
        String ex[] = {name, s};
        String newContact = format(String.format(format, (Object[]) ex));
//    Adds new contact to Contacts ArrayList
        Contacts.add(newContact);
        try {
//    Adds our newly created contact to our contacts.txt file
            Files.write(toOurDataFile, Contacts, StandardOpenOption.APPEND);
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

    //    Creates format method to enable formatting newContact
    private static String format(String format) {
        return format;
    }

    //    Method to delete selected contact
    public static void deleteContact(Input in) {
        Path toOurDataPlace = Paths.get("src/content");
        Path toOurDataFile = Paths.get(String.valueOf(toOurDataPlace), "contacts.txt");
//    Accepts user input to select which contact to delete. Works by entering either first, or first and last name
        String name = in.getString("What Contact would you like to delete?");
        List<String> currentList = new ArrayList<>();
        try {
            currentList = Files.readAllLines(toOurDataFile);
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
//    Iterates through each list. Deletes item if it matches
        Iterator<String> listIterator = currentList.iterator();
        while (listIterator.hasNext()) {
            String contact = listIterator.next();
            if (contact.contains(name)) {
                listIterator.remove();
            }
        }
        try {
            Files.write(toOurDataFile, currentList);
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }


    //   Method that allows user to search by name and displays name and number
    public static void searchByName(Input in) {
        Path toOurDataPlace = Paths.get("src/content");
        Path toOurDataFile = Paths.get(String.valueOf(toOurDataPlace), "contacts.txt");
        String name = in.getString("What Contact would you like view?");
        List<String> currentList = new ArrayList<>();
        try {
            currentList = Files.readAllLines(toOurDataFile);
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
//    Iterates through each list in file and compares user input to contents. Displays item if it matches
        Iterator<String> listIterator = currentList.iterator();
        while (listIterator.hasNext()) {
            String iterate = listIterator.next();
            if (iterate.contains(name)) {
                System.out.println(iterate);
            }
        }
    }


    //    Main method that displays menu and calls methods depending on user input
    public static void runApp(Input input) {
        System.out.println("Main Menu");
        boolean run = true;
        while (run) {
            System.out.println("   ~ Contact List ~");
            System.out.println("+-------------------------+");
            System.out.println(" 1. Lists contacts");
            System.out.println(" 2. Add contacts");
            System.out.println(" 3. Search contacts");
            System.out.println(" 4. Delete contacts");
            System.out.println(" 5. Exit");
            System.out.println("+-------------------------+");
            int userResp = input.getInt("Please enter a number.", 1, 5);
            input.getString();
            switch (userResp) {
                case 1:
                    viewContacts();
                    System.out.println();
                    break;
                case 2:
                    addContact(input);
                    System.out.println();
                    break;
                case 3:
                    searchByName(input);
                    System.out.println();
                    break;
                case 4:
                    deleteContact(input);
                    System.out.println();
                    break;
                default:
                    System.out.println("Are you sure you want to exit?");
                    if (input.yesNo()) {
                        System.out.println("Goodbye");
                        run = false;
                    } else {
                        System.out.println();
                    }
            }
        }

    }

    public static void main(String[] args) {
        runApp(new Input());
    }

}