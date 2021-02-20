package com.ssafy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SWEA_10032_과자분배 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		for(int t=1;t<=n;t++) {
			String[] str=br.readLine().split(" ");
			int a=Integer.parseInt(str[0]);
			int b=Integer.parseInt(str[1]);
			int result=a%b;
			sb.append("#"+t+" "+result+"\n");
		}
		System.out.println(sb);
	}
}
