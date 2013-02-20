package Tests;
import static org.junit.Assert.*;

import org.junit.Test;

import f21as.Parcel;


public class ParcelTest {

	
	@Test
	public void testCalFee() {
		

		Parcel tp1= new Parcel("D001,-1,-1,-1,-1,-1");
		Parcel tp2= new Parcel("P001,0,0,0,0,0");
		Parcel tp3= new Parcel("D002,1,1,1,1,1");
		Parcel tp4= new Parcel("P002,10,10,10,10,10");
		Parcel tp5= new Parcel("D003,100,100,100,100,100");
		Parcel tp6= new Parcel("P003,1000,1000,1000,1000,1000");
		Parcel tp7= new Parcel("D004,2147483647,2147483647,2147483647,2147483647,2147483647");
		Parcel tp8= new Parcel("P004,2147483648,2147483648,2147483648,2147483648,2147483648");
		Parcel tp9= new Parcel("D005,-2147483647,-2147483647,-2147483647,-2147483647,-2147483647");
		Parcel tp10= new Parcel("P005,0,139,86,21,2");
		Parcel tp11= new Parcel("D006,10,0,22,57,96");
		Parcel tp12= new Parcel("P006,26,132,21,105,0");
		Parcel tp13= new Parcel("D007,18,163,32,0,132");
		Parcel tp14= new Parcel("P007,60,119,0,3,3");
		Parcel tp15= new Parcel("D008,17,100,190,72,194");
		Parcel tp16= new Parcel("P008,56,4,8,182,44");
		Parcel tp17= new Parcel("D009,50,131,14,98,85");
		Parcel tp18= new Parcel("P009,30,121,194,109,189");


		//System.out.println(tp.calFee(),0.1);
		assertEquals(0.0,tp1.calculateFee(),0.1);
		assertEquals(0.0,tp2.calculateFee(),0.1);
		assertEquals(9.09,tp3.calculateFee(),0.1);
		assertEquals(135.0,tp4.calculateFee(),0.1);
		assertEquals(2025.0,tp5.calculateFee(),0.1);
		assertEquals(112500.0,tp6.calculateFee(),0.1);
		assertEquals(415051765431108860.0,tp7.calculateFee(),0.1);
		assertEquals(0.0,tp8.calculateFee(),0.1);
		assertEquals(0.0,tp9.calculateFee(),0.1);
		assertEquals(1737.5,tp10.calculateFee(),0.1);
		assertEquals(0,tp11.calculateFee(),0.1);
		assertEquals(1663.2,tp12.calculateFee(),0.1);
		assertEquals(1731.06,tp13.calculateFee(),0.1);
		assertEquals(1904,tp14.calculateFee(),0.1);
		assertEquals(1278,tp15.calculateFee(),0.1);
		assertEquals(72.4,tp16.calculateFee(),0.1);
		assertEquals(2063.25,tp17.calculateFee(),0.1);
		assertEquals(1875.5,tp18.calculateFee(),0.1);


	}

}
