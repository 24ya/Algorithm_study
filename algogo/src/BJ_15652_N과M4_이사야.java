import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BJ_15652_N과M4_이사야 {
    static boolean[] visited;
    static List<int[]> answers=new ArrayList<>();
    static int[] numbers;
    static int N, M;
    public static void main(String[] args) throws IOException {
        BufferedReader input=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer NM=new StringTokenizer(input.readLine());
        StringBuilder output= new StringBuilder();

        N=Integer.parseInt(NM.nextToken());
        M=Integer.parseInt(NM.nextToken());
        visited= new boolean[N+1];
        numbers= new int[N+1];
        for (int i=0;i<N+1;i++){
            numbers[i]=i;
        }


        combination(new int[M],0,1);


        for (int i=0; i<answers.size(); i++){
            int[] next=answers.get(i);
            for(int j=0; j<next.length;j++){
                output.append(next[j]).append(" ");
            }
            output.append("\n");
        }
        System.out.println(output);
    }

    static void combination(int[] combine,int depth,int start){

        if (depth>=M){
            int[] foradd=combine.clone();
            answers.add(foradd);
            return;
        }

        for (int i=start;i<N+1;i++){
            if(!visited[i]){
                combine[depth]=i;
                // visited[i]=true;
                combination(combine, depth+1,i);
                // visited[i]=false;

            }    
        }
    }
}


