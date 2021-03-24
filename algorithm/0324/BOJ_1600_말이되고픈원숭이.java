package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

//1
//4 4
//0 0 0 0
//1 0 0 0
//0 0 1 0
//0 1 0 0
public class BOJ_1600_말이되고픈원숭이 {
	static int[] dy = { 0, 1, 0, -1 };
	static int[] dx = { 1, 0, -1, 0 };
	static int[] horseDy = { 1, 2, 2, 1, -1, -2, -2, -1 };
	static int[] horseDx = { 2, 1, -1, -2, -2, -1, 1, 2 };
	static int[][] arr;
	static int k, n, m;
	static int min = Integer.MAX_VALUE;
	static boolean[][][] visit;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		k = Integer.parseInt(br.readLine());
		String[] str = br.readLine().split(" ");
		n = Integer.parseInt(str[0]);
		m = Integer.parseInt(str[1]);
		arr = new int[201][201];
		visit = new boolean[201][201][31];
		for (int i = 0; i < n; i++) {
			String[] temp = br.readLine().split(" ");
			for (int j = 0; j < m; j++) {
				arr[i][j] = Integer.parseInt(temp[j]);
			}
		}

		
		System.out.println(bfs(0, 0));

	}

	static class pos {
		int y, x, cnt, horse;

		public pos(int y, int x, int cnt, int horse) {
			super();
			this.y = y;
			this.x = x;
			this.cnt = cnt;
			this.horse = horse;
		}
	}

	private static int bfs(int r, int c) {
		Queue<pos> q = new LinkedList<pos>();
		q.offer(new pos(r, c, 0, 0));
		visit[r][c][0] = true;
		while (!q.isEmpty()) {
			pos p = q.poll();
			int y = p.y;
			int x = p.x;
			int cnt = p.cnt;
			int horse = p.horse;

			if (y == n - 1 && x == m - 1) {
				return cnt;
			}

			if (horse < k) {
				for (int dir = 0; dir < 8; dir++) {
					int ny = y + horseDy[dir];
					int nx = x + horseDx[dir];

					if (ny >= 0 && nx >= 0 && ny < n && nx < m && arr[ny][nx] != 1) {
						if (!visit[ny][nx][horse + 1] && arr[ny][nx] == 0) {
							visit[ny][nx][horse + 1] = true;
							System.out.println(horse);
							q.offer(new pos(ny, nx, cnt + 1, horse + 1));
						}
					}
				}
			}

			for (int dir = 0; dir < 4; dir++) {
				int ny = y + dy[dir];
				int nx = x + dx[dir];

				if (ny >= 0 && nx >= 0 && ny < n && nx < m && !visit[ny][nx][horse] && arr[ny][nx] ==0) {
					visit[ny][nx][horse] = true;
					System.out.println(horse);
					q.offer(new pos(ny, nx, cnt + 1, horse));
				}
			}
		}
		return -1;
	}
}
