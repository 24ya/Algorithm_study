import java.util.*;
import java.io.*;


public class BJ_1181_단어정렬_이사야{
	public static void main(String[] args) throws IOException {
		BufferedReader input=new BufferedReader(new InputStreamReader(System.in));
		StringBuilder output=new StringBuilder();
		int N=Integer.parseInt(input.readLine());
		Set<String> mySet=new HashSet<>();
		for(int i=0;i<N;i++){
			mySet.add(input.readLine());
		}
		String[] myString=mySet.toArray(new String[0]);
		Arrays.sort(myString,(a,b)->{
			if (a.length()==b.length()) return a.compareTo(b);
			return a.length()-b.length();
		});
		for(String e:myString){
			System.out.println(e);
		}
	}
}