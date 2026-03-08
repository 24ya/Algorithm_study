import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_9086_문자열 {

    public static void main(String[] args) throws IOException {
        BufferedReader input=new BufferedReader(new InputStreamReader(System.in));
        StringBuilder output=new StringBuilder();
        int N=Integer.parseInt(input.readLine());
        for (int i=0;i<N;i++){
            String S=input.readLine();
            output.append(S.charAt(0)).append(S.charAt(S.length()-1)).append(("\n"));
        }
        System.out.println(output);
    }
}