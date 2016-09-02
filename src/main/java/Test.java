import javax.validation.constraints.NotNull;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by mr_change on 16-7-27.
 */
public class Test {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String inputOne = "";
        String inputTwo = "";
//        System.out.print("输入第一行：");
//        inputOne = bufferedReader.readLine();
//        bufferedReader = new BufferedReader(new InputStreamReader(System.in));
//        System.out.print("输入第二行：");
//        inputTwo = bufferedReader.readLine();
//
//        System.out.println(check(inputOne) ? "yes" : "false");
//        System.out.println(check(inputTwo) ? "yes" : "false");
        System.out.println(output(null));
    }

    private static boolean check(String input) {
        for(int cnt = 0;cnt < input.length();cnt++) {
            char a = input.charAt(cnt);
            if(a < 32 && a > 126 || a == ' ') {
                return false;
            }
        }

        return true;
    }

    public static String output(@NotNull String in) {
        return in.substring(0,2);
    }
}
