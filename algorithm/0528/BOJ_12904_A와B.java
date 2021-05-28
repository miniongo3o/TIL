package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_12904_A와B {
	static String tar;
	static int answer = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer s=new StringBuffer(br.readLine());
		StringBuffer t=new StringBuffer(br.readLine());
		
		while(s.length()<t.length()) {
			if(t.charAt(t.length()-1)=='A') {
				t.deleteCharAt(t.length()-1);
			}else if(t.charAt(t.length()-1)=='B') {
				t.deleteCharAt(t.length()-1);
				t.reverse();
			}
		}
		if(t.toString().equals(s.toString())) {
			System.out.println(1);
		}else {
			System.out.println(0);
		}
		
	}
}
