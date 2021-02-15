package ssafy_algo_0215;

import java.util.Arrays;
import java.util.Scanner;
//비트마스크로 다시풀어보기
public class BOJ_1182_부분수열의합 {
	static int N;
	static int M;
	static int[] arr;
	static int answer=0;
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		N=sc.nextInt();
		M=sc.nextInt();
		arr=new int[N];
		for(int i=0;i<N;i++) {
			arr[i]=sc.nextInt();
		}
		
		powerset(0, new boolean[N]);
		System.out.println(answer);
	}
	
	private static void powerset(int cnt,boolean[] selected) {
		if(cnt==N) {
			int sum=0;
			int check=0;
			for(int i=0;i<N;i++) {
				if(selected[i]) {
					check++;
					sum+=arr[i];
				}
			}
			if(sum==M&&check!=0) {
				System.out.println(Arrays.toString(selected));
				answer++;
			}
			return;
		}
		
		selected[cnt]=true;
		powerset(cnt+1,selected);
		selected[cnt]=false;
		powerset(cnt+1,selected);
		
	}
}


/*package ssafy_algo_0215;

import java.util.Arrays;
import java.util.Scanner;

public class BOJ_1182_부분수열의합 {
	static int N;
	static int M;
	static int[] arr;
	static int answer=0;
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		N=sc.nextInt();
		M=sc.nextInt();
		arr=new int[N];
		for(int i=0;i<N;i++) {
			arr[i]=sc.nextInt();
		}
		
		powerset(0, new boolean[N]);
		System.out.println(answer);
	}
	
	private static void powerset(int cnt,boolean[] selected) {
		if(cnt==N) {
			int sum=0;
			int check=0;
			for(int i=0;i<N;i++) {
				if(selected[i]) {
					check++;
					sum+=arr[i];
				}
			}
			if(sum==M&&check!=0) {
				System.out.println(Arrays.toString(selected));
				answer++;
			}
			return;
		}
		
		selected[cnt]=true;
		powerset(cnt+1,selected);
		selected[cnt]=false;
		powerset(cnt+1,selected);
		
	}
}
*/