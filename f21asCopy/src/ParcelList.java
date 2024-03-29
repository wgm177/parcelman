



import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

/** ParcelList is a public class that handles a list of parcels in the depot. It uses a hashmap with 
 * specialized operations that can be used on it to add and retrieve parcels.   
*
* @author Amjad Bari
* @author Wayne Muller
* @author Sanaa Diab
* @version 65
* @since February, 2013
*/
public class ParcelList {
	
	/** parcelList is a hashmap that stores the parcels found in the depot */
	private Map<String, Parcel> parcelList = new LinkedHashMap<String, Parcel>();
	private int totalCollected = 0;
	private int totalWarehouse = 0;
	private double totalFee = 0.0;
	
	/** addParcel(Parcel p) adds parcels read from the file to the hashmap
	 * 
	 * @param p		a parameter of type Parcel
	 * @return		true if parcel is successfully added to the hashmap, false if not. 
	 */
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
	
	/**findByID(String id) finds a parcel by its ID
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
		String stats = "";
		
		String 	s =	  String.format("%1$-" + 7 + "s","ID");
		s = s + "|" + String.format("%1$-" + 5 + "s", "DIW");
		s = s + "|" + String.format("%1$-" + 5 + "s", "W(kg)");
		s = s + "|" + String.format("%1$-" + 5 + "s","W(m)");
		s = s + "|" + String.format("%1$-" + 5 + "s","H(m)");
	    s = s + "|" + String.format("%1$-" + 5 + "s", "L(m)");
		s = s + "|" + String.format("%1$" + 8 + "s", "AED");
		s = s + "|" + String.format("%1$-" + 15 + "s", "Collected By");
		s = s + "\n";
		
		
		String collected = "\n Parcels Collected: \n";
		collected = collected + s;
		String unCollected = "\n Parcels in warehouse: \n";
		unCollected = unCollected + s;
		
		
		for(String id: parcelList.keySet())
		{
			p = this.findByID(id);
			
			if(p.isReceived())
			{
				totalCollected ++;
				totalFee = totalFee + p.getCost();
				collected = collected + p.printParcel() + "\n";
			}
			else
			{	
				totalWarehouse ++;
				unCollected = unCollected + p.printParcel() + "\n";
			}
		}
		stats = "\n";
		stats = stats + "Summary:" + "\n";
		stats = stats + "Total parcels collected: ";
		stats = stats + totalCollected + "\n";
		stats = stats + "Total parcels in warehouse: ";
		stats = stats + totalWarehouse + "\n";
		stats = stats + "Total fee collected: ";
		stats = stats + String.format("%.2f", totalFee);
		//stats = stats +  totalFee;
		
		return collected + unCollected + stats;
	}
	
	public Set<String> getKeySet()
	{
		return this.parcelList.keySet();
	}
	
	/*public static void main(String[] args)
	{
		ParcelList pl = new ParcelList();
		
		System.out.println(pl.addParcel(new Parcel("6,5,154,36,140")));
		System.out.println(pl.addParcel(new Parcel("P007,26,45,104,3")));
		System.out.println(pl.addParcel(new Parcel("P007,56,,114,34,130")));
		System.out.println((pl.parcelReport()));
		
		
		
	}*/

}
