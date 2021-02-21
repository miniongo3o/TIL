package com.ssafy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SWEA_10200_구독자전쟁 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int n=Integer.parseInt(br.readLine());
		
		for(int t=1;t<=n;t++) {
			StringTokenizer st=new StringTokenizer(br.readLine());
			int total=Integer.parseInt(st.nextToken());
			int a=Integer.parseInt(st.nextToken());
			int b=Integer.parseInt(st.nextToken());
			
			// 둘 중 작은 값이, 가장 큰 값
			int maxResult=Math.min(a, b);
			int minResult=0;
			// 둘 중 큰값?
			int max=Math.max(a, b);
			int min=maxResult;
			int temp=total-max;
			
			if(temp>min) {
				minResult=0;
			}else {
				minResult=min-temp;
			}
					
			System.out.println("#"+t+" "+maxResult+" "+minResult);
		}
	}
}
