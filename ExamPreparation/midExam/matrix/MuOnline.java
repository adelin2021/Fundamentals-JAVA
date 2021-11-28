import java.util.Scanner;

public class MuOnline {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] dungeonsRooms = scanner.nextLine().split("\\|");
        int health = 100;
        int bitcoins = 0;
        int theBestRoom = 0;
        for (int i = 0; i < dungeonsRooms.length; i++) {
            String[] commands = dungeonsRooms[i].split(" ");


            switch (commands[0]) {
                case "potion":
                    int extraHealt = Integer.parseInt(commands[1]);
                    if (health + extraHealt > 100) {

                        System.out.printf("You healed for %d hp.%n", 100-health);
                        health=100;
                        System.out.printf("Current health: %d hp.%n", health);
                    } else {
                        health += extraHealt;
                        System.out.printf("You healed for %d hp.%n", extraHealt);
                        System.out.printf("Current health: %d hp.%n", health);
                    }
                    break;
                case "chest":
                    int extraBitcouns = Integer.parseInt(commands[1]);
                    bitcoins += extraBitcouns;
                    System.out.printf("You found %d bitcoins.%n", extraBitcouns);
                    break;
                default:
                    String monster = commands[0];
                    int atackPower = Integer.parseInt(commands[1]);
                    if (health - atackPower <= 0) {
                        System.out.printf("You died! Killed by %s.%n", monster);
                        theBestRoom = i+1;
                        System.out.printf("Best room: %d%n", theBestRoom);
                        return;
                    } else {
                        health -= atackPower;
                        System.out.printf("You slayed %s.%n", monster);

                    }
                    break;
            }
        }

        System.out.printf("You've made it!%nBitcoins: %d%nHealth: %d", bitcoins, health);

    }
}


