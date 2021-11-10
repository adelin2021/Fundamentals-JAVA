import java.util.Scanner;

public class TheImItationGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder decodedMessage = new StringBuilder(scanner.nextLine());
        String instructions = scanner.nextLine();
        while (!instructions.equals("Decode")) {
            String[] commands = instructions.split("\\|");
            switch (commands[0]) {
                case "Move":
                    int indexToMove = Integer.parseInt(commands[1]);
                    String takeFirstIndex = decodedMessage.substring(0,indexToMove);
                    decodedMessage.delete(0,indexToMove);
                    decodedMessage.append(takeFirstIndex);
                    break;
                case "Insert":
                    int index = Integer.parseInt(commands[1]);
                    String value =commands[2];
                    decodedMessage.insert(index,value);
                    break;
                case "ChangeAll":
                    String substring = commands[1];
                    String replaceAll = commands[2];
                    decodedMessage = new StringBuilder(decodedMessage.toString().replace(substring,replaceAll));
                    break;

            }
            instructions = scanner.nextLine();
        }
        System.out.println("The decrypted message is: "+decodedMessage);
    }

}

