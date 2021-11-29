import java.util.Locale;
import java.util.Scanner;

public class ActivationKeys {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder activationKeys = new StringBuilder(scanner.nextLine());

        String input = scanner.nextLine();

        while (!input.equals("Generate")) {
            String[] commands = input.split(">>>");
            switch (commands[0]) {
                case "Contains":
                    String sub = commands[1];
                    if (activationKeys.toString().contains(sub)) {

                        System.out.println("" + activationKeys + " contains " + sub + "");
                    } else {
                        System.out.println("Substring not found!");
                    }
                    break;
                case "Flip":
                    String upOrLower = commands[1];
                    int startIndex = Integer.parseInt(commands[2]);
                    int endIndex = Integer.parseInt(commands[3]);

                    String subReplays = activationKeys.substring(startIndex,endIndex);

                    if (upOrLower.equals("Upper")) {

                        activationKeys =new StringBuilder(activationKeys.toString()
                                .replaceAll(subReplays,subReplays.toUpperCase(Locale.ROOT)));
                    } else {
                        activationKeys =new StringBuilder(activationKeys.toString()
                                .replaceAll(subReplays,subReplays.toLowerCase(Locale.ROOT)));
                    }
                    System.out.println(activationKeys);
                    break;
                case "Slice":
                    int start =Integer.parseInt(commands[1]);
                    int end =Integer.parseInt(commands[2]);
                    if(start>=0 && start<=activationKeys.length() && end>=0 && end <=activationKeys.length()) {
                        activationKeys.delete(start, end);
                    System.out.println(activationKeys);
                    }
                    break;

            }


            input = scanner.nextLine();
        }
        System.out.println("Your activation key is: " + activationKeys + "");
    }
}
