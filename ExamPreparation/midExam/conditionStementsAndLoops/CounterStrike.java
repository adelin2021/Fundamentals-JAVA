import java.util.Scanner;

public class CounterStrike {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int firstPerOurs = Integer.parseInt(scanner.nextLine());
        int secondPerOurs = Integer.parseInt(scanner.nextLine());
        int thirdPerOurs = Integer.parseInt(scanner.nextLine());

        int ollStudents = Integer.parseInt(scanner.nextLine());

        int studentsPerOur = firstPerOurs + secondPerOurs + thirdPerOurs;

        int sum = ollStudents / studentsPerOur;

        if (ollStudents % studentsPerOur != 0) {
            sum++;
        }
        for (int i = 1; i <= sum; i++) {
            if (i % 4 == 0) {
                sum += 1;
            }

        }

        System.out.printf("Time needed: %dh.%n", sum);
    }
}

