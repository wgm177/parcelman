package f21as;


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
	String 	s =	  String.format("%1$-" + 7 + "s","ID");
	s = s + "|" + String.format("%1$-" + 5 + "s", "DIW");
	s = s + "|" + String.format("%1$-" + 5 + "s", "W(kg)");
	s = s + "|" + String.format("%1$-" + 5 + "s","W(m)");
	s = s + "|" + String.format("%1$-" + 5 + "s","H(m)");
    s = s + "|" + String.format("%1$-" + 5 + "s", "L(m)");
	s = s + "|" + String.format("%1$-" + 8 + "s", "AED");
	s = s + "|" + String.format("%1$-" + 9 + "s", "Collected\n");
	
	
	String collected = "\n Parcels Collected: \n";
	collected = collected + s;
	String unCollected = "\n Parcels in warehouse: \n";
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
	
	System.out.println(pl.addParcel(new Parcel("XC001, 2, 3, 25, 69, 9")));
	System.out.println(pl.addParcel(new Parcel("XC002, 2, 3, 25, 65, 9")));
	System.out.println(pl.addParcel(new Parcel("XC003, 2, 3, 25, 64, 9")));
	System.out.println(pl.addParcel(new Parcel("XC004, 2, 3, 25, 61, 8")));
	System.out.println(pl.addParcel(new Parcel("XC005, 2, 3, 25, 58, 7")));
	System.out.println(pl.findByID("XC002").isReceived());
	
	
}

}
