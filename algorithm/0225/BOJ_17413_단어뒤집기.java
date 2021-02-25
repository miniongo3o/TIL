package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ_17413_단어뒤집기 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		StringBuilder sb = new StringBuilder();
		boolean flag = false;
		Stack<Character> st = new Stack<Character>();
		
		for (int i = 0; i < str.length(); i++) {
			char a = str.charAt(i);
			if (a == ' ') {
				while (!st.empty()) {
					sb.append(st.pop());
				}
				sb.append(a);
				continue;
			}
			// 태그를 만나면 flag true.
			if (a == '<') {
				flag = true;
			}

			// true일 때는 문장을 뒤집지 않고 넣어준다.
			if (flag) {

				// 태그를 만났는데, 스택이 비어있지않다면?
				while (!st.empty()) {
					sb.append(st.pop());
				}
				sb.append(a);
			} else {	
				// false일 때는 stack에 넣어준다.
				st.push(a);
			}

			// 닫는 태그를 만나면 flag를 false로 바꿔줘서 다시 반대로 넣게한다.
			if (a == '>') {
				flag = false;
			}
		}
		while (!st.empty()) {
			sb.append(st.pop());
		}
		System.out.println(sb);
	}
}
