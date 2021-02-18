package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SWEA_10570_제곱팰린드롬 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		for (int t = 1; t <= N; t++) {
			int cnt = 0;
			String[] str = br.readLine().split(" ");
			int a = Integer.parseInt(str[0]);
			int b = Integer.parseInt(str[1]);

			for (int i = a; i <= b; i++) {
				double sqr = Math.sqrt(i);
				if (isit(i) && (sqr == (int) sqr)) {
					if (isit((int)sqr)) {
						cnt++;
					}
				}

			}
			System.out.println("#" + t + " " + cnt);

		}

	}

	private static boolean isit(int n) {

		String s = Integer.toString(n);
		int len = s.length();
		if (len == 1) {
			return true;
		}

		if (len % 2 == 0) {

			for (int i = 0; i < len / 2; i++) {
				if (s.charAt(i) != s.charAt(len - 1 - i)) {
					return false;
				}
			}
			return true;

		} else {

			for (int i = 0; i < len / 2; i++) {
				if (s.charAt(i) != s.charAt(len - 1 - i)) {
					return false;
				}
			}
			return true;
		}
	}
}