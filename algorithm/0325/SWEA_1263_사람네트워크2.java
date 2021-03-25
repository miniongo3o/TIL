package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_1263_사람네트워크2 {
	static int T, n;
	static int arr[][];
	static int INF = 100000000;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			n = Integer.parseInt(st.nextToken());
			arr = new int[n][n];

			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
					// i,j가 같으면 본인 자신이므로 0임.
					// i,j가 같지 않으면서 0이면 연결되지 않았으므로 무한대로 설정한다.
					if (i != j && arr[i][j] == 0)
						arr[i][j] = INF;
				}
			}

			// 경출도 : 경유,출발,도착
			for (int k = 0; k < n; k++) {
				for (int i = 0; i < n; i++) {
					for (int j = 0; j < n; j++) {
						arr[i][j] = Math.min(arr[i][k] + arr[k][j], arr[i][j]);
					}
				}
			}

			int min = INF;
			for (int i = 0; i < n; i++) {
				int sum = 0;
				for (int j = 0; j < n; j++) {
					if (arr[i][j] < INF)
						sum += arr[i][j];
				}
				if (min > sum) {
					min = sum;
				}
			}
			
			System.out.println("#"+t+" "+min);

		}

	}
}
