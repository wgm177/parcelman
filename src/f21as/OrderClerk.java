package f21as;

public class OrderClerk implements Runnable{
CustomerList customerList;
ParcelList parcelList;
String processReport = "Start process report";


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
		String processed = null;
		p.setCost();
		p.setReceived(true);
		p.setCollectedBy(c.getName());
		c.setProcessed(true);
		
		processed = processed + ("Parcel with ID: " + p.getParcelID() + " collected." + "\n");
		processed = processed + ("Charged customer: " + c.getName() + " AED " + String.format("%.2f",p.getCost()) + "\n");
		processed = processed + ("Next customer please!" + "\n");
		processed = processed + ("\n");
		
		processReport = processed;
		return processed;
	}

	private  String processUnSuccessParcel(Customer c, Parcel p)
	{
		String processed = null;
		
		
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
						System.out.println(Thread.currentThread().getName()+" Running ");
					}
					else
					{
						System.out.println(processUnSuccessParcel(c, p));
						System.out.println(Thread.currentThread().getName()+" Running ");
					}
				}
				
				try {
				        //System.out.println("Here");
				        Thread.sleep(1000);
				    } catch (InterruptedException e) {
				        e.printStackTrace();
				    }
			}
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		processCustomer();
	}

	
}
