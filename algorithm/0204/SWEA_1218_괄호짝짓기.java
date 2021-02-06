package ssafy_algo_0204;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;

public class T10_1218 {
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		for(int T=1;T<=10;T++) {
			int N=Integer.parseInt(br.readLine());
			char[] str=br.readLine().toCharArray();
			int[] arr=new int[11];
			Arrays.fill(arr, 1);
			Stack<Character> stack=new Stack<>();
			for(int i=0;i<str.length;i++) {
				if(str[i]=='('||str[i]=='<'||str[i]=='['||str[i]=='{') {
					stack.push(str[i]);
				}
				else
				{
					if(stack.isEmpty()) {
						arr[T]=0;
						break;
					}
					
					char temp=stack.pop();
					if( Math.abs(temp-str[i])>2 ) {
						arr[T]=0;
						break;
					}
				}
				
			}
			System.out.println("#"+T+" "+arr[T]);
			
		}
	}
}
