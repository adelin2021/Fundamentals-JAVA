import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double sum = 0;
        double taxes = 0;
        double total = 0;

        while (true) {
            String input = scanner.nextLine();

            if (input.equals("special")) {

                taxes = sum * 0.20;
                total = (sum + taxes) * 0.90;
                break;
            }
            if (input.equals("regular")) {
                taxes = sum * 0.20;
                total = sum + taxes;
                break;

            }
            double price = Double.parseDouble(input);
            if (price < 0) {
                System.out.println("Invalid price!");
            } else {
                sum += price;

            }
        }

        if (sum == 0) {
            System.out.println("Invalid order!");
            return;
        } else {
            System.out.printf("Congratulations you've just bought a new computer!\n" +
                    "        Price without taxes: %.2f$\n" +
                    "        Taxes: %.2f$%n", sum, taxes);
            System.out.println("-----------");
            System.out.printf("Total price: %.2f$%n", total);

        }
    }
}

