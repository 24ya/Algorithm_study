import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class BJ_15654_N과M5_이사야 {
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
        NM= new StringTokenizer(input.readLine());
        visited= new boolean[N+1];
        numbers= new int[N+1];
        for (int i=1;i<N+1;i++){
            numbers[i]=Integer.parseInt(NM.nextToken());
        }
        Arrays.sort(numbers);


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

        for (int i=1;i<N+1;i++){
            if(!visited[i]){
                combine[depth]=numbers[i];
                visited[i]=true;
                combination(combine, depth+1,i);
                visited[i]=false;

            }    
        }
    }
}


