import java.io.BufferedReader;
import java.io.DataOutput;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class Student {

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));


        Map<String ,Double> students = new LinkedHashMap<>();

        while (true){
            String[] studentInfo = reader.readLine().split(" ");
            if("print".equals(studentInfo[0]))
                break;

            String name = studentInfo[0];
            double money = Double.parseDouble(studentInfo[1]);

            if(!students.containsKey(name)){
                students.put(name,money);
            }else {
                students.put(name,students.get(name) + money);
            }
        }


        students.entrySet().stream().sorted((s1,s2) -> {
            return Double.compare(s2.getValue(),s1.getValue());
        }).forEach(x -> {
            System.out.printf("%s -> %.2f\n",x.getKey(),x.getValue());
        });




    }
}