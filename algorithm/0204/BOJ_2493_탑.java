package ssafy_algo_0204;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;


class Top{
	int idx;
	int value;
	
	public Top(int idx,int value) {
		this.idx=idx;
		this.value=value;
	}
}
public class BOJ_2493 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int N=Integer.parseInt(br.readLine());
		
		
		String[] str=br.readLine().split(" ");
		int[] arr=new int[N];
		for(int i=0;i<str.length;i++) {
			arr[i]=Integer.parseInt(str[i]);
		}
		Stack<Top> stack=new Stack<>();
		
		List<Integer> list=new ArrayList<>();
		for(int i=0;i<N;i++) {
			while(!stack.empty()) {
				if(stack.peek().value>=arr[i]) {
					list.add(stack.peek().idx+1);
					stack.push(new Top(i,arr[i]));
					break;
				}
				else {
					System.out.println(stack.pop().value);
				}
			}
			if(stack.isEmpty()) {
				list.add(0);
				stack.push(new Top(i,arr[i]));
			}
		}
		for(int index: list) {
			System.out.print(index+" ");
		}
		

	}
}
