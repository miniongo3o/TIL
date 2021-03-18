
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class MST1_KruskalTest {
	
	
	static class Edge implements Comparable<Edge>{
		int from,to,weight;
		public Edge(int from,int to,int weight) {
			super();
			this.from=from;
			this.to=to;
			this.weight=weight;
		}
		
		@Override
		public int compareTo(Edge o) {
			//return this.weight-o.weight;
			// 가중치가 음수가 있을 때를 대비.
			// 언더플로우나 오버플로우를 대비한다..
			return Integer.compare(this.weight, o.weight);
		}
	}
	
	static int V,E;
	static int parents[];
	static Edge[] edgeList;
	//크기가 1인 단위 집합을 만든다.
	static void make() {
		for(int i=0;i<V;i++) {
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
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine()," ");
		V=Integer.parseInt(st.nextToken());
		E=Integer.parseInt(st.nextToken());
		
		parents=new int[V];
		edgeList=new Edge[E];
		for(int i=0;i<E;i++) {
			st=new StringTokenizer(br.readLine()," ");
			int from=Integer.parseInt(st.nextToken());
			int to=Integer.parseInt(st.nextToken());
			int weight=Integer.parseInt(st.nextToken());
			edgeList[i]=new Edge(from, to, weight);
		}//간선 리스트
		
		//1.간선리스트 가중치 기준 오름차순 정렬
		Arrays.sort(edgeList);
		
		make();
		int result=0;
		int count=0; // 선택한 간선 수
		
		for(Edge edge:edgeList) {
			if(union(edge.from,edge.to)) {
				//사이클이 발생하지않는경우 = true
				result+=edge.weight;
				if(++count==V-1) {
					//정점 갯수-1 = 목표 간선의 수
					break;
				}
			}
		}
		System.out.println(result);
	}
}
