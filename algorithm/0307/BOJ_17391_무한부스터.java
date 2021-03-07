package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_17391_무한부스터 {
	static int dy[]= {};
	static int dx[]= {};
	static int arr[][];
	public static void main(String[] args) throws IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		int n=Integer.parseInt(st.nextToken());
		int m=Integer.parseInt(st.nextToken());
		arr=new int[n][m];
		for(int i=0;i<n;i++) {
			st= new StringTokenizer(br.readLine());
			for(int j=0;j<m;j++) {
				arr[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		
		
		
	}
}

