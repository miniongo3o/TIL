package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class BOJ_15961_회전초밥 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] tmp = br.readLine().split(" ");
		int n = Integer.parseInt(tmp[0]);
		int d = Integer.parseInt(tmp[1]);
		int k = Integer.parseInt(tmp[2]);
		int c = Integer.parseInt(tmp[3]);

		int[] list = new int[n];
		for (int i = 0; i < n; ++i)
			list[i] = Integer.parseInt(br.readLine());

		int[] chk = new int[d + 1];
		chk[c]++;

		int cnt = 1;
		for (int i = 0; i < k; i++) {
			if (chk[list[i]]++ == 0)
				cnt++;
			System.out.println(chk[list[i]]+" "+list[i]);
		}
		int ans = cnt;

		for (int i = k; i < n + k; i++) {
			if (--chk[list[i - k]] == 0)
				cnt--;
			if (chk[list[i % n]]++ == 0)
				cnt++;
			if (cnt > ans)
				ans = cnt;
		}

		System.out.println(ans);
	}
}
