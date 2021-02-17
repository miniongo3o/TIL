package algo_hw;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1992_쿼드트리 {
    private static int n,m;
    private static char map[][];
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine().trim());
        map=new char[n][n];
        
        for(int i=0;i<n;i++) {
        	map[i]=br.readLine().toCharArray();
        }
        
        
        doSomething(0,0,n);
	}
	
	private static boolean isOk(int row,int col,int n) {
		char condition=map[row][col];
		for(int i=row;i<row+n;i++) {
			for(int j=col;j<col+n;j++) {
				if(condition!=map[i][j]) {
					return false;
				}
			}
		}
		m=condition;
		return true;
	}
	
	private static void doSomething(int row,int col,int n) {
		if(isOk(row,col,n)) {
			System.out.print((m-'0'));
		}else {
			System.out.print("(");
			int s=n/2;
			for(int i=0;i<2;i++) {
				for(int j=0;j<2;j++) {
					doSomething(row+s*i, col+s*j, s);
				}
			}
			System.out.print(")");
		}
	}
}
