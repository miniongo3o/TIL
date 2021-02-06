package ssafy_algo;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Day2_SWEA_1208 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		System.setIn(new FileInputStream("Day2_SWEA_1208.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		

		for (int j = 1; j <= 10; j++) {
			int n = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());
			int[] arr = new int[100];
			for (int i = 0; i < 100; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			for (int i = 0; i < n; i++) {
				Arrays.sort(arr);
				arr[0]++;
				arr[99]--;
			}

			
			Arrays.sort(arr);
			int answer=arr[99]-arr[0];
			System.out.println("#"+j+" "+answer);
		}
	}
}
