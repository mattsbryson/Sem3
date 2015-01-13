import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;


public class JMasterCreateSorted 
{
	public JMasterCreateSorted(){};
	
	public JMasterCreateSorted(String unsorted, String sorted) throws IOException
	{
		//create directory
		File dir = new File("temp");
		dir.mkdirs();
		
		File data = new File(unsorted);
		BufferedReader master = new BufferedReader(new FileReader(data));
		int MasterLength = 0;
		String line;
		while((line = master.readLine()) != null)
		{
			MasterLength++;
		}
		
		master = new BufferedReader(new FileReader(data));
		//generate files with data inside, separated by first 3 digits 
		for (int a = 0; a < MasterLength;a++)
	    {
			String currentLine = master.readLine();
			String tmpName = JParser.InputLineToSocialSecurityNumberString(currentLine).substring(0, 3);
	        File tmp = new File("temp/tmp" + tmpName + ".txt");
	        PrintWriter writer = new PrintWriter(new FileWriter(tmp, true));
	        writer.println(JParser.InputLineToSocialSecurityNumberString(currentLine) + ":" + JParser.InputLineToFirstName(currentLine) + ":" + JParser.InputLineToMiddleName(currentLine) + ":" + JParser.InputLineToLastName(currentLine));
	        writer.flush();
	        writer.close();
	    }
		 
		 //sort the files
		for (int i = 100; i < 1000; i++)
	    {
			File tmp = new File("temp/tmp" + i + ".txt");
			if (tmp.exists())
			{
                int length = 0;
                BufferedReader tmpLen = new BufferedReader(new FileReader(tmp));
                while (tmpLen.readLine() != null)
                {
                    length++;
                }
                tmpLen.close();

                BufferedReader reader = new BufferedReader(new FileReader(tmp));
                String SortArray[] = new String[length];
                int j = 0;
                String sLine = "";
                while ((sLine = reader.readLine()) != null)
                {
                    SortArray[j] = sLine;
                    j++;
                }
                reader.close();
                
                
                //sort array
                
                int end = SortArray.length;
                while (0 < end)
                {
                    end--;
                    boolean swapLine = false;
                    for (int m = 0; m < end; m++)
                    {
                        int a = Integer.parseInt(SortArray[m].substring(0, SortArray[m].indexOf(':')).replace("-", ""));
                        int b = Integer.parseInt(SortArray[m+1].substring(0, SortArray[m+1].indexOf(':')).replace("-", ""));
                        String temp = null;
                        if ( a > b)
                        {
                                temp = SortArray[m];
                                SortArray[m] = SortArray[m + 1];
                                SortArray[m + 1] = temp;
                                swapLine = true;
                        }
                    }
                    if (!swapLine)
                        {
                            break;
                        }
                }
               
                
                //sort complete
                
                PrintWriter writer = new PrintWriter(new FileWriter(tmp, false));
                for (int k = 0; k < SortArray.length; k++)
                {
                    writer.println(SortArray[k]);
                }
                writer.close();

			}
	    }
		
		
		//save to central file, clean up the mess 
	 	int j = 0;
	 	PrintWriter writer = new PrintWriter(new FileWriter(sorted, false));
        for (int i = 100; i < 1000; i++)
        {
            File tmp = new File("temp/tmp" + i + ".txt");
            if (tmp.exists())
            {
                BufferedReader reader = new BufferedReader(new FileReader(tmp));
                String sLine = "";
                while ((sLine = reader.readLine()) != null)
                {  
                    writer.println(sLine);
                    j++;
                }
                reader.close();
            }
            tmp.delete();
        }
        writer.close();
	}		        
	
}
