package f21as;

import java.util.LinkedList;
import java.util.List;

public class OrderClerk extends Thread implements Subject, Observer {
private CustomerList customerList;
private ParcelList parcelList;
private String processReport = "Counter Closed";
private List<Observer> registeredObservers = new LinkedList<Observer>();
private  int workingSpeed = 4000;
private boolean working = false;


	public OrderClerk(CustomerList cl, ParcelList pl) {
		super();
		this.customerList = cl;
		this.parcelList = pl;
		
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
		
		processed = processed + ("Parcel: " + p.getParcelID() + " in process." + "\n");
		processed = processed + ("Charged: \n" + c.getName() + "\nAED " + String.format("%.2f",p.getCost()) + "\n");
		processed = processed + ("Next please!" + "\n");
		//processed = processed + ("\n");
		
		processReport = processed;
		//notifyObservers();
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
		
		while (true)
		{
			if(working){
				c = customerList.nextAvailableCustomer();
				if(c != null)
				{
					c.setProcessed(true);
					p = parcelList.findByID(c.getParcelID());
						if((p.getParcelID() != "") && ((p.isReceived() == false) ))
						{
							System.out.println(processSuccessParcel(c, p));
							notifyObservers();
						}
						else
						{
							System.out.println(processUnSuccessParcel(c, p));
						}
					
					
					try {
					    sleep(workingSpeed);
					} 
					catch (InterruptedException e) {
					        e.printStackTrace();
					}
					
					//notifyObservers();
					LogFile.addLog("Processed customer: " + c.getName());
				}
				else
				{
					this.processReport = "Waiting for customer";
					//notifyObservers();
				}
			}// end if working
			else
			{
				this.processReport = "Please use next counter";
			}
			notifyObservers();
		}//end while
			//this.processReport = "Finished";
			//notifyObservers();
			
		
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

	public void increaseWorkingSpeed() {
		this.workingSpeed += 100;
	}
	
	public void decreaseWorkingSpeed() {
		if(this.workingSpeed >= 100){
			this.workingSpeed -= 100;
		}
	}
	public int getWorkingSpeed(){
		return this.workingSpeed;
	}

	public boolean isWorking() {
		return working;
	}

	public void setWorking(boolean working) {
		this.working = working;
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}
	
}
