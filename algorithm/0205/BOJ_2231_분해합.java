package ssafy_algo_0205;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//분해합
public class BOJ_2231 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str=br.readLine();
		int num=Integer.parseInt(str);
		int answer=0;
		for(int i=1;i<num;i++) {
			// 1부터, 숫자 num까지 시작 값은 본인 자신.
			
			int sum=i;
			String temp=Integer.toString(i);
			
			
			for(int p=0;p<temp.length();p++) {
				sum+=temp.charAt(p)-'0'; 
				
			}
			
			if(sum==num) {
				answer=i;
                break;
			}
			
			
		}
        System.out.println(answer);
		
		
	}
}
