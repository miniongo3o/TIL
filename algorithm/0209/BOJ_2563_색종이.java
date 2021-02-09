package algo_hw;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_2563_색종이 {

	static int[][] arr = new int[100][100];
	static boolean[][] visit = new boolean[100][100];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int sum=0;
		for (int t = 1; t <= N; t++) {
			String[] str = br.readLine().split(" ");
			int x = Integer.parseInt(str[0]);
			int y = Integer.parseInt(str[1]);

			for (int i = y; i < y + 10; i++) {
				for (int j = x; j < x + 10; j++) {
					if (!visit[i][j]) {
						arr[i][j] = 1;
						visit[i][j]=true;
						sum+=1;
					}
				}
			}
			
		}
		System.out.println(sum);

	}
}
