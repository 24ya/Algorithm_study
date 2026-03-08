import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class BJ_17219_비밀번호찾기_이사야 {
    public static void main(String[] args) throws IOException{
        BufferedReader input=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer NM=new StringTokenizer(input.readLine());
        int N=Integer.parseInt(NM.nextToken());
        int M=Integer.parseInt(NM.nextToken());
        Map<String,String> id_passwordMap=new HashMap<>();
        StringBuilder output=new StringBuilder();
        for (int i=0;i<N;i++){
            StringTokenizer id_password=new StringTokenizer(input.readLine());
            id_passwordMap.put(id_password.nextToken(), id_password.nextToken());
        }
        for (int i=0;i<M;i++){
            output.append(id_passwordMap.get(input.readLine())).append("\n");
        }
        System.out.println(output);
    }
}