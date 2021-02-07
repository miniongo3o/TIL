package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_1974 {
	static int[] dy = { 0, 0, 1, 1, 1, 0, -1, -1,-1 };
	static int[] dx = { 0, 1, 1, 0, -1, -1, -1, 0, 1 };

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		for (int t = 0; t < N; t++) {
			int answer = 1;
			int[][] arr = new int[9][9];
			for (int i = 0; i < 9; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < 9; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			// 가로검사
			for (int i = 0; i < 9; i++) {
				int[] garo = new int[10];
				int[] sero = new int[10];
				for (int j = 0; j < 9; j++) {
					garo[arr[i][j]] += 1;
					if (garo[arr[i][j]] == 2) {
//						System.out.println("#"+t+" "+0);
						answer = 0;
						break;
					}

					sero[arr[j][i]] += 1;
					if (sero[arr[j][i]] == 2) {
						answer = 0;
						break;
					}

				}
				if (answer == 0)
					break;
			}

			for (int i = 1; i < 9; i += 3) {
				for (int j = 1; j < 9; j += 3) {
					if (!check(i, j, arr)) {
						answer=0;
						break;
					}
				}
				if(answer==0)break;
			}

			System.out.println("#" + (t + 1) + " " + answer);
		}

	}

	public static boolean check(int y, int x, int[][] arr) {
		int[] check=new int[10];
		for(int i=0;i<9;i++) {
			check[arr[y+dy[i]][x+dx[i]]]+=1;
			//System.out.println((y+dy[i])+" "+(x+dx[i]));
			//System.out.println(arr[y+dy[i]][x+dx[i]]);
			if(check[arr[y+dy[i]][x+dx[i]]]>=2)
			{
				return false;
			}
		}
		
		
		return true;
	}
}
