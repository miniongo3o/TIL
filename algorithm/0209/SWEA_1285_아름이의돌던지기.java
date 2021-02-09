package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SWEA_1285_아름이의돌던지기 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		for(int t=1;t<=N;t++) {
			int x=Integer.parseInt(br.readLine());
			String[] str=br.readLine().split(" ");
			int cnt=0;
			int min=-1;
			for(int i=0;i<x;i++) {
				if(Math.abs(Integer.parseInt(str[i]))<min) {
					min=Math.abs(Integer.parseInt(str[i]));
					cnt=1;
				}else if( Math.abs(Integer.parseInt(str[i]))==min){
					cnt+=1;
				}
			}
		}
	}
}
