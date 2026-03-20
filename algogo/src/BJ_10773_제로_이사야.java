    import java.io.*;
    import java.util.*;

    public class BJ_10773_제로_이사야 {
        public static void main(String[] args) throws IOException {
            BufferedReader input=new BufferedReader(new InputStreamReader(System.in));
            StringBuilder output=new StringBuilder();
            Stack<Integer> myStack=new Stack<>();
            int N=Integer.parseInt(input.readLine());
            for(int i=0;i<N;i++){
                int command=Integer.parseInt(input.readLine());
                if (command>0) myStack.push(command);
                else myStack.pop();
            }
            int total=0;
            while(!myStack.isEmpty()){
                total+=myStack.pop();
            }
            System.out.println(total);
        }
    }