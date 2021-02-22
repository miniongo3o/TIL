package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SWEA_2805_농작물수확하기 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		for(int t=1;t<=n;t++) {
			int m = Integer.parseInt(br.readLine());
			int[][] arr=new int[m][m];
			
			for(int i=0;i<m;i++) {
				String str=br.readLine();
				for(int j=0;j<m;j++) {
					arr[i][j]=str.charAt(j)-'0';
				}
			}
			
			
			int sum=0;
			int range=1;
			//윗쪽
			for(int i=0;i<m/2;i++) {
				int p=m/2-i;
				for(int j=0;j<range;j++) {
					sum+=arr[i][p+j];
					sum+=arr[m-1-i][p+j];
				}
				range+=2;
			}
			
			//아래쪽
			for(int i=0;i<m;i++) {
				sum+=arr[m/2][i];
			}
			System.out.println("#"+t+" "+sum);
		}
		
	}
}
