package BOJ;

import java.util.*;

public class BOJ_15650 {

	static int num;
	static int N;
	static int[] arr;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		num = sc.nextInt();
		N = sc.nextInt();
		arr = new int[num];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = i + 1;
		}
		comb(0, new int[N], 0);
	}

	public static void comb(int toSelect, int[] selected, int startIdx) {

		if (toSelect == N) {
			for (int i = 0; i < selected.length; i++) {
				System.out.print(selected[i] + " ");
			}
			System.out.println();
			return;
		}

		for (int i = startIdx; i < arr.length; i++) {
			selected[toSelect] = arr[i];
			comb(toSelect + 1, selected, i + 1);
		}
	}
}