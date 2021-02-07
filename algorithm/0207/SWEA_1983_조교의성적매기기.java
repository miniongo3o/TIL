package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// 조교의 성적매기기
public class SWEA_1983 {
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {

			String[] str = br.readLine().split(" ");
			int student = Integer.parseInt(str[0]);
			int wannaKnow = Integer.parseInt(str[1]);
			double want = 0;
			double[] arr = new double[student];
			for (int m = 0; m < student; m++) {
				String[] score = br.readLine().split(" ");
				arr[m] = ((double) Integer.parseInt(score[0]) * 35 / 100 + (double)Integer.parseInt(score[1]) * 45 / 100
						+ (double)Integer.parseInt(score[2]) * 20 / 100);
				if (m + 1 == wannaKnow)
					want = arr[m];
			}
			Arrays.sort(arr);
			for (int i = 0; i < student; i++) {
				if (arr[i] == want)
					wannaKnow = student - i;
			}
			//System.out.println(wannaKnow * 100 / student+" "+want);
			int rank = wannaKnow * 100 / student;

			String result = "";
			if (rank <= 10) {
				result="A+";
			} else if (rank <= 20) {
				result="A0";
			} else if (rank <= 30) {
				result="A-";
			} else if (rank <= 40) {
				result="B+";
			} else if (rank <= 50) {
				result="B0";
			} else if (rank <= 60) {
				result="B-";
			} else if (rank <= 70) {
				result="C+";
			} else if (rank <= 80) {
				result="C0";
			} else if (rank <= 90) {
				result="C-";
			} else {
				result="D0";
			}
			//System.out.println(Arrays.toString(arr));
			System.out.println("#"+t+" "+result);
		}
	}
}