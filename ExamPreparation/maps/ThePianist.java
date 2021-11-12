import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class ThePianist {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        Map<String, String[]> infoPieces = new TreeMap<>();

        for (int i = 0; i < n; i++) {
            String[] toMap = scanner.nextLine().split("\\|");
            String key = toMap[0];

            infoPieces.putIfAbsent(key, new String[2]);
            infoPieces.get(key)[0] = toMap[1];
            infoPieces.get(key)[1] = toMap[2];

        }
        String input = scanner.nextLine();

        while (!input.equals("Stop")) {
            String[] command = input.split("\\|");
            switch (command[0]) {
                case "Add":
                    if (infoPieces.containsKey(command[1])) {
                        System.out.println(command[1] + " is already in the collection!");
                    } else {
                        System.out.println(command[1] + " by " + command[2] + " in " + command[3] + " added to the collection!");
                        String newKey = command[1];
                        String[] newValue = new String[2];

                        infoPieces.putIfAbsent(newKey, newValue);
                        infoPieces.get(newKey)[0] = command[2];
                        infoPieces.get(newKey)[1] = command[3];
                    }
                    break;
                case "Remove":
                    if (infoPieces.containsKey(command[1])) {
                        infoPieces.remove(command[1]);
                        System.out.println("Successfully removed " + command[1] + "!");
                    } else {
                        System.out.println("Invalid operation! " + command[1] + " does not exist in the collection.");
                    }
                    break;
                case "ChangeKey":
                    if (infoPieces.containsKey(command[1])) {
                        infoPieces.get(command[1])[1]= command[2];
                        System.out.println("Changed the key of "+command[1]+" to "+command[2]+"!");
                    } else {
                        System.out.println("Invalid operation! " + command[1] + " does not exist in the collection.");
                    }
                    break;
            }

            input = scanner.nextLine();
        }
        infoPieces.forEach((key, value) -> System.out.printf(
                "%s -> Composer: %s, Key: %s%n", key, value[0], value[1]));
    }
}


