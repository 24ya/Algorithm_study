import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_16953_Atob_이사야 {
    public static void main(String[] args) throws IOException {
        BufferedReader input=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer AB=new StringTokenizer(input.readLine());
        StringBuilder output= new StringBuilder();
        Long A=Long.parseLong(AB.nextToken());
        Long B=Long.parseLong(AB.nextToken());
        int result=Bmaker(A, B, 1);
        if (result==Integer.MAX_VALUE){
            output.append(-1);
        } else{
            output.append(result);
        }
        System.out.println(output);
    }
    
    static int Bmaker(Long A,Long B,int count){
        if(A>B){
            return Integer.MAX_VALUE;
        } else if(A.equals(B)){
            return count;
        }

        return Math.min(Bmaker(A*2, B, count+1), Bmaker(A*10+1, B, count+1));
    }
}


