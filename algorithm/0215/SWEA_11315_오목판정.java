package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class SWEA_11315_오목판정 {
	static int N, M;
	static int[] dy = { 0, 1, 0, -1,-1,1,1,-1 };
	static int[] dx = { 1, 0, -1, 0,1,1,-1,-1 };
	static char[][] arr;
	static boolean flag = false;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		

		for (int tc = 1; tc <= N; tc++) {
			M = Integer.parseInt(br.readLine());
			arr = new char[M][M];
			for (int i = 0; i < M; i++) {
				arr[i] = br.readLine().toCharArray();
			}

			for (int i = 0; i < M; i++) {
				for (int j = 0; j < M; j++) {
					if (arr[i][j] == 'o') {
						for (int dir = 0; dir < 8; dir++) {
							dfs(i, j, dir, 1);
						}
					}
				}
			}
			String str = "NO";
			if (flag)str = "YES";
			System.out.println("#" + tc + " " + str);
			flag=false;

		}

	}

	private static void dfs(int y, int x, int dir, int depth) {
		if(depth==5)flag=true;
		int nx = x + dx[dir];
		int ny = y + dy[dir];

		if (ny >= 0 && nx >= 0 && ny < M && nx < M && arr[ny][nx] == 'o') {
			dfs(ny,nx,dir,depth+1);
		}

	}

}
