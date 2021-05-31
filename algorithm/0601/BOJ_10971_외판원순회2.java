package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_10971_외판원순회2 {
	static int n;
	static int min = Integer.MAX_VALUE;
	static int[][] arr;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n=Integer.parseInt(br.readLine());
		arr = new int[n][n];
		for (int i = 0; i < n; i++) {
			String[] str = br.readLine().split(" ");
			for (int j = 0; j < n; j++) {
				arr[i][j] = Integer.parseInt(str[j]);
			}
		}
		
		permu(0,new boolean[n],new int[n]);
		System.out.println(min);
	}
	public static void permu(int select,boolean visited[],int selected[]) {
		if(select ==n) {
			int sum=0;
			
			int start=selected[0];
			for(int i=1;i<n;i++) {
				if(arr[start][selected[i]]==0)return;
				sum+=arr[start][selected[i]];
				start=selected[i];
				if(min<sum)break;
				
			}
			if(arr[selected[n-1]][selected[0]]==0)return;
			if(sum!=0) {
				min=Math.min(min, sum+arr[selected[n-1]][selected[0]]);
				
				for(int i:selected) {
					System.out.print(i+" ");
				}
				System.out.println(sum);
			}
			
			return;
		}
		
		
		for(int i=0;i<n;i++) {
			if(!visited[i]) {
				visited[i]=true;
				selected[select]=i;
				permu(select+1,visited,selected);
				visited[i]=false;
			}
		}
	}
}
