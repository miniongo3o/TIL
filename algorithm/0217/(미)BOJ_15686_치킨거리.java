package ssafy_algo_0217;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class BOJ_15686_치킨거리 {
	
	 static class pos{
		int x,y;
		
		public pos(int x,int y) {
			super();
			this.x=x;
			this.y=y;
		}
		@Override
		public String toString() {
			return "store [x=" + x + ", y=" + y + "]";
		}
		
	}
	
	static int n,chicken;
	static int[][] arr;
	static ArrayList<pos> house=new ArrayList<pos>();
	static ArrayList<pos> store=new ArrayList<pos>();
	static int cidx=0;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String[] str=br.readLine().split(" ");
		n=Integer.parseInt(str[0]);
		chicken=Integer.parseInt(str[1]);
		arr=new int[n+1][n+1];
		
		//입력
		for(int i=1;i<=n;i++) {
			String[] temp=br.readLine().split(" ");
			for(int j=1;j<=n;j++) {
				int num=Integer.parseInt(temp[j-1]);
				arr[i][j]=num;
				if(num==1) {
					house.add(new pos(j,i));
				}else if(num==2) {
					store.add(new pos(j,i));
				}
			}
		}
		
		
		// 치킨집은 배열에관리
		// 집은 어레이리스트에 관리
		// 집을 돌면서, 치킨집과의 거리를 모두 계산
		// 그중 최소의 치킨집 선택.
		// 치킨집들의 선택된 값이 작은것들중 r개를 뽑는다.
		//치킨집은 치킨거리와 선택된횟수를 가지고있어야한다.
		int[] result=new int[store.size()];
		
		
	}
	
	private static int cal(pos a, pos b) {
		return Math.abs(a.x-b.x)+Math.abs(a.y-b.y);
	}
}
