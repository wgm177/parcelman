

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class DepotMan {
	private ParcelList parcelList = new ParcelList();
	private CustomerList customerList = new CustomerList();
	private static final File customerFile = new File("customers.txt");
	private static final File parcelFile = new File("parcels.txt");
	private File parcelRepFile = new File("parcelReport.txt");

	
	public boolean popCustomerList()
	{
		Scanner fread = null;
				
		try
		{
			fread = new Scanner(customerFile);
			while (fread.hasNextLine())
			{
				Customer c = new Customer(fread.nextLine());
				customerList.addCustomer(c);
			}
		}
		catch(IOException e)
			{
				System.out.println("IO exception");
				return false;
			}
			finally
			{
				fread.close();
			}
			
		return true;
	}
	
	public boolean popParcelList()
	{
		Scanner fread = null;
				
		try
		{
			fread = new Scanner(parcelFile);
			while (fread.hasNextLine())
			{
				Parcel p = new Parcel(fread.nextLine());
				parcelList.addParcel(p);
			}
		}
		catch(IOException e)
			{
				System.out.println("IO exception");
				return false;
			}
			finally
			{
				fread.close();
			}
			
		return true;
	}
	
	public  void writeParcelReport()
	{
		BufferedWriter writer;

		try {
			writer = new BufferedWriter(new FileWriter(this.parcelRepFile));
			writer.write(this.parcelList.parcelReport());
			writer.newLine();
			writer.close();
			
		}
		catch (IOException e)
		{
			System.out.println("Error opening"	+ " the file " + this.parcelRepFile.getName());
			System.exit(0);
		}
	}
	
	public boolean collectParcel()
	{
		Customer c = null;
		Parcel p = null;
		
		for (String n: customerList.getKeySet())
		{
			{
				c = customerList.findByName(n);
				p = parcelList.findByID(c.getParcelID());
				if((p.getParcelID() != "") && (p.isReceived() != true))
				{
					p.setReceived(true);
					this.calculateFee(p);
					System.out.println("Parcel with ID: " + p.getParcelID() + " collected.");
					System.out.println("Charged customer: " + c.getName() + " AED " + p.getCost());
					System.out.println("Next customer please!");
					System.out.println("");
				}
				else
				{
					System.out.println("No such parcel ("+ c.getParcelID() +") in warehouse.");
					System.out.println("Turned customer " + c.getName() + " away.");
				}
			}
		}
		return false;
	}
	
	public void calculateFee(Parcel p)
	{
		p.setCost(((p.getHeight()/5 * p.getWidth()/5 * p.getWeight()) ^ p.getDepotDays())/10);
	}
	
	public static void main(String [] args)
	{
		DepotMan dm = new DepotMan();
		dm.popCustomerList();
		dm.popParcelList();
		dm.collectParcel();
		dm.writeParcelReport();
		//some comment
		//bb
	}
}
