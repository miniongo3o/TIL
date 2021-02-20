package com.ssafy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SWEA_10059_유효기간 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int n=Integer.parseInt(br.readLine());
		StringBuilder sb=new StringBuilder();
		
		for(int t=1;t<=n;t++) {
			String str=br.readLine();

			String s1=Character.toString(str.charAt(0))+Character.toString(str.charAt(1));
			String s2=Character.toString(str.charAt(2))+Character.toString(str.charAt(3));
			if(s1.charAt(0)=='0') {
				s1=Character.toString(s1.charAt(1));
			}
			
			if(s2.charAt(0)=='0') {
				s2=Character.toString(s2.charAt(1));
			}
			System.out.println(s1+" "+s2);
			int a1=Integer.parseInt(s1);
			int a2=Integer.parseInt(s2);
			
			if(a1>12&&a2>12||a1==0&&a2==0) {
				sb.append("#"+t+" "+"NA\n");
			}else if(a1<13&&a2<13&&a1>0&&a2>0) {
				sb.append("#"+t+" "+"AMBIGUOUS\n");
				//앞의 것만 12넘음 = YYMM
			}else if(a1<13) {
				sb.append("#"+t+" "+"MMYY\n");
				//뒤의것만 12넘음 = MMYY
			}else if(a2>13) {
				sb.append("#"+t+" "+"YYMM\n");
			}
			
		}
		System.out.println(sb);
	}
}
