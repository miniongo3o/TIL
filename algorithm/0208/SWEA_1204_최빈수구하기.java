package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SWEA_1204_최빈수구하기 {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		for (int t = 1; t <= N; t++) {
			br.readLine();
			int max = -1;
			int result=0;
			String[] str = br.readLine().split(" ");
			int[] arr = new int[1001];
			for (int i = 0; i < 1000; i++) {
				int idx = Integer.parseInt(str[i]);
				arr[idx] += 1;
				if (max <= arr[idx]) {
					max = arr[idx];
					result=idx;
				}
				
			}
			System.out.println("#"+t+" "+result);

		}

	}
}
