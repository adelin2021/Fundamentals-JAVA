import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Inventory {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> items = Arrays.stream(scanner.nextLine()
                .split(", ")).collect(Collectors.toList());

        String input = scanner.nextLine();
        while (!input.equals("Craft!")) {
            String[] commands = input.split(" ");
            switch (commands[0]) {
                case "Collect":
                    String item = commands[2];
                    if (!items.contains(item)) {
                        items.add(item);
                    } else {
                        break;

                    }
                    break;
                case "Drop":
                    String currentitem = commands[2];
                    if (items.contains(currentitem)) {
                        items.remove(currentitem);
                    }
                    break;
                case "Combine":
                    String[] combine = commands[3].split(":");
                    String oldItem = combine[0];
                    String newItem = combine[1];
                    if (items.contains(oldItem)) {
                        items.add(items.indexOf(oldItem) + 1, newItem);
                    }
                    break;
                case "Renew":
                    String renewItem = commands[2];
                    if (items.contains(renewItem)) {
                        items.remove(renewItem);
                        items.add(renewItem);
                    }
                    break;
            }
            input = scanner.nextLine();
        }

        System.out.println(String.join(", ", items));
    }
}

