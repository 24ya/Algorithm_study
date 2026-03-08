import java.io.*;
import java.util.*;

public class BJ_2839_설탕배달_이사야 {
    public static void main(String[] args) throws IOException {
        BufferedReader input=new BufferedReader(new InputStreamReader(System.in));
        StringBuilder output = new StringBuilder();
        int N=Integer.parseInt(input.readLine());
        int five=N/5,three=0, temp=0;
        while(five>0){
            temp=five*5;
            while (N-temp>=3){
                temp=five*5+3*++three;
            }
            if (temp==N){
                break;
            }
            five--;
        }
        if (five==0){
            if(N%3!=0){
                System.out.println(-1);
            }else{
                System.out.println(N/3);
            }
        }else{
            System.out.println(five+three);
        }
    }
}