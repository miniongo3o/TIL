package JungOl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class JungOl_1681_해밀턴순환회로 {
	static int n;
	static int[][] arr;
	static boolean[] visit;
	static int min;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		min = Integer.MAX_VALUE;
		arr = new int[n][n];
		visit = new boolean[n];
		for (int i = 0; i < n; i++) {
			String[] str = br.readLine().split(" ");
			for (int j = 0; j < n; j++) {
				arr[i][j] = Integer.parseInt(str[j]);
			}
		}
		dfs(0,0,0);
		System.out.println(min);
	}

	public static void dfs(int y, int cnt, int sum) {
		if (sum >= min) {
			return;
		}

		if (cnt == n - 1) {
			if (arr[y][0] != 0) {
				min = Math.min(sum+arr[y][0], min);
			}
			return;
		}
		
		for (int i = 1; i < n; i++) {
			if (!visit[i]&&arr[y][i]!=0) {
				visit[i] = true;
				dfs(i, cnt + 1, sum + arr[y][i]);
				visit[i] = false;
			}
		}

	}
}
