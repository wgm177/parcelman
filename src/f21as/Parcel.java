package f21as;

// sanaa's test comment 2s

public class Parcel {
	private String parcelID;
	private int depotDays;
	private int weight, width, height;
    private int length;
	private double cost;
	private boolean received;
	
	
	
	public Parcel() 
	{
		this.parcelID = "";
		this.depotDays = 0;
		this.weight = 0;
		this.width = 0;
		this.height = 0;
        this.length=0;
		this.cost = calFee();
		//this.received = null;		
	}
	
	public Parcel(String s)
	{
		String [] sr = s.split(",");
		try
		{
			if(sr.length == 6)
			{
				try
				{
					this.parcelID = sr[0];
					this.depotDays = Integer.parseInt(sr[1].trim());
					this.weight = Integer.parseInt(sr[2].trim());
					this.width = Integer.parseInt(sr[3].trim());
					this.height = Integer.parseInt(sr[4].trim());
					this.length = Integer.parseInt(sr[5].trim());
				}
				catch(NumberFormatException e)
				{
					System.out.println("Error in input file." + e.getMessage());
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
		this.received = false;
		//this.cost = calFee();
	}
	
	public String printParcel()
	{
		String 	s = "" + String.format("%1$-" + 7 + "s",this.parcelID);
				s = s + "|" + String.format("%1$-" + 5 + "s", this.depotDays);
				s = s + "|" + String.format("%1$-" + 5 + "s",this.weight);
				s = s + "|" + String.format("%1$-" + 5 + "s",this.width);
				s = s + "|" + String.format("%1$-" + 5 + "s",this.height);
                s = s + "|" + String.format("%1$-" + 5 + "s",this.length);
				s = s + "|" + String.format("%1$" + 8 + "s", String.format("%,5.2f",this.cost));
				s = s + "|" + String.format("%1$-" + 5 + "s",this.received);
				
		return s;
	}
	
	public boolean equals(Parcel p)
	{
		if(this.parcelID == p.getParcelID())
			return true;
		else 
			return false;					
	}
	
	//calculate the original fee
    private int originalFee()
        {
            if(this.weight >0)
            return this.weight*10;
            else
            return 0;
        }
    
        //the following method return extra fee will be added based on dimensions
    private double extraFeeDimensions()
        {
            int dimension=this.height*this.width*this.length;
            double dimensionFee=0;
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
          //the following method return extra fee will be added based on number of days
   private double extraFeeDay()
        {
            return this.depotDays*originalFee()*0.01;
        }
        //the following method return amount of discount based on customer's id
   
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
	
   public double calFee()
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
		this.parcelID = parcelID;
	}
	public int getDepotDays() 
	{
		return depotDays;
	}
	public void setDepotDays(int depotDays) 
	{
		this.depotDays = depotDays;
	}
	public int getWeight() 
	{
		return weight;
	}
	public void setWeight(int weight) 
	{
		this.weight = weight;
	}
	public int getWidth() 
	{
		return width;
	}
	public void setWidth(int width) 
	{
		this.width = width;
	}
	public int getHeight() 
	{
		return height;
	}
	public void setHeight(int height) 
	{
		this.height = height;
	}
	public double getCost() 
	{
		return cost;
	}
	public void setCost() 
	{
		this.cost = calFee();
	}
	public boolean isReceived() 
	{
		return received;
	}
	public void setReceived(boolean received) 
	{
		this.received = received;
	}
	
	/*public static void main(String[] args)
	{
		Parcel p1 = new Parcel();
		System.out.println(p1.printParcel());
		Parcel p2 = new Parcel("XC001, 2, 3, 25, 69");
		System.out.println(p2.printParcel());
	}*/

}
