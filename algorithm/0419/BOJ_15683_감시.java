package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class BOJ_15683_감시 {
	static int[] dy = { -1, 1, 0, 0 };
	static int[] dx = { 0, 0, -1, 1 };
	static List<pos> list;
	static int min = Integer.MAX_VALUE;

	static class pos {
		int y, x, type;

		public pos(int y, int x, int type) {
			this.y = y;
			this.x = x;
			this.type = type;
		}
	}

	static int n;
	static int m;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] str = br.readLine().split(" ");
		n = Integer.parseInt(str[0]);
		m = Integer.parseInt(str[1]);
		int[][] arr = new int[n][m];
		list = new ArrayList();
		for (int i = 0; i < n; i++) {
			String[] temp = br.readLine().split(" ");
			for (int j = 0; j < m; j++) {
				arr[i][j] = Integer.parseInt(temp[j]);
				if (arr[i][j] != 0 && arr[i][j] != 6) {
					list.add(new pos(i, j, arr[i][j]));
				}
			}
		}

		dfs(arr, 0);

		System.out.println(min);

	}

	public static int count(int[][] arr) {
		int cnt = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (arr[i][j] == 0) {
					cnt++;
				}
			}
		}

		return cnt;
	}

	// 먼저 list.foreach()로 하나씩 돌림
	// e(해당 cctv)의 방향에 따른 경우의 수 하나를 copied 배열에 적용.
	// 해당 copied배열을 다음 cctv 에 전달?
	public static void printer(int[][] arr) {
		System.out.println("=================");
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println("===============");
	}

	public static void dfs(int[][] arr, int idx) {
		if (idx >= list.size()) {
			int cnt = count(arr);
			min = Math.min(min, cnt);
			return;
		}
		pos cctv = list.get(idx);
		int y = cctv.y;
		int x = cctv.x;
		int type = cctv.type;
		int[][] copied;
		if (type == 1) {
			// 한쪽 방향만 체크하는 타입
			// 4가지 방향을 돌려봐야함
			for (int dir = 0; dir < 4; dir++) {
				copied = copy(arr);
				marking(dir, copied, y, x);

				// TODO: cctv파라미터에 다음 cctv넘겨주기
				dfs(copied, idx + 1);
			}

		} else if (type == 2) {
			// 양방향
			for (int dir = 0; dir < 2; dir++) {
				copied = copy(arr);

				if (dir == 0) {
					// 상하
					marking(0, copied, y, x);
					marking(1, copied, y, x);

				} else {
					// 좌우
					marking(2, copied, y, x);
					marking(3, copied, y, x);
				}
				dfs(copied, idx + 1);
			}

		} else if (type == 3) {
			// 직각
			for (int dir = 0; dir < 4; dir++) {
				copied = copy(arr);
				if (dir == 0) {
					// 좌상
					marking(0, copied, y, x);
					marking(2, copied, y, x);

				} else if (dir == 1) {
					// 상우
					marking(0, copied, y, x);
					marking(3, copied, y, x);

				} else if (dir == 2) {
					// 우하
					marking(1, copied, y, x);
					marking(3, copied, y, x);

				} else {
					// 좌하
					marking(1, copied, y, x);
					marking(2, copied, y, x);
				}
				dfs(copied, idx + 1);
			}

		} else if (type == 4) {
			// 세방향
			for (int dir = 0; dir < 4; dir++) {
				copied = copy(arr);
				if (dir == 0) {
					marking(0, copied, y, x);
					marking(1, copied, y, x);
					marking(2, copied, y, x);
				} else if (dir == 1) {
					marking(1, copied, y, x);
					marking(2, copied, y, x);
					marking(3, copied, y, x);

				} else if (dir == 2) {
					marking(2, copied, y, x);
					marking(3, copied, y, x);
					marking(0, copied, y, x);
				} else {
					marking(3, copied, y, x);
					marking(0, copied, y, x);
					marking(1, copied, y, x);
				}
				dfs(copied, idx + 1);
			}

		} else if (type == 5) {
			// 상하좌우
			copied = copy(arr);
			marking(0, copied, y, x);
			marking(1, copied, y, x);
			marking(2, copied, y, x);
			marking(3, copied, y, x);
			dfs(copied, idx + 1);

		}
	}

	public static void marking(int dir, int[][] arr, int y, int x) {
		int ny = y, nx = x;
		while (true) {
			ny = ny + dy[dir];
			nx = nx + dx[dir];

			// 범위를 벗어나면 그만
			if (ny < 0 || nx < 0 || ny >= n || nx >= m || arr[ny][nx] == 6) {
				break;
			}
			// cctv면 지나침
			if (arr[ny][nx] > 0 && arr[ny][nx] < 6)
				continue;
			// 9는 벽을 의미
			arr[ny][nx] = 9;

		}
	}

	public static int[][] copy(int[][] arr) {
		int[][] copied = new int[n][m];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				copied[i][j] = arr[i][j];
			}
		}
		return copied;
	}
}
