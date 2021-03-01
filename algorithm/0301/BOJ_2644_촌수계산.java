package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_2644_촌수계산 {
	static int n, m, start, answer = Integer.MAX_VALUE, dest, arr[][];
	static boolean[] visit;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		String[] str = br.readLine().split(" ");
		start = Integer.parseInt(str[0]);
		dest = Integer.parseInt(str[1]);

		arr = new int[n + 1][n + 1];
		m = Integer.parseInt(br.readLine());
		visit = new boolean[n + 1];
		for (int i = 0; i < m; i++) {
			String[] temp = br.readLine().split(" ");
			int from = Integer.parseInt(temp[0]);
			int to = Integer.parseInt(temp[1]);
			arr[from][to] = 1;
			arr[to][from] = 1;
		}

		dfs(start, 1);
		if (answer == Integer.MAX_VALUE) {
			System.out.println(-1);
		} else {
			System.out.println(answer);
		}
	}

	private static void dfs(int num, int cnt) {
		for (int i = 1; i <= n; i++) {
			if (arr[num][i] == 1 && i == dest) {
				System.out.println("answer is " + num + "," + i);
				answer = Math.min(answer, cnt);
				return;
			}
			if (arr[num][i] == 1 && !visit[i]) {
				visit[i] = true;
				System.out.println(num + " to " + i);
				dfs(i, cnt + 1);
			}
		}

	}
}
