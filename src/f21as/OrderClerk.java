package f21as;

public class OrderClerk implements Runnable{
CustomerList customerList;
ParcelList parcelList;
String processReport = "Start process report";


	public OrderClerk(CustomerList cl, ParcelList pl) {
		this.customerList = cl;
		this.parcelList = pl;
		
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
		//customerList.deleteCustomer(c);
		
		processed = processed + ("Parcel with ID: " + p.getParcelID() + " collected." + "\n");
		processed = processed + ("Charged customer: " + c.getName() + " AED " + String.format("%.2f",p.getCost()) + "\n");
		processed = processed + ("Next customer please!" + "\n");
		processed = processed + ("\n");
		
		processReport = processed;
		return processed;
	}

	private String processUnSuccessParcel(Customer c, Parcel p)
	{
		String processed = null;
		
		
		processed = processed + ("Parcel with ID: " + p.getParcelID() + " is not found." + "\n");
		processed = processed + ("Turned away customer: " + c.getName() + "\n");
		processed = processed + ("Next customer please!" + "\n");
		processed = processed + ("\n");
		
		processReport = processed;
		return processed;
	}
	
	public void processCustomer()
	{
		Customer c = null;
		Parcel p = null;
		
		for (Integer n: customerList.getKeySet())
		{
			{
				c = customerList.findBySeqNum(n);
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
			
			
			
		}
				
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		//processCustomer();
	}

	
}
