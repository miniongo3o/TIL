package ssafy_algo_0205;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SWEA_3499 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N=Integer.parseInt(br.readLine());
		for(int t=1;t<=N;t++) {
			StringBuilder answer=new StringBuilder();
			int cnt=Integer.parseInt(br.readLine());	
			String[] str=br.readLine().split(" ");
			if(cnt%2==0) {
				//짝수개일때
				for(int i=0;i<cnt/2;i++) {
					answer.append(str[i]).append(" ").append(str[i+cnt/2]).append(" ");
				}
				
				
			} else {
				for(int i=0;i<(cnt+1)/2-1;i++) {

					answer.append(str[i]).append(" ").append(str[i+(cnt+1)/2]).append(" ");
				}
				answer.append(str[(cnt+1)/2-1]);
				
				
			}
			System.out.println("#"+t+" "+answer.toString());
		}
	}
}
