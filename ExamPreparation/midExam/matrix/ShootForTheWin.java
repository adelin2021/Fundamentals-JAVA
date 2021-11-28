import java.util.Arrays;
import java.util.Scanner;

public class ShootForTheWin {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] targets = Arrays.stream(scanner.nextLine()
                .split(" ")).mapToInt(Integer::parseInt).toArray();
        String input = scanner.nextLine();
        int countShootingTargets = 0;
        while (!input.equals("End")) {
            int shootingTargets = Integer.parseInt(input);
            if (shootingTargets < targets.length) {
                int shoot = targets[shootingTargets];
                for (int i = 0; i < targets.length; i++) {

                    if (i == shootingTargets && targets[i] != -1) {
                        targets[shootingTargets] = -1;
                        countShootingTargets++;
                    } else {
                        if (targets[i] > shoot && targets[i] != -1) {
                            targets[i] -= shoot;
                        } else {
                            if (targets[i] != -1) {
                                targets[i] += shoot;
                            }
                        }
                    }
                }
            }
            input = scanner.nextLine();
        }


        System.out.printf("Shot targets: %d -> ", countShootingTargets);
        for (int target : targets) {
            System.out.print( target + " ");
        }
    }
}


