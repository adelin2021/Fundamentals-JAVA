import java.util.Scanner;

public class PasswordReset {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        StringBuilder passwordReset = new StringBuilder(scanner.nextLine());
        String input = scanner.nextLine();
        while (!input.equals("Done")) {
            String[] commands = input.split("\\s+");
            switch (commands[0]) {
                case "TakeOdd":
                    StringBuilder newPassword = new StringBuilder();
                    for (int i = 0; i < passwordReset.length(); i++) {
                        if (i % 2 != 0) {
                            newPassword.append(passwordReset.charAt(i));
                        }
                    }
                    passwordReset = newPassword;
                    System.out.println(passwordReset);
                    break;
                case "Cut":
                    int index = Integer.parseInt(commands[1]);
                    int length = Integer.parseInt(commands[2]);
                    if (index + length >= 0 && index + length <= passwordReset.length()) {
                        passwordReset.delete(index, index + length);

                    }
                    System.out.println(passwordReset);
                    break;
                case "Substitute":
                    String subStr = commands[1];
                    String substitute = commands[2];
                    if (passwordReset.toString().contains(subStr)) {
                        passwordReset = new StringBuilder(passwordReset.toString()
                                .replace(subStr, substitute));

                    } else {
                        System.out.println("Nothing to replace!");
                        break;
                    }
                    System.out.println(passwordReset);
            }

                    input = scanner.nextLine();
            }

        System.out.println("Your password is: " + passwordReset);
    }
}



