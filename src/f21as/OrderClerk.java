package f21as;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class OrderClerk implements Runnable, Subject {
CustomerList customerList;
ParcelList parcelList;
String processReport = "Counter Closed";
private List<Observer> registeredObservers = new LinkedList<Observer>();
private LogFile lf = LogFile.getInstance();

	public OrderClerk(CustomerList cl, ParcelList pl) {
		this.customerList = cl;
		this.parcelList = pl;
		//processCustomer();
	}
	
	public String getProcessReport() {
		return processReport;
	}

	private String processSuccessParcel(Customer c, Parcel p)
	{
		String processed = "";
		p.setCost();
		p.setReceived(true);
		p.setCollectedBy(c.getName());
		c.setProcessed(true);
		notifyObservers();
		processed = processed + ("Parcel with ID: " + p.getParcelID() + " collected." + "\n");
		processed = processed + ("Charged customer: " + c.getName() + " AED " + String.format("%.2f",p.getCost()) + "\n");
		processed = processed + ("Next customer please!" + "\n");
		processed = processed + ("\n");
		
		processReport = processed;
		return processed;
	}

	private  String processUnSuccessParcel(Customer c, Parcel p)
	{
		String processed = "";
		
		
		processed = processed + ("Parcel with ID: " + c.getParcelID() + " is not found." + "\n");
		processed = processed + ("Turned away customer: " + c.getName() + "\n");
		processed = processed + ("Next customer please!" + "\n");
		processed = processed + ("\n");
		
		processReport = processed;
		return processed;
	}
	
	public synchronized void processCustomer()
	{
		Customer c = null;
		Parcel p = null;
		
		for (Integer n: customerList.getKeySet())
		{
			
				c = customerList.findBySeqNum(n);
				if(!c.isProcessed())
				{
					p = parcelList.findByID(c.getParcelID());
					if((p.getParcelID() != "") && ((p.isReceived() == false) ))
					{
						System.out.println(processSuccessParcel(c, p));
						//System.out.println(Thread.currentThread().getName()+" Running ");
						//notifyObservers();
					}
					else
					{
						System.out.println(processUnSuccessParcel(c, p));
						//System.out.println(Thread.currentThread().getName()+" Running ");
						//notifyObservers();
					}
				}
				
				try {
				        //System.out.println("Here");
				        Thread.sleep(3000);
				    } catch (InterruptedException e) {
				        e.printStackTrace();
				    }
				notifyObservers();
				lf.addLog("Processed customer: " + c.getName());
			}
		
			lf.saveLogList();
		
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		processCustomer();
	}

	@Override
	public void registerObserver(Observer obs) {
		// TODO Auto-generated method stub
		registeredObservers.add(obs);
	}

	@Override
	public void removeObserver(Observer obs) {
		// TODO Auto-generated method stub
		registeredObservers.remove( obs); 
	}

	@Override
	public void notifyObservers() {
		// TODO Auto-generated method stub
		for( Observer obs : registeredObservers)
			{
			obs.update();  
			}
	}

	
}
