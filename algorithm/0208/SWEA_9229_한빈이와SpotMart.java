package algo_hw;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SWEA_9229 {

	static int[] arr;
	static int max;
	static int count;
	static int limit;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringBuilder sb=new StringBuilder();
		for (int t = 1; t <= N; t++) {
			max = -1;
			String[] str = br.readLine().split(" ");
			count = Integer.parseInt(str[0]);
			limit = Integer.parseInt(str[1]);
			arr = new int[count];
			String[] snack = br.readLine().split(" ");

			for (int i = 0; i < count; i++) {
				arr[i] = Integer.parseInt(snack[i]);
			}

			comb(0, new int[2], 0);
			sb.append("#").append(t).append(" ").append(max).append("\n");
			

		}
		System.out.println(sb);
	}

	public static void comb(int select, int[] selected, int startIdx) {

		if (select == 2) {
			int temp = selected[0] + selected[1];
			if (temp > max&&temp<=limit)
				max = temp;

			return;
		}

		for (int i = startIdx; i < count; i++) {
			selected[select]=arr[i];
			comb(select + 1, selected, i + 1);
		}

	}
}
