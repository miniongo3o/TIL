package ssafy_algo_0209;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SWEA_1233_사칙연산유효성검사 {
	static char[] arr;
	static int N;
	public static boolean inner(int n) {
		return (1<=n&&n<=N&&arr[n]==0);
	}
	public static boolean answer(int n) {
		if (n > N)return false;
		char c = arr[n];
		if ('0' <= c && c <= '9') {
			if ((inner(n * 2) && inner(n * 2 + 1)) || (n * 2 > N) && (n * 2 + 1 > N))
				return true;
			return false;
		} else
			return (answer(n * 2) & answer(n * 2 + 1));
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int t = 1; t <= 10; t++) {
			N = Integer.parseInt(br.readLine());
			arr = new char[202];
			for (int i = 1; i <= N; i++) {
				String[] str = br.readLine().split(" ");
				
				arr[i] = str[1].charAt(0);
			}

			int result = (answer(1) == true) ? 1 : 0;
			System.out.println("#" + t + " " + result);
		}

	}
}
