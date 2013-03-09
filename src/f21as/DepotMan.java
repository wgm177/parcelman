package f21as;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/** DepotMan class runs the parcel man program. It reads the lists and initiates the parcel 
 * collection simulation then writes the output report.  
*
* @author Amjad Bari
* @author Wayne Muller
* @author Sanaa Diab
* @version 61
* @since February, 2013
*/

public class DepotMan {
	private  ParcelList parcelList = new ParcelList();
	private  CustomerList customerList = new CustomerList();
	private static final File customerFile = new File("customers.txt");
	private static final File parcelFile = new File("parcels.txt");
	
	private OrderClerkList orderClerkList;
	
	
	
	
	/**  popCustomerList() reads the customer.txt file 
	 * @throws Exception  if file cannot be read  
	 * @return true if file reading was successful or false if any problems issued 
	 */
	public boolean popCustomerList()
	{
		Scanner fread = null;
				
		try
		{
			fread = new Scanner(customerFile);
			while (fread.hasNextLine())
			{
				Customer c = new Customer(fread.nextLine());
				customerList.addCustomer(c);
				
			}
		}
		catch(Exception e)
			{
				//System.out.println("Cannot read from customer input file");
				LogFile.addLog("Cannot read from customer input file: " + customerFile.getName());
				return false;
			}
			finally
			{
				fread.close();
				
			}
		return true;
		
	}
	
	/**   popParcelList() reads the parcel.txt file 
	 * @throws Exception  if file cannot be read 
	 * @return true if file reading was successful or false if any problems issued 
	 */
	public boolean popParcelList()
	{
		Scanner fread = null;
				
		try
		{
			fread = new Scanner(parcelFile);
			while (fread.hasNextLine())
			{
				Parcel p = new Parcel(fread.nextLine());
				parcelList.addParcel(p);
				
			}
			
		}
		catch(Exception e)
			{
				System.out.println("Cannot read from parcel input file.");
				LogFile.addLog("Cannot read in parcelFile: " + parcelFile.getName());
				
				return false;
			}
			finally
			{
				fread.close();
			}
			
		
		return true;
	}
	

	
	
	/**   collectParcel() is the collection simulation method which takes one customer at a time
	 * and checks the parcel they are claiming, calculates the fees and receives the payment. 
	 * This process is printing on console.  
	 * @return false at end of operation
	 */
	
	
//	
		
	public static void main(String [] args)
	{
		DepotMan dm = new DepotMan();
		
		System.out.println(dm.popCustomerList());
		System.out.println(dm.popParcelList());
		dm.orderClerkList = new OrderClerkList(dm.customerList,dm.parcelList);
		
		//OrderClerk oc = new OrderClerk(dm.customerList, dm.parcelList);
		//Thread t1 = new Thread(oc);
		//t1.start();
		
		//OrderClerk oc1 = new OrderClerk(dm.customerList, dm.parcelList);
		//Thread t2 = new Thread(oc1);
		//t2.start();
		
		GUIMain gm = new GUIMain("ParcelMan v2.0", dm.orderClerkList);
		
		

	}

	
}
