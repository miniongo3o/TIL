package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ_14503_로봇청소기 {
	static int n, m;
	static int arr[][];
	static int dx[] = { 0, 1, 0, -1 };
	static int dy[] = { -1, 0, 1, 0 };
	static int max = -1;
	static int rx, ry, rd;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] str = br.readLine().split(" ");
		String[] robot = br.readLine().split(" ");

		n = Integer.parseInt(str[0]);
		m = Integer.parseInt(str[1]);
		arr = new int[n][m];

		ry = Integer.parseInt(robot[0]);
		rx = Integer.parseInt(robot[1]);
		rd = Integer.parseInt(robot[2]);

		for (int i = 0; i < n; i++) {
			str = br.readLine().split(" ");
			for (int j = 0; j < m; j++) {
				arr[i][j] = Integer.parseInt(str[j]);
			}
		}
		int cnt = 0;
		while(true) {
			if(arr[ry][rx]==0) {
				cnt++;
				arr[ry][rx]=2;
			}
			
			int check=0;
			for(int i=0;i<4;i++) {
				rd=rd-1;
				if(rd<0) {
					rd=3;
				}
				int ny=ry+dy[rd];
				int nx=rx+dx[rd];
				if(arr[ny][nx]==0) {
					rx=nx;
					ry=ny;
					check=1;
					break;
				}
			}
			if(check==1) {
				continue;
			}
			int dd=rd-2;
			if(dd==-2) {
				dd=2;
			}
			if(dd==-1) {
				dd=3;
			}
			rx=rx+dx[dd];
			ry=ry+dy[dd];
			
			if(arr[ry][rx]==1) {
				break;
			}
			
		}
		System.out.println(cnt);
		
	}

}
