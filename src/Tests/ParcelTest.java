package Tests;
import static org.junit.Assert.*;

import org.junit.Test;

import f21as.Parcel;


public class ParcelTest {

	
	@Test
	public void testCalFee() {
		/*fail("Not yet implemented");
		  
		 */

		Parcel tp1= new Parcel("D001,53,3,48,106,100");
		Parcel tp2= new Parcel("P001,44,17,2,111,58");
		Parcel tp3= new Parcel("D002,8,15,67,142,23");
		Parcel tp4= new Parcel("P002,17,46,22,42,71");
		Parcel tp5= new Parcel("D003,60,28,59,110,21");
		Parcel tp6= new Parcel("P003,48,44,73,40,133");
		Parcel tp7= new Parcel("D004,11,20,11,117,140");
		Parcel tp8= new Parcel("P004,25,45,120,28,96");
		Parcel tp9= new Parcel("D005,47,30,128,64,112");
		Parcel tp10= new Parcel("P005,10,4,129,111,63");
		Parcel tp11= new Parcel("D006,12,13,106,136,141");
		Parcel tp12= new Parcel("P006,5,18,106,61,70");
		Parcel tp13= new Parcel("D007,5,44,83,75,4");
		Parcel tp14= new Parcel("P007,56,25,114,34,130");
		Parcel tp15= new Parcel("D008,19,7,92,119,124");
		Parcel tp16= new Parcel("P008,3,44,108,114,1");
		Parcel tp17= new Parcel("D009,46,29,94,23,110");
		Parcel tp18= new Parcel("P009,2,35,17,68,144");
		Parcel tp19= new Parcel("D010,29,36,27,42,12");
		Parcel tp20= new Parcel("P010,3,11,49,42,15");
		Parcel tp21= new Parcel("D011,10,29,11,20,147");
		Parcel tp22= new Parcel("P011,58,1,106,135,53");
		Parcel tp23= new Parcel("D012,19,16,61,26,128");
		Parcel tp24= new Parcel("P012,47,10,74,7,66");
		Parcel tp25= new Parcel("D013,19,25,101,22,8");
		Parcel tp26= new Parcel("P013,43,0,70,15,75");
		Parcel tp27= new Parcel("D014,49,29,109,47,47");
		Parcel tp28= new Parcel("P014,20,3,63,120,94");
		Parcel tp29= new Parcel("P015,4,0,96,101,98");
		Parcel tp30= new Parcel("P016,54,16,137,84,1");
		Parcel tp31= new Parcel("P017,29,11,3,74,125");
		Parcel tp32= new Parcel("P018,16,9,146,78,5");
		Parcel tp33= new Parcel("P019,13,25,88,73,87");
		Parcel tp34= new Parcel("P020,38,30,36,48,106");
		Parcel tp35= new Parcel("P021,37,3,82,38,127");
		Parcel tp36= new Parcel("P022,36,50,4,51,90");
		Parcel tp37= new Parcel("P023,0,18,85,58,94");
		Parcel tp38= new Parcel("P024,7,7,119,1,5");
		Parcel tp39= new Parcel("P025,44,41,127,71,125");
		Parcel tp40= new Parcel("P026,57,22,102,22,113");
		Parcel tp41= new Parcel("P027,38,20,70,72,36");
		Parcel tp42= new Parcel("P028,16,14,30,12,124");
		Parcel tp43= new Parcel("P029,22,30,70,138,68");
		Parcel tp44= new Parcel("P030,23,30,54,39,50");
		Parcel tp45= new Parcel("P031,45,20,31,7,83");
		Parcel tp46= new Parcel("P032,52,14,115,105,36");


		
		//System.out.println(tp.calFee(),0.1);
		assertEquals(433.44,tp1.calculateFee(),0.1);
		assertEquals(811.2,tp2.calculateFee(),0.1);
		assertEquals(204.75,tp3.calculateFee(),0.1);
		assertEquals(66.5,tp4.calculateFee(),0.1);
		assertEquals(749.25,tp5.calculateFee(),0.1);
		assertEquals(13,tp6.calculateFee(),0.1);
		assertEquals(52.92,tp7.calculateFee(),0.1);
		assertEquals(136.8,tp8.calculateFee(),0.1);
		assertEquals(181.44,tp9.calculateFee(),0.1);
		assertEquals(503.2,tp10.calculateFee(),0.1);
		assertEquals(186.48,tp11.calculateFee(),0.1);
		assertEquals(102.6,tp12.calculateFee(),0.1);
		assertEquals(568.8,tp13.calculateFee(),0.1);
		assertEquals(694.2,tp14.calculateFee(),0.1);
		assertEquals(643.95,tp15.calculateFee(),0.1);
		assertEquals(17.3,tp16.calculateFee(),0.1);
		assertEquals(603.45,tp17.calculateFee(),0.1);
		assertEquals(447.5,tp18.calculateFee(),0.1);
		assertEquals(348.66,tp19.calculateFee(),0.1);
		assertEquals(622.8,tp20.calculateFee(),0.1);
		assertEquals(246.6,tp21.calculateFee(),0.1);
		assertEquals(16.8,tp22.calculateFee(),0.1);
		assertEquals(291.6,tp23.calculateFee(),0.1);
		assertEquals(151.2,tp24.calculateFee(),0.1);
		assertEquals(102.06,tp25.calculateFee(),0.1);
		assertEquals(496.8,tp26.calculateFee(),0.1);
		assertEquals(495.36,tp27.calculateFee(),0.1);
		assertEquals(720.3,tp28.calculateFee(),0.1);
		assertEquals(283.8,tp29.calculateFee(),0.1);
		assertEquals(403.2,tp30.calculateFee(),0.1);
		assertEquals(576.4,tp31.calculateFee(),0.1);
		assertEquals(443.7,tp32.calculateFee(),0.1);
		assertEquals(676.2,tp33.calculateFee(),0.1);
		assertEquals(547.6,tp34.calculateFee(),0.1);
		assertEquals(194.6,tp35.calculateFee(),0.1);
		assertEquals(15.2,tp36.calculateFee(),0.1);
		assertEquals(592.2,tp37.calculateFee(),0.1);
		assertEquals(13.2,tp38.calculateFee(),0.1);
		assertEquals(666.9,tp39.calculateFee(),0.1);
		assertEquals(222.7,tp40.calculateFee(),0.1);
		assertEquals(212.8,tp41.calculateFee(),0.1);
		assertEquals(704,tp42.calculateFee(),0.1);
		assertEquals(391.5,tp43.calculateFee(),0.1);
		assertEquals(268.6,tp44.calculateFee(),0.1);
		assertEquals(522.6,tp45.calculateFee(),0.1);
		assertEquals(232.7,tp46.calculateFee(),0.1);




	}

}
