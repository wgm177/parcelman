package f21as;



import java.io.File;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

/** CustomerList is a public class that handles a list of customers coming in the queue. It uses a hashmap with 
 * specialized operations that can be used on it to add and retrieve customers.   
*
* @author Amjad Bari
* @author Wayne Muller
* @author Sanaa Diab
* @version 64
* @since February, 2013
*/
public class CustomerList extends Thread{
	
	/** customerList is a hashmap that stores the queue of users as they are processed */
	private Map<Integer, Customer> customerList = new LinkedHashMap<Integer, Customer>();
	private static final File customerFile = new File("customers.txt");
	private List<Observer> registeredObservers = new LinkedList<Observer>();
	private int joinSpeed = 500;
	private boolean closedForDay = false;
	
	
	public Map<Integer, Customer> getCustomerList() {
		return customerList;
	}

	public boolean isClosedForDay() {
		return closedForDay;
	}

	public void setClosedForDay(boolean closedForDay) {
		this.closedForDay = closedForDay;
	}
	
	/**  popCustomerList() reads the customer.txt file 
	 * @throws Exception  if file cannot be read  
	 * @return true if file reading was successful or false if any problems issued 
	 */
	public  boolean popCustomerList()
	{
		Scanner fread = null;
				
		try
		{
			fread = new Scanner(customerFile);
			while (fread.hasNextLine() && !closedForDay)
			{
				Customer c = new Customer(fread.nextLine());
				addCustomer(c);
				try {
				    sleep(joinSpeed);
				} 
				catch (InterruptedException e) {
				        e.printStackTrace();
				}
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
	

	/** addCustomer(Customer c) adds customers read from the file to the hashmap
	 * 
	 * @param c		a parameter of type Customer
	 * @return		true if customer is successfully added to the hashmap, false if not. 
	 */
	
	public synchronized boolean addCustomer(Customer c){
		if(c != null)
		{
			customerList.put(c.getSeqNo(), c);
			
			LogFile.addLog("Add new customer: " + c.getName());
			return true;
		}
		
		else
			return false;
	}
	
	/** findByName(String name) finds a customer by their name
	 * 
	 * @param name		a parameter of type String which contains the name of the customer
	 * @return			variable of type Customer 
	 */
	public synchronized Customer findByName(String name)
	{
		Customer c = new Customer();
		if(!customerList.isEmpty())
			{
				if(customerList.containsKey(name))
				{
					c = customerList.get(name);
				}
		
			}
		return c;
	}
	
	/** findBySeqNum(Integer n) finds a customer by their seqNumber
	 * @param n			an integer that contains sequence number
	 * @return			variable of type Customer 
	 */
	public synchronized Customer findBySeqNum(Integer n)
	{
		Customer c = new Customer();
		if(!customerList.isEmpty())
			{
			if(customerList.containsKey(n))
				{
				c = customerList.get(n);
				}
			
			}
		return c;
	}
	
	public synchronized String customerQueReport(int columns)
	{
		String row = "";
		int count = 0;
		
		for(Customer c: customerList.values())
		{
			if(! c.isProcessed())
			{
					row = row + "|" + String.format("%1$-30s",c.getSeqNo() + " - " + c.getName());
					count ++;
					
					if (count == columns)
					{
							row = row + "|\n";
							count = 0;
					}
			}
				
		}
			//LogFile.addLog("Generate Customer Report");
			notifyAll();
			return row;
	}
	
	
	public synchronized Set<Integer> getKeySet()
	{
		return this.customerList.keySet();
	}
	
	
	public synchronized void deleteCustomer(Customer c) {
		// TODO Auto-generated method stub
		this.customerList.remove(c.getSeqNo());
		LogFile.addLog("Delete customer: " + c.getName());
	}

	public synchronized Customer nextAvailableCustomer() {
		Customer firstCustomer = null;
		for (Customer c: customerList.values()){
			if(!c.isProcessed()){
				firstCustomer = c;
				break;
			}
		}
		return firstCustomer;
	}

	public int getJoinSpeed() {
		return joinSpeed;
	}

	public void setJoinSpeed(int joinSpeed) {
		this.joinSpeed = joinSpeed;
		
	}
	
	public synchronized void closeCustomers() {
			for(Customer c: customerList.values()){
				if(!c.isProcessed()){
					customerList.remove(c);
				}
			}

		LogFile.addLog("Customers exit");
	}

	@Override
	public void run() {
		
			popCustomerList();
	}
	

}
