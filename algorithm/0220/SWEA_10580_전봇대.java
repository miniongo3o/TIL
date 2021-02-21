package com.ssafy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SWEA_10580_전봇대 {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb=new StringBuilder();
		
		int n=Integer.parseInt(br.readLine());
		for(int t=1;t<=n;t++) {
			int m=Integer.parseInt(br.readLine());
			int[][] arr=new int[m][2];
			for(int i=0;i<m;i++) {
				String[] str=br.readLine().split(" ");
				arr[i][0]=Integer.parseInt(str[0]);
				arr[i][1]=Integer.parseInt(str[1]);
			}
			
			int answer=0;
			for(int i=0;i<m-1;i++) {
				int y1=arr[i][0];
				int y2=arr[i][1];
				for(int j=i+1;j<m;j++) {
					int nexty1=arr[j][0];
					int nexty2=arr[j][1];
					
					if(y1>nexty1&&y2>nexty2) {
						continue;
					}
					
					if(y1<nexty1&&y2<nexty2) {
						continue;
					}
					answer++;
				}
				
			}
			sb.append("#"+t+" "+answer+"\n");
		}
		System.out.println(sb);
	}
}
