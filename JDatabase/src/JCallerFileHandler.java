import java.io.IOException;
import java.util.Date;
import java.util.Scanner;


public class JCallerFileHandler {

	public static void main(String[] args) throws IOException 
	{ 
		String name = "";
		int num = 0;
		
		
		Scanner reader = new Scanner(System.in);
		System.out.print("Please enter your whole name, delimited by spaces: ");
		name = reader.nextLine();
		System.out.print("How many names would you like to generate? ");
		num = reader.nextInt();
		
		JTransactionCreateUnsorted masterUnsort = new JTransactionCreateUnsorted(num, name);
		masterUnsort.printData("MasterFileUnsorted");
		JMasterCreateSorted masterSort = new JMasterCreateSorted("MasterFileUnsorted.txt", "MasterFileSorted.txt");
		
		System.out.print("How many names would you like to generate for the transaction file? ");
		num = reader.nextInt();
		JTransactionCreateUnsorted trans = new JTransactionCreateUnsorted(num, name);
		trans.printData("TransFileUnsorted");
		JMasterCreateSorted transSorted = new JMasterCreateSorted("TransFileUnsorted.txt", "TransFileSorted.txt");
		
		JPostTransactionToMaster merge = new JPostTransactionToMaster("MasterFileSorted.txt", "TransFileSorted.txt");
		
		System.out.print("Please enter a 9 digit SSN:");
		String search = reader.next();
		String sResult = JBinarySearch.ssnSearch(search);
		System.out.println(sResult);
		
	}
	
}
