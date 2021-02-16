package ssafy_algo_0216;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_2839_설탕배달 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int three=0;
		int five=0;
//		
//		if (n == 4 || n == 7) {
//			System.out.println(-1);
//			return;
//		}
//		if (n % 5 == 0) {
//			System.out.println(n / 5);
//			return;
//		}
//		
//		if ((n % 5) == 1 || (n % 5) == 3) {
//			System.out.println((n / 5) + 1);
//			return;
//		}
//
//		if ((n % 5) == 2 || (n % 5) == 4) {
//			System.out.println((n / 5) + 2);
//			return;
//		}
		
		while(n%5!=0&&n>=0) {
			n=n-3;
			three++;
		}
		
		if(n<0) {
			System.out.println(-1);
		}else {
			System.out.println(((n/5)+three));
		}
		
	}
}
