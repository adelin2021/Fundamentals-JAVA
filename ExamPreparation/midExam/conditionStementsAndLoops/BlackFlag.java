import java.util.Scanner;

public class BlackFlag {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int days = Integer.parseInt(scanner.nextLine());
        int dailyPlunder = Integer.parseInt(scanner.nextLine());
        int expectedPlunder = Integer.parseInt(scanner.nextLine());
        double sum = 0;
        for (int i = 1; i <= days; i++) {

            sum += dailyPlunder;
            if (i % 3 == 0) {
                sum += dailyPlunder  * 0.50;
            }
            if (i % 5 == 0) {
                sum *= 0.70;
            }
        }
        if (sum >= expectedPlunder) {
            System.out.printf("Ahoy! %.2f plunder gained.", sum);
        } else {
            System.out.printf("Collected only %.2f%% of the plunder.", (sum / expectedPlunder * 100));
        }
    }
}
