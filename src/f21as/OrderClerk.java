package f21as;

import java.util.LinkedList;
import java.util.List;

public class OrderClerk extends Thread implements Subject{
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
	t = new Thread(this);
	t.start();
	
	
}
	
public void registerObserver( Observer obs)
{  registeredObservers.add( obs);}

public void removeObserver( Observer obs)
{  registeredObservers.remove( obs); } 

public void notifyObservers()
{  for( Observer obs : registeredObservers) 
	obs.Update();  
}


public synchronized void collectParcel() throws InterruptedException
{
	Customer c = null;
	Parcel p = null;
	String processed = "";
	for (Integer n: customerList.getKeySet())
	{
		
			c = customerList.findBySeqNum(n);
			p = parcelList.findByID(c.getParcelID());
			if((p.getParcelID() != "") && ((p.isReceived() == false) ))
			{
				p.setCost();
				p.setReceived(true);
				p.setCollectedBy(c.getName());
				this.customerList.deleteCustomer(c);
				processed = processed + ("Parcel with ID: " + p.getParcelID() + " collected." + "\n");
				processed = processed + ("Charged customer: " + c.getName() + " AED " + String.format("%.2f",p.getCost()) + "\n");
				processed = processed + ("Next customer please!" + "\n");
				processed = processed + ("\n");
			}
			else
			{
				processed = processed + ("No such parcel ("+ c.getParcelID() +") in warehouse." + "\n");
				processed = processed + ("Turned customer " + c.getName() + " away." + "\n");
				processed = processed + ("Next customer please!" + "\n");
				processed = processed + ("\n");
			}
		
			try {
				sleep(4000);
				
			} catch (InterruptedException e) {
				System.out.println(e.getMessage()) ;
			 }

			System.out.println(processed);
			this.processReport = processed;
			
		processed = "";
	}
	//return processed;
}


@Override
public void run() {
	// TODO Auto-generated method stub
	try {
		this.collectParcel();
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
}
