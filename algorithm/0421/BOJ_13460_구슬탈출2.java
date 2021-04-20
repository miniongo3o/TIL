package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_13460_구슬탈출2 {
	static class pos {
		int y, x,dir;
		boolean isAlive;

		public pos(int y, int x, boolean isAlive,int dir) {
			this.y = y;
			this.x = x;
			this.isAlive = isAlive;
			this.dir=dir;
		}

		public pos() {
			super();
		}
	}

	static int n, m;
	static int[] dy = { 1, -1, 0, 0 };
	static int[] dx = { 0, 0, 1, -1 };
	static int min = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] str = br.readLine().split(" ");
		n = Integer.parseInt(str[0]);
		m = Integer.parseInt(str[1]);
		pos O = new pos();
		pos R = new pos();
		pos B = new pos();
//		String[][] arr = new String[n][m];
		char[][] arr=new char[n][m];
		for (int i = 0; i < n; i++) {
			String temp = br.readLine();
			for (int j = 0; j < m; j++) {
//				arr[i][j] = temp[j];
				arr[i]=temp.toCharArray();
				if (arr[i][j]=='O') {
					O = new pos(i, j, true,0);
				} else if (arr[i][j]=='R') {
					R = new pos(i, j, true,4);
				} else if (arr[i][j]=='B') {
					B = new pos(i, j, true,4);
				}
			}
		}
		dfs(arr, R, B, 0);
		if (min == Integer.MAX_VALUE)

		{
			System.out.println(-1);
		} else {
			System.out.println(min);
		}

	}

	static int cnt;

	public static void dfs(char[][] arr, pos r, pos b, int idx) {
		if (idx > 10) {
			return;
		}

		for (int dir = 0; dir < 4; dir++) {
			if(dir==r.dir)continue;
			pos nr = new pos(r.y, r.x, r.isAlive,r.dir);
			pos nb = new pos(b.y, b.x, b.isAlive,b.dir);
			char[][] copied = copy(arr);
			if (redFirst(r, b, dir)) {
				move(nr, copied, dir);
				move(nb, copied, dir);
			} else {
				move(nb, copied, dir);
				move(nr, copied, dir);
			}

			if (!b.isAlive) {
				return;
			}

			if (!r.isAlive) {
				min = Math.min(min, idx);
				return;
			}
			if (min > idx + 1) {
				dfs(copied, nr, nb, idx + 1);
			}

		}

	}
	
	public static boolean redFirst(pos r, pos b, int dir) {
		// 빨강이 먼저 움직여야하면 true,아니면 false
		if (dir == 0) {
			// 아래
			return (r.y > b.y) ? true : false;
		} else if (dir == 1) {
			// 위
			return (r.y < b.y) ? true : false;
		} else if (dir == 2) {
			// 오른쪽
			return (r.x > b.x) ? true : false;
		} else if (dir == 3) {
			// 왼쪽
			return (r.x < b.x) ? true : false;
		}

		return true;
	}

	public static char[][] copy(char[][] arr) {
		char[][] copied = new char[n][m];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				copied[i][j] = arr[i][j];
			}
		}
		return copied;
	}

	public static void move(pos first, char[][] arr, int dir) {
		// 빨강이 먼저 구멍을 만나면 true, 아니면 false return 하도록
		// 하상우좌
		// 다른 공을 만나면 멈춤..
		int y = first.y;
		int x = first.x;
		char str = arr[y][x];
		int ny = y;
		int nx = x;

		while (true) {
			ny += dy[dir];
			nx += dx[dir];

			// 구멍을 만났을 때
			if (arr[ny][nx]=='O') {
				first.isAlive = false;
				arr[y][x] = '.';
				return;
			}

			// 이동할 수 없을 떄 = 다른 공이거나 벽
			if (!(arr[ny][nx]=='.')) {
				// 벽
				ny -= dy[dir];
				nx -= dx[dir];
				break;
			}
		}
		arr[y][x] = '.';
		arr[ny][nx] = str;
		first.y = ny;
		first.x = nx;

		return;

	}

	public static void printer(char[][] arr) {
		System.out.println("===");
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println("===");
	}
}
