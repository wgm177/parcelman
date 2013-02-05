

public class Customer {
	private String name;
	private String parcelID;
	private int seqNo;
	
	
	public Customer() {
		this.name = "";
		this.parcelID = "";
		this.seqNo = 0;
	}
	
	public Customer(String s) {
		String [] sr = s.split(",");
		try
		{
			this.seqNo = Integer.parseInt(sr[0].trim());
			this.name = sr[1].trim();
			this.parcelID = sr[2].trim();
			
		}catch(Exception e)
		{
			System.out.println("String format error. Cannot convert string to Customer");
		}
	}
	
	public String printCustomer()
	{
		String s = "";
		s = s + "Name: " + this.name;
		s = s + " parcelID: " + this.parcelID;
		s = s + " seqNo: " + this.seqNo;
		return s;
		
	}
	
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the parcelNumber
	 */
	public String getParcelID() {
		return parcelID;
	}
	/**
	 * @param parcelID the parcelID to set
	 */
	public void setParcelNumber(String parcelID) {
		this.parcelID = parcelID;
	}
	/**
	 * @return the seqNumber
	 */
	public int getSeqNo() {
		return seqNo;
	}
	/**
	 * @param seqNo the seqNo to set
	 */
	public void setSeqNumber(int seqNo) {
		this.seqNo = seqNo;
	}
	
	public static void main(String[] args)
	{
		Customer c1 = new Customer();
		System.out.println(c1.printCustomer());
		Customer c2 = new Customer("2, Wayne Muller, XC001");
		System.out.println(c2.printCustomer());
		
	}
		

}
