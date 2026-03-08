import java.io.BufferedReader;
// import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
// import java.io.OutputStreamWriter;
// import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_1620_나는야포켓몬마스터이다솜_이사야 {
    public static void main(String[] args) throws IOException{
        BufferedReader input=new BufferedReader(new InputStreamReader(System.in));
        // BufferedWriter output=new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer NM=new StringTokenizer(input.readLine());
        Map<String,Integer> Name_num = new HashMap<>();
        StringBuilder output=new StringBuilder();
        int N=Integer.parseInt(NM.nextToken());
        int M=Integer.parseInt(NM.nextToken());
        // String[] Pokemon=new String[N];
        List<String> Pokemon=new ArrayList<>();
        for (int i=0;i<N;i++){
            String Name=input.readLine();
            Pokemon.add(Name);
            Name_num.put(Name,i+1);
        }
        for (int i=0;i<M;i++){
            String Question=input.readLine();
            if (Question.charAt(0)>64){
                output.append(Name_num.get(Question)).append("\n");
            }else{
                output.append(Pokemon.get(Integer.parseInt(Question)-1)).append("\n");
            }
        }

        System.out.println(output);
        // output.flush();
        input.close();
        // output.close();
    }
}