import java.io.BufferedReader;
// import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
// import java.util.ArrayList;
// import java.util.List;
// import java.io.OutputStreamWriter;
// import java.util.Arrays;
// import java.util.StringTokenizer;


public class BJ_2439_별찍기2_이사야 {
    public static void main(String[] args) throws IOException{
        BufferedReader input=new BufferedReader(new InputStreamReader(System.in));
        StringBuilder output=new StringBuilder();
        int N=Integer.parseInt(input.readLine());
        for (int i=1;i<N+1;i++){
            for (int j=0;j<N-i;j++){
                output.append(" ");
            }
            for (int j=0;j<i;j++){
                output.append("*");
            }
            output.append(("\n"));
        }
        input.close();
        System.out.println(output);
    }
}
//     public static void Guitar(String[] Possible){

//     }
// }