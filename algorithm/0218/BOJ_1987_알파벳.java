package algo_hw;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ_1987_알파벳 {
	static int[] dx = { 1, 0, -1, 0 };
	static int[] dy = { 0, 1, 0, -1 };
	static char[][] arr;
	static boolean[] visit;
	static int max = -1;
	static int r, c;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		// 65~90
		arr = new char[r][c];
		visit = new boolean[91];
		for (int i = 0; i < r; i++) {
			arr[i] = br.readLine().toCharArray();
		}

		for (int i = 0; i < 2; i++) {
			doing(0, 0, 1);
		}

		System.out.println(max);

	}

	private static void doing(int y, int x, int cnt) {
		
		//System.out.println(arr[y][x]+"("+y+","+x+")"+" "+cnt);
		
		if (cnt > max)
			max = cnt;
		visit[(int) arr[y][x]] = true;

		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];

			if (ny >= 0 && nx >= 0 && ny < r && nx < c && !visit[(int) arr[ny][nx]]) {
				doing(ny, nx, cnt + 1);
			}
		}
		visit[(int) arr[y][x]] = false;

	}
}
