import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FancyBarcodes {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        while (n-- > 0) {
            String input = scanner.nextLine();
            String regex = "([@][#]+)(?<validBarcode>[A-Z][A-Za-z0-9]{4,}[A-Z])([@][#]+)";
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(input);
            if (matcher.find()) {
                String concatDigits = "";
                int count = 0;
                for (int i = 0; i < matcher.group("validBarcode").length(); i++) {

                    char isDigitOr = matcher.group("validBarcode").charAt(i);
                    if (Character.isDigit(isDigitOr)) {
                        concatDigits += isDigitOr;
                        count++;
                    }
                }
                if (count == 0) {
                    System.out.println("Product group: 00");
                } else {
                    System.out.println("Product group: " + concatDigits);
                }
            } else {
                System.out.println("Invalid barcode");
            }
        }

    }
}
