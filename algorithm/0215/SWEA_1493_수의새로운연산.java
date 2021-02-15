package SWEA;

import java.util.Scanner;

public class SWEA_1493_수의새로운연산 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int[][] arr = new int[N][2];
		for (int i = 0; i < N; i++) {
			arr[i][0] = sc.nextInt();
			arr[i][1] = sc.nextInt();
		}

		int[][] map = new int[350][350];
		for (int i = 1; i < 350; i++) {
			for (int j = 1; j < 350; j++) {
				map[i][j] = pos(j, i);
			}
		}
		for (int k = 0; k < N; k++) {

			int x1 = 0, x2 = 0, y1 = 0, y2 = 0;

			for (int i = 0; i < 350; i++) {
				for (int j = 0; j < 350; j++) {
					if ((map[i][j]) == (arr[k][0])) {
						x1 = j;
						y1 = i;
					}
					if (map[i][j] == arr[k][1]) {
						x2=j;
						y2=i;
					}
				}
			}

			System.out.println("#" + (k + 1) + " " + pos(x1 + x2, y1 + y2));
		}

	}

	private static int star(int a, int b) {
		return 1;
	}

	private static int pos(int x, int y) {
		int j = 0;
		for (int i = 1; i <= x; i++) {
			j += i;
		}
		// System.out.print(j+" ");
		int p = j;
		for (int k = 1; k < y; k++) {
			p += (k + x - 1);
		}
		// System.out.println(p);
		return p;
	}
}
