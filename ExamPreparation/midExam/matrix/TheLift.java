import java.util.Arrays;
import java.util.Scanner;

public class TheLift {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int allPeople = Integer.parseInt(scanner.nextLine());
        int[] lift = Arrays.stream(scanner.nextLine()
                .split(" ")).mapToInt(Integer::parseInt).toArray();
        for (int i = 0; i <= lift.length - 1; i++) {

            while (allPeople > 0) {
                if (lift[i] < 4) {
                    lift[i] += 1;
                    allPeople--;
                } else {
                    break;
                }
            }
        }

        if (allPeople==0 && lift[lift.length-1] <4) {
            System.out.println("The lift has empty spots!");
        } else if (allPeople>0) {
            System.out.printf("There isn't enough space! %d people in a allPeople!%n", allPeople);

        }
        for (int i : lift) {
            System.out.print(i + " ");
        }
    }
}

