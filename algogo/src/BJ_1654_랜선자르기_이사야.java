import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;




public class BJ_1654_랜선자르기_이사야 {
    public static void main(String[] args) throws IOException{
        BufferedReader input=new BufferedReader(new InputStreamReader(System.in));
        StringBuilder output=new StringBuilder();
        StringTokenizer KN=new StringTokenizer(input.readLine());
        int K=Integer.parseInt(KN.nextToken());
        int N=Integer.parseInt(KN.nextToken());
        int[] LAN=new int[K];
        long MIN=Integer.MAX_VALUE;
        long MAX=Integer.MIN_VALUE;
        for(int i=0;i<K;i++){
            int lan=Integer.parseInt(input.readLine());
            if (lan<MIN){MIN=lan;}
            if (lan>MAX){MAX=lan;}
            LAN[i]=lan;
        }
        // MAX=MIN;
        MIN=1;
        int answer=0;
        while (MIN<=MAX){
            int amount=0;
            long slice=(MIN+MAX)/2;
            for (int i=0;i<K;i++){
                amount+=LAN[i]/slice;
            }
            if (amount<N){
                MAX=slice-1;
            } else{
                MIN=slice+1;
                if(answer<slice){
                    answer=(int)slice;
                }
            }
        }
        System.out.println(answer);
    }

}