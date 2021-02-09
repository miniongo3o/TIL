package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SWEA_1288_새로운불면증치료법 {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int N=Integer.parseInt(br.readLine());
		for(int t=1;t<=N;t++) {
			String num=br.readLine();
			int to=Integer.parseInt(num);
			boolean[] check=new boolean[10];
			String cnt=""; //진행 횟수
			int checknum=0; // 배열 체크횟수
			while(true) {
				
				for(int i=0;i<num.length();i++) {
					int temp=(int)num.charAt(i)-'0';
					if(!check[temp]) {
						check[temp]=true;
						checknum++;
						System.out.print(temp+" ");
						if(checknum==10) {
							cnt=num;
							break;
						}
					}
				}
				if(checknum==10) {
					break;
				}
				
				num=Integer.toString(to+Integer.parseInt(num));
			}
			System.out.println("#"+t+" "+cnt);
			
		}
	}
}
