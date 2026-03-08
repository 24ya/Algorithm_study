import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
// import java.util.ArrayList;
// import java.util.Arrays;
// import java.util.HashMap;
// import java.util.List;
// import java.util.Map;
import java.util.StringTokenizer;

public class BJ_11047_동전0_이사야 {
    public static void main(String[] args) throws IOException{
        BufferedReader input=new BufferedReader(new InputStreamReader(System.in));
        // StringBuilder output=new StringBuilder();
        StringTokenizer NK=new StringTokenizer(input.readLine());
        int now_money=0;
        int answer=0;
        int N=Integer.parseInt(NK.nextToken());
        int K=Integer.parseInt(NK.nextToken());
        // List<Integer> Coins=new ArrayList<>();
        int[] Coins=new int[N];
        for (int i=0;i<N;i++){
            // Coins.add(Integer.parseInt(input.readLine()));
            Coins[i]=Integer.parseInt(input.readLine());
        }
        // Coins=Coins.reversed();
        for (int i=Coins.length-1;i>=0;i--){
            if (now_money==K){
                break;
            } else {
                if(now_money+Coins[i]<=K){
                    now_money+=Coins[i];
                    answer++;
                    i++;
                }
            }
        }
        System.out.println(answer);
        input.close();
    }
}