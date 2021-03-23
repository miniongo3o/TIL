package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1463_1로만들기 {
	static int n;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		int arr[] = new int[n + 1];
		arr[0]=arr[1]=0;
		for(int i=2;i<=n;i++) {
			arr[i]=arr[i-1]+1;
			if(i%2==0) {
				arr[i]=Math.min(arr[i], arr[i/2]+1);
			}
			if(i%3==0) {
				arr[i]=Math.min(arr[i], arr[i/3]+1);
			}
		}
		System.out.println(arr[n]);
		
	}
}
// 12 6 3 1
// 12 4 2 1