package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ_14502_연구소 {
	static int n, m;
	static int arr[][], temp[][];
	static int dx[] = { 1, 0, -1, 0 };
	static int dy[] = { 0, 1, 0, -1 };
	static int max = -1;

	static class pos {
		int y, x;

		public pos(int y, int x) {
			super();
			this.y = y;
			this.x = x;
		}
	}

	static boolean visit[][];

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] str = br.readLine().split(" ");
		n = Integer.parseInt(str[0]);
		m = Integer.parseInt(str[1]);
		arr = new int[n][m];

		for (int i = 0; i < n; i++) {
			str = br.readLine().split(" ");
			for (int j = 0; j < m; j++) {
				arr[i][j] = Integer.parseInt(str[j]);
			}
		}

		comb(0, new pos[3], 0);
		if (max == -1) {
			max = 0;
		}
		System.out.println(max);
	}

	// 3개의 벽을 세울 조합을 구함.
	private static void comb(int toSelect, pos[] selected, int start) {

		if (toSelect == 3) {
			temp = new int[n][m];
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					temp[i][j] = arr[i][j];
				}
			}

			for (int i = 0; i < 3; i++) {

				temp[selected[i].y][selected[i].x] = 1;

			}

			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					if (temp[i][j] == 2) {
						spread(i, j);
					}
				}
			}

			max = Math.max(max, counting());

			return;

		}

		for (int i = start; i < n*m; i++) {

			int y = i / m;
			int x = i % m;

			if (arr[y][x] == 0) {
				selected[toSelect] = new pos(y, x);
				comb(toSelect + 1, selected,i+1);
			}
		}
	}

	// 바이러스가 퍼짐
	private static void spread(int y, int x) {

		for (int dir = 0; dir < 4; dir++) {
			int ny = y + dy[dir];
			int nx = x + dx[dir];
			if (ny >= 0 && nx >= 0 && ny < n && nx < m && temp[ny][nx] == 0) {
				temp[ny][nx] = 2;
				spread(ny, nx);
			}
		}

	}

	private static int counting() {
		int count = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (temp[i][j] == 0) {
					count++;
				}
			}
		}

		return count;
	}
}
