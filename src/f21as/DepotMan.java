package f21as;

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
	//private  ParcelList parcelList = new ParcelList();
	//private  CustomerList customerList = new CustomerList();
	//private OrderClerkList orderClerkList;
	
	
	/**   collectParcel() is the collection simulation method which takes one customer at a time
	 * and checks the parcel they are claiming, calculates the fees and receives the payment. 
	 * This process is printing on console.  
	 * @return false at end of operation
	 */
	
	
//	
		
	public static void main(String [] args)
	{
		//DepotMan dm = new DepotMan();
		OrderClerkList orderClerkList;
		ParcelList parcelList = new ParcelList();
		CustomerList customerList = new CustomerList();
		
		parcelList.popParcelList();
		orderClerkList = new OrderClerkList(customerList,parcelList);
		new GUIMain("ParcelMan v2.0", orderClerkList);
		
		
		
		customerList.start();
		customerList.popCustomerList();
		
		
		

	}

	

	
}
