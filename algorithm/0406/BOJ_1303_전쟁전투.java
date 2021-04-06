package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ_1303_전쟁전투 {
	static int n, m, v;
	static char[][] arr;
	static boolean[][] visit;
	static int dy[] = { 1, -1, 0, 0 };
	static int dx[] = { 0, 0, 1, -1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] str = br.readLine().split(" ");
		n = Integer.parseInt(str[1]);
		m = Integer.parseInt(str[0]);
		arr = new char[n][m];
		visit = new boolean[n][m];

		for (int i = 0; i < n; i++) {
			String temp = br.readLine();
			arr[i] = temp.toCharArray();
		}
		int sumW = 0;
		int sumB = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (arr[i][j] == 'W' && !visit[i][j]) {
					int mox = dfs(i, j, 'W');
					if (mox != 1)
						mox -= 1;
					sumW += (mox * mox);
				} else if (arr[i][j] == 'B' && !visit[i][j]) {
					int mox = dfs(i, j, 'B');
					if (mox != 1)
						mox -= 1;
					sumB += (mox * mox);
				}
			}
		}
		System.out.println(sumW+" "+sumB);

	}

	private static int dfs(int y, int x, char v) {
		int cnt = 0;
		for (int dir = 0; dir < 4; dir++) {
			int ny = y + dy[dir];
			int nx = x + dx[dir];
			if (ny >= n || nx >= m || ny < 0 || nx < 0)
				continue;

			if (!visit[ny][nx] && arr[ny][nx] == v) {
				visit[ny][nx] = true;
				cnt += dfs(ny, nx, v);
			}
		}

		return 1 + cnt;
	}
}
