package f21as;

import java.util.ArrayList;

public class OrderClerkList {
	private  ParcelList parcelList = new ParcelList();
	private  CustomerList customerList = new CustomerList();
	private ArrayList<OrderClerk> orderClerkList = new ArrayList<OrderClerk>(0);
	
	public OrderClerkList(CustomerList customerList, ParcelList parcelList) {
		this.parcelList = parcelList;
		this.customerList = customerList;
		//addOrderClerk();
	}

	public ArrayList<OrderClerk> getOrderClerkList() 
	{
		return orderClerkList;
	}

	public void addOrderClerk() 
	{
		orderClerkList.add(new OrderClerk(this.customerList,this.parcelList));
			
	}
	
	public void removeOrderClerk(int index) 
	{
		orderClerkList.remove(index);
			
	}
	
	public ParcelList getParcelList() {
		return parcelList;
	}

	public CustomerList getCustomerList() {
		return customerList;
	}
	
	public OrderClerk getOrderClerk(int i)
	{
		return this.orderClerkList.get(i);
	}
	
	
	
	
}
