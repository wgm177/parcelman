

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class CustomerList {
	Map<String, Customer> customerList = new HashMap<String, Customer>();
	
public boolean addCustomer(Customer c)
{
	if(c != null)
	{
		customerList.put(c.getName(), c);
		return true;
	}
		
	else
		return false;
}

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

public Set<String> getKeySet()
{
	return this.customerList.keySet();
}

public static void main(String[] args)
{
	CustomerList cl = new CustomerList();
	
	System.out.println(cl.addCustomer(new Customer("1, Wayne Muller, XC001")));
	System.out.println(cl.addCustomer(new Customer("2, Piet Pompies, XC003")));
	System.out.println(cl.addCustomer(new Customer("3, Sarel Seemonster, XC004")));
	System.out.println(cl.findByName("Wayne Mulle").getParcelID());
	
	
}

}
