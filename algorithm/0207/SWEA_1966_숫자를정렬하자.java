package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class SWEA_1966 {
	public static void main(String[] args) throws NumberFormatException, IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N=Integer.parseInt(br.readLine());
		for(int i=1;i<=N;i++) {
			
			int size=Integer.parseInt(br.readLine());
			int[] arr=new int[size];
			String[] str=br.readLine().split(" ");
			for(int j=0;j<size;j++) {
				arr[j]=Integer.parseInt(str[j]);
			}
			Arrays.sort(arr);
			sb.append("#").append(i).append(" ");
			for(int k=0;k<size;k++) {
				sb.append(arr[k]).append(" ");
			}
			System.out.println(sb);
			sb.setLength(0);
			
		}
	}
}
