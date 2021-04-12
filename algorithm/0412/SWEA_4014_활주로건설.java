package SWEA;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class SWEA_4014_활주로건설 {
	static int[][] arr;
	static int N, X, cnt;
	static boolean[][] garo;
	static boolean[][] sero;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			String[] str = br.readLine().split(" ");
			N = Integer.parseInt(str[0]);
			X = Integer.parseInt(str[1]);
			arr = new int[N][N];
			sero = new boolean[N][N];
			garo = new boolean[N][N];
			for (int i = 0; i < N; i++) {
				String[] temp = br.readLine().split(" ");
				for (int j = 0; j < N; j++) {
					arr[i][j] = Integer.parseInt(temp[j]);
				}
			}

			cnt = 0;

			checkGaro();

			checkSero();

			System.out.println("#" + t + " " + cnt);

		}
	}

	private static void checkGaro() {
		for (int i = 0; i < N; i++) {
			boolean flag = true;
			for (int j = 0; j < N - 1; j++) {

				// 높이가 같다면 ? 넘어감
				if (arr[i][j] == arr[i][j + 1]) {
					continue;
				}

				// 앞의 칸이 더 높을때
				if (arr[i][j] > arr[i][j + 1]) {

					// 높이차이가 1보다크면 불가능
					if (arr[i][j] - arr[i][j + 1] > 1) {
						flag = false;
						break;
					}

					// 경사로를 더한 길이가 범위를 벗어나면 불가능
					if (j + X >= N) {
						flag = false;
						break;
					}

					for (int k = j + 1; k <= j + X; k++) {
						if (arr[i][j + 1] != arr[i][k]) {
							flag = false;
							break;
						}

						if (garo[i][k]) {
							flag = false;
							break;
						}
					}

					if (!flag) {
						break;
					}

					// 경사로 놓은것으로 체크
					for (int k = j + 1; k <= j + X; k++) {
						garo[i][k] = true;
					}

				}
				// 뒤의 칸이 더 높을 때
				else if (arr[i][j] < arr[i][j + 1]) {

					if (arr[i][j + 1] - arr[i][j] > 1) {
						flag = false;
						break;
					}
					if (j + 1 - X < 0) {
						flag = false;
						break;
					}

					for (int k = j; k >= j + 1 - X; k--) {

						if (arr[i][j] != arr[i][k]) {
							flag = false;
							break;
						}

						if (garo[i][k]) {
							flag = false;
							break;
						}
					}
					if (!flag) {
						break;
					}

					for (int k = j; k >= j+1-X; k--) {
						garo[i][k] = true;
					}

				}
			}
			if (flag)
				cnt++;
		}
	}

	private static void checkSero() {
		for (int j = 0; j < N; j++) {
			boolean flag = true;
			for (int i = 0; i < N - 1; i++) {

				// 높이가 같다면 ? 넘어감
				if (arr[i][j] == arr[i+1][j]) {
					continue;
				}

				// 앞의 칸이 더 높을때
				if (arr[i][j] > arr[i+1][j]) {

					// 높이차이가 1보다크면 불가능
					if (arr[i][j] - arr[i+1][j] > 1) {
						flag = false;
						break;
					}

					// 경사로를 더한 길이가 범위를 벗어나면 불가능
					if (i + X >= N) {
						flag = false;
						break;
					}

					for (int k = i + 1; k <= i + X; k++) {
						if (arr[i+1][j] != arr[k][j]) {
							flag = false;
							break;
						}

						if (sero[k][j]) {
							flag = false;
							break;
						}
					}

					if (!flag) {
						break;
					}

					// 경사로 놓은것으로 체크
					for (int k = i + 1; k <= i + X; k++) {
						sero[k][j] = true;
					}

				}
				// 뒤의 칸이 더 높을 때
				else if (arr[i][j] < arr[i+1][j]) {

					if (arr[i+1][j] - arr[i][j] > 1) {
						flag = false;
						break;
					}
					if (i + 1 - X < 0) {
						flag = false;
						break;
					}

					for (int k = i; k >= i + 1 - X; k--) {

						if (arr[i][j] != arr[k][j]) {
							flag = false;
							break;
						}

						if (sero[k][j]) {
							flag = false;
							break;
						}
					}
					if (!flag) {
						break;
					}

					for (int k = i; k >= i+1-X; k--) {
						sero[k][j] = true;
					}

				}
			}
			if (flag)
				cnt++;
		}
	}
}
