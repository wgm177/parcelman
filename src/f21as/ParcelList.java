package f21as;



import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
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
	private File parcelRepFile = new File("parcelReport.txt");
	private int totalCollected = 0;
	private int totalWarehouse = 0;
	private double totalFee = 0.0;
	private String parcelFileName = "parcels.txt";
	
	
	
	public void setParcelFileName(String parcelFileName) {
		this.parcelFileName = parcelFileName;
	}
	
	
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
	
	/**   popParcelList() reads the parcel.txt file 
	 * @throws Exception  if file cannot be read 
	 * @return true if file reading was successful or false if any problems issued 
	 */
	public boolean popParcelList()
	{
		File parcelFile = new File(parcelFileName);
		Scanner fread = null;
				
		try
		{
			fread = new Scanner(parcelFile);
			while (fread.hasNextLine())
			{
				Parcel p = new Parcel(fread.nextLine());
				addParcel(p);
				
			}
			LogFile.addLog("Read in parcel file: " + parcelFile.getName());
			
		}
		catch(Exception e)
			{
				//System.out.println("Cannot read from parcel input file.");
				LogFile.addLog("Cannot read in parcelFile: " + parcelFile.getName());
				
				return false;
			}
			finally
			{
				fread.close();
			}
			
		
		return true;
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
		LogFile.addLog("Generate Parcel Report");
		return collected + unCollected + stats;
	}
	
	public String warehouseReport(int columns)
	{
		
		//String report = "";
		String row = "";
		int count = 0;
		
		for(Parcel p: parcelList.values())
		{
			
			
				if(! p.isReceived())
				{
					row = row + "|" + String.format("%1$-6s",p.getParcelID());
					count ++;
				}
				if (count == columns){
					row = row + "|\n";
					
					count = 0;
				}
				
			}
			return row;
		}
		
	/**   writeParcelReport() writes the parcel collection results of the program in parcelReport.txt 
	 * @throws Exception  if file cannot be read 
	 */
	public  void writeParcelReport()
	{
		BufferedWriter writer;
		
		try {
			writer = new BufferedWriter(new FileWriter(this.parcelRepFile));
			writer.write(this.parcelReport());
			writer.newLine();
			writer.close();
			LogFile.addLog("Write parcel report");
			
		}
		catch (Exception e)
		{
			LogFile.addLog("Error opening"	+ " the file " + this.parcelRepFile.getName());
			System.exit(0);
		}
		
	}
	
	public Set<String> getKeySet()
	{
		return this.parcelList.keySet();
	}
	
	
}
