package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

//3 5 7 9 11
//1 2 3 4 5 
public class BOJ_15658_연산자끼워넣기2 {
	static int max=Integer.MIN_VALUE;
	static int min=Integer.MAX_VALUE;
	static int n;
	static int arr[];
	static int op[];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n=Integer.parseInt(br.readLine());
		String[] str=br.readLine().split(" ");
		arr=new int[n];
		for(int i=0;i<n;i++) {
			arr[i]=Integer.parseInt(str[i]);
		}
		op=new int[4];
		String[] temp=br.readLine().split(" ");
		for(int i=0;i<4;i++) {
			op[i]=Integer.parseInt(temp[i]);
		}
		backtracking(1,arr[0]);
		System.out.println(max);
		System.out.println(min);
		
	}
	
	public static void backtracking(int cnt, int sum) {
		if(cnt>=n) {
			min=Math.min(min, sum);
			max=Math.max(max, sum);
			return;
		}
		for(int i=0;i<4;i++) {
			if(op[i]==0) {
				continue;
			}
			op[i]--;
			switch(i) {
			case 0:
				backtracking(cnt+1,sum+arr[cnt]);
				break;
			case 1:
				backtracking(cnt+1,sum-arr[cnt]);
				break;
			case 2:
				backtracking(cnt+1,sum*arr[cnt]);
				break;
			case 3:
				backtracking(cnt+1,sum/arr[cnt]);
				break;
			}
			op[i]++;
			
		}
	}

}
