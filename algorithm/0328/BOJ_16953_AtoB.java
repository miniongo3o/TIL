package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ_16953_AtoB {
	static int n;
	static int m;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] str = br.readLine().split(" ");
		n = Integer.parseInt(str[0]);
		m = Integer.parseInt(str[1]);
		int cnt=0;
		while(true) {
			
			if(n>m) {
				System.out.println(-1);
				break;
			}
			if(n==m) {
				System.out.println(cnt+1);
				break;
			}
			
			if(m%10==1) {
				m/=10;
			}else if(m%2==0) {
				m/=2;
			}else {
				System.out.println(-1);
				break;
			}
			
			cnt++;
			
			
			
			
		}
	}

	
}
