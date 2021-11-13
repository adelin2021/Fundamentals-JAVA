import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MirrorWords {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        String regex = "([#,@])(?<first>[A-Za-z]{3,})\\1\\1(?<second>[A-Za-z]{3,})\\1";

        List<String> mirrorWords = new ArrayList<>();

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);
        int count = 0;
        while (matcher.find()) {
            count++;

            if (matcher.group("first").equals(new StringBuilder(matcher.group("second")).reverse().toString())) {
                mirrorWords.add(String.format("%s <=> %s", matcher.group("first"), matcher.group("second")));
            }
        }


        final String msg1 = count > 0
                ? count+" word pairs found!"
                : "No word pairs found!";
            System.out.println(msg1);

        final String msg2 = mirrorWords.isEmpty()
                ? "No mirror words!"
                :  "The mirror words are:";
        System.out.println(msg2);
        System.out.print(String.join(", ", mirrorWords));


    }
}

