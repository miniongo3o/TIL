package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SWEA_9940_순열1 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		int n=Integer.parseInt(br.readLine());
		StringBuilder sb=new StringBuilder();
		
		for(int t=1;t<=n;t++) {
			int m=Integer.parseInt(br.readLine());
			String[] str=br.readLine().split(" ");
			boolean[] arr=new boolean[m+1];
			String answer="Yes";
			for(int i=0;i<m;i++) {
				if(arr[Integer.parseInt(str[i])]) {
					answer="No";
					break;
				}else {
					arr[Integer.parseInt(str[i])]=true;
				}
			}
			sb.append("#"+t+" "+answer+"\n");
			
			
		}
		sb.setLength(sb.length()-1);
		System.out.println(sb);
	}
}
