import java.util.Scanner;

public class SafeInput {

    static Scanner in = new Scanner(System.in);


    public static String getNonZeroLenStrings(Scanner pipe, String prompt) {
        String retString = "";
        do {
            System.out.print("\n" + prompt + ": ");
            retString = pipe.nextLine();
        } while (retString.length() == 0);

        return retString;
    }

    public static int getInt(Scanner pipe, String prompt) {

        int randomInt = 0;

        while (true) {

            System.out.print(prompt + ": ");

            if (pipe.hasNextInt()) {

                randomInt = pipe.nextInt();
                pipe.nextLine();
                return randomInt;

            } else {

                System.out.println("Please enter an integer");
                pipe.nextLine();

            }

        }

    }

    public static double getDouble(Scanner pipe, String prompt) {
        double randomDouble;

        while (true) {

            System.out.print(prompt + ": ");

            if (pipe.hasNextDouble()) {

                randomDouble = pipe.nextDouble();
                pipe.nextLine();
                return randomDouble;

            } else {

                System.out.println("Please enter a number");
                pipe.nextLine();
            }

        }
    }

    public static int getRangedInt(Scanner pipe, String prompt, int low, int high) {
        int rangedInt;

        while (true) {

            System.out.print(prompt + " [" + low + " - " + high + "]: ");
            if (pipe.hasNextInt()) {

                rangedInt = pipe.nextInt();

                if (rangedInt >= low && rangedInt <= high) {
                    break;

                } else {

                    System.out.println("Please enter a number inbetween " + low + " and " + high + ".");
                }

            } else {

                System.out.println("Invalid input. Please enter an integer.");
                pipe.next();

            }

            pipe.nextLine();

        }
        return rangedInt;

    }

    public static double getRangedDouble(Scanner pipe, String prompt, double low, double high){
        double rangedDouble;

        while (true){

            System.out.print(prompt + " [" + low + " - " + high + "]: ");

            if (pipe.hasNextDouble()){

                rangedDouble = pipe.nextDouble();

                if (rangedDouble >= low && rangedDouble <= high){
                    break;

                } else {

                    System.out.println("Please enter a number inbetween " + low + " and " + high + ".");
                }

            } else {

                System.out.println("Invalid input. Please enter a number inbetween " + low + " and " + high + ".");
                pipe.next();

            }

            pipe.nextLine();

        }

        return rangedDouble;

    }



    public static boolean getYNConfirm(Scanner pipe, String prompt) {
        String answer = "";
        pipe.nextLine();

        while (true){

            System.out.print(prompt);
            answer = pipe.nextLine();

            if (answer.equalsIgnoreCase("y")){

                return true;
            } else if (answer.equalsIgnoreCase("n")) {

                return false;

            } else {

                System.out.println("Please enter either Y or N");
            }
        }
    }


    public static String getRegExString(Scanner pipe, String prompt, String regEx){
        String input;

        do {

            System.out.print(prompt);
            input = pipe.nextLine().trim();

            if (!input.matches(regEx)) {

                System.out.println("Invalid input. Please try again.");

            }

        } while (!input.matches(regEx));

        return input;
    }


    public static String prettyHeader(String msg){
        final int totalWidth = 60;
        final int borderWidth = 3;
        StringBuilder header = new StringBuilder();

        String borderLine = "*".repeat(totalWidth) + "\n";

        header.append(borderLine);

        int messageWidth = msg.length();
        int totalPadding = totalWidth - (borderWidth * 2) - messageWidth;
        int paddingSide = totalPadding / 2;

        header.append("*".repeat(borderWidth));
        header.append(" ".repeat(paddingSide));
        header.append(msg);
        header.append(" ".repeat(totalPadding - paddingSide));
        header.append("*".repeat(borderWidth));
        header.append("\n");
        header.append(borderLine);

        return header.toString();
    }


}