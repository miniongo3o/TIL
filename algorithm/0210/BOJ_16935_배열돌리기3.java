package ssafy_algo_0210;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_16935 {
	static int R, C, M;
	static int[][] arr;
	//static int[] dy = { 0, 1, 0, -1 };
	//static int[] dx = { 1, 0, -1, 0 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] str = br.readLine().split(" ");

		R = Integer.parseInt(str[0]);
		C = Integer.parseInt(str[1]);
		M = Integer.parseInt(str[2]);
		arr = new int[R][C];
		for (int i = 0; i < R; i++) {
			String[] temp = br.readLine().split(" ");
			for (int j = 0; j < C; j++) {
				arr[i][j] = Integer.parseInt(temp[j]);
			}
		}
		String[] op = br.readLine().split(" ");
		for (int z = 0; z < M; z++) {
			int option = Integer.parseInt(op[z]);

			switch (option) {
			case 1:
				m1();
				break;
			case 2:
				m2();
				break;
			case 3:
				m3();
				break;
			case 4:
				m4();
				break;
			case 5:
				m5();
				break;
			case 6:
				m6();
				break;
			}

		}
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[0].length; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
		
	}

	public static void m1() {
//		for (int i = 0; i < R / 2; i++) {
//			int[] temp1 = Arrays.copyOfRange(arr[R - 1 - i], 0, arr[i].length);
//			int[] temp2 = Arrays.copyOfRange(arr[i], 0, arr[i].length);
//			arr[i] = temp1;
//			arr[R - 1 - i] = temp2;
//		}
		for(int c = 0 ; c < arr[0].length ; ++c) {
			for(int r1 = 0, r2 = arr.length - 1 ; r1 < r2 ; r1++, r2--) {
				int temp = arr[r1][c];
				arr[r1][c] = arr[r2][c];
				arr[r2][c] = temp;
			}
		}
	}

	public static void m2() {
//		for (int i = 0; i < R / 2; i++) {
//			for (int j = 0; j < C / 2; j++) {
//				int tmp = arr[i][j];
//				arr[i][j] = arr[i][C - 1 - j];
//				arr[i][C - 1 - j] = tmp;
//
//				int tmp2 = arr[R - 1 - i][j];
//				arr[R - 1 - i][j] = arr[R - 1 - i][C - 1 - j];
//				arr[R - 1 - i][C - 1 - j] = tmp2;
//
//			}
//		}
		for(int r = 0 ; r < arr.length ; ++r) {
			for(int c1 = 0, c2 = arr[0].length - 1 ; c1 < c2 ; c1++, c2--) {
				int temp = arr[r][c1];
				arr[r][c1] = arr[r][c2];
				arr[r][c2] = temp;
			}
		}
	}

	public static void m3() {
		int[][] result = new int[arr[0].length][arr.length];

		for (int r = 0; r < arr.length; ++r) {
			for (int c = 0; c < arr[0].length; ++c) {
				result[c][arr.length - 1 - r] = arr[r][c];
			}
		}

		arr = result;
	}

	public static void m4() {
		int[][] result = new int[arr[0].length][arr.length];

		for (int r = 0; r < result.length; ++r) {
			for (int c = 0; c < result[0].length; ++c) {
				result[r][c] = arr[c][result.length - 1 - r];
			}
		}

		arr = result;
	}

	public static void m5() {
		/*
		 * int[][] newarr=arr; for(int i=0;i<R/2;i++) { for(int j=0;j<C/2;j++) { int
		 * y=i; int x=j;
		 * 
		 * int oy=i; int ox=j; for(int k=0;k<4;k++) { oy=y; ox=x; y=y+dy[k]*(R/2);
		 * x=x+dx[k]*(C/2); newarr[y][x]=arr[oy][ox]; }
		 * 
		 * } }
		 * 
		 * for(int i=0;i<R;i++) { for(int j=0;j<C;j++) {
		 * System.out.print(newarr[i][j]+" "); } System.out.println(); }
		 */

		int[][] result = new int[arr.length][arr[0].length];

		int rowSize = arr.length;
		int colSize = arr[0].length;

		for (int r = 0; r < rowSize / 2; ++r) {
			for (int c = 0; c < colSize / 2; ++c) {
				result[r][c + colSize / 2] = arr[r][c];
			}
		}

		for (int r = 0; r < rowSize / 2; ++r) {
			for (int c = colSize / 2; c < colSize; ++c) {
				result[r + rowSize / 2][c] = arr[r][c];
			}
		}

		for (int r = rowSize / 2; r < rowSize; ++r) {
			for (int c = colSize / 2; c < colSize; ++c) {
				result[r][c - colSize / 2] = arr[r][c];
			}
		}

		for (int r = rowSize / 2; r < rowSize; ++r) {
			for (int c = 0; c < colSize / 2; ++c) {
				result[r - rowSize / 2][c] = arr[r][c];
			}
		}

		arr = result;

	}

	public static void m6() {
		int[][] result = new int[arr.length][arr[0].length];

		int rowSize = arr.length;
		int colSize = arr[0].length;

		// 1번 -> 4번
		for (int r = 0; r < rowSize / 2; ++r) {
			for (int c = 0; c < colSize / 2; ++c) {
				result[r + rowSize / 2][c] = arr[r][c];
			}
		}

		// 4번 -> 3번
		for (int r = rowSize / 2; r < rowSize; ++r) {
			for (int c = 0; c < colSize / 2; ++c) {
				result[r][c + colSize / 2] = arr[r][c];
			}
		}

		// 3번 -> 2번
		for (int r = rowSize / 2; r < rowSize; ++r) {
			for (int c = colSize / 2; c < colSize; ++c) {
				result[r - rowSize / 2][c] = arr[r][c];
			}
		}

		// 2번 -> 1번
		for (int r = 0; r < rowSize / 2; ++r) {
			for (int c = colSize / 2; c < colSize; ++c) {
				result[r][c - colSize / 2] = arr[r][c];
			}
		}

		arr = result;
	}
// 0 5   1  4   2 3 	
}
/*
 * 6 8 1 3 2 6 3 1 2 9 7 9 7 8 2 1 4 5 3 5 9 2 1 9 6 1 8 2 1 3 8 6 3 9 2 1 3 2 8
 * 7 9 2 1 4 5 1 9 8 2 1 3 1
 */

// 1: 상하 반전
// 2: 좌우 반전
// 3: 왼쪽 90도
// 4: 오른쪽 90도
// 5: 1 > 2 > 3 > 4
// 6: 1 > 4 > 3 > 2