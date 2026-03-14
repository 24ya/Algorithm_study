import java.io.*;
import java.util.*;

public class BJ_1182_부분수열의합_이사야 {
    static int N,S;
    static int[] num;
    public static void main(String[] args) throws IOException {
        BufferedReader input=new BufferedReader(new InputStreamReader(System.in));
        StringBuilder output=new StringBuilder();
        StringTokenizer NM=new StringTokenizer(input.readLine());
        N=Integer.parseInt(NM.nextToken());
        S=Integer.parseInt(NM.nextToken());
        num=new int[N];
        NM=new StringTokenizer(input.readLine());
        for(int i=0;i<N;i++){
            num[i]=Integer.parseInt(NM.nextToken());
        }
        System.out.println(Maker());
    }
    static int Maker(){
        int answer=0;
        for (int i=1;i<1<<N;i++){
            int temp=0;
            for (int j=0;j<N;j++){
                if ((i&(1<<j))>0) temp+=num[j];
            }
            if (temp==S) answer++;
        }
        return answer;
    }
}