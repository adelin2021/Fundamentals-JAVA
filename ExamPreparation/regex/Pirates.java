import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Pirates {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        Map<String, int[]> piratesHistory = new LinkedHashMap<>();

        while (!input.equals("Sail")) {
            String[] info = input.split("\\|\\|");
            String cityName = info[0];
            int population = info[1];
            int gold = info[2];
            if (!piratesHistory.containsKey(cityName)) {
                piratesHistory.putIfAbsent(cityName, new int[2]);
                piratesHistory.get(cityName)[0] = population;
                piratesHistory.get(cityName)[1] = gold;
            } else {
                piratesHistory.get(cityName)[0] += population;
                piratesHistory.get(cityName)[1] += gold;
            }


            input = scanner.nextLine();
        }
    }
}
