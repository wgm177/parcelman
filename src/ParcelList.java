

import java.util.HashMap;

public class ParcelList {
	HashMap<String, Parcel> parcelList = new HashMap<String, Parcel>();
	
public boolean addParcel(Parcel p)
{
	if(p != null)
	{
		parcelList.put(p.getParcelID(),p);
		return true;
	}
		
	else
		return false;
}

/**
 * 
 * @param id - Parcel ID in String format
 * @return - Parcel object if found. Null object if not found.
 */
public Parcel findByID(String id)
{
	Parcel p = new Parcel();
	if(!parcelList.isEmpty())
	{
		if(parcelList.containsKey(id))
		{
			p = parcelList.get(id);
		}
	}
	return p;
}

public String parcelReport()
{
	Parcel p = null;
	String 	s = "" + String.format("%1$-" + 10 + "s","Parcel ID");
	s = s + "|" + String.format("%1$-" + 10 + "s", "Days on rack");
	s = s + "|" + String.format("%1$-" + 10 + "s", "Weight");
	s = s + "|" + String.format("%1$-" + 10 + "s","Width");
	s = s + "|" + String.format("%1$-" + 10 + "s","Height");
    s = s + "|" + String.format("%1$-" + 10 + "s", "Length");
	s = s + "|" + String.format("%1$-" + 10 + "s", "Cost\n");
	
	
	String collected = "\nCollected Parcels: \n";
	collected = collected + s;
	String unCollected = "\nParcels left in warehouse: \n";
	unCollected = unCollected + s;
	
	
	for(String id: parcelList.keySet())
	{
		p = this.findByID(id);
		
		if(p.isReceived())
		{
			
			collected = collected + p.printParcel() + "\n";
		}
		else
		{
			
			unCollected = unCollected + p.printParcel() + "\n";
		}
	}
	return collected + unCollected;
}
public static void main(String[] args)
{
	ParcelList pl = new ParcelList();
	
	System.out.println(pl.addParcel(new Parcel("XC001, 2, 3, 25, 69")));
	System.out.println(pl.addParcel(new Parcel("XC002, 2, 3, 25, 65")));
	System.out.println(pl.addParcel(new Parcel("XC003, 2, 3, 25, 64")));
	System.out.println(pl.addParcel(new Parcel("XC004, 2, 3, 25, 61")));
	System.out.println(pl.addParcel(new Parcel("XC005, 2, 3, 25, 58")));
	System.out.println(pl.findByID("XC002").isReceived());
	
	
}

}
