import java.util.*;

public class HeroesOfCodeAndLogicVII {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        Map<String, int[]> myHeroes = new HashMap<>();
        for (int i = 0; i < n; i++) {
            String[] heroes = scanner.nextLine().split("\\s+");

            myHeroes.putIfAbsent(heroes[0], new int[2]);
            myHeroes.get(heroes[0])[0] += Integer.parseInt(heroes[1]);
            myHeroes.get(heroes[0])[1] += Integer.parseInt(heroes[2]);
        }
        String input = scanner.nextLine();

        while (!input.equals("End")) {
            String[] commands = input.split(" - ");
            String name = commands[1];
            int amount = Integer.parseInt(commands[2]);
            switch (commands[0]) {
                case "CastSpell":
                    String spellName = commands[3];
                    if (myHeroes.get(name)[1] - amount >= 0) {
                        myHeroes.get(name)[1] -= amount;
                        System.out.printf("%s has successfully cast %s and now has %d MP!%n", name, spellName, myHeroes.get(name)[1]);
                    } else {
                        System.out.printf("%s does not have enough MP to cast %s!%n", name, spellName);
                    }
                    break;
                case "TakeDamage":
                    String attacker = commands[3];
                    myHeroes.get(name)[0] -= amount;
                    if (myHeroes.get(name)[0] > 0) {
                        System.out.printf("%s was hit for %d HP by %s and now has %d HP left!%n", name, amount, attacker, myHeroes.get(name)[0]);
                    } else {
                        myHeroes.remove(name);
                        System.out.printf("%s has been killed by %s!%n", name, attacker);
                    }
                    break;
                case "Recharge":
                    int value = myHeroes.get(name)[1];
                    myHeroes.get(name)[1] += amount;
                    if (myHeroes.get(name)[1] > 200) {
                        myHeroes.get(name)[1] = 200;
                    }

                    System.out.printf("%s recharged for %d MP!%n", name, myHeroes.get(name)[1] - value);
                    break;
                case "Heal":

                    int currentValue = myHeroes.get(name)[0];
                    myHeroes.get(name)[0] += amount;
                    if (myHeroes.get(name)[0] > 100) {
                        myHeroes.get(name)[0] = 100;
                    }

                    System.out.printf("%s healed for %d HP!%n", name, myHeroes.get(name)[0] - currentValue);
                    break;

            }
            input = scanner.nextLine();

        }
        myHeroes.entrySet().stream().sorted((a, b) -> {
            int result = Integer.compare(b.getValue()[0], a.getValue()[0]);
            if (result == 0) {
                result = a.getKey().compareTo(b.getKey());
            }
            return result;
        }).forEach(e -> System.out.printf("%s%n  HP: %d%n  MP: %d%n",
                e.getKey(), e.getValue()[0], e.getValue()[1]));
    }
}

