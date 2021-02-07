package BOJ;

import java.util.Arrays;
import java.util.Scanner;

public class BOJ_15654 {
	static int[] arr;
	static int [] result;
	static boolean[] visit;
	static int N;
	static int R;
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		
		N=sc.nextInt();
		R=sc.nextInt();
		arr=new int[N];
		result=new int[R];
		visit=new boolean[N+1];
		for(int i=0;i<N;i++) {
			arr[i]=sc.nextInt();
		}
		
		Arrays.sort(arr);
		dfs(0);
	}
	
	public static void dfs(int start) {
		
		if(start==R) {
			//depth가 일치할때
			for(int i=0;i<result.length;i++) {
				System.out.print(result[i]+" ");
			}
			System.out.println();
		}else
		{
			//아닐떄
			for(int i=0;i<N;i++) {
				if(!visit[i]) {
					visit[i]=true;
					result[start]=arr[i];
					dfs(start+1);
					visit[i]=false;
					
					
				}
			}
			
		}
		
		
	}
}
