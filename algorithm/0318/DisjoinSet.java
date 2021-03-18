import java.util.Arrays;

public class DisoinSetTest {
	static int N;
	static int parents[];
	
	//크기가 1인 단위 집합을 만든다.
	static void make() {
		for(int i=0;i<N;i++) {
			parents[i]=i;
		}
	}
	//어느 집합에 속해있는지 집합의 대표자를 찾아준다.
	static int findSet(int a) {
		//내가 이 집합의 대표자면 스스로를 return
		if(parents[a]==a)return a;
		
		
		// path compression 하기 전
		// return findSet(parents[a]);
		
		// path compression 후 
		return parents[a]=findSet(parents[a]);
		
	}
	// boolean형 return이 아닌 void여도 상관은 없다.
	
	static boolean union(int a,int b) {
		int aRoot=findSet(a);
		int bRoot=findSet(b);
		if(aRoot==bRoot) return false;
		
		parents[bRoot]=aRoot;
		return true;
	}
	public static void main(String[] args) {
		N=5;
		parents=new int[N];
		
		//1.make set
		make();
		
		// union
		System.out.println("====union=====");
		System.out.println(union(0,1));
		System.out.println(Arrays.toString(parents));
		System.out.println(union(1,2));
		System.out.println(Arrays.toString(parents));
		System.out.println(union(3,4));
		System.out.println(Arrays.toString(parents));
		System.out.println(union(0,2));
		System.out.println(Arrays.toString(parents));
		System.out.println(union(0,4));
		System.out.println(Arrays.toString(parents));
		
		//find
		System.out.println("====find=====");
		System.out.println(findSet(4));
		System.out.println(Arrays.toString(parents));
		System.out.println(findSet(3));
		System.out.println(Arrays.toString(parents));
		System.out.println(findSet(2));
		System.out.println(Arrays.toString(parents));
		System.out.println(findSet(0));
		System.out.println(Arrays.toString(parents));
		System.out.println(findSet(1));
		System.out.println(Arrays.toString(parents));
		
		
	}
}
