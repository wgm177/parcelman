package Tests;


import static org.junit.Assert.*;
import java.io.File;
import org.junit.Test;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import f21as.DepotMan;
import f21as.ParcelList;
public class ParcelListTest {
	
	private static final File parcelFile = new File("parcels.txt");
	DepotMan DepotMan=new DepotMan();
	@Before
	public void setUp() {
		DepotMan.popParcelList();
	}
	@After
	public void tearDown() {
	DepotMan DepotMan=new DepotMan();
	}
	@Test
	public void test1() {
		ParcelList ParcelList=new ParcelList();
		String firstChar;
		for (String P: ParcelList.getKeySet())
		{
			firstChar=P.substring(0,1);
			assertEquals("","P",firstChar);
		}		
	}
	@Test
	public void test2() {
		ParcelList ParcelList=new ParcelList();
		String firstChar;
		for (String P: ParcelList.getKeySet())
		{
			firstChar=P.substring(0,1);
			assertEquals("","D",firstChar);
		}		
	}
}

