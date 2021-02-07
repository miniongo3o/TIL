package ssafy_algo_0205;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_2309 {
	static int[] arr;

	static void Comb(int toSelect, int[] selected, int startIdx) {
		if (toSelect == 7) {
			int sum = 0;
			for (int i = 0; i < 7; i++) {
				sum += selected[i];
			}
			
			if (sum == 100) {
				Arrays.sort(selected);
				for (int i = 3; i < 10; i++) {
					System.out.println(selected[i]);

				}
				arr=new int[10];
				return;

			}
			return;
		}

		for (int i = startIdx; i < 9; i++) {

			selected[toSelect] = arr[i];
			Comb(toSelect + 1, selected, i + 1);
		}

		return;
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		arr = new int[9];
		for (int i = 0; i < 9; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		Comb(0, new int[10], 0);
	}
}