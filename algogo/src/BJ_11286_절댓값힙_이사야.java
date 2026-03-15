import java.io.*;
import java.util.*;

public class BJ_11286_절댓값힙_이사야 {
    public static void main(String[] args) throws IOException {
        BufferedReader input=new BufferedReader(new InputStreamReader(System.in));
        StringBuilder output=new StringBuilder();
        int N= Integer.parseInt(input.readLine());
        PriorityQueue<Integer> pq=new PriorityQueue<>((a,b)->{if(Math.abs(a)-Math.abs(b)==0) return a-b; return Math.abs(a)-Math.abs(b);});
        for(int i=0;i<N;i++){
            int command=Integer.parseInt(input.readLine());
            if (command!=0) {
                pq.offer(command);
            }
            else{
                if (pq.size()==0){
                    output.append(0).append("\n");
                }else{
                    output.append(pq.poll()).append("\n");
                }
            } 
        }
        System.out.println(output);
    }
}