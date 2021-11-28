import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class MovingTarget {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> targets = Arrays.stream(scanner.nextLine()
                .split(" ")).map(Integer::parseInt).collect(Collectors.toList());
        String input = scanner.nextLine();
        while (!input.equals("End")) {
            String[] commands = input.split(" ");
            switch (commands[0]) {
                case "Shoot":
                    int index = Integer.parseInt(commands[1]);
                    int power = Integer.parseInt(commands[2]);
                    if (index < 0 || index > targets.size()) {
                        break;
                    } else {

                        targets.set(index, targets.get(index) - power);
                        if (targets.get(index) <= 0) {
                            targets.remove(index);
                        }
                    }
                    break;
                case "Add":
                    int indexToAdd = Integer.parseInt(commands[1]);
                    int powerToAdd = Integer.parseInt(commands[2]);
                    if (indexToAdd <= targets.size() - 1 && indexToAdd >= 0) {
                        targets.add(indexToAdd, powerToAdd);
                    } else {
                        System.out.println("Invalid placement!");
                    }
                    break;
                case "Strike":
                    int indexStrike = Integer.parseInt(commands[1]);
                    int radius = Integer.parseInt(commands[2]);
                    int start = indexStrike - radius;
                    int end = indexStrike + radius;
                    if (end <= targets.size() - 1 && start >= 0) {

                        while (start <= end) {
                            targets.remove(indexStrike - radius);
                            start++;
                        }

                    } else {
                        System.out.println("Strike missed!");
                        break;
                    }

                    break;
            }
            input = scanner.nextLine();
        }

        int last = targets.size() - 1;
        for (int i = 0; i <= targets.size() - 2; i++) {
            System.out.print(targets.get(i) + "|");
        }
        System.out.print(targets.get(last));

    }
}

