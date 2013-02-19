package Tests;
import static org.junit.Assert.*;

import org.junit.Test;

import f21as.Parcel;


public class ParcelTest {

	
	@Test
	public void testCalFee() {
		

		Parcel tp1= new Parcel("D001,3,40,45,16,159");
		Parcel tp2= new Parcel("P001,11,30,73,106,64");
		Parcel tp3= new Parcel("D002,6,80,12,153,147");
		Parcel tp4= new Parcel("P002,0,85,107,35,195");
		Parcel tp5= new Parcel("D003,29,154,94,46,182");
		Parcel tp6= new Parcel("P003,21,47,158,200,13");
		Parcel tp7= new Parcel("D004,21,56,123,33,177");
		Parcel tp8= new Parcel("P004,33,192,183,91,68");
		Parcel tp9= new Parcel("D005,49,31,15,46,103");
		Parcel tp10= new Parcel("P005,20,4,44,120,55");
		Parcel tp11= new Parcel("D006,49,155,42,59,50");
		Parcel tp12= new Parcel("P006,56,200,79,78,166");
		Parcel tp13= new Parcel("D007,1,21,28,87,161");
		Parcel tp14= new Parcel("P007,38,81,52,4,84");
		Parcel tp15= new Parcel("D008,8,15,125,49,113");
		Parcel tp16= new Parcel("P008,54,9,194,57,3");
		Parcel tp17= new Parcel("D009,36,24,130,167,141");
		Parcel tp18= new Parcel("P009,27,105,126,32,192");
		Parcel tp19= new Parcel("D010,60,106,111,43,81");
		Parcel tp20= new Parcel("P010,8,147,167,1,-1");
		Parcel tp21= new Parcel("D011,37,79,114,138,46");
		Parcel tp22= new Parcel("P011,3,129,55,172,30");
		Parcel tp23= new Parcel("D012,56,170,107,181,129");
		Parcel tp24= new Parcel("P012,36,158,59,27,187");
		Parcel tp25= new Parcel("D013,53,19,121,157,105");
		Parcel tp26= new Parcel("P013,47,137,17,163,47");
		Parcel tp27= new Parcel("D014,37,108,9,162,181");
		Parcel tp28= new Parcel("P014,29,0,133,162,3");
		Parcel tp29= new Parcel("P015,35,28,196,155,200");
		Parcel tp30= new Parcel("P016,45,53,5,47,158");
		Parcel tp31= new Parcel("P017,39,184,167,100,186");
		Parcel tp32= new Parcel("P018,56,69,151,22,124");
		Parcel tp33= new Parcel("P019,18,70,64,68,177");
		Parcel tp34= new Parcel("P020,34,172,145,103,75");
		Parcel tp35= new Parcel("P021,53,117,185,31,27");
		Parcel tp36= new Parcel("P022,35,175,69,177,160");
		Parcel tp37= new Parcel("P023,4,126,138,46,93");
		Parcel tp38= new Parcel("P024,46,49,119,161,87");
		Parcel tp39= new Parcel("P025,47,160,35,129,162");
		Parcel tp40= new Parcel("P026,0,198,78,66,83");
		Parcel tp41= new Parcel("P027,28,13,88,122,160");
		Parcel tp42= new Parcel("P028,31,192,30,167,19");
		Parcel tp43= new Parcel("P029,59,145,107,184,28");
		Parcel tp44= new Parcel("P030,21,100,92,190,54");
		Parcel tp45= new Parcel("P031,24,79,58,167,162");
		Parcel tp46= new Parcel("P032,48,63,44,42,47");

		//System.out.println(tp.calFee(),0.1);
		assertEquals(460.8,tp1.calculateFee(),0.1);
		assertEquals(408,tp2.calculateFee(),0.1);
		assertEquals(943.2,tp3.calculateFee(),0.1);
		assertEquals(1062.5,tp4.calculateFee(),0.1);
		assertEquals(2134.44,tp5.calculateFee(),0.1);
		assertEquals(686.2,tp6.calculateFee(),0.1);
		assertEquals(735.84,tp7.calculateFee(),0.1);
		assertEquals(3033.6,tp8.calculateFee(),0.1);
		assertEquals(485.46,tp9.calculateFee(),0.1);
		assertEquals(58,tp10.calculateFee(),0.1);
		assertEquals(2427.3,tp11.calculateFee(),0.1);
		assertEquals(3620,tp12.calculateFee(),0.1);
		assertEquals(238.14,tp13.calculateFee(),0.1);
		assertEquals(1320.3,tp14.calculateFee(),0.1);
		assertEquals(179.55,tp15.calculateFee(),0.1);
		assertEquals(161.1,tp16.calculateFee(),0.1);
		assertEquals(347.76,tp17.calculateFee(),0.1);
		assertEquals(1596,tp18.calculateFee(),0.1);
		assertEquals(1764.9,tp19.calculateFee(),0.1);
		assertEquals(1587.6,tp20.calculateFee(),0.1);
		assertEquals(1151.82,tp21.calculateFee(),0.1);
		assertEquals(1651.2,tp22.calculateFee(),0.1);
		assertEquals(2769.3,tp23.calculateFee(),0.1);
		assertEquals(2543.8,tp24.calculateFee(),0.1);
		assertEquals(304.38,tp25.calculateFee(),0.1);
		assertEquals(2356.4,tp26.calculateFee(),0.1);
		assertEquals(1574.64,tp27.calculateFee(),0.1);
		assertEquals(0,tp28.calculateFee(),0.1);
		assertEquals(448,tp29.calculateFee(),0.1);
		assertEquals(901,tp30.calculateFee(),0.1);
		assertEquals(3017.6,tp31.calculateFee(),0.1);
		assertEquals(1248.9,tp32.calculateFee(),0.1);
		assertEquals(1001,tp33.calculateFee(),0.1);
		assertEquals(2734.8,tp34.calculateFee(),0.1);
		assertEquals(2082.6,tp35.calculateFee(),0.1);
		assertEquals(2800,tp36.calculateFee(),0.1);
		assertEquals(1625.4,tp37.calculateFee(),0.1);
		assertEquals(837.9,tp38.calculateFee(),0.1);
		assertEquals(2752,tp39.calculateFee(),0.1);
		assertEquals(2475,tp40.calculateFee(),0.1);
		assertEquals(198.9,tp41.calculateFee(),0.1);
		assertEquals(2995.2,tp42.calculateFee(),0.1);
		assertEquals(2668,tp43.calculateFee(),0.1);
		assertEquals(1460,tp44.calculateFee(),0.1);
		assertEquals(1177.1,tp45.calculateFee(),0.1);
		assertEquals(1089.9,tp46.calculateFee(),0.1);

	}

}
