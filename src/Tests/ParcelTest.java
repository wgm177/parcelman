package Tests;
import static org.junit.Assert.*;

import org.junit.Test;

import f21as.Parcel;


public class ParcelTest {

	@SuppressWarnings("deprecation")
	@Test
	public void testCalFee() {
		//fail("Not yet implemented");X21    |2    |3    |25   |64   |6    |18.0 |true 

		Parcel tp = new Parcel("x21, 2,3, 25, 64,6");
		System.out.println(tp.calFee());
		assertEquals(101.3,tp.calFee(),0.3);
	}

}
