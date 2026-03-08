import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class BJ_1764_듣보잡_이사야 {
    public static void main(String[] args) throws IOException{
        BufferedReader input=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer NM=new StringTokenizer(input.readLine());
        Map<String,Integer> Name_num = new HashMap<>();
        StringBuilder output=new StringBuilder();
        List<String> DBjob=new ArrayList<>();
        int N=Integer.parseInt(NM.nextToken());
        int M=Integer.parseInt(NM.nextToken());
        int count=0;
        for (int i=0;i<N;i++){
            String Name=input.readLine();
            Name_num.put(Name,i);
        }
        for (int i=0;i<M;i++){
            String Name=input.readLine();
            if(Name_num.containsKey(Name)){
                count++;
                DBjob.add(Name);
            }
        }
        output.append(count).append("\n");

        String[] DBjob_sort=DBjob.toArray(new String[0]);
        Arrays.sort(DBjob_sort);
        for (String name:DBjob_sort){
            output.append(name).append("\n");
        }
        System.out.println(output);
        input.close();
    }
}