import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {
	static int L, N, D;

	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb=new StringBuilder();

		for (int tc = 1; tc <= T; tc++) {
			String[] str=br.readLine().split(" ");
			D = Integer.parseInt(str[0]);
			L = Integer.parseInt(str[1]);
			N = Integer.parseInt(str[2]);

			int sum = 0;

			for (int i = 0; i < N; i++) {
				sum += D * (1 + 0.01*L * i);
			}
			sb.append("#"+tc+" "+sum+"\n");

		}
		System.out.println(sb);

	}
}
