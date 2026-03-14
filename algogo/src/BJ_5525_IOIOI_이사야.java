import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_5525_IOIOI_이사야 {

    public static void main(String[] args) throws IOException {
        BufferedReader input=new BufferedReader(new InputStreamReader(System.in));
        int N=Integer.parseInt(input.readLine());
        int M=Integer.parseInt(input.readLine());
        String LINE=input.readLine();
        int count=0,answer=0;
        for (int i=1;i<M-1;i++){
            if(LINE.charAt(i-1)=='I'&&LINE.charAt(i)=='O'&&LINE.charAt(i+1)=='I'){
                count++;
                i++;
            } else{
                count=0;
            }
            if (count==N){
                count--;
                answer++;
            }
        }
        System.out.println(answer);
    }
}