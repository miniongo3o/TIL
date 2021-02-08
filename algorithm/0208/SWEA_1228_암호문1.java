package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

class node{
	int data;
	node next;
	
	public node(int data) {
		super();
		this.data = data;
	}
	
	
}

public class SWEA_1228 {
	node head=new node(-1); //더미노드
	
	public  void push(int n) {
		node newnode=new node(n);
		
		if(head.next==null) {
			head.next=newnode;
			return;
		}
		
		node cur=head.next;
		while(cur.next!=null) {
			cur=cur.next;
		}
		cur.next=newnode;
		return;
		
	}
	
	public  void insert(int startIdx,String[] str) {
		node newNode=new node(Integer.parseInt(str[0]));
		node cur=newNode;
		for(int i=1;i<str.length;i++) {
			node temp=new node(Integer.parseInt(str[i]));
			cur.next=temp;
			cur=cur.next;
		}
		
		node search=head;
		for(int i=0;i<startIdx;i++) {
			search=search.next;
		}
		node next=search.next;
		search.next=newNode;
		cur.next=next;
		return;
	}
	
	public void printall() {
		node cur=head.next;
		int cnt=0;
		while(cnt!=10) {
			cnt++;
			System.out.print(cur.data+" ");
			cur=cur.next;
		}
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		for(int t=1;t<=10;t++) {
			
			SWEA_1228 mine=new SWEA_1228();
			
			int N=Integer.parseInt(br.readLine());
			String[] str=br.readLine().split(" ");
			for(int i=0;i<N;i++) {
				mine.push(Integer.parseInt(str[i]));
						
			}
			int order=Integer.parseInt(br.readLine());
			String[] temp=br.readLine().split(" ");
			//int startIdx=Integer.parseInt(temp[1]);
			//int number=Integer.parseInt(temp[2]);
			for(int i=0;i<temp.length;i++) {
				if(temp[i].equals("I")) {
					int start=Integer.parseInt(temp[i+1]);
					int x=Integer.parseInt(temp[i+2]);
					String[] param=new String[x];
					for(int j=0;j<x;j++) {
						param[j]=temp[i+3+j];
					}
					mine.insert(start,param);
					
				}
			}
			System.out.print("#"+t+" ");
			mine.printall();
			System.out.println();
			
		}
		
	}
}
