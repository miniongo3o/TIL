package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ_2206_벽부수고이동하기 {
	static int n, m, min;
	static int[][] visit;
	static int[][] arr;
	static int[] dx = { 1, 0, -1, 0 };
	static int[] dy = { 0, 1, 0, -1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] str = br.readLine().split(" ");
		n = Integer.parseInt(str[0]);
		m = Integer.parseInt(str[1]);
		arr = new int[n][m];
		visit = new int[n][m];
		for (int i = 0; i < n; i++) {
			String[] temp = br.readLine().split("");
			for (int j = 0; j < m; j++) {
				arr[i][j] = Integer.parseInt(temp[j]);
				visit[i][j] = Integer.MAX_VALUE;
			}
		}
		min = Integer.MAX_VALUE;
		bfs();
		if (min == Integer.MAX_VALUE) {
			System.out.println(-1);
		} else {
			System.out.println(min);
		}
	}

	static class pos {
		int y, x;
		int cnt;
		int crash;

		public pos(int y, int x, int cnt, int crash) {
			this.y = y;
			this.x = x;
			this.cnt = cnt;
			this.crash = crash;
		}
	}

	private static void bfs() {
		Queue<pos> q = new LinkedList<pos>();
		q.offer(new pos(0, 0, 1, 0));
		visit[0][0] = 0;

		while (!q.isEmpty()) {
			pos p = q.poll();
			int y = p.y;
			int x = p.x;
			int cnt = p.cnt;
			int crash = p.crash;
			if (y == n - 1 && x == m - 1) {
				min = cnt;
				break;
			}
			for (int dir = 0; dir < 4; dir++) {
				int ny = y + dy[dir];
				int nx = x + dx[dir];

				if (ny >= 0 && nx >= 0 && ny < n && nx < m) {

		

		
					if (visit[ny][nx] <= crash) {
						continue;
					}
					
					if (arr[ny][nx] == 0) {
						visit[ny][nx] = crash;
						q.offer(new pos(ny, nx, cnt + 1, crash));

					} else {
						if (crash == 0) {
							visit[ny][nx] = crash + 1;
							q.offer(new pos(ny, nx, cnt + 1, crash + 1));
						}
					}
				}
			}
		}
	}

}
