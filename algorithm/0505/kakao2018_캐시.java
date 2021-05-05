package programmers;

import java.util.LinkedList;
import java.util.Queue;

public class kakao2018_캐시 {
	public static void main(String[] args) {

		int cach = 3;
		String[] city = { "Jeju", "Pangyo", "Seoul", "NewYork", "LA", "Jeju", "Pangyo", "Seoul", "NewYork", "LA" };
//		String[] city={"Jeju", "Pangyo", "Seoul", "NewYork", "LA", "Jeju", "Pangyo", "Seoul", "NewYork", "LA"};

		System.out.println(solution(cach, city));
	}

	public static int solution(int cach, String[] city) {
		int answer = 0;
		// 1. 캐시사이즈가 0이면, LRU를 따질 필요 없이 들어올 때마다 +5하여 return
		if (cach == 0)
			return city.length * 5;
		LinkedList<String> q = new LinkedList();

		for (String s : city) {
			
			// 2. 모두 소문자로 변경하여 처리
			s= s.toLowerCase();
			
			// 3. LinkedList에 해당 값이 있을 떄 remove를 하면 true, 아니면 false를 return하므로
			//    true인 경우 해당 값을 삭제하고 가장 앞에 추가한다.(addFirst) 왜 ? LRU(Least Recently Used)이므로
			//    가장 사용되지 않은 것들은 자동으로 뒤로 밀린다. 이미 캐시안에 있던 것이므로 +1
			if(q.remove(s)) {
				q.addFirst(s);
				answer++;
			}else {
				
				// 4. LinkedList에 해당 값이 없었을 때, 캐시가 꽉 차있다면 마지막 값을 삭제하고 새로운 String을 맨앞에 추가해준다.(LRU)
				if(q.size()==cach) { 
					q.pollLast();
				}
				
				// 5. 캐시에 새로운 값이 들어온 것이므로 +5 
				q.addFirst(s);
				answer+=5;	
				
				
			}
			
		}

		return answer;
	}
}
