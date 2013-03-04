package f21as;

import java.util.LinkedList;
import java.util.List;

public class OrderClerk  implements Subject{
CustomerList customerList;
ParcelList parcelList;
Thread t;
String processReport;


private List<Observer> registeredObservers = new LinkedList<Observer>();

public String getProcessReport() {
	return processReport;
}



public OrderClerk(CustomerList cl, ParcelList pl) {
	this.customerList = cl;
	this.parcelList = pl;
	//t = new Thread(this);
	//t.start();
	
	
}
	
public void registerObserver( Observer obs)
{  registeredObservers.add( obs);}

public void removeObserver( Observer obs)
{  registeredObservers.remove( obs); } 

public void notifyObservers()
{  for( Observer obs : registeredObservers) 
	obs.Update();  
}

public String processParcel(Customer c, Parcel p)
{
	String processed = null;
	p.setCost();
	p.setReceived(true);
	p.setCollectedBy(c.getName());
	customerList.deleteCustomer(c);
	
	processed = processed + ("Parcel with ID: " + p.getParcelID() + " collected." + "\n");
	processed = processed + ("Charged customer: " + c.getName() + " AED " + String.format("%.2f",p.getCost()) + "\n");
	processed = processed + ("Next customer please!" + "\n");
	processed = processed + ("\n");
	
	return processed;
}



	public void run() {
		// TODO Auto-generated method stub
		
			//this.collectParcel();
		
	}
}
