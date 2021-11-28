import java.util.Scanner;

public class BonusScoringSystem {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int numStudents = Integer.parseInt(scanner.nextLine());
        int lectures = Integer.parseInt(scanner.nextLine());
        int bonuses = Integer.parseInt(scanner.nextLine());

        int highestLectures = 0;
        double highestBonus = 0;

        for (int i = 0; i < numStudents; i++) {
            int input = Integer.parseInt(scanner.nextLine());
            double bonus = Math.ceil(input*1. / lectures * (5 + bonuses));
            if (highestLectures <= input) {
                highestLectures = input;
            }
            if (highestBonus <= bonus) {
                highestBonus = bonus;
            }
        }

        System.out.printf("Max Bonus: %.0f.%n",highestBonus);
        System.out.printf("The student has attended %d lectures.",highestLectures);

    }
}

