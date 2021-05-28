package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

//3 5 7 9 11
//1 2 3 4 5 
public class BOJ_14425_문자열집합 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] str = br.readLine().split(" ");
		int n = Integer.parseInt(str[0]);
		int m = Integer.parseInt(str[1]);
		Set<String> set = new HashSet();
		for (int i = 0; i < n; i++) {
			set.add(br.readLine());
		}
		for (String key : set) {
		}
		int res = 0;
		for (int i = 0; i < m; i++) {
			String tar = br.readLine();
			if(set.contains(tar))res++;
		}
		System.out.println(res);

	}

}
