package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_11650_좌표정렬하기 {
	static class man implements Comparable<man>{
		int y,x;
		public man(int y,int x) {
			this.y=y;
			this.x=x;
		}
		@Override
		public int compareTo(man o) {
			// TODO Auto-generated method stub
			if(this.y==o.y) {
				return this.x-o.x;
			}
			return this.y-o.y;
		}
		public String toString() {
			return this.y+" "+this.x;
		}
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		man[] arr=new man[n];
		for(int i=0;i<n;i++) {
			String[] str=br.readLine().split(" ");
			arr[i]=new man(Integer.parseInt(str[0]),Integer.parseInt(str[1]));
		}
		Arrays.sort(arr);
		for(int i=0;i<n;i++) {
			System.out.println(arr[i]);
		}
	}
}
