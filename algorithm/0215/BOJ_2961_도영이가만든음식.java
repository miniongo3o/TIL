package ssafy_algo_0215;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_2961_도영이가만든음식 {
	static int N;
	static int[] S, B;
	static int min = Integer.MAX_VALUE;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		S = new int[N];
		B = new int[N];
		for (int i = 0; i < N; i++) {
			String[] str = br.readLine().split(" ");
			S[i] = Integer.parseInt(str[0]);
			B[i] = Integer.parseInt(str[1]);
		}
		powerSet(0, new boolean[N]);
		System.out.println(min);
	}

	private static void powerSet(int cnt, boolean[] isSelected) {
		if (cnt == N) {

			int Ssum = 1;
			int Bsum = 0;
			int count = 0;
			for (int i = 0; i < N; i++) {
				if (isSelected[i]) {
					Ssum *= S[i];
					Bsum += B[i];
					count++;
				}

			}
			if (count == 0)
				return;

			if (min > Math.abs(Ssum - Bsum)) {
				min = Math.abs(Ssum - Bsum);
			}
			return;
		}

		isSelected[cnt] = true;
		powerSet(cnt + 1, isSelected);
		isSelected[cnt] = false;
		powerSet(cnt + 1, isSelected);

	}
}

//재료 N개
// 신맛 S, 쓴맛 B
// 음식의 신맛 : 신맛의 곱
// 음식의 쓴맛 : 쓴맛의 합
// 신맛과 쓴맛의 차이를 작게하여라.
