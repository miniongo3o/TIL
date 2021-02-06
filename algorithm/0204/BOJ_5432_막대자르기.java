package com.ssafy.AlgoPlus_0204;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/*

조건 : 
* 막대기는 아래것이 위를 포함하게만 가능!
* 레이저는 반드시 존재

( : 쇠막대기의 시작 or 레이저
) : 쇠막대기의 끝, 레이저의 끝

레이저 = )가 나왔을 때 idx-1 이 ( 여야한다.


() ( ( ( () () ) ( () ) () ) ) ( () )
    ~~~~~
     레이저를 쏘면, 막대기가 열린 수만큼 잘라진다 !! 
 
 
 1.데이터 입력
 2. 전체 문자열 수를 반복 돌면서 "(" 문자열이면 막대기 시작일 수 있으니 Stack에 추가
 3. ")" 
  3-1. idx-1 == '(' 레이저인경우. '('를 하나 감소해준다.stack에 저장된 '('개수 만큼 잘라자ㅣㄹ 수 있으므로 cnt에 추가
  3-2. idx-1 != '(' 막대기의 끝인경우. 잘라진 쇠막대기 1개를 cnt에 추가.


*/
public class SWEA_5432 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int N=Integer.parseInt(br.readLine());
		
		for(int i=1;i<=N;i++) {
			String str=br.readLine();
			char[] arr=new char[str.length()];
			for(int j=0;j<str.length();j++) {
				arr[j]=str.charAt(j);
			}
			int sum=0;
			Stack<Character> stack=new Stack<>();
			for(int j=0;j<str.length();j++) {
				if(arr[j]=='(')stack.push(arr[i]);
				else if(arr[j]==')'&&arr[j-1]=='(') {
					//레이저일때
					//레이저이므로 전에 넣었떤 ( 를 빼준다
					stack.pop();
					//현재 겹쳐진 막대의수를 더해준다.
					sum+=stack.size();
					
				}else if(arr[j]==')'&&arr[j-1]==')') {
					//레이저가 아닌, 막대의 끝일 때
					
					//막대가 끝이 났으므로, 하나의 (를 빼준다.
					stack.pop();
					//잘려진 막대기 끝을 하나 더해준다.
					sum+=1;
				}
			}
			System.out.println("#"+i+" "+sum);
		}
		
		
	}
}