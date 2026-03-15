import java.io.*;
import java.util.*;

public class BJ_11279_최대힙_이사야 {
    public static void main(String[] args) throws IOException {
        BufferedReader input=new BufferedReader(new InputStreamReader(System.in));
        StringBuilder output=new StringBuilder();
        int N= Integer.parseInt(input.readLine());
        PriorityQueue<Integer> pq=new PriorityQueue<>((a,b)->b-a);
        for(int i=0;i<N;i++){
            int command=Integer.parseInt(input.readLine());
            if (command>0) {
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