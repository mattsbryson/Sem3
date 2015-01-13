import java.util.*;

public class JParser 
{
	//input is unparsed, space delimited name
	public static ArrayList<String> NameInputToArrayList(String InputName)
	{
		InputName.toLowerCase();
		ArrayList<String> ParsedName = new ArrayList <String>();
		int split;
		while((split = InputName.indexOf(' ')) != -1 || InputName.length() > 1)
		{
			if(split != -1)
			{
				ParsedName.add(InputName.substring(0, split));
				InputName = InputName.substring(split + 1);
			}
			else
			{
				ParsedName.add(InputName);
				InputName = "";
			}
		}
		return ParsedName;
	}
		
	public static String NameArrayToString(ArrayList<String> ParsedName)
	{
		String FullName = "";
		for(int i = 0; i < ParsedName.size(); i++)
		{
			FullName += ParsedName.get(i);
		}
		return FullName;
	}
	
	public static String InputLineToSSNString(String line)
	{
	     String ssn = line.substring(0, line.indexOf(':'));
         line = line.substring(line.indexOf(':') + 1);
         String first = line.substring(0, line.indexOf(':'));
         line = line.substring(line.indexOf(':') + 1);
         String middle = line.substring(0, line.indexOf(':'));
         line = line.substring(line.indexOf(':') + 1);
         String last = line;
         
         return ssn;
	}
	
	public static String InputLineToFirstName(String line)
	{
	     String ssn = line.substring(0, line.indexOf(':'));
         line = line.substring(line.indexOf(':') + 1);
         String first = line.substring(0, line.indexOf(':'));
         line = line.substring(line.indexOf(':') + 1);
         String middle = line.substring(0, line.indexOf(':'));
         line = line.substring(line.indexOf(':') + 1);
         String last = line;
         
         return first;
	}
	
	public static String InputLineToMiddleName(String line)
	{
	     String ssn = line.substring(0, line.indexOf(':'));
         line = line.substring(line.indexOf(':') + 1);
         String first = line.substring(0, line.indexOf(':'));
         line = line.substring(line.indexOf(':') + 1);
         String middle = line.substring(0, line.indexOf(':'));
         line = line.substring(line.indexOf(':') + 1);
         String last = line;
         
         return middle;
	}
	
	public static String InputLineToLastName(String line)
	{
	     String ssn = line.substring(0, line.indexOf(':'));
         line = line.substring(line.indexOf(':') + 1);
         String first = line.substring(0, line.indexOf(':'));
         line = line.substring(line.indexOf(':') + 1);
         String middle = line.substring(0, line.indexOf(':'));
         line = line.substring(line.indexOf(':') + 1);
         String last = line;
         
         return last;
	}
	
	public static String InputLineToFullNameWSpaces(String line)
	{
	     String ssn = line.substring(0, line.indexOf(':'));
         line = line.substring(line.indexOf(':') + 1);
         String first = line.substring(0, line.indexOf(':'));
         line = line.substring(line.indexOf(':') + 1);
         String middle = line.substring(0, line.indexOf(':'));
         line = line.substring(line.indexOf(':') + 1);
         String last = line;
         
         return first + " " + middle + " " + last;
	}
	
	public static int InputLineToSSN(String line)
	{
	     String ssn = line.substring(0, line.indexOf(':'));
         line = line.substring(line.indexOf(':') + 1);
         String first = line.substring(0, line.indexOf(':'));
         line = line.substring(line.indexOf(':') + 1);
         String middle = line.substring(0, line.indexOf(':'));
         line = line.substring(line.indexOf(':') + 1);
         String last = line;
         
         ssn = ssn.replace("-", "");
         
         return Integer.parseInt(ssn);
	}
	
	
}
