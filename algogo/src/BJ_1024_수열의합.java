import java.io.*;
import java.util.*;

public class BJ_1024_수열의합 {
    public static void main(String[] args) throws IOException {
    BufferedReader input=new BufferedReader(new InputStreamReader(System.in));
    StringBuilder output=new StringBuilder();
    StringTokenizer st=new StringTokenizer(input.readLine());
    long N=Long.parseLong(st.nextToken());
    long L=Long.parseLong(st.nextToken());
    long len=-1;
    for(long i=L;i<=100;i++){
        if (i%2==0){
            if(N%i==i/2){
                if(N/i-i/2+1<0){
                    continue;
                }else{
                    len=i;
                    break;
                }
                
            }
        }else{
            if(N%i==0){
                
                if(N/i-i/2<0){
                    continue;
                }else{
                    len=i;
                    break;
                }
                
            }
        }
    }
    if (len==-1){
        output.append(-1);
    }else if(len%2==1){
        for (int i=0;i<len;i++){
            output.append(N/len-len/2+i).append(" ");
        }
    }else{
        for (int i=0;i<len;i++){
            output.append(N/len-len/2+i+1).append(" ");
        }
    }
    System.out.println(output);
    }
}