import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class BJ_9375_패션왕신해빈_이사야 {
    public static void main(String[] args) throws IOException {
        BufferedReader input=new BufferedReader(new InputStreamReader(System.in));
        StringBuilder output= new StringBuilder();
        int T=Integer.parseInt(input.readLine());
        for(int test_case=0;test_case<T;test_case++){
            Map<String,Integer> clothes=new HashMap<>();
            List<String> Keys=new ArrayList<>();
            int N=Integer.parseInt(input.readLine());
            for(int i=0;i<N;i++){
                StringTokenizer mapStringTokenizer=new StringTokenizer(input.readLine());
                mapStringTokenizer.nextToken();
                String c=mapStringTokenizer.nextToken();
                if(clothes.containsKey(c)){
                    clothes.put(c, clothes.get(c)+1);
                } else {
                    clothes.put(c, 1);
                    Keys.add(c);
                }
            }
            int total=1;
            for(String k:Keys){
                total*=(clothes.get(k)+1);
            }
            output.append(--total).append("\n");
        }
        System.out.println(output);
    }
}


