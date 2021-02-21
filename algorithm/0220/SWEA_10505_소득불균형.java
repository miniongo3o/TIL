package com.ssafy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SWEA_10505_소득불균형 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int n=Integer.parseInt(br.readLine());
		StringBuilder sb=new StringBuilder();
		for(int t=1;t<=n;t++) {
			int m=Integer.parseInt(br.readLine());
			String[] str=br.readLine().split(" ");
			int arr[]= new int[m];
			int sum=0;
			int cnt=0;
			for(int i=0;i<m;i++) {
				arr[i]=Integer.parseInt(str[i]);
				sum+=arr[i];
			}
			double avg=sum/m;
			for(int i=0;i<m;i++) {
				if(arr[i]<=avg) {
					cnt++;
				}
			}
			sb.append("#"+t+" "+cnt+"\n");
		}
		System.out.println(sb);
	}
}
