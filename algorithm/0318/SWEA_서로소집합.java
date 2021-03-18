package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class SWEA_서로소집합 {
	static int T;
	static int r, c;
	static ArrayList<Integer>[] arr;
	static int[] parents;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		StringBuilder sb=new StringBuilder();
		for (int t = 1; t <= T; t++) {
			String[] temp = br.readLine().split(" ");
			r = Integer.parseInt(temp[0])+1;
			c = Integer.parseInt(temp[1]);
			arr = new ArrayList[r];
			parents=new int[r];
			make();
			sb.append("#"+t+" ");
			for (int i = 0; i < c; i++) {
				String[] str = br.readLine().split(" ");
				int op = Integer.parseInt(str[0]);
				int start = Integer.parseInt(str[1]);
				int dest = Integer.parseInt(str[2]);
				
				if (op == 0) {
					union(start,dest);
				} else {
					if(findSet(start)==findSet(dest)) {
						sb.append(1);
					}else {
						sb.append(0);
					}
					
					
				}
			}
			sb.append("\n");
		}
		System.out.println(sb);
		
	}
	private static int findSet(int a) {
		if(parents[a]==a)return a;
		
		return parents[a]=findSet(parents[a]);
	}
	private static void make() {
		for(int i=0;i<r;i++) {
			parents[i]=i;
		}
	}
	private static boolean union(int a,int b) {
		int aroot=findSet(a);
		int broot=findSet(b);
		if(aroot==broot)return false;
		
		parents[broot]=aroot;
		return true;
	}
}
