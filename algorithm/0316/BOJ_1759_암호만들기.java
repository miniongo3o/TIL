package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

import javax.sound.midi.Synthesizer;

public class BOJ_1759_암호만들기 {
	static String temp[];
	static char[] arr;
	static int n, m;
	static int result[];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] str = br.readLine().split(" ");

		n = Integer.parseInt(str[0]);
		m = Integer.parseInt(str[1]);

		temp = br.readLine().split(" ");
		arr = new char[m];
		result = new int[m];
		for (int i = 0; i < m; i++) {
			arr[i] = temp[i].charAt(0);
		}
		Arrays.sort(arr);
		dfs(0, 0, 0, 0);

	}

	private static void dfs(int startIdx, int cnt, int ja, int mo) {

		for (int i = startIdx; i < m; i++) {
			result[i] = 1;
			dfs(i + 1, cnt + 1, ja + (!isMo(arr[i]) ? 1 : 0), mo + (!isMo(arr[i]) ? 0 : 1));
			result[i] = 0;
		}

		if (cnt == n && ja >= 2 && mo >= 1) {
			print();
		}

	}

	private static void print() {
		for (int j = 0; j < m; j++) {
			if (result[j] == 1) {
				System.out.print(arr[j]);
			}

		}
		System.out.println();
	}

	private static boolean isMo(char c) {
		if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
			return true;
		}

		return false;
	}
}
