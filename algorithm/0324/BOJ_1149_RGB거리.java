package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_1149_RGB거리 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int arr[][] = new int[n][3];
		for (int i = 0; i < n; i++) {
			String[] str = br.readLine().split(" ");
			for (int j = 0; j < 3; j++) {
				arr[i][j] = Integer.parseInt(str[j]);
			}
		}

		if (n == 1) {
			Arrays.sort(arr[0]);
			System.out.println(arr[0][0]);
			return;
		}

		for (int i = 1; i < n; i++) {

			for (int j = 0; j < 3; j++) {
				int temp=arr[i][j];
				int min=Integer.MAX_VALUE;
				for(int k=0;k<3;k++) {
					if(j==k)continue;
					min=Math.min(min, temp+arr[i-1][k]);
				}
				arr[i][j]=min;
			}

		}
		Arrays.sort(arr[n-1]);
		System.out.println(arr[n-1][0]);
	}
}
