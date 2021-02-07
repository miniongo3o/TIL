package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SWEA_1961 {

	static int N;
	static int T;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			String[][] arr = new String[N][N];
			for (int i = 0; i < N; i++) {
				arr[i] = br.readLine().split(" ");

			}
			String[][] answer1 = turn(arr);
			String[][] answer2 = turn(answer1);
			String[][] answer3 = turn(answer2);

			System.out.println("#"+t);
			for (int i = 0; i < N; i++) {
				
				StringBuilder sb=new StringBuilder();
				
				
				for (int j = 0; j < N; j++) {
					sb.append(answer1[i][j]);
				}
				sb.append(" ");
				for (int j = 0; j < N; j++) {
					sb.append(answer2[i][j]);
				}
				sb.append(" ");
				for (int j = 0; j < N; j++) {
					sb.append(answer3[i][j]);
				}
				sb.append("\n");
				
				System.out.print(sb);
			}
			

		}

	}

	public static String[][] turn(String[][] arr) {
		String[][] result = new String[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				result[i][j] = arr[N - 1 - j][i];
			}

		}
		return result;
	}
}

// 180도 회전
//String[][] temp2=new String[N][N];
//for(int i=0;i<N;i++) {
//	for(int j=0;j<N;j++) {
//		temp1[i][j]=arr[N-1-j][N-1-j];
//	}
//}