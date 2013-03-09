package f21as;



import java.util.LinkedHashMap;
import java.util.Map;
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
public class CustomerList {
	
	/** customerList is a hashmap that stores the queue of users as they are processed */
	private Map<Integer, Customer> customerList = new LinkedHashMap<Integer, Customer>();
	
	public Map<Integer, Customer> getCustomerList() {
		return customerList;
	}

	

	/** addCustomer(Customer c) adds customers read from the file to the hashmap
	 * 
	 * @param c		a parameter of type Customer
	 * @return		true if customer is successfully added to the hashmap, false if not. 
	 */
	
	public boolean addCustomer(Customer c){
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
	public Customer findByName(String name)
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
	public Customer findBySeqNum(Integer n)
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
	
	public String customerQueReport(int columns)
	{
		Customer c = null;
		//String report = "";
		String row = "";
		int count = 0;
		
		for(Integer seqNo: customerList.keySet())
		{
			c = this.findBySeqNum(seqNo);
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
			LogFile.addLog("Generate Customer Report");
			return row;
			
		}
	public Set<Integer> getKeySet()
	{
		return this.customerList.keySet();
	}
	
	public static void main(String[] args)
	{
		CustomerList cl = new CustomerList();
		
		System.out.println(cl.addCustomer(new Customer("4,Jenny McDonald Cooper,P036")));
		System.out.println(cl.addCustomer(new Customer("91,Thomas Saunders Reynolds,P024")));
		System.out.println(cl.addCustomer(new Customer("999,Zachary Poe Hood")));
		
		
		
	}

	public void deleteCustomer(Customer c) {
		// TODO Auto-generated method stub
		this.customerList.remove(c.getSeqNo());
		LogFile.addLog("Delete customer: " + c.getName());
	}

}
