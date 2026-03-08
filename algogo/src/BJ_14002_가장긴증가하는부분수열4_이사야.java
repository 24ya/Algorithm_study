import java.io.*;
import java.util.*;

public class BJ_14002_가장긴증가하는부분수열4_이사야 {
    static ArrayList<Integer> LIS;
    static int[] positionCheck;
    public static void main(String[] args) throws IOException {
        BufferedReader input=new BufferedReader(new InputStreamReader(System.in));
        StringBuilder output = new StringBuilder();
        int N=Integer.parseInt(input.readLine());
        int[] A=new int[N];
        StringTokenizer st=new StringTokenizer(input.readLine());
        for(int i=0;i<N;i++){
            A[i]=Integer.parseInt(st.nextToken());
        }
        LIS=new ArrayList<>();
        positionCheck=new int[N];
        LIS.add(A[0]);
        positionCheck[0]=0;
        for (int i=1;i<N;i++){
            if (A[i]>LIS.get(LIS.size()-1)){
                LIS.add(A[i]);
                positionCheck[i]=LIS.size()-1;
            }else{
                binarySearch(A[i],i);
            }
        }
        output.append(LIS.size()).append("\n");
        Stack<Integer> myStack=new Stack<>();
        int target=LIS.size()-1;
        for(int i=N-1;i>=0;i--){
            if(positionCheck[i]==target){
                myStack.add(A[i]);
                target--;
            }
        }
        while (!myStack.isEmpty()){
            output.append(myStack.pop()).append(" ");
        }
        System.out.println(output);
    }
    static void binarySearch(int n,int i){
        int L=0, R=LIS.size()-1,temp=0;
        while (L<R) {
            temp=(L+R)/2;
            if (LIS.get(temp)==n){
                LIS.set(temp,n);
                positionCheck[i]=temp;
                return;
            }else if (LIS.get(temp)<n){
                L=temp+1;
            }else{
                R=temp;
            }
        }
        LIS.set(L,n);
        positionCheck[i]=L;
    }
}