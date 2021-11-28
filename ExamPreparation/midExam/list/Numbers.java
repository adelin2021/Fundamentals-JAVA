import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Numbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt).collect(Collectors.toList());

        double sum = numbers.stream().mapToInt(Integer::intValue).sum();
        sum /= numbers.size() * 1.0;
        for (int n = numbers.size() - 1; n > -1; n--) {

            if (numbers.size() <=1) {
                System.out.println("No");
                return;
            }
            if (numbers.get(n) <= sum) {
                numbers.remove(n);

            }
        }
        Collections.sort(numbers);
        Collections.reverse(numbers);

        for (int i = 0; i < numbers.size(); i++) {
            if(i==5){
                return;
            }
            System.out.print(numbers.get(i) + " ");

        }
    }
}
