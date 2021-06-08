package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class BOJ_1339_단어수학 {
	static class pos implements Comparable<pos> {
		int num;
		char word;

		public pos(int num, char word) {
			this.num = num;
			this.word = word;
		}

		@Override
		public int compareTo(pos o) {
			// TODO Auto-generated method stub
			return o.num - this.num;
		}

		public pos() {
			super();
		}
	}

	public static void main(String[] args) throws IOException {
//		char a='A';
//		System.out.println((int)(a-64));
//		int b=1;
//		System.out.println((char)(b+64));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] list = new int[27];
		pos[] p = new pos[27];
		for (int i = 0; i < 27; i++) {
			p[i] = new pos();
		}
		for (int i = 0; i < n; i++) {
			char[] arr = br.readLine().toCharArray();
			int len = arr.length;
			for (int j = 0; j < len; j++) {
				int ten = 1;
				for (int k = 1; k < len - j; k++) {
					ten *= 10;
				}
				list[(int) (arr[j] - 64)] += ten;
				p[(int) (arr[j] - 64)].num += ten;
				p[(int) (arr[j] - 64)].word = arr[j];
			}
		}
		Arrays.sort(p);
		int idx=9;
		int sum=0;
		for (int i = 0; i <= 26; i++) {
			if (p[i].num != 0) {
				sum+=p[i].num*idx;
				idx--;
			}
		}
		System.out.println(sum);
	}
}
