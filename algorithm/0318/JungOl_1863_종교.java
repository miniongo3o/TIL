package JungOl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class JungOl_1863_종교 {
	static int n,cmd;
	static int[] parents;
	static int cnt;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] str=br.readLine().split(" ");
		n=Integer.parseInt(str[0]);
		cmd=Integer.parseInt(str[1]);
		parents=new int[n+1];
		cnt=1;
		for(int i=0;i<cmd;i++) {
			String[] temp=br.readLine().split(" ");
			int start=Integer.parseInt(temp[0]);
			int dest=Integer.parseInt(temp[1]);
			union(start,dest);
			
		}
		System.out.println(cnt);
	}
	private static void make() {
		for(int i=0;i<n;i++) {
			parents[i]=i;
		}
	}
	private static int findSet(int a) {
		if(parents[a]==a) {
			return a;
		}
		
		return parents[a]=findSet(parents[a]);
	}
	private static void union(int a,int b) {
		int roota=findSet(a);
		int rootb=findSet(b);
		if(roota==rootb) {
			return;
		}else {
			cnt++;
		}
	}
}
