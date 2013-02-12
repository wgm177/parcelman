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
		Parcel tp3= new Parcel("D002,1,1,9,1,1");
		Parcel tp4= new Parcel("P002,1,1,9,2,2");
		Parcel tp5= new Parcel("D003,1,1,20,4,4");
		Parcel tp6= new Parcel("P003,1,1,20,4,4");
		Parcel tp7= new Parcel("D004,1,1,30,8,8");
		Parcel tp8= new Parcel("P004,1,1,30,8,8");
		Parcel tp9= new Parcel("D005,1,1,40,16,16");
		Parcel tp10= new Parcel("P005,1,1,40,16,16");
		Parcel tp11= new Parcel("D006,1,1,32,32,32");
		Parcel tp12= new Parcel("P006,1,1,32,32,32");
		Parcel tp13= new Parcel("D007,1,1,50,64,64");
		Parcel tp14= new Parcel("P007,1,1,50,64,64");
		Parcel tp15= new Parcel("D008,1,1,60,128,128");
		Parcel tp16= new Parcel("P008,1,1,60,128,128");
		Parcel tp17= new Parcel("D009,1,1,1,256,0");
		Parcel tp18= new Parcel("P009,1,1,1,256,0");
		Parcel tp19= new Parcel("D010,1,1,10,512,1");
		Parcel tp20= new Parcel("P010,1,1,10,512,2");
		Parcel tp21= new Parcel("D011,1,1,15,1,4");
		Parcel tp22= new Parcel("P011,1,1,15,1,4");
		Parcel tp23= new Parcel("D012,1,1,22,2,8");
		Parcel tp24= new Parcel("P012,1,1,22,2,8");
		Parcel tp25= new Parcel("D013,1,1,38,4,16");
		Parcel tp26= new Parcel("P013,1,1,38,4,16");
		Parcel tp27= new Parcel("D014,1,1,49,8,1");
		Parcel tp28= new Parcel("P014,1,1,49,8,4000");
		Parcel tp29= new Parcel("P015,1,1,55,16,80000");
		Parcel tp30= new Parcel("P016,1,1,55,16,100000");
		Parcel tp31= new Parcel("P017,1,1,4000,32,10000000");
		Parcel tp32= new Parcel("P018,1,1,80000,32,1");
		Parcel tp33= new Parcel("P019,1,1,1000000,64,1");
		Parcel tp34= new Parcel("P020,1,1,10000,10000,10000");
		Parcel tp35= new Parcel("P021,0,0,0,0,0");
		Parcel tp36= new Parcel("P022,1,0,0,0,0");
		Parcel tp37= new Parcel("P023,0,1,0,0,0");
		Parcel tp38= new Parcel("P024,0,0,1,0,0");
		Parcel tp39= new Parcel("P025,0,0,0,1,0");
		Parcel tp40= new Parcel("P026,0,0,0,0,-1");
		Parcel tp41= new Parcel("P027,0,0,0,-1,-2");
		Parcel tp42= new Parcel("P028,0,0,0,-2,-3");
		Parcel tp43= new Parcel("P029,0,0,0,3,-4");
		Parcel tp44= new Parcel("P030,0,0,0,5,-5");
		Parcel tp45= new Parcel("P031,0,0,0,10,-6");
		Parcel tp46= new Parcel("P032,0,0,0,60,-7");

		
		//System.out.println(tp.calFee(),0.1);
		assertEquals(0,tp1.calFee(),0.1);
		assertEquals(0,tp2.calFee(),0.1);
		assertEquals(18.09,tp3.calFee(),0.1);
		assertEquals(40.4,tp4.calFee(),0.1);
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
		assertEquals(4608,tp17.calFee(),0.1);
		assertEquals(5120,tp18.calFee(),0.1);
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
		assertEquals(32000400,tp31.calFee(),0.1);
		assertEquals(403.2,tp32.calFee(),0.1);
		assertEquals(806.4,tp33.calFee(),0.1);
		assertEquals(10125000,tp34.calFee(),0.1);
		assertEquals(0,tp35.calFee(),0.1);
		assertEquals(0,tp36.calFee(),0.1);
		assertEquals(0,tp37.calFee(),0.1);
		assertEquals(0,tp38.calFee(),0.1);
		assertEquals(20,tp39.calFee(),0.1);
		assertEquals(0,tp40.calFee(),0.1);
		assertEquals(-19.8,tp41.calFee(),0.1);
		assertEquals(-39.4,tp42.calFee(),0.1);
		assertEquals(58.8,tp43.calFee(),0.1);
		assertEquals(97.5,tp44.calFee(),0.1);
		assertEquals(194,tp45.calFee(),0.1);
		assertEquals(1158,tp46.calFee(),0.1);

	}

}
