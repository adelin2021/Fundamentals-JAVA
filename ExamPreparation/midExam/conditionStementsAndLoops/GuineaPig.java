import java.util.Scanner;

public class GuineaPig {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        double food = Double.parseDouble(scanner.nextLine()) * 1000;
        double hay = Double.parseDouble(scanner.nextLine()) * 1000;
        double cover = Double.parseDouble(scanner.nextLine()) * 1000;
        double weight = Double.parseDouble(scanner.nextLine()) * 1000;

        double puppyFood = 300;
        double puppyCoverCollect = 0;
        double coverLosses = cover;
        for (int i = 1; i <= 30; i++) {
            food -= puppyFood;

            if (i % 2 == 0) {
                double hayPerDay = food * 0.5 / 10;
                hay -= hayPerDay;

            } else if (i % 3 == 0) {

                cover -= weight / 3;
                puppyCoverCollect += weight / 3;
            }
        }

        if (food > 0 && hay > 0 && cover > 0) {
            double totalCover = cover - puppyCoverCollect;
            System.out.printf("Everything is fine! Puppy is happy! Food: %.2f, Hay: %.2f, Cover: %.2f.", food / 1000, hay / 1000, totalCover / 1000);
        } else {
            System.out.println("Merry must go to the pet store!");
        }
    }
}
