package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_1976 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		int N=Integer.parseInt(br.readLine());
		for(int i=1;i<=N;i++){
			
			StringTokenizer st=new StringTokenizer(br.readLine());
			int h1=Integer.parseInt(st.nextToken());
			int m1=Integer.parseInt(st.nextToken());
			int h2=Integer.parseInt(st.nextToken());
			int m2=Integer.parseInt(st.nextToken());
			
			int resultH=h1+h2;
			int resultM=m1+m2;
			
			if(resultM>=60) {
				resultM-=60;
				resultH+=1;
			}
			
			if(resultH>=13) {
				resultH-=12;
			}
			System.out.println("#"+i+" "+resultH+" "+resultM);
			
		}
	}
}
