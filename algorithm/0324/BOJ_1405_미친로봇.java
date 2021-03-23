package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1405_미친로봇 {
	static boolean[][] visit;
	static int[] dy = { 0, 0, 1, -1 };
	static int[] dx = { 1, -1, 0, 0 };
	static int n;
	static double result = 1;
	static double[] percent = new double[4];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] str = br.readLine().split(" ");
		n = Integer.parseInt(str[0]);
		for (int i = 1; i <= 4; i++) {
			percent[i - 1] = Double.parseDouble(str[i]) * 0.01;
		}
		visit = new boolean[32][32];
		visit[15][15] = true;
		dfs(15, 15, 0, 1.0);
		System.out.println(result);
	}

	private static void dfs(int y, int x, int level, double value) {

		if (level == n) {
			return;
		}
		visit[y][x] = true;

		for (int dir = 0; dir < 4; dir++) {
			int ny = y + dy[dir];
			int nx = x + dx[dir];
			if (visit[ny][nx]) {
				result-=value*percent[dir];
				continue;
			}
			visit[ny][nx] = true;
			dfs(ny, nx, level + 1, value * percent[dir]);
			visit[ny][nx] = false;

		}
	}

}

// 방문했던곳을 지나지 않는다 = 단순하다

// 단순한 확률을 구해라
// 방문했던 곳을 지나는 경우의 확률들을 1에서 뺴라.