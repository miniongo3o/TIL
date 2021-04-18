package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ_12100_2048easy {
	static int[] dy = { -1, 1, 0, 0 };
	static int[] dx = { 0, 0, -1, 1 };
	static int n;
	static int max = -1;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		int[][] arr = new int[n][n];

		for (int i = 0; i < n; i++) {
			String[] str = br.readLine().split(" ");
			for (int j = 0; j < n; j++) {
				arr[i][j] = Integer.parseInt(str[j]);
			}
		}
		dfs(arr, 0);
		System.out.println(max);
	}

	public static void printer(int[][] arr) {
		System.out.println("=================");
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println("===============");
	}

	public static void dfs(int[][] arr, int idx) {
		if (idx == 5) {
			count(arr);
			return;
		}
		int[][] copied;
		for (int dir = 0; dir < 4; dir++) {
			copied = copy(arr);
			move(copied, dir);
			sum(copied, dir);
			move(copied, dir);
			dfs(copied, idx + 1);
		}
	}

	// nxn돌면서 max체크할것인가 or 합쳐질 때 맥스를 체크할것인가
	public static void count(int[][] arr) {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (max <= arr[i][j]) {
					max = arr[i][j];
//					printer(arr);
				}

			}
		}
	}

	public static void move(int[][] arr, int dir) {
		// 위
		Queue<Integer> q = new LinkedList();
		if (dir == 0) {
			for (int i = 0; i < n; i++) {

				for (int j = 0; j < n; j++) {
					if (arr[j][i] == 0) {
						continue;
					} else {
						q.offer(arr[j][i]);

					}
				}

				for (int k = q.size(); k < n; k++) {
					q.offer(0);
				}

				for (int j = 0; j < n; j++) {
					arr[j][i] = q.poll();
				}
			}
		} else if (dir == 1) {
			// 아래
			for (int i = 0; i < n; i++) {

				for (int j = n - 1; j >= 0; j--) {
					if (arr[j][i] == 0) {
						continue;
					} else {
						q.offer(arr[j][i]);

					}
				}

				for (int k = q.size(); k < n; k++) {
					q.offer(0);
				}

				for (int j = n - 1; j >= 0; j--) {
					arr[j][i] = q.poll();
				}
			}
		} else if (dir == 2) {
			// 왼
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if (arr[i][j] == 0) {
						continue;
					} else {
						q.offer(arr[i][j]);

					}
				}

				for (int k = q.size(); k < n; k++) {
					q.offer(0);
				}

				for (int j = 0; j < n; j++) {
					arr[i][j] = q.poll();
				}
			}
		} else if (dir == 3) {
			// 오
			for (int i = 0; i < n; i++) {
				for (int j = n - 1; j >= 0; j--) {
					if (arr[i][j] == 0) {
						continue;
					} else {
						q.offer(arr[i][j]);

					}
				}

				for (int k = q.size(); k < n; k++) {
					q.offer(0);
				}

				for (int j = n - 1; j >= 0; j--) {
					arr[i][j] = q.poll();
				}
			}
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

	public static void sum(int[][] arr, int dir) {
		switch (dir) {
		case 0:
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n-1; j++) {
					if (arr[j][i] == arr[j + 1][i]) {
						arr[j][i] = arr[j][i] * 2;
						arr[j + 1][i] = 0;
					}
				}
			}
			break;
		case 1:
			for (int i = 0; i < n; i++) {
				for (int j = n - 1; j > 0; j --) {
					if (arr[j][i] == arr[j - 1][i]) {
						arr[j][i] = arr[j][i] * 2;
						arr[j - 1][i] = 0;
					}
				}
			}
			break;
		case 2:
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n-1; j ++ ) {
					if (arr[i][j] == arr[i][j + 1]) {
						arr[i][j] = arr[i][j] * 2;
						arr[i][j + 1] = 0;
					}
				}
			}

			break;
		case 3:
			for (int i = 0; i < n; i++) {
				for (int j = n - 1; j > 0; j --) {
					if (arr[i][j] == arr[i][j - 1]) {
						arr[i][j] = arr[i][j] * 2;
						arr[i][j - 1] = 0;
					}
				}
			}
			break;
		}
	}

}
