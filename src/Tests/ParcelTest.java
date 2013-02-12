package Tests;
import static org.junit.Assert.*;

import org.junit.Test;

import f21as.Parcel;


public class ParcelTest {

	
	@Test
	public void testCalFee() {
		/*fail("Not yet implemented");
		  
		 */

		Parcel tp1= new Parcel("D001,0,0,0,0,0");
		Parcel tp2= new Parcel("P001,0,0,0,0,0");
		Parcel tp3= new Parcel("D002,1,1,1,1,9");
		Parcel tp4= new Parcel("P002,2,2,1,1,9");
		Parcel tp5= new Parcel("D003,4,4,1,1,20");
		Parcel tp6= new Parcel("P003,4,4,1,1,20");
		Parcel tp7= new Parcel("D004,8,8,1,1,30");
		Parcel tp8= new Parcel("P004,8,8,1,1,30");
		Parcel tp9= new Parcel("D005,16,16,1,1,40");
		Parcel tp10= new Parcel("P005,16,16,1,1,40");
		Parcel tp11= new Parcel("D006,32,32,1,1,32");
		Parcel tp12= new Parcel("P006,32,32,1,1,32");
		Parcel tp13= new Parcel("D007,64,64,1,1,50");
		Parcel tp14= new Parcel("P007,64,64,1,1,50");
		Parcel tp15= new Parcel("D008,128,128,1,1,60");
		Parcel tp16= new Parcel("P008,128,128,1,1,60");
		Parcel tp17= new Parcel("D009,0,256,1,1,1");
		Parcel tp18= new Parcel("P009,0,256,1,1,1");
		Parcel tp19= new Parcel("D010,1,512,1,1,10");
		Parcel tp20= new Parcel("P010,2,512,1,1,10");
		Parcel tp21= new Parcel("D011,4,1,1,1,15");
		Parcel tp22= new Parcel("P011,4,1,1,1,15");
		Parcel tp23= new Parcel("D012,8,2,1,1,22");
		Parcel tp24= new Parcel("P012,8,2,1,1,22");
		Parcel tp25= new Parcel("D013,16,4,1,1,38");
		Parcel tp26= new Parcel("P013,16,4,1,1,38");
		Parcel tp27= new Parcel("D014,1,8,1,1,49");
		Parcel tp28= new Parcel("P014,4000,8,1,1,49");
		Parcel tp29= new Parcel("P015,80000,16,1,1,55");
		Parcel tp30= new Parcel("P016,100000,16,1,1,55");
		Parcel tp31= new Parcel("P017,1000,32,1,1,4000");
		Parcel tp32= new Parcel("P018,1,32,1,1,80000");
		Parcel tp33= new Parcel("P019,1,64,1,1,1000000");
		Parcel tp34= new Parcel("P020,10000,10000,1,1,10000");
		Parcel tp35= new Parcel("P021,0,0,0,0,0");
		Parcel tp36= new Parcel("P022,0,0,1,0,0");
		Parcel tp37= new Parcel("P023,0,0,0,1,0");
		Parcel tp38= new Parcel("P024,0,0,0,0,1");
		Parcel tp39= new Parcel("P025,0,1,0,0,0");
		Parcel tp40= new Parcel("P026,-1,0,0,0,0");
		Parcel tp41= new Parcel("P027,-2,-1,0,0,0");
		Parcel tp42= new Parcel("P028,-3,-2,0,0,0");
		Parcel tp43= new Parcel("P029,-4,3,0,0,0");
		Parcel tp44= new Parcel("P030,-5,5,0,0,0");
		Parcel tp45= new Parcel("P031,-6,10,0,0,0");
		Parcel tp46= new Parcel("P032,-7,60,0,0,0");


		
		//System.out.println(tp.calFee(),0.1);
		assertEquals(0,tp1.calFee(),0.1);
		assertEquals(0,tp2.calFee(),0.1);
		assertEquals(9.09,tp3.calFee(),0.1);
		assertEquals(20.4,tp4.calFee(),0.1);
		assertEquals(41.04,tp5.calFee(),0.1);
		assertEquals(45.6,tp6.calFee(),0.1);
		assertEquals(88.56,tp7.calFee(),0.1);
		assertEquals(98.4,tp8.calFee(),0.1);
		assertEquals(195.84,tp9.calFee(),0.1);
		assertEquals(217.6,tp10.calFee(),0.1);
		assertEquals(423.36,tp11.calFee(),0.1);
		assertEquals(470.4,tp12.calFee(),0.1);
		assertEquals(1088.64,tp13.calFee(),0.1);
		assertEquals(1209.6,tp14.calFee(),0.1);
		assertEquals(2914.56,tp15.calFee(),0.1);
		assertEquals(3238.4,tp16.calFee(),0.1);
		assertEquals(2304,tp17.calFee(),0.1);
		assertEquals(2560,tp18.calFee(),0.1);
		assertEquals(4884.48,tp19.calFee(),0.1);
		assertEquals(5478.4,tp20.calFee(),0.1);
		assertEquals(9.81,tp21.calFee(),0.1);
		assertEquals(10.9,tp22.calFee(),0.1);
		assertEquals(21.24,tp23.calFee(),0.1);
		assertEquals(23.6,tp24.calFee(),0.1);
		assertEquals(47.16,tp25.calFee(),0.1);
		assertEquals(52.4,tp26.calFee(),0.1);
		assertEquals(87.12,tp27.calFee(),0.1);
		assertEquals(3296,tp28.calFee(),0.1);
		assertEquals(128200,tp29.calFee(),0.1);
		assertEquals(160200,tp30.calFee(),0.1);
		assertEquals(3600,tp31.calFee(),0.1);
		assertEquals(403.2,tp32.calFee(),0.1);
		assertEquals(806.4,tp33.calFee(),0.1);
		assertEquals(10125000,tp34.calFee(),0.1);
		assertEquals(0,tp35.calFee(),0.1);
		assertEquals(0,tp36.calFee(),0.1);
		assertEquals(0,tp37.calFee(),0.1);
		assertEquals(0,tp38.calFee(),0.1);
		assertEquals(10,tp39.calFee(),0.1);
		assertEquals(0,tp40.calFee(),0.1);
		assertEquals(-9.8,tp41.calFee(),0.1);
		assertEquals(-19.4,tp42.calFee(),0.1);
		assertEquals(28.8,tp43.calFee(),0.1);
		assertEquals(47.5,tp44.calFee(),0.1);
		assertEquals(94,tp45.calFee(),0.1);
		assertEquals(558,tp46.calFee(),0.1);


	}

}
