package ssafy_algo_0208;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class SWEA_5215_햄버거다이어트 {
	static int target;
	static int N;
	static int[] taste;
	static int[] cal;
	static int maxTaste;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		int T=Integer.parseInt(br.readLine());
		
		for(int t=1;t<=T;t++) {
			maxTaste=-1;
			StringBuilder sb=new StringBuilder();
			String[] str=br.readLine().split(" ");
			N=Integer.parseInt(str[0]);
			target=Integer.parseInt(str[1]);
			taste=new int[N];
			cal=new int[N];
			for(int i=0;i<N;i++) {
				String[] temp=br.readLine().split(" ");
				taste[i]=Integer.parseInt(temp[0]);
				cal[i]=Integer.parseInt(temp[1]);
			}
			
			
			powerset(0,new boolean[N]);
			
			sb.append("#").append(t).append(" ").append(maxTaste);
			System.out.println(sb);
			
		}
	}
	
	
	public static void powerset(int select,boolean[] selected) {
		if(select==N) {
			int sumTaste=0;
			int sumCal=0;
			for(int i=0;i<N;i++) {
				if(selected[i]) {
					
					sumTaste+=taste[i];
					sumCal+=cal[i];
				}
				if(sumCal<=target&&maxTaste<sumTaste) {
					maxTaste=sumTaste;
				}
			}
			return;
		}
		
		selected[select]=true;
		powerset(select+1,selected);
		
		selected[select]=false;
		powerset(select+1,selected);
		
	}
}
