import java.util.*;
import java.io.*;


public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader input=new BufferedReader(new InputStreamReader(System.in));
        StringBuilder output=new StringBuilder();
        int N=Integer.parseInt(input.readLine());
        for(int i=0;i<N;i++){
            for(int j=0;j<N-i-1;j++){
                output.append(" ");
            }
            for (int j=0;j<(i+1)*2-1;j++){
                output.append("*");
            }
            output.append("\n");
        }
        System.out.println(output);
    }
}
