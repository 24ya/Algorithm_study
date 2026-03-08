import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_11399_ATM_이사야 {
    public static void main(String[] args) throws IOException{
        BufferedReader input=new BufferedReader(new InputStreamReader(System.in));
        int N=Integer.parseInt(input.readLine());
        int answer=0;
        int[] P=new int[N];
        StringTokenizer Ps=new StringTokenizer(input.readLine());        
        for(int i=0;i<N;i++){
            P[i]=Integer.parseInt(Ps.nextToken());
        }
        Arrays.sort(P);
        for (int i=0;i<N;i++){
            for(int j=0;j<i+1;j++){
                answer+=P[j];
            }
        }
        System.out.println(answer);
    }
}