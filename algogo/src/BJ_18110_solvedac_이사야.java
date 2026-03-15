import java.io.*;
import java.util.*;

public class BJ_18110_solvedac_이사야 {
    public static void main(String[] args) throws IOException {
        BufferedReader input=new BufferedReader(new InputStreamReader(System.in));
        StringBuilder output=new StringBuilder();
        int N=Integer.parseInt(input.readLine());
        int[] num=new int[N];
        // PriorityQueue<Integer> pq=new PriorityQueue<>((a,b)->a-b);
        // for (int i=0;i<N;i++){
        //     pq.offer(Integer.parseInt(input.readLine()));
        // }
        for(int i=0;i<N;i++){
            num[i]=Integer.parseInt(input.readLine());
        }
        int R=Math.round(((float)N)*3/20);
        Arrays.sort(num);
        // for (int i=0;i<R;i++){
        //     pq.poll();
        // }
        // Integer[] T=pq.toArray(new Integer[0]);
        float total=0;
        for (int i=R;i<N-R;i++){
            total+=num[i];
        }
        int answer=Math.round(total/(N-(2*R)));
        System.out.println(answer);
    }
}