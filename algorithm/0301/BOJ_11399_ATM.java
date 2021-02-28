package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_11399_ATM {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n=Integer.parseInt(br.readLine());
		
		int[] arr=new int[n];
		String[] str=br.readLine().split(" ");
		for(int i=0;i<str.length;i++) {
			arr[i]=Integer.parseInt(str[i]);
		}
		Arrays.sort(arr);
		int sum=arr[0];
		for(int i=1;i<arr.length;i++) {
			arr[i]=arr[i]+arr[i-1];
			sum+=arr[i];
		}
		System.out.println(sum);
	}

}
