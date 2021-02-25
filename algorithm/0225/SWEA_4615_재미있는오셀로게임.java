package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SWEA_4615_재미있는오셀로게임 {
	static int n, m, arr[][];
	static int dc[] = { 0, 1, 1, 1, 0, -1, -1, -1 };
	static int dr[] = { -1, -1, 0, 1, 1, 1, 0, -1 };
	static int black, white;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= t; tc++) {
			String[] str = br.readLine().split(" ");
			n = Integer.parseInt(str[0]);
			m = Integer.parseInt(str[1]);
			arr = new int[n + 1][n + 1];
			int mid = n / 2;
			arr[mid][mid] = 2;
			arr[mid + 1][mid + 1] = 2;

			arr[mid + 1][mid] = 1;
			arr[mid][mid + 1] = 1;
			print();
			for (int k = 0; k < m; k++) {
				String[] temp = br.readLine().split(" ");
				int r = Integer.parseInt(temp[0]);
				int c = Integer.parseInt(temp[1]);
				int stone = Integer.parseInt(temp[2]);
				for (int dir = 0; dir < 8; dir++) {
					doit(r, c, dir, stone);
					print();
				}

			}
			counting();
			System.out.println("#" + tc + " " + black + " " + white);
		}
	}

	// 해당방향으로 가다가 0을만나면(빈곳) break.
	// 반대 색을 만나면 진행
	// 반대색 만나고 같은색만나면 그사이를 같은색으로 바꾸고 return
	private static void doit(int r, int c, int dir, int stone) {
		boolean flag = false;
		int nr = r;
		int nc = c;
		while (true) {

			nr = nr + dr[dir];
			nc = nc + dc[dir];
			// 범위를 벗어나거나 0을만나면(빈칸) 종료
			if (nr < 1 || nc < 1 || nr > n || nc > n || (arr[nr][nc] == 0)) {
				return;
			}

			// 중간에 다른돌을 만났다.
			if (arr[nr][nc] != stone) {
				flag = true;
				// 같은돌을 만났다.
			}
			if (arr[nr][nc] == stone /*|| arr[nr][nc] == 0*/) {
				// 같은돌을 만났으면서, 그전에 만났던 돌이 다른돌이면 처음부터 지금까지 다 같은돌로 바꿔준다
				if (flag) {
					
					int tempr = r;
					int tempc = c ;
					while (true) {
						if (tempr == nr && tempc == nc) {
							print();
							
							return;
						}
						arr[tempr][tempc] = stone;
						tempr += dr[dir];
						tempc += dc[dir];
					}
				}else {
					return;
				}
			}
		}
	}

	private static void counting() {
		white = 0;
		black = 0;
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				if (arr[i][j] == 1) {
					black += 1;
				}
				if (arr[i][j] == 2) {
					white += 1;
				}
			}
		}
	}

	private static void print() {
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				System.out.print(arr[i][j]);
			}
			System.out.println();
		}
		System.out.println("==========");
	}
}
