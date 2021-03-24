package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_2636_치즈 {
	static int[] dy = { 0, 1, 0, -1 };
	static int[] dx = { 1, 0, -1, 0 };
	static int n, m,cnt,answer;
	static boolean[][] visit;
	static int[][] arr;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] str = br.readLine().split(" ");
		n = Integer.parseInt(str[0]);
		m = Integer.parseInt(str[1]);
		arr = new int[n][m];
		visit = new boolean[n][m];
		for (int i = 0; i < n; i++) {
			String[] temp = br.readLine().split(" ");
			for (int j = 0; j < m; j++) {
				arr[i][j] = Integer.parseInt(temp[j]);
			}
		}

//		for (int i = 0; i < n; i++) {
//			for (int j = 0; j < m; j++) {
//				System.out.print(arr[i][j]);
//			}
//			System.out.println();
//		}
//		System.out.println("=====================");
		while(cheese()) {
			visit=new boolean[n][m];
			dfs(0, 0);
		}
//		for (int i = 0; i < n; i++) {
//			for (int j = 0; j < m; j++) {
//				System.out.print(arr[i][j]);
//			}
//			System.out.println();
//		}
		System.out.println(cnt+ " " + answer);
	}

	private static void dfs(int y, int x) {

		for (int dir = 0; dir < 4; dir++) {
			int ny = y + dy[dir];
			int nx = x + dx[dir];

			if (ny >= 0 && nx >= 0 && ny < n && nx < m && !visit[ny][nx]) {
				visit[ny][nx] = true;
				if (arr[ny][nx] == 1) {
					arr[ny][nx] = 0;
				} else {
					dfs(ny, nx);
				}
			}

		}
	}
	private static boolean cheese() {
		cnt++;
		int temp=0;
		boolean flag=false;
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				if(arr[i][j]==1) {
					flag=true;
					temp++;
				}
			}
		}
		if(flag)answer=temp;
		if(!flag)cnt-=1;
		return flag;
	}
}
