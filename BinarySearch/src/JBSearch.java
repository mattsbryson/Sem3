import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;


public class JBSearch {

	public static void main(String[] args) 
	{
		ArrayList <Integer> myList = listGen();
		Collections.sort(myList);
		Scanner reader = new Scanner(System.in);
		int find;
		
		System.out.print("What number would you like to look for: ");
		find = reader.nextInt();
		
		while(myList.size() > 1)
		{
			int mid = myList.get(myList.size()/2);
			if(find > mid)
			{
				myList.subList(0, (myList.size()/2 + 1));
			}
			else
			{
				myList.subList((myList.size()/2 + 1), myList.size());
			}
		}
		System.out.println(myList.get(0));

	}
	
	public static ArrayList <Integer> listGen()
	{
		ArrayList <Integer> temp = new ArrayList <Integer>();
		Random gen = new Random();
		
		for(int i = 0; i < 10000; i++)
		{
			temp.add(gen.nextInt());
		}
		
		
		return temp;
	}

}
