package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ_9012_괄호 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		for (int i = 0; i < n; i++) {
			char[] str = br.readLine().toCharArray();
			boolean flag = true;
			Stack<Character> st = new Stack();
			for (int j = 0; j < str.length; j++) {
				if (str[j] == '(') {
					st.push(str[j]);
				} else {
					if (st.isEmpty()) {
						flag = false;
						break;
					}
					st.pop();
				}

			}

			if (!flag || !st.isEmpty()) {
				System.out.println("NO");
			} else {

				System.out.println("YES");
			}

		}

	}
}
