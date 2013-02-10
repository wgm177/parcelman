package Tests;
import static org.junit.Assert.*;

import org.junit.Test;

import f21as.Parcel;


public class ParcelTest {

	
	@Test
	public void testCalFee() {
		/*fail("Not yet implemented");
		  
		 */

		Parcel tp = new Parcel("D421, 4, 3, 25, 64,6");
		Parcel tp2 = new Parcel("X4001, 2, 3, 25, 69, 4");
		Parcel tp3 = new Parcel("X21, 9, 3, 25, 64,6");
		Parcel tp4 = new Parcel("X4004, 5, 3, 25, 69,5");
		
		//System.out.println(tp.calFee(),0.1);
		assertEquals(34.83,tp.calFee(),0.1);
		assertEquals(38.1,tp2.calFee(),0.1);
		assertEquals(40.20,tp3.calFee(),0.1);
		assertEquals(39.00,tp4.calFee(),0.1);
	}

}
