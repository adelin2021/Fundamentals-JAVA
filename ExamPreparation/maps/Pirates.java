import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Pirates {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        Map<String, int[]> piratesPlunders = new LinkedHashMap<>();

        while (!input.equals("Sail")) {
            String[] info = input.split("\\|\\|");
            String cityName = info[0];
            int population = Integer.parseInt(info[1]);
            int gold = Integer.parseInt(info[2]);
            if (!piratesPlunders.containsKey(cityName)) {
                piratesPlunders.putIfAbsent(cityName, new int[2]);
                piratesPlunders.get(cityName)[0] = population;
                piratesPlunders.get(cityName)[1] = gold;
            } else {
                piratesPlunders.get(cityName)[0] += population;
                piratesPlunders.get(cityName)[1] += gold;
            }

            input = scanner.nextLine();
        }
        String input2 = scanner.nextLine();
        while (!input2.equals("End")) {
            String[] commands = input2.split("=>");
            String town = commands[1];
            switch (commands[0]) {
                case "Plunder":
                    int people = Integer.parseInt(commands[2]);
                    int gold = Integer.parseInt(commands[3]);

                    piratesPlunders.get(town)[0] -= people;
                    piratesPlunders.get(town)[1] -= gold;

                    System.out.println(town + " plundered! " + gold + "" +
                            " gold stolen, " + people +
                            " citizens killed.");

                    if (piratesPlunders.get(town)[0] <= 0 || piratesPlunders.get(town)[1]<=0) {
                        System.out.println("" + town + " has been wiped off the map!");
                        piratesPlunders.remove(town);

                    }

                    break;
                case "Prosper":
                    int prosperGold = Integer.parseInt(commands[2]);
                    if (prosperGold <= 0) {
                        System.out.println("Gold added cannot be a negative number!");
                    } else {
                        piratesPlunders.get(town)[1] += prosperGold;
                        System.out.println(prosperGold + " gold added to the city treasury." +
                                " " + town + " now has " + piratesPlunders.get(town)[1] + " gold.");
                    }
                    break;

            }

            input2 = scanner.nextLine();
        }
        if (piratesPlunders.isEmpty()) {
            System.out.println("Ahoy, Captain! All targets have been plundered and destroyed!");
        } else {
            System.out.println("Ahoy, Captain! There are " + piratesPlunders.size() + " wealthy settlements to go to:");
            piratesPlunders.entrySet().stream().sorted((a, b) -> {
                int result = Integer.compare(b.getValue()[1], a.getValue()[1]);
                if (result == 0) {
                    result = a.getKey().compareTo(b.getKey());
                }
                return result;

            }).forEach(e -> System.out.println(e.getKey() + " -> Population:"
                    + "" + " " + e.getValue()[0] + " citizens," +
                    " Gold: " + e.getValue()[1] + " kg"));
        }
    }
}
