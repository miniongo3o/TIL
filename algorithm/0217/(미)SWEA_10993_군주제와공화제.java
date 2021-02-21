package SWEA;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class SWEA_10993_군주제와공화제 {
	static int n;
	static int T;
	static int[][] arr;

	// [][3]의 값은 0: D, 자기자신의idx : K, 아니면 따르는 나라의idx
	public static void main(String[] args) throws NumberFormatException, IOException {
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			n = Integer.parseInt(br.readLine());
			arr = new int[n + 1][4];
			for (int i = 1; i <= n; i++) {
				String[] str = br.readLine().split(" ");
				arr[i][0] = Integer.parseInt(str[0]);
				arr[i][1] = Integer.parseInt(str[1]);
				arr[i][2] = Integer.parseInt(str[2]);
				arr[i][3] = i;
			}

			for (int i = 1; i <= n; i++) {
				KD(i);
			}

			StringBuilder sb = new StringBuilder();
			sb.append("#" + tc + " ");
			for (int i = 1; i <= n; i++) {
				if (arr[i][3] == 0) {
					sb.append("D ");
				} else if (arr[i][3] == i) {
					sb.append("K ");
				} else {
					sb.append(arr[i][3] + " ");
				}

			}
			sb.setLength(sb.length() - 1);
			System.out.println(sb);
		}
	}

	private static void KD(int idx) {
		int x = arr[idx][0];
		int y = arr[idx][1];
		int s = arr[idx][2];

		int threatCnt = 0;// 위협하는 국가의 수
		double max = 0; // 가장 높은 영향력의 수치
		int power = 0; // 따르는 나라 인덱스
		boolean flagD = false;
		for (int i = 1; i <= n; i++) {

			if (i == idx) {
				continue;
			}
			int Ex = arr[i][0];
			int Ey = arr[i][1];
			int Es = arr[i][2];

			double res = (double) Es / ((x - Ex) * (x - Ex) + (y - Ey) * (y - Ey)); // 영향력 수치
			// 영향력이 군사력보다 클때
			if (res > s) {
				threatCnt++;
				// flagD를 처리해줘야함 : 동일한 max가 2개이상일때

				if (threatCnt == 1) {
					// 위협국이 하나일때
					max = res;
					power = i;

				} else if (threatCnt > 1) {
					// max가 동일할 떄
					if (max == res) {
						flagD = true;
					} else {
						// 2개의 같은값이 있는데, 더작은 위협국이 등장한경우, true를 유지한다.
						// 최신값이 max보다 크면 값을 바꿔준다. true였을경우 false로 바꿔준다
						if (res > max) {
							max = res;
							power = i;
							flagD = false;
						}

					}
				}
			}
		}

		if (threatCnt == 1){
			// 한개만 초과시, 해당 강국을 따른다.
			arr[idx][3] = power;
			// 해당국가를 따랐던 나라들은 모두 강국을 따른다.
			for (int i = 1; i <= n; i++) {
				if (arr[i][3] == idx) {
					arr[i][3] = power;
				}
			}
		} else if (threatCnt == 0) {
			// 아무도 없다면?
			arr[idx][3] = idx;
			return;
		} else {
			// 2개이상일때,

			// 그중, max값이 동일한것이 있따면 D ( arr[][3]=0 )
			if (flagD) {
				arr[idx][3] = 0;
			} else {
				// 동일한것이 없고 하나가 가장높다면? 해당 강국power를 따른다.
				arr[idx][3] = power;
				for (int z = 1; z <= n; z++) {
					// 만약 이 나라를 따르는 곳들이 있었다면, 모두 새 강국 power로 바꿔준다.
					if (arr[z][3] == idx) {
						arr[z][3] = power;
					}
				}

			}

		}

	}
}