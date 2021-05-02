package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_2846_오르막길 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];
		String[] str = br.readLine().split(" ");
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(str[i]);
		}

		int max = -1;
		for (int i = 0; i < n - 1; i++) {
			int startV = arr[i];
			int endV = -1;
			int maxIdx = -1;
			for (int j = i; j < n - 1; j++) {
				if (arr[j + 1] > arr[j]) {
					maxIdx = j + 1;
					endV = arr[j + 1];
				} else {
					break;
				}
			}
			if (maxIdx != -1) {
				max = Math.max(max, endV - startV);
				System.out.println(i + " " + maxIdx);
			}
		}
		if (max == -1) {
			System.out.println(0);
			return;
		} else {
			System.out.println(max);
		}

	}
}
