package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_10819_차이를최대로 {
	static int[] arr;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		String[] str = br.readLine().split(" ");
		arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(str[i]);
		}
		permutation(0, new int[n], new boolean[n]);
		System.out.println(max);
	}

	static int n;
	static int max=-1;
	public static void permutation(int select, int[] selected, boolean[] visited) {
		if (select == n) {
			int sum=0;
			for(int i=0;i<n-1;i++) {
				sum+=Math.abs(selected[i]-selected[i+1]);
			}
			max=Math.max(max, sum);
			return;
		}

		for (int i = 0; i < n; i++) {
			if (!visited[i]) {
				selected[select] = arr[i];
				visited[i]=true;
				permutation(select + 1, selected,visited);
				visited[i]=false;
			}
		}

	}
}
