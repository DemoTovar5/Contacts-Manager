import java.util.Scanner;

public class Input {
    private Scanner scanner;
//            = new Scanner(System.in);

    public Input() {
        this.scanner = new Scanner(System.in);
    }

    public String getString() {
        return this.scanner.nextLine();
    }


    public String getString(String prompt) {
        System.out.println(prompt);
        return this.scanner.nextLine();
    }

    public boolean yesNo() {
        String userInput = this.scanner.nextLine();
        return userInput.trim().equalsIgnoreCase("y") || userInput.trim().equalsIgnoreCase("yes");
    }


    public long getInt(String prompt){
        long number;
        try {
            number = Long.valueOf(getString(prompt));
            return number;
        } catch (NumberFormatException nfe){
            System.out.println("Wrong input, try again: ");
            return getInt(prompt);
        }
    }

    public int getInt(int min, int max) {
        System.out.printf("Give me a whole number between %d and %d", min, max);
        int userNumber = this.scanner.nextInt();

        if(userNumber >= min && userNumber <= max) {
            return userNumber;
        } else {
            System.out.println("That number is invalid.");
            return getInt(min, max);
        }
    }


    public int getInt(String prompt, int min, int max) {
        System.out.println(prompt);
        int userNumber = this.scanner.nextInt();

        if(userNumber >= min && userNumber <= max) {
            return userNumber;
        } else {
            System.out.println("That number is invalid.");
            return getInt(min, max);
        }
    }


}