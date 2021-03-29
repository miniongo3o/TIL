package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;

public class BOJ_1755_숫자놀이 {
	// 각 인데스 숫자에 맞는 문자열로 초기화한다.
	// 입력 값을 integer로 parse한 다음 map[index]로 접근하기 위함
	static String[] map = { "zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine" };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] str = br.readLine().split(" ");

		int start = Integer.parseInt(str[0]);
		int end = Integer.parseInt(str[1]);
		// 배열의 크기를 적당히 선언해준다.
		// 만약 5부터 8까지라면, 5,6,7,8 이므로 4개가 필요하다.
		// 따라서 끝값-시작값+1 만큼 크기로 배열을 선언해준다.
		String[] arr = new String[end - start + 1];

		// 정렬을 한 뒤의 결과 key값(String)에 맞는 value(Integer)를 받아오기 위해 해쉬맵을 선언한다.
		HashMap<String, Integer> hash = new HashMap<>();

		// 시작값부터 입력값까지 순회한다.
		for (int i = start; i <= end; i++) {
			// 만약 해당 값이 한자리 수라면 간단하게 인덱스로 접근한다.
			// 해쉬맵에는 해당 문자열을 키 값, 해당 인덱스(숫자)를 value로 입력해준다.
			if (i < 10) {
				arr[i - start] = map[i];
				hash.put(map[i], i);
			} else {
				// 만약 두자리수라면 인덱스의 십의 자리와 일의 자리를 구분하여 해쉬맵에 넣어준다.
				arr[i - start] = map[i / 10] + " " + map[i % 10];
				hash.put(map[i / 10] + " " + map[i % 10], i);
			}
		}

		// 문자열의 정렬은 기본적으로 구현되어있음
		Arrays.sort(arr);

		// 정렬한 순서대로, 키값을 이용하여 해당 value들을 출력해주면 문자열 순으로 정렬된 결과가 출력된다.
		for (int i = 0; i < arr.length; i++) {
			// 10개마다 개행을 위한 코드
			if (i > 0 && i % 10 == 0)
				System.out.println();
			System.out.print(hash.get(arr[i]) + " ");

		}
		System.out.println();

	}
}
