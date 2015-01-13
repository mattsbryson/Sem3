import java.io.*;


public class JPostTransactionToMaster 
{
	public JPostTransactionToMaster(){}
	
	public JPostTransactionToMaster(String SortMaster, String SortTrans) throws IOException
	{
		File master = new File(SortMaster);
		File trans = new File(SortTrans);
		File SlaveMaster = new File("SlaveMaster.txt");
		if(!SlaveMaster.exists())
		{
			SlaveMaster.createNewFile();
		}
		
		BufferedReader mReader = new BufferedReader(new FileReader(master));
		BufferedReader tReader = new BufferedReader(new FileReader(trans));
		PrintWriter sWriter = new PrintWriter(SlaveMaster); 
		
		String mLine = mReader.readLine();
		String tLine = tReader.readLine(); 
		
		while(tLine != null && mLine != null)
		{
			int mSocialSecurityNumber = JParser.InputLineToSocialSecurityNumber(mLine);
			int tSocialSecurityNumber = JParser.InputLineToSocialSecurityNumber(tLine);
			
			if(mSocialSecurityNumber == tSocialSecurityNumber)
			{
				sWriter.println(mLine);
				sWriter.println(tLine); 
				mLine = mReader.readLine();
				tLine = tReader.readLine();
			}
			else if(mSocialSecurityNumber < tSocialSecurityNumber)
			{
				sWriter.println(mLine);
				mLine = mReader.readLine();
			}
			else
			{
				sWriter.println(tLine);
				tLine = tReader.readLine();
			}
		}
		
		if(mLine != null)
		{
			sWriter.println(mLine);
			while((mLine = mReader.readLine()) != null)
			{
				sWriter.println(mLine);
			}
		}
		
		if(tLine != null)
		{
			sWriter.println(tLine);
			while((tLine = mReader.readLine()) != null)
			{
				sWriter.println(tLine);
			}
		}
		
		sWriter.close();
	}

}
