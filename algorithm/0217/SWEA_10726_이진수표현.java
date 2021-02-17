package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SWEA_10726_이진수표현 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		for (int t = 1; t <= n; t++) {
			String[] str = br.readLine().split(" ");
			int a = Integer.parseInt(str[0]);
			int b = Integer.parseInt(str[1]);
			//System.out.println(b & (1 << (a - 1)));
			boolean flag=true;
			for(int i=0;i<a;i++){
				if( (b&(1<<i))==0 ) {
					flag=false;
				}
			}
			
			if(flag) {
				System.out.println("ON");
			}else {
				System.out.println("OFF");
			}
			
			
		}
	}
}
