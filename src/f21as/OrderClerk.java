package f21as;

public class OrderClerk {
CustomerList customerList;
ParcelList parcelList;

public OrderClerk(CustomerList cl, ParcelList pl) {
	this.customerList = cl;
	this.parcelList = pl;
	
	
	
}
	
public String collectParcel()
{
	Customer c = null;
	Parcel p = null;
	String processed = "";
	for (Integer n: customerList.getKeySet())
	{
		{
			c = customerList.findBySeqNum(n);
			p = parcelList.findByID(c.getParcelID());
			if((p.getParcelID() != "") && ((p.isReceived() == false) ))
			{
				p.setCost();
				p.setReceived(true);
				p.setCollectedBy(c.getName());
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
		}
	}
	return processed;
}



}
