import java.util.Scanner;

public class SecretChat {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder concealedMessage = new StringBuilder(scanner.nextLine());
        String input = scanner.nextLine();
        while (!input.equals("Reveal")) {
            String[] commands = input.split(":\\|:");
            switch (commands[0]) {
                case "InsertSpace":
                    int index = Integer.parseInt(commands[1]);
                    if(index >= 0 && index<=concealedMessage.length()){
                        concealedMessage.insert(index," ");
                    }
                    System.out.println(concealedMessage);
                    break;
                case "Reverse":
                    String sub = commands[1];
                    StringBuilder reverseSub = new StringBuilder(sub).reverse();
                    int start = concealedMessage.indexOf(sub);
                    if (concealedMessage.toString().contains(sub)) {
                        concealedMessage = new StringBuilder(concealedMessage
                                .delete(start, start + sub.length()).append(reverseSub));
                        System.out.println(concealedMessage);
                    }else{
                        System.out.println("error");
                    }

                    break;
                case "ChangeAll":
                    String subStr = commands[1];
                    String replesment = commands[2];
                    concealedMessage = new StringBuilder(concealedMessage.toString()
                            .replace(subStr,replesment));
                    System.out.println(concealedMessage);
                    break;
            }

            input = scanner.nextLine();
        }
        System.out.println("You have a new text message: "+concealedMessage);
    }
}
