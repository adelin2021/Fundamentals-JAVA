import java.util.Arrays;
import java.util.Scanner;

public class HeartDelivery {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] neighborhood = Arrays.stream(scanner.nextLine()
                .split("@")).mapToInt(Integer::parseInt).toArray();
        String input = scanner.nextLine();

        int lastIndex = 0;
        while (!input.equals("Love!")) {

            int length = Integer.parseInt(input.split("\\s+")[1]);
            lastIndex += length;
            if (lastIndex >= neighborhood.length) {

                lastIndex = 0;
            }

            if (neighborhood[lastIndex] <= 0) {
                System.out.printf("Place %d already had Valentine's day.%n", lastIndex);

            } else {
                neighborhood[lastIndex] = neighborhood[lastIndex] - 2;
                if (neighborhood[lastIndex] <= 0) {
                    System.out.printf("Place %d has Valentine's day.%n", lastIndex);

                }
            }
            input = scanner.nextLine();
        }
        int failCounter = 0;
        for (int i = 0; i <= neighborhood.length - 1; i++) {
            if (neighborhood[i] != 0) {
                failCounter++;

            }
        }

        System.out.printf("Cupid's last position was %d.%n", lastIndex);
        if (failCounter > 0) {
            System.out.printf("Cupid has failed %d places.", failCounter);
        } else {
            System.out.println("Mission was successful.");

        }
    }
}

