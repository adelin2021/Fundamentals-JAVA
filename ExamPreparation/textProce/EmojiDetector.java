import java.util.ArrayDeque;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmojiDetector {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String text = scanner.nextLine();

        int coolThresholdSum = 1;
        String numbers = "\\d";

        ArrayDeque<String> coolOne = new ArrayDeque<>();

        Pattern numPattern = Pattern.compile(numbers);
        Matcher numMatcher = numPattern.matcher(text);
        int countAllEmojis = 0;
        while (numMatcher.find()) {
            int value = Integer.parseInt(numMatcher.group());
            coolThresholdSum *= value;
        }
        System.out.println("Cool threshold: " + coolThresholdSum + "");

        String regex = "(?<separator>[\\\\*:])\\1(?<emoji>[A-Z][a-z]{2,})\\1\\1";
            Pattern emojiPattern = Pattern.compile(regex);
            Matcher emojiMatcher = emojiPattern.matcher(text);

            while (emojiMatcher.find()) {
                countAllEmojis++;

                String toCoolOne =emojiMatcher.group("emoji");
                int accountAsciiValue = 0;

                for (int i = 0; i < toCoolOne.length() ; i++) {
                    char asciiValue = emojiMatcher.group("emoji").charAt(i);

                    accountAsciiValue += asciiValue;
                }

                if (accountAsciiValue >= coolThresholdSum) {
                    coolOne.offer(emojiMatcher.group());
                }
            }

        System.out.println("" + countAllEmojis + " emojis found in the text. The cool ones are:");
        while (!coolOne.isEmpty()) {
            System.out.println(coolOne.poll());
        }
    }
}


