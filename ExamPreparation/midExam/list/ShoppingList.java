import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ShoppingList {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> shopingList = Arrays.stream(scanner.nextLine()
                .split("!")).collect(Collectors.toList());
        String input = scanner.nextLine();
        while (!input.equals("Go Shopping!")) {
            String[] commands = input.split(" ");
            switch (commands[0]) {
                case "Urgent":
                    String item = commands[1];
                    if (!shopingList.contains(item)) {
                        shopingList.add(0,item);
                    }
                    break;
                case "Unnecessary":
                    String unnecessaryItem = commands[1];
                    if (shopingList.contains(unnecessaryItem)) {
                        shopingList.remove(shopingList.indexOf(unnecessaryItem));
                    }
                    break;
                case "Correct":
                    String oldItem = commands[1];
                    String newItem = commands[2];
                    if (shopingList.contains(oldItem)) {
                        shopingList.set(shopingList.indexOf(oldItem), newItem);
                    }
                    break;
                case "Rearrange":
                    String rearrangeItem = commands[1];
                    if (shopingList.contains(rearrangeItem)) {
                        shopingList.remove(rearrangeItem);
                        shopingList.add(rearrangeItem);
                    }

                    break;

            }
            input = scanner.nextLine();
        }
        System.out.println(String.join(", ", shopingList));
    }
}

