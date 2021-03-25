package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SEWA_3307_최장증가부분수열 {
	static int T;
	static int n;
	static int[] arr;
	static int[] dp;
	static int max;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		T=Integer.parseInt(br.readLine());
		for(int t=1;t<=T;t++) {
			n=Integer.parseInt(br.readLine());
			max=Integer.MAX_VALUE;
			arr=new int[n];
			dp=new int[n];
			String[] str=br.readLine().split(" ");
			for(int i=0;i<n;i++) {
				arr[i]=Integer.parseInt(str[i]);
				dp[i]=1;
			}
			
			for(int i=0;i<n;i++) {
				for(int j=0;j<i;j++) {
					if(arr[j]<arr[i]&&dp[i]<dp[j]+1) {
						dp[i]=dp[j]+1;
					}
				}
				if(max<dp[i])max=dp[i];
			}
			
			System.out.println("#"+t+" "+dp[n-1]);
		}
	}
}
