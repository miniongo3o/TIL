package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class SWEA_10912_외로운문자 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		for (int t = 1; t <= n; t++) {

			char[] arr = br.readLine().toCharArray();
			Arrays.sort(arr);
			boolean[] visit = new boolean[arr.length];
			for (int i = 0;;) {

				if (i >= arr.length || i + 1 >= arr.length)
					break;
				if (arr[i] == arr[i + 1]) {
					visit[i] = true;
					visit[i + 1] = true;i = i + 2;
				}else {
					i=i+1;
				}
				

			}

			boolean flag = true;
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < arr.length; i++) {
				if (!visit[i]) {
					flag = false;
					sb.append(arr[i]);
				}
			}

			System.out.print("#"+t+" "); 
			if (flag) {
				System.out.println("Good");
			} else {
				System.out.println(sb); 
			}
		}

	}
}
