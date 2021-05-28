package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_1058_친구 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		n=Integer.parseInt(br.readLine());
		arr=new char[n][n];
		for(int i=0;i<n;i++) {
			 arr[i]=br.readLine().toCharArray();
		}
		visit=new boolean[n][n];
		answer=new int[n];
			
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				if(i==j)continue;
				if(arr[i][j]=='Y') {
					answer[i]+=1;
				}
				if(arr[i][j]=='N') {
					for(int k=0;k<n;k++) {
						if(arr[i][k]=='Y'&&arr[k][j]=='Y') {
							answer[i]+=1;
						}
						
					}
				}
			}
		}
		Arrays.sort(answer);
		System.out.println(answer[n-1]);
	}
	static int[] answer;
	static char[][] arr;
	static int n;
	static boolean[][] visit;
}
