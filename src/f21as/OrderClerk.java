package f21as;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class OrderClerk extends Thread implements Subject {
private CustomerList customerList;
private ParcelList parcelList;
private String processReport = "Counter Closed";
private List<Observer> registeredObservers = new LinkedList<Observer>();
private int workingSpeed = 2000;
//private LogFile lf = LogFile.getInstance();

	public OrderClerk(CustomerList cl, ParcelList pl) {
		this.customerList = cl;
		this.parcelList = pl;
		//processCustomer();
	}
	
	public String getProcessReport() {
		return processReport;
	}

	private synchronized String processSuccessParcel(Customer c, Parcel p)
	{
		String processed = "";
		p.setCost();
		p.setReceived(true);
		p.setCollectedBy(c.getName());
		c.setProcessed(true);
		
		processed = processed + ("ParcelID: " + p.getParcelID() + "\ncollected." + "\n");
		processed = processed + ("Charged: " + c.getName() + "\nAED " + String.format("%.2f",p.getCost()) + "\n");
		processed = processed + ("Next please!" + "\n");
		processed = processed + ("\n");
		
		processReport = processed;
		notifyObservers();
		return processed;
	}

	private  String processUnSuccessParcel(Customer c, Parcel p)
	{
		String processed = "";
		
		
		processed = processed + ("ParcelID: " + c.getParcelID() + "\nis not found." + "\n");
		processed = processed + ("Turned away customer:\n" + c.getName() + "\n");
		processed = processed + ("Next please!" + "\n");
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
						
					}
					else
					{
						System.out.println(processUnSuccessParcel(c, p));
						
					}
				}
				
				try {
				     this.sleep(this.workingSpeed);
				    } catch (InterruptedException e) {
				        e.printStackTrace();
				    }
				notifyObservers();
				LogFile.addLog("Processed customer: " + c.getName());
			}
			this.processReport = "Finished";
			notifyObservers();
			
		
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

	public void setWorkingSpeed(int workingSpeed) {
		this.workingSpeed = workingSpeed;
	}

	
}
