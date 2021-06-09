package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class BOJ_21610_��������ͺ�ٶ�� {
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
		// y,x��ǥ�� �������� �簢�� ������� ������ ����� ����Ѵ�.
		// �� ��ǥ�� �밢���� ���� ������(0�� �ƴϸ�), �� ������ŭ ���� ������Ų��.
		// ����ǥ�� ����Ǿ������ʴ�.
	}

	public static void move(int dir, int cnt) {
		// y,x��ǥ�� �������� �ϴ� �簢�� ����� ������
		// �̵��Ѵ�. ���� ���� ����Ǿ� �ִ�.
		// dir �������� cnt��ŭ �̵��Ѵ�.
		
		
		for(pos p:list) {
			int y=p.y;
			int x=p.x;
			int ny=y+dy[dir]*cnt;
			int nx=x+dx[dir]*cnt;
			
		}
	}

	public static void rain() {
		// ������ �ִ� ��� ĭ�� �� 1 ������.
		// ������ �������.
	}
}
