



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
	
	/** addCustomer(Customer c) adds customers read from the file to the hashmap
	 * 
	 * @param c		a parameter of type Customer
	 * @return		true if customer is successfully added to the hashmap, false if not. 
	 */
	
	public boolean addCustomer(Customer c){
		if(c != null)
		{
			customerList.put(c.getSeqNo(), c);
			return true;
		}
		
		else
			return false;
	}
	public int getSize()
	{
		return customerList.size();
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
	public String getCustomerInfo()
	{
		String result="";
		 for (Customer s : customerList.values()) {
			// result += "\n";
			 result += String.format("%-5s", s.getSeqNo());  
			 result += String.format("%-6s", s.getName());
			
          
			 result += "\n";
       }
		
	/*	for(int id: customerList.keySet())
		{
			result+=id;
			
			
		}*/
		 return result;
	}
	public Set<Integer> getKeySet()
	{
		return this.customerList.keySet();
	}
	
	/*public static void main(String[] args)
	{
		CustomerList cl = new CustomerList();
		
		System.out.println(cl.addCustomer(new Customer("4,Jenny McDonald Cooper,P036")));
		System.out.println(cl.addCustomer(new Customer("91,Thomas Saunders Reynolds,P024")));
		System.out.println(cl.addCustomer(new Customer("999,Zachary Poe Hood")));
		
		
		
	}*/

}
