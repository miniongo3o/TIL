package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class BOJ_21610_마법사상어와비바라기 {
	static int N, M;
	static int[][] arr;
	static int[] dy= {0,-1,-1,-1,0,1,1,1};
	static int[] dx= {-1,-1,0,1,1,1,0,-1};

	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String[] str=br.readLine().split(" ");
		N=Integer.parseInt(str[0]);
		M=Integer.parseInt(str[1]);
		arr=new int[N][N];
		for(int i=0;i<N;i++) {
			String[] temp=br.readLine().split(" ");
			for(int j=0;j<N;j++) {
				arr[i][j]=Integer.parseInt(temp[j]);
			}
		}
		pos moveData[]=new pos[M];
		
		list.add(new pos(N-1,0));
		list.add(new pos(N-2,0));
		list.add(new pos(N-1,1));
		list.add(new pos(N-2,1));
		
		for(int i=0;i<M;i++) {
			String[] temp=br.readLine().split(" ");
			int dir=Integer.parseInt(temp[0]);
			int cnt=Integer.parseInt(temp[1]);
			solution(dir,cnt);
		}
	}
	static ArrayList<pos> list= new ArrayList();
	public static void solution(int dir, int cnt) {

		move(dir, cnt);
		rain();
		copy();

	}

	static class pos {
		int y, x;

		public pos(int y, int x) {
			this.y = y;
			this.x = x;
		}
	}

	// pos= new int[2][2]
	public static void copy() {
		// y,x좌표를 기준으로 사각형 모양으로 물복사 기술을 사용한다.
		// 각 좌표의 대각선에 물이 있으면(0이 아니면), 그 갯수만큼 물을 증가시킨다.
		// 끝좌표는 연결되어있지않다.
	}

	public static void move(int dir, int cnt) {
		// y,x좌표를 기준으로 하는 사각형 모양의 구름이
		// 이동한다. 끝과 끝은 연결되어 있다.
		// dir 방향으로 cnt만큼 이동한다.
		
		
		for(pos p:list) {
			int y=p.y;
			int x=p.x;
			int ny=y+dy[dir]*cnt;
			int nx=x+dx[dir]*cnt;
			
		}
	}

	public static void rain() {
		// 구름이 있는 모든 칸에 비를 1 내린다.
		// 구름이 사라진다.
	}
}
