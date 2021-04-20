package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BOJ_16234_인구이동 {
	static int[] dy = { 1, -1, 0, 0 };
	static int[] dx = { 0, 0, 1, -1 };
	static boolean[][] visit;
	static int n, R, L;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] str = br.readLine().split(" ");

		n = Integer.parseInt(str[0]);
		L = Integer.parseInt(str[1]);
		R = Integer.parseInt(str[2]);

		int[][] arr = new int[n][n];
		for (int i = 0; i < n; i++) {
			String[] temp = br.readLine().split(" ");
			for (int j = 0; j < n; j++) {
				arr[i][j] = Integer.parseInt(temp[j]);
			}
		}
		int change = 0;
	

		while (true) {	
			visit = new boolean[n][n];
			int[][] copied = copy(arr);
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if (!visit[i][j]) {
						bfs(i, j, copied);
					}
				}
			}

			if (check(arr, copied)) {
				change++;
			}else {
				break;
			}
			arr=copy(copied);
		}
		
		
		System.out.println(change);
	}

	private static void printer(int[][] arr) {
		System.out.println("===");
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println("===");
	}

	static class pos {
		int y, x;

		public pos(int y, int x) {
			this.y = y;
			this.x = x;
		}
	}

	public static int[][] copy(int[][] arr) {
		int[][] copied = new int[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				copied[i][j] = arr[i][j];
			}
		}
		return copied;
	}

	public static boolean check(int[][] copied, int[][] arr) {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (copied[i][j] != arr[i][j]) {
					return true;
				}
			}
		}
		return false;
	}

	public static void bfs(int r, int c, int[][] arr) {
		Queue<pos> q = new LinkedList();
		q.offer(new pos(r, c));
		visit[r][c] = true;
		List<pos> list = new ArrayList();
		list.add(new pos(r, c));
		int cnt = 1;
		int sum = arr[r][c];
		while (!q.isEmpty()) {
			pos p = q.poll();
			int y = p.y;
			int x = p.x;

			for (int dir = 0; dir < 4; dir++) {
				int ny = y + dy[dir];
				int nx = x + dx[dir];

				if (ny >= 0 && nx >= 0 && ny < n && nx < n && !visit[ny][nx]) {
					int res = Math.abs(arr[y][x] - arr[ny][nx]);
					if (res >= L && res <= R) {
						q.offer(new pos(ny, nx));
						visit[ny][nx] = true;
						cnt++;
						sum += arr[ny][nx];
						list.add(new pos(ny, nx));
					}
				}

			}
		}
		int res = sum / cnt;
		for (pos p : list) {
			arr[p.y][p.x] = res;
		}

	}
}
