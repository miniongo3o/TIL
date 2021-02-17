package ssafy_algo_0217;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class BOJ_17135_캐슬디펜스 {
	public static class pos{
		int y,x;
		
		public pos(int y,int x) {
			super();
			this.x=x;
			this.y=y;
			
		}
		
	}
	
	static int N,M;
	static int d;
	static int[][] arr;
	static int[] archer,ar,tmpArr;
	static int kill=0;
	
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str=br.readLine().split(" ");
        N=Integer.parseInt(str[0]);
        M=Integer.parseInt(str[1]);
        d=Integer.parseInt(str[2]);
        arr=new int[N+1][M];
        
        for(int i=0;i<N;i++) {
        	String[] temp=br.readLine().split(" ");
        	for(int j=0;j<M;j++) {
        		arr[i][j]=Integer.parseInt(temp[j]);
        	}
        }
        
        ar=new int[3];
        tmpArr=new int[M];
        for(int i=0;i<M;i++) {
        	tmpArr[i]=i;
        }
        
	}
	
	private static void shot() {
		
	}
	private static void comb(int cnt,int startIdx) {
		if(cnt==3) {
			boolean [][] visit=new boolean[N][M];
			
			//3개선택된경우.
			//궁수의위치 arr[y][ar[i]]
			pos a1=new pos(N,ar[0]);
			pos a2=new pos(N,ar[1]);
			pos a3=new pos(N,ar[2]);
			
			for(int i=N-1;i>=0;i--) {
				
				
				
			}
		}
		
		if(startIdx==M) {
			return;
		}
		
		ar[cnt]=tmpArr[startIdx];
		comb(cnt+1,startIdx+1);
		comb(cnt,startIdx+1);
		
	}
	
	
	private static int getDist(pos p1,pos p2) {
		
		return Math.abs(p1.x-p2.x)+Math.abs(p1.y-p2.y);
	}
}
