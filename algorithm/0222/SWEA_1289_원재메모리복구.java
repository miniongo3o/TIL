package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SWEA_1289_원재메모리복구 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		for(int t=1;t<=n;t++) {
			String str=br.readLine();
			int sum=0;
			if(str.charAt(0)=='1')sum=1;
			for(int i=0;i<str.length()-1;i++) {
				if(str.charAt(i)!=str.charAt(i+1)) {
					sum+=1;
				}
			}
			System.out.println("#"+t+" "+sum);
		}
	}
}
