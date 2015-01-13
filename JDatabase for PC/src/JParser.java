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
	
	public static String InputLineToSocialSecurityNumberString(String line)
	{
	     String SocialSecurityNumber = line.substring(0, line.indexOf(':'));
         line = line.substring(line.indexOf(':') + 1);
         String FirstName = line.substring(0, line.indexOf(':'));
         line = line.substring(line.indexOf(':') + 1);
         String MiddleName = line.substring(0, line.indexOf(':'));
         line = line.substring(line.indexOf(':') + 1);
         String LastName = line;
         
         return SocialSecurityNumber;
	}
	
	public static String InputLineToFirstName(String line)
	{
	     String SocialSecurityNumber = line.substring(0, line.indexOf(':'));
         line = line.substring(line.indexOf(':') + 1);
         String FirstName = line.substring(0, line.indexOf(':'));
         line = line.substring(line.indexOf(':') + 1);
         String MiddleName = line.substring(0, line.indexOf(':'));
         line = line.substring(line.indexOf(':') + 1);
         String LastName = line;
         
         return FirstName;
	}
	
	public static String InputLineToMiddleName(String line)
	{
	     String SocialSecurityNumber = line.substring(0, line.indexOf(':'));
         line = line.substring(line.indexOf(':') + 1);
         String FirstName = line.substring(0, line.indexOf(':'));
         line = line.substring(line.indexOf(':') + 1);
         String MiddleName = line.substring(0, line.indexOf(':'));
         line = line.substring(line.indexOf(':') + 1);
         String LastName = line;
         
         return MiddleName;
	}
	
	public static String InputLineToLastName(String line)
	{
	     String SocialSecurityNumber = line.substring(0, line.indexOf(':'));
         line = line.substring(line.indexOf(':') + 1);
         String FirstName = line.substring(0, line.indexOf(':'));
         line = line.substring(line.indexOf(':') + 1);
         String MiddleName = line.substring(0, line.indexOf(':'));
         line = line.substring(line.indexOf(':') + 1);
         String LastName = line;
         
         return LastName;
	}
	
	public static String InputLineToFullNameWSpaces(String line)
	{
	     String SocialSecurityNumber = line.substring(0, line.indexOf(':'));
         line = line.substring(line.indexOf(':') + 1);
         String FirstName = line.substring(0, line.indexOf(':'));
         line = line.substring(line.indexOf(':') + 1);
         String MiddleName = line.substring(0, line.indexOf(':'));
         line = line.substring(line.indexOf(':') + 1);
         String LastName = line;
         
         return FirstName + " " + MiddleName + " " + LastName;
	}
	
	public static int InputLineToSocialSecurityNumber(String line)
	{
	     String SocialSecurityNumber = line.substring(0, line.indexOf(':'));
         line = line.substring(line.indexOf(':') + 1);
         String FirstName = line.substring(0, line.indexOf(':'));
         line = line.substring(line.indexOf(':') + 1);
         String MiddleName = line.substring(0, line.indexOf(':'));
         line = line.substring(line.indexOf(':') + 1);
         String LastName = line;
         
         SocialSecurityNumber = SocialSecurityNumber.replace("-", "");
         
         return Integer.parseInt(SocialSecurityNumber);
	}
	
	
}
