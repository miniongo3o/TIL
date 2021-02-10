package ssafy_algo_0210;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class BOJ_16926_배열돌리기1 {

	static int N, M, R,num;
	static int[][] arr;
	static int[] dx = { 0, 1, 0, -1 };
	static int[] dy = { 1, 0, -1, 0 };



	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] str = br.readLine().split(" ");

		N = Integer.parseInt(str[0]);
		M = Integer.parseInt(str[1]);
		R = Integer.parseInt(str[2]);
		arr = new int[N][M];
		for (int i = 0; i < N; i++) {
			String[] temp = br.readLine().split(" ");
			for (int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(temp[j]);
			}
		}
		num = Math.min(N, M) / 2;
		for (int i = 0; i < R; i++) {
			turn();
		}
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				System.out.print(arr[i][j]+" ");
			}
			System.out.println();
		}

	}

	public static void turn() {
		for (int n = 0; n < num; n++) {

			int temp = arr[n][n];

			int index = 0; 
			int lx = n, ly = n; 
			while (index < 4) {

				int nx = lx + dx[index];
				int ny = ly + dy[index];

				if (nx >= n && ny >= n && nx < N - n && ny < M - n) {
					arr[lx][ly] =arr[nx][ny]; 
					lx = nx; 
					ly = ny;
				} else {
					index++; 
				}
			}
			arr[n + 1][n] = temp;
		}
	}

}
