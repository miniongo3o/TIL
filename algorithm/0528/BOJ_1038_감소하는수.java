package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ_1038_감소하는수 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		long n=Integer.parseInt(br.readLine());
		if(n>=0&&n<=10) {
			System.out.println(n);
			return;
		}
		long idx=10;
		for(long i=20;i<1000000;i++) {
			String s=String.valueOf(i);
			int len=s.length();
			boolean flag=true;
			for(int j=0;j<len-1;j++) {
				if(s.charAt(j)-'0'<=s.charAt(j+1)-'0') {
					flag=false;
					break;
				}
			}
			
			if(flag) {
				idx++;
				if(idx==n) {
					System.out.println(i);
					return;
				}
			}
			
		}
		System.out.println(-1);
	}
}
