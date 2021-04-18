package BOJ;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_14888_연산자끼워넣기 {
	static int k, sum, n;
	static int op[];
	static int arr[];
	static int min=Integer.MAX_VALUE;
	static int max=Integer.MIN_VALUE;
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		arr = new int[n];
		String[] str = br.readLine().split(" ");
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(str[i]);
		}
		String[] temp = br.readLine().split(" ");

		int plus = Integer.parseInt(temp[0]); // 1
		int minus = Integer.parseInt(temp[1]); // 0
		int multi = Integer.parseInt(temp[2]); // 1
		int divide = Integer.parseInt(temp[3]);// 0

		sum = plus + minus + multi + divide;
		op = new int[sum];
		int i = 0;
		for (; i < plus; i++) {

			op[i] = 1;
		}
		for (; i < plus + minus; i++) {
			op[i] = 2;
		}
		for (; i < plus + minus + multi; i++) {
			op[i] = 3;
		}
		for (; i < sum; i++) {
			op[i] = 4;
		}
		k = sum;
		permu(0, new int[sum], new boolean[sum]);
//		System.out.println(max);
//		System.out.println(min);
	}

	public static void permu(int select, int[] selected, boolean[] visit) {
		if (select == k) {

			System.out.println(Arrays.toString(selected));
			int res = arr[0];
			for (int i = 1, j = 0; i < n; i++, j++) {

				if (selected[j] == 1) {
					res+=arr[i];
				} else if (selected[j] == 2) {
					res-=arr[i];
				} else if (selected[j] == 3) {
					res*=arr[i];
				} else if (selected[j] == 4) {
					res/=arr[i];
				}

			}
//			System.out.println(res);
			min=Math.min(min, res);
			max=Math.max(max, res);
			return;
		}

		for (int i = 0; i < sum; i++) {
			if (!visit[i]) {
				visit[i] = true;
				selected[select] = op[i];
				permu(select + 1, selected, visit);
				visit[i] = false;
			}
		}

	}
}
