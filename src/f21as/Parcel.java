package f21as;

/** Parcel Class handles the parcel, its fee calculation,  
*
* @author Amjad Bari
* @author Wayne Muller
* @author Sanaa Diab
* @version 65
* @since February, 2013
*/
//check if i can commit ?
public class Parcel {
	/** parcelID stores the ID of each parcel as it is read */
	private String parcelID;
	/** depotDays stores the number of days a parcel has been stored in depot */
	private int depotDays;
	/** weight, width, height and length store the dimensions and weight of the parcel */
	private int weight, width, height, length;
	/** cost saves the parcel fees */
	private double cost;
	/** received stores how much was received from customer */
	private boolean received;
	/** collectedBy stores the name of the customer who collected the parcel */
	private String collectedBy;
	
	
	/** Parcel() sets the default variables for this class. */
	public Parcel() 
	{
		this.parcelID = "";
		this.depotDays = 0;
		this.weight = 0;
		this.width = 0;
		this.height = 0;
        this.length=0;
		//this.cost = calculateFee();
		this.collectedBy = "";
		this.received = false;		
	}
	
	/** Parcel(String s) receives a string containing one line read from the parcel.txt file 
	 * and sets the variables according to the provided data
	 * 
	 * @param s			string containing read text
	 * @throws ParcelStringFormatException  which indicates an error in the string format
	 * @throws NumberFormatException  
	 * @throws ArrayIndexOutOfBoundsException  
	 */
	public Parcel(String s)
	{
		String [] sr = s.split(",");
		try
		{
			if(sr.length == 6)
			{
				try
				{
					setParcelID(sr[0]);
					setDepotDays(Integer.parseInt(sr[1].trim()));
					setWeight(Integer.parseInt(sr[2].trim()));
					setWidth(Integer.parseInt(sr[3].trim()));
					setHeight(Integer.parseInt(sr[4].trim()));
					setLength(Integer.parseInt(sr[5].trim()));
					this.received = false;
					this.collectedBy = "";
				}
				catch(NumberFormatException e)
				{
					System.out.println("Error in input file. Cannot convert to int" + e.getMessage());
				}
				catch(ArrayIndexOutOfBoundsException e)
				{
					System.out.println("Error in input file. To few parts" + e.getMessage());
				}
			}
			else
			{
				throw new ParcelStringFormatException();
			}
			
		}catch(ParcelStringFormatException e)
		{
			System.out.println("String format error: Cannot convert string to parcel.");
		}
	}
	
	
	/** printParcel()
	 * @return			string s with the parcel's information after collection
	 */
	public String printParcel()
	{
				String 	s =   String.format("%1$-" + 7 + "s",this.parcelID);
				s = s + "|" + String.format("%1$-" + 5 + "s", this.depotDays);
				s = s + "|" + String.format("%1$-" + 5 + "s",this.weight);
				s = s + "|" + String.format("%1$-" + 5 + "s",this.width);
				s = s + "|" + String.format("%1$-" + 5 + "s",this.height);
                s = s + "|" + String.format("%1$-" + 5 + "s",this.length);
				s = s + "|" + String.format("%1$" + 8 + "s", String.format("%.2f",this.cost));
				//s = s + "|" + String.format("%1$" + 8 + "s", this.cost);
				s = s + "|" + String.format("%1$-" + 15 + "s",this.collectedBy);
				
		return s;
	}
	
	
	/** printParcel()
	 * @return			string s with the parcel's detailed cost information
	 */
	public String printParcelCost()
	{
				String 	s =   String.format("%1$-" + 7 + "s",this.originalFee());
				s = s + "|" + String.format("%1$-" + 5 + "s", this.extraFeeDimensions());
				s = s + "|" + String.format("%1$-" + 5 + "s", this.extraFeeDay());
				s = s + "|" + String.format("%1$-" + 5 + "s",this.discount()* (originalFee()+extraFeeDay()+extraFeeDimensions()));
				s = s + "|" + String.format("%1$-" + 5 + "s",this.calculateFee());
				
				
		return s;
	}
	
	/** equals(Parcel p) checks if the current parcel is the same as the given parcel
	 * @param p			object of type Parcel
	 * @return			true if its the same parcel and false if not
	 */
	public boolean equals(Parcel p)
	{
		if(this.parcelID == p.getParcelID())
			return true;
		else 
			return false;					
	}
	
	/** originalFee() 	calculates the original fee based on the weight 
	 * @return			fees if the weight is greater than 0 otherwise returns 0
	 */
    private double originalFee()
        {
            if(this.weight > 0)
            {	
            	return (double)this.weight*10;
            }	
            else
            	return 0.0;
        }
    
    /**extraFeeDimensions()	calculates the extra fee that will be added based on dimensions 
	 * @return			a double value which stores the fees on the parcel based on dimensions.
	 */
   
    // sanaa: why wasn't a case used here instead of these ifs 
    private double extraFeeDimensions()
        {
            double dimension=(double)this.height * (double)this.width * (double)this.length;
            double dimensionFee=0.0;
            if(dimension>9 && dimension<20)
            {
               dimensionFee=originalFee()*0.05;
            }
             if(dimension>=20 && dimension<30)
            {
               dimensionFee=originalFee()*0.1;
            }
              if(dimension>=30 && dimension<40)
            {
               dimensionFee=originalFee()*0.15;
            }
            
             if(dimension>=40 && dimension<50)
            {
               dimensionFee=originalFee()*0.20;
            }
             if(dimension>=50)
            {
               dimensionFee=originalFee()*0.25;
            }
            
            return dimensionFee;
        }
          
    /**extraFeeDay()	calculates the extra fee that will be added based on days stored in depot 
  	 * @return			a double value which stores the fees on the parcel
  	 */
  
    private double extraFeeDay()
        {
            return this.depotDays*originalFee()*0.01;
        }
        
    /**extraFeeDay()	checks if a discount applies on a parcel 
  	 * @return			discount, a double value which stores the discount value
  	 * @throws NullPointerException
  	 */
    
    private double discount()
   {
	   double discount = 0.0;
	  try
	  {
	   if (this.parcelID.length() > 1 && this.parcelID != null)
	   {
		   if (parcelID.charAt(0) == 'd' || parcelID.charAt(0) == 'D')
		   {
			   discount = 0.1;
		   }
	   }
	  }
	  catch(NullPointerException e)
	  {
		  System.out.println("Error in parcelID: " + e.getMessage());
	  }
	   return discount;
	   
   }
	
   public double calculateFee()
	{
		//return ((this.height/5 * this.width/5 * this.weight) ^ this.depotDays)/10;
      double fee = 0.0;
            fee = originalFee()+extraFeeDay()+extraFeeDimensions();
            fee = fee - (fee * discount());
            
	   return fee;
	}
	
	public String getParcelID() 
	{
		return parcelID;
	}
	public void setParcelID(String parcelID) 
	{
		if ((parcelID.length() > 1) && (parcelID.length() < 7) && (validParcelStart(parcelID)))
			{
				this.parcelID = parcelID;
			}
		else
		{
			this.parcelID = "invalid";
		}
	}
	public int getDepotDays() 
	{
		return depotDays;
	}
	public void setDepotDays(int depotDays) 
	{
		
		if (depotDays >= 0)
		{
			this.depotDays = depotDays;
		}
		else
		{
			this.depotDays = 0;
		}
	}
	public int getWeight() 
	{
		return weight;
	}
	public void setWeight(int weight) 
	{
		if (weight >=0)
		{
			this.weight = weight;
		}
		else 
		{
			this.weight = 0;
		}
	}
	public int getWidth() 
	{
		return width;
	}
	public void setWidth(int width) 
	{
		if (width >=0 )
		{
			this.width = width;
		}
		else
		{
			this.width = 0;
		}
	}
	public int getHeight() 
	{
		return height;
	}
	public void setHeight(int height) 
	{
		if (height >= 0 )
		{
			this.height = height;
		}
		else
		{
			this.height = 0;
		}
	}
	private void setLength(int length) 
	{
		if (length >= 0 )
		{
			this.length = length;
		}
		else
		{
			this.length = 0;
		}
	}
	public double getCost() 
	{
		return cost;
	}
	public void setCost() 
	{
		this.cost = calculateFee();
	}
	public boolean isReceived() 
	{
		return received;
	}
	public void setReceived(boolean received) 
	{
		this.received = received;
	}
	
	private boolean validParcelStart(String parcelID)
	{
		return ((parcelID.startsWith("p")) || (parcelID.startsWith("P")) || (parcelID.startsWith("d")) || (parcelID.startsWith("D")));
	}

	/**
	 * @return the collectedBy
	 */
	public String getCollectedBy() {
		return collectedBy;
	}

	/**
	 * @param collectedBy the collectedBy to set
	 */
	public void setCollectedBy(String collectedBy) {
		this.collectedBy = collectedBy;
	}
	
	/*public static void main(String[] args)
	{
		Parcel tp1= new Parcel("D005,2147483647,2147483647,2147483647,2147483647,2147483647");
		System.out.println(tp1.printParcel());
		
		
	}*/
}
