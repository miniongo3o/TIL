package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_17144_미세먼지안녕 {
	static int r, c, t;
	static int arr[][];
	static int temp[][];
	static int[] dy = { 1, -1, 0, 0 };
	static int[] dx = { 0, 0, 1, -1 };
	static int cleaner,cleaner2;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] str = br.readLine().split(" ");
		r = Integer.parseInt(str[0]);
		c = Integer.parseInt(str[1]);
		t = Integer.parseInt(str[2]);
		arr = new int[r][c];
		
		for (int i = 0; i < r; i++) {
			String[] temp = br.readLine().split(" ");
			for (int j = 0; j < c; j++) {
				arr[i][j] = Integer.parseInt(temp[j]);
				if(arr[i][j]==-1) {
					cleaner2=i;
				}
			}
		}
		cleaner=cleaner2-1;
		for (int time = 0; time < t; time++) {
			temp = new int[r][c];
			for (int i = 0; i < r; i++) {
				for (int j = 0; j < c; j++) {
					if (arr[i][j] > 0) {
						spread(i, j);
					}
				}
			}
			arr=temp;
			arr[cleaner][0]=-1;
			arr[cleaner2][0]=-1;
			move();
		}
		int sum=0;
		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				if(arr[i][j]>0) {
					sum+=arr[i][j];
				}
			}
		}
		System.out.println(sum);
		
	}

	// arr[y][x]>0 이면 호출하는 확산 함수
	public static void spread(int y, int x) {
		int cnt = 0;
		for (int dir = 0; dir < 4; dir++) {
			int ny = y + dy[dir];
			int nx = x + dx[dir];

			if (ny < 0 || nx < 0 || ny >= r || nx >= c || arr[ny][nx] == -1) {
				continue;
			}

			// 다음칸에 5분의 1만큼
			temp[ny][nx] += arr[y][x] / 5;
			cnt++;
		}
		temp[y][x] += arr[y][x] - (arr[y][x] / 5) * cnt;

	}

	public static void move() {
		
		//상단
		for(int i=cleaner-1;i>0;i--) {
			arr[i][0]=arr[i-1][0];
		}
		arr[0][0]=arr[0][1];
		
		for(int i=1;i<c-1;i++) {
			arr[0][i]=arr[0][i+1];
		}
		arr[0][c-1]=arr[1][c-1];
		for(int i=0;i<cleaner;i++) {
			arr[i][c-1]=arr[i+1][c-1];
		}
		arr[cleaner][c-1]=arr[cleaner][c-2];
		for(int i=c-2;i>1;i--) {
			arr[cleaner][i]=arr[cleaner][i-1];
		}
		arr[cleaner][1]=0;
		
		//하단
		for(int i=cleaner2+1;i<r-1;i++) {
			arr[i][0]=arr[i+1][0];
		}
		arr[r-1][0]=arr[r-1][1];
		
		for(int i=1;i<c-1;i++) {
			arr[r-1][i]=arr[r-1][i+1];
		}
		arr[r-1][c-1]=arr[r-2][c-1];
		
		for(int i=r-1;i>cleaner2;i--) {
			arr[i][c-1]=arr[i-1][c-1];
		}
		arr[cleaner2][c-1]=arr[cleaner2][c-2];
		
		for(int i=c-2;i>1;i--) {
			arr[cleaner2][i]=arr[cleaner2][i-1];
		}
		arr[cleaner2][1]=0;
		
	}
}
