package ssafy_algo_0203;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//농작물 수확하기
public class T09_2805_D3 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int num = Integer.parseInt(br.readLine());
		for (int T = 1; T <= num; T++) {
			int N = Integer.parseInt(br.readLine());
			int[][] arr = new int[N][N];
			for (int k = 0; k < N; k++) {
				String[] str = br.readLine().split("");
				for (int m = 0; m < N; m++) {
					arr[k][m] = Integer.parseInt(str[m]);
				}
			}

			int sum=0;
			for (int i = 0; i < N/2; i++) {
				for (int j = N/2-i; j <= (N/2+i); j++) {
					sum+=arr[i][j];
				}
			}
			
			
			
			for (int i = N/2; i >=0; i--) {
				for (int j = N/2-i; j <= (N/2+i); j++) {
					sum+=arr[N-i-1][j];
				}
			}
			System.out.println("#"+T+" "+sum);
		}
	}
}
