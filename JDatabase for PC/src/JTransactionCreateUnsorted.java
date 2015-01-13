
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Random;


public class JTransactionCreateUnsorted 
{
	public JTransactionCreateUnsorted(){};
	
	public JTransactionCreateUnsorted(int DbSize, String NameInput) 
	{
		//Initialize required variables 
		dbLength = DbSize;
		dataB = new String [dbLength] [4];
		ParsedName = JParser.NameInputToArrayList(NameInput);
		FullName = JParser.NameArrayToString(ParsedName);		
			
		
		int [] nType = new int [FullName.length()]; 
		
		// goes to lower case 
		FullName = FullName.toLowerCase();
		
		//vowels equal 0, cons. equals 1
		for(int i = 0; i < FullName.length(); i++)
		{
			if(FullName.charAt(i) == 'a' || FullName.charAt(i) == 'e' || FullName.charAt(i) == 'i' || FullName.charAt(i) == 'o' || FullName.charAt(i) == 'u')
			{
				nType [i] = 0;
			}
			else
			{
				nType [i] = 1;
			}
		}
		
		int [] stringB = new int[FullName.length()];
		
		
		//use to start at base values
		/*
		for(int i = 0; i < nType.length; i++)
		{
			stringB[i] = 0;
		}
		*/
		
		
		
		
		//test FullName
		//	System.out.println(FullName);
		
		for(int i = 0; i < nType.length; i++)
		{
			if(nType[i] == 0)
			{
				stringB[i] = index(nType[i], FullName.charAt(i));
			}
			else
			{
				stringB[i] = index(nType[i], FullName.charAt(i));
			}
			//System.out.print(stringB[i]);
		}
		
		//generate names
		boolean max  = false; 
		
		for(int i = 0; i < dbLength; i++)
		{
			stringB[0]++;
			for(int k = 0; k < stringB.length; k++)
			{
				if(stringB[k] > vow.length - 1 && nType[k] == 0)
				{
					
					if(stringB[stringB.length - 1] == vow.length - 1)
					{
						
						if(max == true )
						{
							System.out.println("Out of options, please enter a longer name."); //create new name method to call 
							System.exit(0);
						}
						else
						{
							//use to start at base values
							
							for(int g = 0; g < nType.length; g++)
							{
								stringB[g] = 0;
							}
							System.out.println("Started over");
							max = true;
						}
					}
					
					
					stringB[k] = 0;
					stringB[k+1]++;
				}
				else if(stringB[k] > cons.length - 1 && nType[k] == 1)
				{
					if(stringB[stringB.length - 1] == cons.length - 1)
					{
						
						if(max == true )
						{
							System.out.println("Out of options, please enter a longer name."); //create new name method to call 
							System.exit(0);
						}
						else
						{
							//use to start at base values
							
							for(int g = 0; g < nType.length; g++)
							{
								stringB[g] = 0;
							}
							System.out.println("Started over");
							max = true;
						}
					}
					stringB[k] = 0;
					stringB[k+1]++;
				}
			}
			//add generated number to array as string interpreted
			
			String temp = "";
			for(int c = 0; c < stringB.length; c++)
			{
				if(nType[c] == 0)
				{
					temp += vow[stringB[c]];
				}
				else
				{
					temp += cons[stringB[c]];
				}
			}
			//formats into database
			String [] dat = new String [4];
			// test output System.out.println(temp.length() + " " + " " + names.get(0).length() + names.get(0) + " " + names.get(1) + " " + names.get(2));
			dat [1] = temp.substring(0, ParsedName.get(0).length());
			dat [2] = temp.substring(ParsedName.get(0).length(), ParsedName.get(1).length() + ParsedName.get(0).length());
			dat [3] = temp.substring(ParsedName.get(1).length() + ParsedName.get(0).length(), temp.length());
		
			
			//SocialSecurityNumber
			//change to true to skip checking
			boolean dup = true;
			if(!dup)
			{
				boolean exist = false;
				String SocialSecurityNumber = "000000000";
				while(!exist)
				{
					exist = true;
					int rSocialSecurityNumber = (int) (Math.random() * 1000000000);
					//System.out.println(rSocialSecurityNumber);
					SocialSecurityNumber = rSocialSecurityNumber + SocialSecurityNumber;
					if(!(dataB[0][0] == null))
					{
						for(int n = 0; n < dataB.length; n++)
						{
							if(SocialSecurityNumber.equals(dataB[i][0]))
							{
								exist = false;
							}
						}
					}
					else
					{
						exist = true;
					}
				}
				dat [0] = SocialSecurityNumber.substring(0, 9);
				
			}
			else
			{
				String SocialSecurityNumber = "000000000";
				int rSocialSecurityNumber = (int) (Math.random() * 1000000000);
				//System.out.println(rSocialSecurityNumber);
				SocialSecurityNumber = rSocialSecurityNumber + SocialSecurityNumber;
				dat [0] = SocialSecurityNumber.substring(0, 9);
			}
			
			
			//save
			dataB [i] = dat;
			
			
		}
		
		//for SocialSecurityNumber use string with 00000000 then add random to it and then save string 
		
		

		
		
	}	
	
	public void setSize(int A)
	{
		dbLength = A;
	}
	
	
	public void printData(String FileName) throws IOException
	{
		File output = new File(FileName + ".txt");
		if(!output.exists())
		{
			output.createNewFile();
		}
		PrintWriter out = new PrintWriter(output);
		
		for(int i = 0; i < dataB.length; i++)
		{
			String [] temp = dataB [i];
			for(int k = 0; k < temp.length; k++)
			{
				if(temp.length - 1 == k)
				{
					out.print(temp[k]);
				}
				else if(k == 0)
				{
					for(int o = 0; o < temp[k].length(); o++)
					{
						out.print(temp[k].charAt(o));
						if(o == 2 || o == 4)
						{
							out.print("-");
						}
						
					}
					out.print(":");
				}
				else
				{
					out.print(temp[k] + ":");
				}
			}
			out.println();
		}
		out.close();
	}
	
	//index of char 
	private int index(int type, char find)
	{
		int c = 0;
		if(type == 0)
		{
			for(int i = 0; i < vow.length; i++)
			{
				if(find == vow[i])
				{
					c = i;
					break;
				}
			}
		}
		else
		{
			for(int i = 0; i < cons.length; i++)
			{
				if(find == cons[i])
				{
					c = i;
					break;
				}
			}
		}
		//System.out.print("I am c: " + c + " ");
		return c;
	}
	
	
	
					
	 
	
	private static String [] [] dataB;
	//private static ArrayList <String []> dataB = new ArrayList <String []> ();;
	private int dbLength = 0;
	private char [] cons = {'b', 'c', 'd', 'f', 'g', 'h', 'j', 'k', 'l', 'm', 'n', 'p', 'q', 'r', 's', 't', 'v', 'w', 'x', 'y', 'z'};
	private char [] vow = {'a', 'e', 'i', 'o', 'u'};
	ArrayList <String> ParsedName;
	String FullName;
	
}
	
	