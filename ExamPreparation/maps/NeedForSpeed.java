import java.util.*;

public class NeedForSpeed {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        Map<String, Integer[]> cars = new TreeMap<>();
        for (int i = 0; i < n; i++) {

            String[] input = scanner.nextLine().split("\\|");
            String car = input[0];
            int mileage = Integer.parseInt(input[1]);
            int fuel = Integer.parseInt(input[2]);
            cars.putIfAbsent(car, new Integer[2]);
            cars.get(car)[0] = mileage;
            cars.get(car)[1] = fuel;

        }
        String input2 = scanner.nextLine();
        while (!input2.equals("Stop")) {
            String[] command = input2.split(" : ");
            String model = command[1];
            switch (command[0]) {
                case "Drive":
                    int distance = Integer.parseInt(command[2]);
                    int fuel = Integer.parseInt(command[3]);
                    if (cars.containsKey(model)) {
                        if (cars.get(model)[1] - fuel <= 0) {
                            System.out.println("Not enough fuel to make that ride");
                        } else {
                            cars.get(model)[0] += distance;
                            cars.get(model)[1] -= fuel;
                            System.out.println(model + " driven for " + distance + " kilometers. " + fuel + " liters of fuel consumed.");
                        }
                        if (cars.get(model)[0] >= 100000) {
                            cars.remove(model);
                            System.out.println("Time to sell the " + model + "!");
                        }
                    }
                    break;
                case "Refuel":
                    int refuel = Integer.parseInt(command[2]);
                    if (cars.containsKey(model)) {
                        if (cars.get(model)[1] + refuel > 75) {
                            int sum = 75 - cars.get(model)[1];
                            System.out.println(model + " refueled with " + sum + " liters");
                            cars.get(model)[1] = 75;
                        } else {
                            cars.get(model)[1] += refuel;
                            System.out.println(model + " refueled with " + refuel + " liters");
                        }
                    }

                    break;
                case "Revert":
                    int klm = Integer.parseInt(command[2]);
                    if (cars.containsKey(model)) {
                        if (cars.get(model)[0] - klm < 10000) {
                            cars.get(model)[0] = 10000;
                        } else {
                            cars.get(model)[0] -= klm;
                            System.out.println(model + " mileage decreased by " + klm + " kilometers");
                        }
                        break;

                    }
            }

            input2 = scanner.nextLine();
        }

        cars.entrySet().stream()
                .sorted((a, b) -> b.getValue()[0].compareTo(a.getValue()[0]))
                .forEach(e -> System.out.printf("%s -> Mileage: %d kms," +
                                " Fuel in the tank: %d lt.%n"
                        , e.getKey()
                        , e.getValue()[0]
                        , e.getValue()[1]));

    }
}


