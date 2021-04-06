package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ_1743_음식물피하기 {
	static int n, m, v;
	static int[][] arr;
	static int max = -1;
	static boolean[][] visit;
	static int dy[] = { 1, -1, 0, 0 };
	static int dx[] = { 0, 0, 1, -1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] str = br.readLine().split(" ");
		n = Integer.parseInt(str[0]);
		m = Integer.parseInt(str[1]);
		v = Integer.parseInt(str[2]);
		arr = new int[n][m];
		visit = new boolean[n][m];
		for (int i = 0; i < v; i++) {
			String[] temp = br.readLine().split(" ");
			int y = Integer.parseInt(temp[0])-1;
			int x = Integer.parseInt(temp[1])-1;
			arr[y][x] = 1;
		}

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (arr[i][j] == 1) {
					int mox = dfs(i, j);
					if(mox!=1)mox-=1;
					if(mox>max)max=mox;
				}
			}
		}
		System.out.println(max);
	}

	private static int dfs(int y, int x) {
		int cnt = 0;
		for (int dir = 0; dir < 4; dir++) {
			int ny = y + dy[dir];
			int nx = x + dx[dir];
			if (ny >= n || nx >= m || ny < 0 || nx < 0)
				continue;

			if (!visit[ny][nx] && arr[ny][nx] == 1) {
				visit[ny][nx] = true;
				cnt += dfs(ny, nx);
			}
		}

		return 1 + cnt;
	}
}
