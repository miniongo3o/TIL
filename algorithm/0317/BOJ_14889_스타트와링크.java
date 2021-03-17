package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_14889_스타트와링크 {
	static int mid, n,min=Integer.MAX_VALUE;
	static int[][] arr;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		mid = n / 2;
		arr = new int[n][n];
		for (int i = 0; i < n; i++) {
			String[] str = br.readLine().split(" ");
			for (int j = 0; j < n; j++) {
				arr[i][j] = Integer.parseInt(str[j]);
			}
		}
		comb(0,new int[mid],0,new boolean[n]);
		System.out.println(min/2);

	}

	private static void comb(int select, int[] selected, int startIdx, boolean visit[]) {
		if (select == mid) {
			int sum1 = 0;
			int sum2 = 0;
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if (i == j) {
						continue;
					}
					if (visit[i] && visit[j]) {
						System.out.println(i+","+j);
						sum1 += (arr[i][j] + arr[j][i]);
					}
					if(!visit[i]&&!visit[j]){
						sum2+= (arr[i][j] + arr[j][i]);
					}
				}
			}
			System.out.println("answer "+sum1+" "+sum2);
			min=Math.min(Math.abs(sum1-sum2),min);
			return;
		}
		
		for(int i=startIdx;i<n;i++) {
			selected[select]=i;
			visit[i]=true;
			comb(select+1,selected,i+1,visit);
			visit[i]=false;
		}
		
	}
}
