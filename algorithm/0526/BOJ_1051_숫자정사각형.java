package BOJ;

import java.io.IOException;
import java.util.Scanner;

public class BOJ_1051_숫자정사각형 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		char[][] arr = new char[n][m];
		for (int i = 0; i < n; i++) {
			arr[i] = sc.next().toCharArray();
		}
		int res = 1;
		int max = Math.abs(n - m);
		if(n==m)max=n-1;
		for (int i = 0; i < n - 1; i++) {
			for (int j = 0; j < m - 1; j++) {
				for (int k = 1; k <= max; k++) {
					if (i + k >= n || j + k >= m) {
						System.out.println(k);
						continue;
					}
					if (arr[i][j] == arr[i][j + k] && arr[i][j] == arr[i + k][j] && arr[i][j] == arr[i + k][j + k]) {
						res = Math.max(res, (k + 1) * (k + 1));
					}
				}

			}
		}
		System.out.println(res);
	}
}
