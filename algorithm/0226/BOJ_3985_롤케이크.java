package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_3985_롤케이크 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int cake = Integer.parseInt(br.readLine());
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[cake + 1];
		int max = 0;
		int maxer = 0;
		int realmaxer=0;
		int realmax=0;
		for (int i = 1; i <= n; i++) {
			String[] str = br.readLine().split(" ");
			int start = Integer.parseInt(str[0]);
			int end = Integer.parseInt(str[1]);
			if (end - start > max) {
				max = end - start;
				maxer=i;
			}
			for (int j = start; j <= end; j++) {
				if (arr[j] == 0) {
					arr[j] = i;
				}
			}
			int[] check = new int[n + 1];
			for (int j = 1; j <= cake; j++) {
				if (arr[j] != 0) {
					check[arr[j]]++;
				}
			}

			for (int j = 1; j <= n; j++) {
				if (realmax < check[j]) {
					realmax=check[j];
					realmaxer = j;
				}
			}
		}
		System.out.println(maxer + "\n" + realmaxer);

	}
}
