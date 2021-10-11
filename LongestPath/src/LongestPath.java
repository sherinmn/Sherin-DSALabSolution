import java.util.*;
import java.util.Scanner;

public class LongestPath {
	
	static class Node{
		int data;
		Node left,right;
	}

public static Node newNode(int data)
{
	Node temp=new Node();
	temp.data=data;
	
	temp.left=null;
	temp.right=null;
	
	return temp;
	
}

public static ArrayList<Integer> checkLongestPath(Node root)
{
	if(root==null)
	{
		ArrayList<Integer> value=new ArrayList<>();
		return value;
	}
	
	ArrayList<Integer> right=checkLongestPath(root.right);
	
	ArrayList<Integer> left=checkLongestPath(root.left);
	
	if(right.size() < left.size())
	{
		left.add(root.data);
	}
	else
	{
		right.add(root.data);
	}
	
	return (left.size() > right.size()?left : right);
}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node node1=newNode(100);
		Node node2=newNode(20);
		Node node3=newNode(130);
		Node node4 =newNode(10);
		Node node5 =newNode(50);
		Node node6 =newNode(110);
		Node node7 =newNode(140);
		Node node8 =newNode(5);
		
		node4.left = node8;
		node2.left = node4;

		node2.right=node5;
		node3.left=node6;
		node3.right=node7;

		node1.right=node3;
		node1.left=node2;
		
		ArrayList<Integer> list=checkLongestPath(node1);
		int n=list.size();
		
		System.out.println("the longest path is -" );
		for(int i=n - 1;i >= 0;i--)
		{
			System.out.print(list.get(i)+"-> ");
		}
		
		

	}

}
