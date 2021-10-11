import java.util.*;
import java.util.Scanner;
import java.util.Stack;
public class BalancedBrackets {
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		BalancedBrackets ob=new BalancedBrackets();
		
		System.out.println("Enter the expression consisiting of opening and closing brackets ");
		String exp=sc.nextLine();
		boolean flag=ob.checkBracket(exp);
		if(flag)
			System.out.println("Balanced brackets");
		else
			System.out.println("Brackets unbalanced");

	}
	
	public boolean checkBracket(String exp)
	{
		if(exp.length()%2!=0)
		{
			return false;
		}
		Stack<Character> bracketStack=new Stack<>();
		for(int i=0;i<exp.length();i++)
		{
			char bracket=exp.charAt(i);
			if(bracket=='{'||bracket=='['||bracket=='(')
			{
				bracketStack.push(bracket);
			}
			else
			{
				char topChar=bracketStack.pop();
				switch(bracket)
				{
				case '}':
					if(topChar=='['||topChar=='(')
					{
						return false;
					}
					else
						return true;
				case ']':
					if(topChar=='{'||topChar=='(')
					{
						return false;
					}
					else
						return true;
				case ')':
					if(topChar=='['||topChar=='{')
					{
						return false;
					}
					else
						return true;
				default: return bracketStack.isEmpty();
				
				}
			}
		}
		return false;
	}

}
