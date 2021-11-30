import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Pirates {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        Map<String,int[]> piratesHistory = new LinkedHashMap<>();

        while (!input.equals("Sail")){
            String[] info = input.split("\\|\\|");
String cityName = info[0];
if(piratesHistory.containsKey(cityName)) {
}else{

}


              input = scanner.nextLine();
        }
    }
}
