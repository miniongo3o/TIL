package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class BOJ_1339_�ܾ���� {
	// pos ��ü�� ���ĺ�:���� ���ڸ� ǥ��, ������ ���� override
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
				// �ε������� �ڸ����� �����ش�.
				// 0�� �ε��� = ���� ū ���̹Ƿ� 10^n-1 
				for (int k = 1; k < len - j; k++) {
					ten *= 10;
				}
				// ���� 2 AAA C �� �Է� �޾��� �� 
				// p[1]=('A',111), p[3]=('C',1)
				list[(int) (arr[j] - 64)] += ten;
				p[(int) (arr[j] - 64)].num += ten;
				p[(int) (arr[j] - 64)].word = arr[j];
			}
		}
		// ���ĺ� ���� �ƴ�, �Է¹��� ���� �������� ������������ �������ش�.
		Arrays.sort(p);
		int idx=9;
		int sum=0;
		// ���ĺ��� 10�� �̸��̹Ƿ� 9���� 1���� �����Ѵ�.
		// ���� ū ���� ���� ���ĺ��� 9���� �������ְ� 1�� ���ҽ�Ų��.
		for (int i = 0; i <= 26; i++) {
			if (p[i].num != 0) {
				sum+=p[i].num*idx;
				idx--;
			}
		}
		System.out.println(sum);
	}
}
