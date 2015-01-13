import java.io.*;
import java.util.Scanner;

public class JBinarySearch 
{
	public static String SocialSecurityNumberSearch(String search) throws IOException
	{
		int searchInt = Integer.parseInt(search);
		Scanner in = new Scanner(new File("SlaveMaster.txt"));
		int length = in.next().length() + 2; //plus one for mac, two for pc
		in.close();
		RandomAccessFile master = new RandomAccessFile(new File("SlaveMaster.txt"), "r");
		
		int line = 0;
		byte [] buff = new byte[length];
	    int begin = 0;
	    int end = (int) master.length() / length;
	    while (begin <= end) 
	    {
	        int mid = (begin + end) / 2;
	        master.seek(mid * length);
	        master.read(buff);
	        String info = new String(buff);
	        line = JParser.InputLineToSocialSecurityNumber(info);

	        if (line == 0 || line > searchInt) 
	        {
	        	if(line == searchInt)
	        	{
	        		return info;
	        	}
	            end = mid - 1;
	        } 
	        else 
	        {
	        	if(line == searchInt)
	        	{
	        		return info;
	        	}
	            begin = mid + 1;
	        }
	    }
	    
	    return "SocialSecurityNumber was not found in the database.";
	}
}
