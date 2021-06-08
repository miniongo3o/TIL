package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class BOJ_1339_단어수학 {
	// pos 객체로 알파벳:현재 숫자를 표현, 정렬을 위해 override
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
				// 인덱스마다 자릿수를 곱해준다.
				// 0번 인덱스 = 가장 큰 수이므로 10^n-1 
				for (int k = 1; k < len - j; k++) {
					ten *= 10;
				}
				// 만약 2 AAA C 를 입력 받았을 때 
				// p[1]=('A',111), p[3]=('C',1)
				list[(int) (arr[j] - 64)] += ten;
				p[(int) (arr[j] - 64)].num += ten;
				p[(int) (arr[j] - 64)].word = arr[j];
			}
		}
		// 알파벳 순이 아닌, 입력받은 수를 기준으로 내림차순으로 정렬해준다.
		Arrays.sort(p);
		int idx=9;
		int sum=0;
		// 알파벳은 10개 미만이므로 9부터 1까지 존재한다.
		// 가장 큰 값을 가진 알파벳을 9부터 설정해주고 1씩 감소시킨다.
		for (int i = 0; i <= 26; i++) {
			if (p[i].num != 0) {
				sum+=p[i].num*idx;
				idx--;
			}
		}
		System.out.println(sum);
	}
}
