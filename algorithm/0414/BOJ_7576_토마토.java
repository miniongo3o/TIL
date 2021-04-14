package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ_7576_토마토 {
	//  상하좌우 
	static int[] dy = { 1, -1, 0, 0 };
	static int[] dx = { 0, 0, 1, -1 };

	static class pos {
		int y, x;
		int cnt;

		public pos(int y, int x, int cnt) {
			this.y = y;
			this.x = x;
			this.cnt = cnt;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] str = br.readLine().split(" ");
		int m = Integer.parseInt(str[0]);
		int n = Integer.parseInt(str[1]);
		int[][] arr = new int[n][m];

		Queue<pos> q = new LinkedList();
		boolean[][] visit = new boolean[n][m];

		int fresh = 0;
		int unfresh = 0;
		for (int i = 0; i < n; i++) {
			String[] temp = br.readLine().split(" ");
			for (int j = 0; j < m; j++) {
				arr[i][j] = Integer.parseInt(temp[j]);
				if (arr[i][j] == 1) {
					q.offer(new pos(i, j, 0));
					visit[i][j] = true;
				} else if (arr[i][j] == 0) {
					fresh++;
				} else {
					visit[i][j] = true;
				}
			}
		}
		int max = -1;
		// 한개도 없는 경우
		if (fresh == 0) {
			System.out.println(0);
			return;
		}

		// bfs확인
		while (!q.isEmpty()) {
			// 익은 토마토의 갯수가 증가해서 익지않은 토마토의 총 갯수와 같아지면 다 익은것
			if (unfresh == fresh) {
				System.out.println(max + 1);
				return;
			}
			pos p = q.poll();
			int y = p.y;
			int x = p.x;
			int cnt = p.cnt;
			max = (cnt > max ? cnt : max);

			// 같은 높이 상하좌우
			for (int dir = 0; dir < 4; dir++) {
				int ny = y + dy[dir];
				int nx = x + dx[dir];
				if (ny < 0 || nx < 0 || ny >= n || nx >= m)
					continue;
				if (!visit[ny][nx] && arr[ny][nx] == 0) {
					visit[ny][nx] = true;
					arr[ny][nx] = 1;
					unfresh++;
					q.offer(new pos(ny, nx, cnt + 1));
				}

			}

		}

		// 체크 : 익지 않은 토마토가 하나라도 있으면 -1 return
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					if (arr[i][j] == 0) {
						System.out.println(-1);
						return;
					}
				}
			}
		System.out.println(max);

	}

}
