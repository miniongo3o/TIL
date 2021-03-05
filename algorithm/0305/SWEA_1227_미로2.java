package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SWEA_1227_미로2 {
	static int n;
	static int[][] arr;
	static int destx, desty;
	static int startx, starty, answer;
	static int dy[] = { 0, 1, 0, -1 };
	static int dx[] = { 1, 0, -1, 0 };
	static boolean[][] visit;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		for (int t = 1; t <= 10; t++) {
			br.readLine();
			
			visit = new boolean[100][100];
			arr = new int[100][100];
			for (int i = 0; i < 100; i++) {
				String str = br.readLine();
				for (int j = 0; j < 100; j++) {
					arr[i][j] = str.charAt(j) - '0';
					if (arr[i][j] == 2) {
						startx = j;
						starty = i;
					}

					if (arr[i][j] == 3) {
						destx = j;
						desty = i;
					}
				}
			}

			answer = 0;
			dfs(starty, startx);
			sb.append("#" + t + " " + answer + "\n");
		}
		System.out.println(sb);
	}

	private static void dfs(int y, int x) {
		if (y == desty && x == destx) {
			answer = 1;
			return;
		}

		for (int i = 0; i < 4; i++) {
			int ny = y + dy[i];
			int nx = x + dx[i];
			if (ny >= 0 && nx >= 0 && ny < 100 && nx < 100 && arr[ny][nx] != 1 && !visit[ny][nx]) {
				visit[ny][nx] = true;
				dfs(ny, nx);
			}
		}

	}
}
