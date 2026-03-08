import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader input=new BufferedReader(new InputStreamReader(System.in));
        int N=Integer.parseInt(input.readLine());
        int M=Integer.parseInt(input.readLine());
        StringBuilder ioi=new StringBuilder("I");
        int count=0;
        for (int i=0;i<N;i++){
            ioi.append("OI");
        }
        String IOI=ioi.toString();
        String Line=input.readLine();
        for (int i=0;i<M-ioi.length()+1;i++){
            if (Line..equals(IOI)){
                count++;
            }
        }
        System.out.println(count);
    }
}