package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1543_문서검색 {
	static int n,m;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		String find = br.readLine();
		String str2=str.replaceAll(find, "");
		System.out.println((str.length()-str2.length())/find.length());
	} 

}
