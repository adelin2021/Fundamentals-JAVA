import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class addAstra {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String text = scanner.nextLine();
        String regex = "([|#])(?<name>[A-Za-z ]+)\\1(?<date>[0-9]{2}\\/[0-9]{2}\\/[0-9]{2})\\1(?<calories>[0-9]{1,5})\\1";
        List<String> info = new ArrayList<>();
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);

        int sumCalories = 0;
        while (matcher.find()) {
            String name = String.format("Item: %s, Best before: %s, Nutrition: %s", matcher.group("name"), matcher.group("date"), matcher.group("calories"));
            info.add(name);

            sumCalories += Integer.parseInt(matcher.group("calories"));
        }
        System.out.println("You have food to last you for: " + sumCalories / 2000 + " days!");
        info.forEach(System.out::println);
    }

}


