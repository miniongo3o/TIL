package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SWEA_9997_미니멀리즘시계 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		int n=Integer.parseInt(br.readLine());
		for(int t=1;t<=n;t++) {
			int a=Integer.parseInt(br.readLine());
			int b=a*2;
			int time=b/60;
			int minute=b-time*60;
			System.out.println("#"+t+" "+time+" "+minute);
		}
	}
}
