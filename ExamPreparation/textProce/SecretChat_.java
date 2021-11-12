import java.util.Scanner;

public class SecretChat_ {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder messege = new StringBuilder(scanner.nextLine());
        String input = scanner.nextLine();
        while (!input.equals("Reveal")) {
            String[] command = input.split(":\\|:");
            switch (command[0]) {
                case "InsertSpace":
                    int index = Integer.parseInt(command[1]);
                    messege.insert(index," ");
                    System.out.println(messege);
                    break;
                case "Reverse":
                    if (messege.toString().contains(command[1])) {
                   messege = new StringBuilder(messege.toString()
                           .replace(command[1],new StringBuilder(command[1]).reverse().toString()));

                        System.out.println(messege);
                    } else {
                        System.out.println("error");
                    }
                    break;
                case "ChangeAll":
                    messege = new StringBuilder(messege.toString()
                            .replace(command[1], command[2]));
                    System.out.println(messege);
                    break;

            }
            input = scanner.nextLine();
        }
        System.out.println("You have a new text message: " + messege);
    }
}