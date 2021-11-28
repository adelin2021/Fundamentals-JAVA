import java.util.Arrays;
import java.util.Scanner;

public class ManOWar {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] pirateShip = Arrays.stream(scanner.nextLine()
                .split(">")).mapToInt(Integer::parseInt).toArray();

        int[] worShip = Arrays.stream(scanner.nextLine()
                .split(">")).mapToInt(Integer::parseInt).toArray();
        int maximumHealthCapacity = Integer.parseInt(scanner.nextLine());
        String input = scanner.nextLine();
        while (!input.equals("Retire")) {
            String[] commands = input.split(" ");
            switch (commands[0]) {
                case "Fire":
                    int index = Integer.parseInt(commands[1]);
                    int damage = Integer.parseInt(commands[2]);
                    if (index >= 0 && index <= worShip.length-1) {
                        worShip[index] -= damage;
                        if (worShip[index] <= 0) {
                            System.out.println("You won! The enemy ship has sunken.");
                            return;

                        }

                    }
                    break;
                case "Defend":
                    int startIndex = Integer.parseInt(commands[1]);
                    int endIndex = Integer.parseInt(commands[2]);
                    int pirateDamage = Integer.parseInt(commands[3]);
                    if (startIndex >= 0 && endIndex <= pirateShip.length-1) {
                        for (int i = startIndex; i <= endIndex; i++) {
                            pirateShip[i] -= pirateDamage;

                            if (pirateShip[i] <= 0) {
                                System.out.println("You lost! The pirate ship has sunken.");
                                return;
                            }
                        }
                    }
                    break;
                case "Repair":
                    int repairIndex = Integer.parseInt(commands[1]);
                    int health = Integer.parseInt(commands[2]);

                    if (repairIndex >=0 && repairIndex <= pirateShip.length-1) {
                        pirateShip[repairIndex] += health;
                        if (pirateShip[repairIndex] > maximumHealthCapacity) {
                            pirateShip[repairIndex] = maximumHealthCapacity;
                        }
                    }

                    break;
                case "Status":
                    int counter = 0;
                    for (int i = 0; i <= pirateShip.length-1; i++) {
                        if(pirateShip[i] < maximumHealthCapacity* 0.20){
                            counter++;
                        }
                    }
                    System.out.printf("%d sections need repair.%n",counter);
                    break;

            }

            input = scanner.nextLine();
        }
        int sumPirate = Arrays.stream(pirateShip).sum();
        System.out.printf("Pirate ship status: %d%n",sumPirate);
        int sumWorship = Arrays.stream(worShip).sum();
        System.out.printf("Warship status: %d",sumWorship);
    }
}

