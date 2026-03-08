import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;
/* 
DP로 풀어야 된다고 함
DP 잘 몰라서 못풀었음..

시간 초과 발생

*/ 
public class Main {
    static boolean[] visit;
    static int N;
    static int[] numbers;
    static Integer[] answer_subset={};
    public static void main(String[] args) throws IOException {
        BufferedReader input=new BufferedReader(new InputStreamReader(System.in));
        StringBuilder output= new StringBuilder();
        N=Integer.parseInt(input.readLine());
        numbers=new int[N];
        visit=new boolean[N];
        StringTokenizer numbersStringTokenizer=new StringTokenizer(input.readLine());
        for(int i=0;i<N;i++){
            numbers[i]=Integer.parseInt(numbersStringTokenizer.nextToken());
        }
        subset(new ArrayList<>(),0);
        // System.out.println(answer_subset.toString());
        System.out.println(answer_subset.length);
    }



    static void subset(List<Integer> list,int depth){
        // if (depth>=N-1){
        //     if (list.size()>answer_subset.length){
        //         Integer[] forUpdate = list.toArray(new Integer[0]);
        //         answer_subset=forUpdate;
        //     }
        //     return;
        // }

        for(int i=0;i<1<<N;i++){
            for(int j=0;j<N;j++){
                if((i&(1<<j))>0){
                    if (list.size()!=0&&numbers[j]<list.get(list.size()-1)){
                        break;
                    }
                    list.add(numbers[j]);
                }
            }
            if (list.size()>answer_subset.length){
                Integer[] forUpdate = list.toArray(new Integer[0]);
                answer_subset=forUpdate;
            }
            list.clear();
        }
    }
}


