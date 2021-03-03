package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SWEA_10032_과자분배 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		for(int t=1;t<=n;t++) {
			String[] str=br.readLine().split(" ");
			int a=Integer.parseInt(str[0]);
			int b=Integer.parseInt(str[1]);
			int result=a%b;
            if(result!=0){
                result=1;
            }
			// 과자의수보다 사람의 수가 많을때는 a%bㅀ 해결할 수 없음
			//
			sb.append("#"+t+" "+result+"\n");
		}
	    sb.setLength(sb.length()-1);
		System.out.println(sb);
	}
}
