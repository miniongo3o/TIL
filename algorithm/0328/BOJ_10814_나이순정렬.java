package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_10814_나이순정렬 {
	static class man implements Comparable<man>{
		int age;
		String name;
		public man(int age,String name) {
			this.age=age;
			this.name=name;
		}
		@Override
		public int compareTo(man o) {
			// TODO Auto-generated method stub
			return this.age-o.age;
		}
		public String toString() {
			return this.age+" "+this.name;
		}
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		man[] arr=new man[n];
		for(int i=0;i<n;i++) {
			String[] str=br.readLine().split(" ");
			arr[i]=new man(Integer.parseInt(str[0]),str[1]);
		}
		Arrays.sort(arr);
		for(int i=0;i<n;i++) {
			System.out.println(arr[i]);
		}
	}
}
