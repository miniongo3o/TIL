package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_2941_크로아티아알파벳 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		StringBuilder sb = new StringBuilder();
		int sum = 0;
		for (int i = 0; i < str.length(); i++) {
			char a = str.charAt(i);
			switch (a) {
			case 'c':
				if (i + 1 < str.length() && (str.charAt(i + 1) == '=' || str.charAt(i + 1) == '-')) {
					i+=1;
				}
				sum += 1;
				break;

			case 'd':

				if (i + 2 < str.length() && str.charAt(i + 1) == 'z' && str.charAt(i + 2) == '=') {
					i+=2;
				}
				
				if(i+1<str.length()&&str.charAt(i+1)=='-') {
					i+=1;
				}
				
				sum+=1;
				break;
				
			case 'l':
				if(i+1<str.length()&&str.charAt(i+1)=='j') {
					i+=1;
				}
				sum+=1;
				break;
			case 'n':
				if(i+1<str.length()&&str.charAt(i+1)=='j') {
					i+=1;
				}
				sum+=1;
				break;
			case 's':
				if(i+1<str.length()&&str.charAt(i+1)=='=') {
					i+=1;
				}
				sum+=1;
				break;
			case 'z':
				if(i+1<str.length()&&str.charAt(i+1)=='=') {
					i+=1;
				}
				sum+=1;
				break;
			default:
				sum+=1;
			}

		}
		System.out.println(sum);
	}
}
