import java.util.Arrays;
import java.util.Scanner;

public class ArrayModifier {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int[] numbers = Arrays.stream(scanner.nextLine()
                .split(" ")).mapToInt(Integer::parseInt).toArray();
        String input = scanner.nextLine();

        while (!input.equals("end")) {
            String[] commands = input.split(" ");
            switch (commands[0]) {
                case "swap":
                    int index1 = Integer.parseInt(commands[1]);
                    int index2 = Integer.parseInt(commands[2]);
                    int first = numbers[index1];
                    int second = numbers[index2];
                    if (index1 >= 0 && index1 <= numbers.length - 1 && index2 >= 0 && index2 <= numbers.length - 1)
                        numbers[index1] = second;
                    numbers[index2] = first;

                    break;
                case "multiply":
                    int firstIndex = Integer.parseInt(commands[1]);
                    int secondIndex = Integer.parseInt(commands[2]);

                    if (firstIndex >= 0 && firstIndex <= numbers.length - 1) ;
                    numbers[firstIndex] = numbers[firstIndex] * numbers[secondIndex];


                    break;
                case "decrease":
                    for (int i = 0; i <= numbers.length - 1; i++) {
                        numbers[i] -= 1;
                    }
                    break;


            }
            input = scanner.nextLine();
        }

        String print = Arrays.toString(numbers).replaceAll("[\\[\\],]", "").trim();
        print = print.replaceAll("\\s+", ", ");
        System.out.print(print);
    }
}

