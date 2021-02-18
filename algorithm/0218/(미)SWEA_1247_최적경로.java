package ssafy_algo_0218;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SWEA_1247_최적경로 {

	public static int length(int[] a, int[] b) {
		return Math.abs(a[0] - b[0]) + Math.abs(a[1] - b[1]);
	}

	public static int Ans = Integer.MAX_VALUE;
	public static int Temp;
	public static int[][] rc;
	public static int[] work;
	public static int[] home;
	public static int N;

	public static int[] comb;

	public static void Simulation() {
	}

	public static void Search(int cnt, int startIdx) {
		if (cnt == N) {
			Simulation();
			return;
		}
		for (int i = startIdx; i < N; i++) {
			comb[cnt] = i;
			Search(cnt + 1, startIdx+1);
		}
	}

	static void Search(int toSelect,cnt) {
		if (cnt == N) {
			Simulation();
			return;
		}
		
		for(int i=0;i<num.length;i++) {
			if(!visited[i]) {
				visited[i]=true;
				selected[toSelect]=num[i];
				makePermutation(toSelect+1,selected,visited);
				visited[i]=false;
			}
		}
		
	public static void main(String args[]) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());

		for (int test_case = 1; test_case <= T; test_case++) {
			N = Integer.parseInt(br.readLine().trim());
			rc = new int[N][2];
			comb = new int[N];
			work = new int[2];
			home = new int[2];

			st = new StringTokenizer(br.readLine());
			work[0] = Integer.parseInt(st.nextToken());
			work[1] = Integer.parseInt(st.nextToken());
			home[0] = Integer.parseInt(st.nextToken());
			home[1] = Integer.parseInt(st.nextToken());
			for (int i = 0; i < N; i++) {
				rc[i][0] = Integer.parseInt(st.nextToken());
				rc[i][1] = Integer.parseInt(st.nextToken());
			}

			Search(0, 0);

			System.out.println("#" + test_case + " " + Ans);
//	            초기화
			Ans = Integer.MAX_VALUE;
		}
	}
}
/*
 * 회사, 집, 고객 회사->고객->집 답 :200 회사: 0,0 집 : 100 100
 * 
 * 90 70 / 40 70 40 / 50 50 20 / 40 30 10 / 30 10 5 / 25 / 15
 * 
 * 
 * 
 */