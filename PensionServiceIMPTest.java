package sem12122.sse3305.service;

import static org.junit.jupiter.api.Assertions.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

import org.junit.jupiter.api.Test;

class PensionServiceIMPTest {

	@Test
	void testcase1() { //TC1 : Age = 40, Service = 121
		PensionServiceIMP pc = new PensionServiceIMP();
		ArrayList<String> test = new ArrayList<>();
		double actPension, actGratuity, actCash;
		test.add("1");//harilahir
		test.add("1");//bulanlahir
		test.add("1970");//tahunlahir
		test.add("1");//harikerja
		test.add("1");//bulankerja
		test.add("2000");//tahunkerja
		test.add("3300");//gaji
		test.add("150");//allowance
		test.add("120");//cuti
		test.add("0");//haricuti
		test.add("0");//bulancuti
		test.add("0");//tahuncuti
		test.add("1");//harisara
		test.add("2");//bulansara
		test.add("2010");//tahunsara
		test.add("P");//jantina
		test.add("N");//istimewa
		ArrayList<String> output = pc.kirapencen(test);
		String tiadaganjaran = output.get(2);
		if (tiadaganjaran.equals("1")||tiadaganjaran.equals("2")) {
			actPension = 0;
			actGratuity = 0;
			actCash = 0;
			assertEquals(0,actPension);
			assertEquals(0,actGratuity);
			assertEquals(0,actCash);
		} else {
			actPension = Double.parseDouble(output.get(4));
			actGratuity = Double.parseDouble(output.get(5));
			actCash = Double.parseDouble(output.get(6));
			assertEquals(665.5,actPension);
			assertEquals(29947.5,actGratuity);
			assertEquals(13800,actCash);
		}
	}
	
	@Test
	void testcase2() { //TC2 : Age = 49 ,Service = 109
		PensionServiceIMP pc = new PensionServiceIMP();
		ArrayList<String> test = new ArrayList<>();
		double actPension, actGratuity, actCash;
		test.add("1");//harilahir
		test.add("1");//bulanlahir
		test.add("1970");//tahunlahir
		test.add("1");//harikerja
		test.add("1");//bulankerja
		test.add("2010");//tahunkerja
		test.add("3300");//gaji
		test.add("150");//allowance
		test.add("120");//cuti
		test.add("0");//haricuti
		test.add("0");//bulancuti
		test.add("0");//tahuncuti
		test.add("1");//harisara
		test.add("2");//bulansara
		test.add("2019");//tahunsara
		test.add("P");//jantina
		test.add("N");//istimewa
		ArrayList<String> output = pc.kirapencen(test);
		String tiadaganjaran = output.get(2);
		if (tiadaganjaran.equals("1")||tiadaganjaran.equals("2")) {
			actPension = 0;
			actGratuity = 0;
			actCash = 0;
			assertEquals(0,actPension);
			assertEquals(0,actGratuity);
			assertEquals(0,actCash);
		} else {
			actPension = Double.parseDouble(output.get(4));
			actGratuity = Double.parseDouble(output.get(5));
			actCash = Double.parseDouble(output.get(6));
			assertEquals(665.5,actPension);
			assertEquals(29947.5,actGratuity);
			assertEquals(13800,actCash);
		}
	}
	
	@Test
	void testcase3() { //TC3 : Age = 35 ,Service = 121 (dont care)
		PensionServiceIMP pc = new PensionServiceIMP();
		ArrayList<String> test = new ArrayList<>();
		double actPension, actGratuity, actCash;
		test.add("1");//harilahir
		test.add("1");//bulanlahir
		test.add("1985");//tahunlahir
		test.add("1");//harikerja
		test.add("1");//bulankerja
		test.add("2010");//tahunkerja
		test.add("3300");//gaji
		test.add("150");//allowance
		test.add("120");//cuti
		test.add("0");//haricuti
		test.add("0");//bulancuti
		test.add("0");//tahuncuti
		test.add("1");//harisara
		test.add("2");//bulansara
		test.add("2020");//tahunsara
		test.add("P");//jantina
		test.add("N");//istimewa
		ArrayList<String> output = pc.kirapencen(test);
		String tiadaganjaran = output.get(2);
		if (tiadaganjaran.equals("1")||tiadaganjaran.equals("2")) {
			actPension = 0;
			actGratuity = 0;
			actCash = 0;
			assertEquals(0,actPension);
			assertEquals(0,actGratuity);
			assertEquals(0,actCash);
		} else {
			actPension = Double.parseDouble(output.get(4));
			actGratuity = Double.parseDouble(output.get(5));
			actCash = Double.parseDouble(output.get(6));
			assertEquals(665.5,actPension);
			assertEquals(29947.5,actGratuity);
			assertEquals(13800,actCash);
		}
	}
	
	@Test
	void testcase4() { //TC22 = start kerja BEFORE = 20/3/1991 & Gender = 'Female' = "Y" & istimewa = 'DONT CARE'
		String[] montharray = new String[] { "Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct",
				"Nov", "Dec" };
		ArrayList<String> test = new ArrayList<>();
		test.add("1");//harilahir
		test.add("1");//bulanlahir
		test.add("1960");//tahunlahir
		test.add("20");//harikerja
		test.add("3");//bulankerja
		test.add("1991");//tahunkerja
		test.add("3300");//gaji
		test.add("150");//allowance
		test.add("120");//gajicuti
		test.add("0");//cutihari
		test.add("0");//cutibulan
		test.add("0");//cutitahun
		test.add("1");//harisara
		test.add("1");//bulansara
		test.add("2010");//tahunsara
		test.add("P");//jantina
		test.add("N");//istimewa
		int tmkhidmat_hari = Integer.parseInt(test.get(3));//tarikh hari start khidmat
		int tmkhidmat_bulan = Integer.parseInt(test.get(4));//bulan start khidmat
		int tmkhidmat_tahun = Integer.parseInt(test.get(5));//tahun start khidmat
		String mkstr = montharray[tmkhidmat_bulan - 1] + " " + tmkhidmat_hari + ", " + tmkhidmat_tahun;
		Date mkstr1 = null;
		try {
			mkstr1 = new SimpleDateFormat("MMMM d, yyyy", Locale.ENGLISH).parse(mkstr);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String sDate1 = "Apr 12, 1991";//patutnya Apr 1, 1991
		Date tarapril = null;
		try {
			tarapril = new SimpleDateFormat("MMMM d, yyyy", Locale.ENGLISH).parse(sDate1);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int umurbayarpencen = 0;
		if (mkstr1.before(tarapril) && ((test.get(15).equals("L") && test.get(16).equals("Y")) || test.get(15).equals("P"))) {
			umurbayarpencen = 45;
		} else {
			if (mkstr1.before(tarapril)) {
				umurbayarpencen = 50;
			} else {
			}
			umurbayarpencen = 55;
		}
	assertEquals(umurbayarpencen,45);
	}
	
	@Test
	void testcase5() { //TC23 = start kerja BEFORE = 20/3/1991 & Gender = 'Female' = "N" & istimewa = "Y"
		String[] montharray = new String[] { "Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct",
				"Nov", "Dec" };
		ArrayList<String> test = new ArrayList<>();
		test.add("1");//harilahir
		test.add("1");//bulanlahir
		test.add("1960");//tahunlahir
		test.add("20");//harikerja
		test.add("3");//bulankerja
		test.add("1991");//tahunkerja
		test.add("3300");//gaji
		test.add("150");//allowance
		test.add("120");//gajicuti
		test.add("0");//cutihari
		test.add("0");//cutibulan
		test.add("0");//cutitahun
		test.add("1");//harisara
		test.add("1");//bulansara
		test.add("2010");//tahunsara
		test.add("L");//jantina
		test.add("Y");//istimewa
		int tmkhidmat_hari = Integer.parseInt(test.get(3));//tarikh hari start khidmat
		int tmkhidmat_bulan = Integer.parseInt(test.get(4));//bulan start khidmat
		int tmkhidmat_tahun = Integer.parseInt(test.get(5));//tahun start khidmat
		String mkstr = montharray[tmkhidmat_bulan - 1] + " " + tmkhidmat_hari + ", " + tmkhidmat_tahun;
		Date mkstr1 = null;
		try {
			mkstr1 = new SimpleDateFormat("MMMM d, yyyy", Locale.ENGLISH).parse(mkstr);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String sDate1 = "Apr 12, 1991";//patutnya Apr 1, 1991
		Date tarapril = null;
		try {
			tarapril = new SimpleDateFormat("MMMM d, yyyy", Locale.ENGLISH).parse(sDate1);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int umurbayarpencen = 0;
		if (mkstr1.before(tarapril) && ((test.get(15).equals("L") && test.get(16).equals("Y")) || test.get(15).equals("P"))) {
			umurbayarpencen = 45;
		} else {
			if (mkstr1.before(tarapril)) {
				umurbayarpencen = 50;
			} else {
			}
			umurbayarpencen = 55;
		}
	assertEquals(umurbayarpencen,45);
	}
	
	@Test
	void testcase6() { //TC24 = start kerja BEFORE = 20/3/1991 & Gender = 'Female' = "N" & istimewa = "N" NI YANG SALAH
		String[] montharray = new String[] { "Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct",
				"Nov", "Dec" };
		ArrayList<String> test = new ArrayList<>();
		test.add("1");//harilahir
		test.add("1");//bulanlahir
		test.add("1960");//tahunlahir
		test.add("20");//harikerja
		test.add("3");//bulankerja
		test.add("1991");//tahunkerja
		test.add("3300");//gaji
		test.add("150");//allowance
		test.add("120");//gajicuti
		test.add("0");//cutihari
		test.add("0");//cutibulan
		test.add("0");//cutitahun
		test.add("1");//harisara
		test.add("1");//bulansara
		test.add("2010");//tahunsara
		test.add("L");//jantina
		test.add("N");//istimewa
		int tmkhidmat_hari = Integer.parseInt(test.get(3));//tarikh hari start khidmat
		int tmkhidmat_bulan = Integer.parseInt(test.get(4));//bulan start khidmat
		int tmkhidmat_tahun = Integer.parseInt(test.get(5));//tahun start khidmat
		String mkstr = montharray[tmkhidmat_bulan - 1] + " " + tmkhidmat_hari + ", " + tmkhidmat_tahun;
		Date mkstr1 = null;
		try {
			mkstr1 = new SimpleDateFormat("MMMM d, yyyy", Locale.ENGLISH).parse(mkstr);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String sDate1 = "Apr 12, 1991";//patutnya Apr 1, 1991
		Date tarapril = null;
		try {
			tarapril = new SimpleDateFormat("MMMM d, yyyy", Locale.ENGLISH).parse(sDate1);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int umurbayarpencen = 0;
		if (mkstr1.before(tarapril) && ((test.get(15).equals("L") && test.get(16).equals("Y")) || test.get(15).equals("P"))) {
			umurbayarpencen = 45;
		} else {
			if (mkstr1.before(tarapril)) {
				umurbayarpencen = 50;
			} else {
			}
			umurbayarpencen = 55;
		}
	assertEquals(umurbayarpencen,50);
	}
	
	@Test
	void testcase7() { //TC25 = start kerja AFTER = 20/3/1998 & Gender = 'DONT CARE' & istimewa = 'DONT CARE'
		String[] montharray = new String[] { "Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct",
				"Nov", "Dec" };
		ArrayList<String> test = new ArrayList<>();
		test.add("1");//harilahir
		test.add("1");//bulanlahir
		test.add("1960");//tahunlahir
		test.add("20");//harikerja
		test.add("3");//bulankerja
		test.add("1998");//tahunkerja
		test.add("3300");//gaji
		test.add("150");//allowance
		test.add("120");//gajicuti
		test.add("0");//cutihari
		test.add("0");//cutibulan
		test.add("0");//cutitahun
		test.add("1");//harisara
		test.add("1");//bulansara
		test.add("2010");//tahunsara
		test.add("P");//jantina
		test.add("N");//istimewa
		int tmkhidmat_hari = Integer.parseInt(test.get(3));//tarikh hari start khidmat
		int tmkhidmat_bulan = Integer.parseInt(test.get(4));//bulan start khidmat
		int tmkhidmat_tahun = Integer.parseInt(test.get(5));//tahun start khidmat
		String mkstr = montharray[tmkhidmat_bulan - 1] + " " + tmkhidmat_hari + ", " + tmkhidmat_tahun;
		Date mkstr1 = null;
		try {
			mkstr1 = new SimpleDateFormat("MMMM d, yyyy", Locale.ENGLISH).parse(mkstr);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String sDate1 = "Apr 12, 1991";//patutnya Apr 1, 1991
		Date tarapril = null;
		try {
			tarapril = new SimpleDateFormat("MMMM d, yyyy", Locale.ENGLISH).parse(sDate1);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int umurbayarpencen = 0;
		if (mkstr1.before(tarapril) && ((test.get(15).equals("L") && test.get(16).equals("Y")) || test.get(15).equals("P"))) {
			umurbayarpencen = 45;
		} else {
			if (mkstr1.before(tarapril)) {
				umurbayarpencen = 50;
			} else {
			}
			umurbayarpencen = 55;
		}
	assertEquals(umurbayarpencen,55);
	}
	
	@Test
	void testcase8() { //TC13 : Age = 39 ,Service = 119
		PensionServiceIMP pc = new PensionServiceIMP();
		ArrayList<String> test = new ArrayList<>();
		double actPension, actGratuity, actCash;
		test.add("1");//harilahir
		test.add("1");//bulanlahir
		test.add("1969");//tahunlahir
		test.add("1");//harikerja
		test.add("2");//bulankerja
		test.add("1998");//tahunkerja
		test.add("3300");//gaji
		test.add("150");//allowance
		test.add("120");//cuti
		test.add("0");//haricuti
		test.add("0");//bulancuti
		test.add("0");//tahuncuti
		test.add("1");//harisara
		test.add("1");//bulansara
		test.add("2008");//tahunsara
		test.add("P");//jantina
		test.add("N");//istimewa
		ArrayList<String> output = pc.kirapencen(test);
		String tiadaganjaran = output.get(2);
		if (tiadaganjaran.equals("1")||tiadaganjaran.equals("2")) {
			actPension = 0;
			actGratuity = 0;
			actCash = 0;
			assertEquals(0,actPension);
			assertEquals(0,actGratuity);
			assertEquals(0,actCash);
		} else {
			actPension = Double.parseDouble(output.get(4));
			actGratuity = Double.parseDouble(output.get(5));
			actCash = Double.parseDouble(output.get(6));
			assertEquals(665.5,actPension);
			assertEquals(29947.5,actGratuity);
			assertEquals(13800,actCash);
		}
	}
	
	@Test
	void testcase9() { //TC13 : Age = 39 ,Service = 120
		PensionServiceIMP pc = new PensionServiceIMP();
		ArrayList<String> test = new ArrayList<>();
		double actPension, actGratuity, actCash;
		test.add("1");//harilahir
		test.add("1");//bulanlahir
		test.add("1969");//tahunlahir
		test.add("1");//harikerja
		test.add("1");//bulankerja
		test.add("1998");//tahunkerja
		test.add("3300");//gaji
		test.add("150");//allowance
		test.add("120");//cuti
		test.add("0");//haricuti
		test.add("0");//bulancuti
		test.add("0");//tahuncuti
		test.add("1");//harisara
		test.add("1");//bulansara
		test.add("2008");//tahunsara
		test.add("P");//jantina
		test.add("N");//istimewa
		ArrayList<String> output = pc.kirapencen(test);
		String tiadaganjaran = output.get(2);
		if (tiadaganjaran.equals("1")||tiadaganjaran.equals("2")) {
			actPension = 0;
			actGratuity = 0;
			actCash = 0;
			assertEquals(0,actPension);
			assertEquals(0,actGratuity);
			assertEquals(0,actCash);
		} else {
			actPension = Double.parseDouble(output.get(4));
			actGratuity = Double.parseDouble(output.get(5));
			actCash = Double.parseDouble(output.get(6));
			assertEquals(665.5,actPension);
			assertEquals(29947.5,actGratuity);
			assertEquals(13800,actCash);
		}
	}
	
	@Test
	void testcase10() { //TC13 : Age = 39 ,Service = 121
		PensionServiceIMP pc = new PensionServiceIMP();
		ArrayList<String> test = new ArrayList<>();
		double actPension, actGratuity, actCash;
		test.add("1");//harilahir
		test.add("1");//bulanlahir
		test.add("1969");//tahunlahir
		test.add("1");//harikerja
		test.add("12");//bulankerja
		test.add("1997");//tahunkerja
		test.add("3300");//gaji
		test.add("150");//allowance
		test.add("120");//cuti
		test.add("0");//haricuti
		test.add("0");//bulancuti
		test.add("0");//tahuncuti
		test.add("1");//harisara
		test.add("1");//bulansara
		test.add("2008");//tahunsara
		test.add("P");//jantina
		test.add("N");//istimewa
		ArrayList<String> output = pc.kirapencen(test);
		String tiadaganjaran = output.get(2);
		if (tiadaganjaran.equals("1")||tiadaganjaran.equals("2")) {
			actPension = 0;
			actGratuity = 0;
			actCash = 0;
			assertEquals(0,actPension);
			assertEquals(0,actGratuity);
			assertEquals(0,actCash);
		} else {
			actPension = Double.parseDouble(output.get(4));
			actGratuity = Double.parseDouble(output.get(5));
			actCash = Double.parseDouble(output.get(6));
			assertEquals(665.5,actPension);
			assertEquals(29947.5,actGratuity);
			assertEquals(13800,actCash);
		}
	}

	@Test
	void testcase11() { //TC13 : Age = 40 ,Service = 119
		PensionServiceIMP pc = new PensionServiceIMP();
		ArrayList<String> test = new ArrayList<>();
		double actPension, actGratuity, actCash;
		test.add("1");//harilahir
		test.add("1");//bulanlahir
		test.add("1968");//tahunlahir
		test.add("1");//harikerja
		test.add("2");//bulankerja
		test.add("1998");//tahunkerja
		test.add("3300");//gaji
		test.add("150");//allowance
		test.add("120");//cuti
		test.add("0");//haricuti
		test.add("0");//bulancuti
		test.add("0");//tahuncuti
		test.add("1");//harisara
		test.add("1");//bulansara
		test.add("2008");//tahunsara
		test.add("P");//jantina
		test.add("N");//istimewa
		ArrayList<String> output = pc.kirapencen(test);
		String tiadaganjaran = output.get(2);
		if (tiadaganjaran.equals("1")||tiadaganjaran.equals("2")) {
			actPension = 0;
			actGratuity = 0;
			actCash = 0;
			assertEquals(0,actPension);
			assertEquals(0,actGratuity);
			assertEquals(0,actCash);
		} else {
			actPension = Double.parseDouble(output.get(4));
			actGratuity = Double.parseDouble(output.get(5));
			actCash = Double.parseDouble(output.get(6));
			assertEquals(665.5,actPension);
			assertEquals(29947.5,actGratuity);
			assertEquals(13800,actCash);
		}
	}
	
	@Test
	void testcase12() { //TC13 : Age = 40 ,Service = 120 YANG NI SALAH
		PensionServiceIMP pc = new PensionServiceIMP();
		ArrayList<String> test = new ArrayList<>();
		double actPension, actGratuity, actCash;
		test.add("1");//harilahir
		test.add("1");//bulanlahir
		test.add("1968");//tahunlahir
		test.add("1");//harikerja
		test.add("1");//bulankerja
		test.add("1998");//tahunkerja
		test.add("3300");//gaji
		test.add("150");//allowance
		test.add("120");//cuti
		test.add("0");//haricuti
		test.add("0");//bulancuti
		test.add("0");//tahuncuti
		test.add("1");//harisara
		test.add("1");//bulansara
		test.add("2008");//tahunsara
		test.add("P");//jantina
		test.add("N");//istimewa
		ArrayList<String> output = pc.kirapencen(test);
		String tiadaganjaran = output.get(2);
		if (tiadaganjaran.equals("1")||tiadaganjaran.equals("2")) {
			actPension = 0;
			actGratuity = 0;
			actCash = 0;
			assertEquals(0,actPension);
			assertEquals(0,actGratuity);
			assertEquals(0,actCash);
		} else {
			actPension = Double.parseDouble(output.get(4));
			actGratuity = Double.parseDouble(output.get(5));
			actCash = Double.parseDouble(output.get(6));
			assertEquals(665.5,actPension);
			assertEquals(29947.5,actGratuity);
			assertEquals(13800,actCash);
		}
	}
	
	@Test
	void testcase13() { //TC13 : Age = 41 ,Service = 119
		PensionServiceIMP pc = new PensionServiceIMP();
		ArrayList<String> test = new ArrayList<>();
		double actPension, actGratuity, actCash;
		test.add("1");//harilahir
		test.add("1");//bulanlahir
		test.add("1967");//tahunlahir
		test.add("1");//harikerja
		test.add("2");//bulankerja
		test.add("1998");//tahunkerja
		test.add("3300");//gaji
		test.add("150");//allowance
		test.add("120");//cuti
		test.add("0");//haricuti
		test.add("0");//bulancuti
		test.add("0");//tahuncuti
		test.add("1");//harisara
		test.add("1");//bulansara
		test.add("2008");//tahunsara
		test.add("P");//jantina
		test.add("N");//istimewa
		ArrayList<String> output = pc.kirapencen(test);
		String tiadaganjaran = output.get(2);
		if (tiadaganjaran.equals("1")||tiadaganjaran.equals("2")) {
			actPension = 0;
			actGratuity = 0;
			actCash = 0;
			assertEquals(0,actPension);
			assertEquals(0,actGratuity);
			assertEquals(0,actCash);
		} else {
			actPension = Double.parseDouble(output.get(4));
			actGratuity = Double.parseDouble(output.get(5));
			actCash = Double.parseDouble(output.get(6));
			assertEquals(665.5,actPension);
			assertEquals(29947.5,actGratuity);
			assertEquals(13800,actCash);
		}
	}
	
	@Test
	void testcase14() { //TC13 : Age = 41 ,Service = 120 YANG NI SALAH
		PensionServiceIMP pc = new PensionServiceIMP();
		ArrayList<String> test = new ArrayList<>();
		double actPension, actGratuity, actCash;
		test.add("1");//harilahir
		test.add("1");//bulanlahir
		test.add("1967");//tahunlahir
		test.add("1");//harikerja
		test.add("1");//bulankerja
		test.add("1998");//tahunkerja
		test.add("3300");//gaji
		test.add("150");//allowance
		test.add("120");//cuti
		test.add("0");//haricuti
		test.add("0");//bulancuti
		test.add("0");//tahuncuti
		test.add("1");//harisara
		test.add("1");//bulansara
		test.add("2008");//tahunsara
		test.add("P");//jantina
		test.add("N");//istimewa
		ArrayList<String> output = pc.kirapencen(test);
		String tiadaganjaran = output.get(2);
		if (tiadaganjaran.equals("1")||tiadaganjaran.equals("2")) {
			actPension = 0;
			actGratuity = 0;
			actCash = 0;
			assertEquals(0,actPension);
			assertEquals(0,actGratuity);
			assertEquals(0,actCash);
		} else {
			actPension = Double.parseDouble(output.get(4));
			actGratuity = Double.parseDouble(output.get(5));
			actCash = Double.parseDouble(output.get(6));
			assertEquals(665.5,actPension);
			assertEquals(29947.5,actGratuity);
			assertEquals(13800,actCash);
		}
	}
	
	@Test
	void testcase15() { //TC14 : Age = 50 ,Service = 130
		PensionServiceIMP pc = new PensionServiceIMP();
		ArrayList<String> test = new ArrayList<>();
		double actPension, actGratuity, actCash;
		test.add("1");//harilahir
		test.add("1");//bulanlahir
		test.add("1958");//tahunlahir
		test.add("1");//harikerja
		test.add("3");//bulankerja
		test.add("1997");//tahunkerja
		test.add("3300");//gaji
		test.add("150");//allowance
		test.add("120");//cuti
		test.add("0");//haricuti
		test.add("0");//bulancuti
		test.add("0");//tahuncuti
		test.add("1");//harisara
		test.add("1");//bulansara
		test.add("2008");//tahunsara
		test.add("P");//jantina
		test.add("N");//istimewa
		ArrayList<String> output = pc.kirapencen(test);
		String tiadaganjaran = output.get(2);
		if (tiadaganjaran.equals("1")||tiadaganjaran.equals("2")) {
			actPension = 0;
			actGratuity = 0;
			actCash = 0;
			assertEquals(0,actPension);
			assertEquals(0,actGratuity);
			assertEquals(0,actCash);
		} else {
			actPension = Double.parseDouble(output.get(4));
			actGratuity = Double.parseDouble(output.get(5));
			actCash = Double.parseDouble(output.get(6));
			assertEquals(715,actPension);
			assertEquals(32175,actGratuity);
			assertEquals(13800,actCash);
		}
	}
	
	@Test
	void testcase16() { //TC15 : Age = 30 ,Service = 110
		PensionServiceIMP pc = new PensionServiceIMP();
		ArrayList<String> test = new ArrayList<>();
		double actPension, actGratuity, actCash;
		test.add("1");//harilahir
		test.add("1");//bulanlahir
		test.add("1978");//tahunlahir
		test.add("1");//harikerja
		test.add("11");//bulankerja
		test.add("1998");//tahunkerja
		test.add("3300");//gaji
		test.add("150");//allowance
		test.add("120");//cuti
		test.add("0");//haricuti
		test.add("0");//bulancuti
		test.add("0");//tahuncuti
		test.add("1");//harisara
		test.add("1");//bulansara
		test.add("2008");//tahunsara
		test.add("P");//jantina
		test.add("N");//istimewa
		ArrayList<String> output = pc.kirapencen(test);
		String tiadaganjaran = output.get(2);
		if (tiadaganjaran.equals("1")||tiadaganjaran.equals("2")) {
			actPension = 0;
			actGratuity = 0;
			actCash = 0;
			assertEquals(0,actPension);
			assertEquals(0,actGratuity);
			assertEquals(0,actCash);
		} else {
			actPension = Double.parseDouble(output.get(4));
			actGratuity = Double.parseDouble(output.get(5));
			actCash = Double.parseDouble(output.get(6));
			assertEquals(665.5,actPension);
			assertEquals(29947.5,actGratuity);
			assertEquals(13800,actCash);
		}
	}
	
	@Test
	void testcase17() { //TC13 : Age = 38 ,Service = 121
		PensionServiceIMP pc = new PensionServiceIMP();
		ArrayList<String> test = new ArrayList<>();
		double actPension, actGratuity, actCash;
		test.add("1");//harilahir
		test.add("1");//bulanlahir
		test.add("1970");//tahunlahir
		test.add("1");//harikerja
		test.add("1");//bulankerja
		test.add("1998");//tahunkerja
		test.add("3300");//gaji
		test.add("150");//allowance
		test.add("120");//cuti
		test.add("0");//haricuti
		test.add("0");//bulancuti
		test.add("0");//tahuncuti
		test.add("1");//harisara
		test.add("1");//bulansara
		test.add("2008");//tahunsara
		test.add("P");//jantina
		test.add("N");//istimewa
		ArrayList<String> output = pc.kirapencen(test);
		String tiadaganjaran = output.get(2);
		if (tiadaganjaran.equals("1")||tiadaganjaran.equals("2")) {
			actPension = 0;
			actGratuity = 0;
			actCash = 0;
			assertEquals(0,actPension);
			assertEquals(0,actGratuity);
			assertEquals(0,actCash);
		} else {
			actPension = Double.parseDouble(output.get(4));
			actGratuity = Double.parseDouble(output.get(5));
			actCash = Double.parseDouble(output.get(6));
			assertEquals(665.5,actPension);
			assertEquals(29947.5,actGratuity);
			assertEquals(13800,actCash);
		}
	}
	
	@Test
	void testcase18() { //TC18 : Age = 29 ,Service = 94
		PensionServiceIMP pc = new PensionServiceIMP();
		ArrayList<String> test = new ArrayList<>();
		double actPension, actGratuity, actCash;
		test.add("1");//harilahir
		test.add("1");//bulanlahir
		test.add("1979");//tahunlahir
		test.add("1");//harikerja
		test.add("3");//bulankerja
		test.add("2000");//tahunkerja
		test.add("3300");//gaji
		test.add("150");//allowance
		test.add("120");//cuti
		test.add("0");//haricuti
		test.add("0");//bulancuti
		test.add("0");//tahuncuti
		test.add("1");//harisara
		test.add("1");//bulansara
		test.add("2008");//tahunsara
		test.add("P");//jantina
		test.add("N");//istimewa
		ArrayList<String> output = pc.kirapencen(test);
		String tiadaganjaran = output.get(2);
		if (tiadaganjaran.equals("1")||tiadaganjaran.equals("2")) {
			actPension = 0;
			actGratuity = 0;
			actCash = 0;
			assertEquals(0,actPension);
			assertEquals(0,actGratuity);
			assertEquals(0,actCash);
		} else {
			actPension = Double.parseDouble(output.get(4));
			actGratuity = Double.parseDouble(output.get(5));
			actCash = Double.parseDouble(output.get(6));
			assertEquals(665.5,actPension);
			assertEquals(29947.5,actGratuity);
			assertEquals(13800,actCash);
		}
	}
	//start conrtol structure
	//service commencement date = 1.1.2000
		@Test
		void testcase19() { //TC26 = Hari Lahir = 12.12.1970 & Retirement date = 9.10.2010
			ArrayList<String> test = new ArrayList<>();
			test.add("12");
			test.add("12");
			test.add("1970");//tahunlahir
			test.add("1");
			test.add("1");
			test.add("2000");//tahunkerja
			test.add("3300");//gaji
			test.add("150");//allowance
			test.add("120");//gajicuti
			test.add("0");//cutihari
			test.add("0");//cutibulan
			test.add("0");//cutitahun
			test.add("9");//harisara
			test.add("10");//bulansara
			test.add("2010");//tahunsara
			test.add("L");//jantina
			test.add("N");//istimewa
			int minusbulan = 0;
			int minustahun;
			int plusbulan = 0;

			minustahun = 0;
			if (Integer.parseInt(test.get(12)) < Integer.parseInt(test.get(0)))
				minusbulan = 1;
			if ((Integer.parseInt(test.get(13)) - minusbulan) < Integer.parseInt(test.get(1))) {
				plusbulan = 12;
				minustahun = 1;
			}
			int umursara_bulan = Integer.parseInt(test.get(13)) - minusbulan + plusbulan - Integer.parseInt(test.get(1));
			int umursara_tahun = Integer.parseInt(test.get(14)) - minustahun - Integer.parseInt(test.get(2));
		
			assertEquals(umursara_bulan,9);
			assertEquals(umursara_tahun,39);
			
		}
		
		@Test
		void testcase20() { //TC27 = Hari Lahir = 19.2.1970 & Retirement date = 20.10.2010
			ArrayList<String> test = new ArrayList<>();
			test.add("19");
			test.add("2");
			test.add("1970");//tahunlahir
			test.add("1");
			test.add("1");
			test.add("2000");//tahunkerja
			test.add("3300");//gaji
			test.add("150");//allowance
			test.add("120");//gajicuti
			test.add("0");//cutihari
			test.add("0");//cutibulan
			test.add("0");//cutitahun
			test.add("20");//harisara
			test.add("10");//bulansara
			test.add("2010");//tahunsara
			test.add("L");//jantina
			test.add("N");//istimewa
			int minusbulan = 0;
			int minustahun;
			int plusbulan = 0;

			minustahun = 0;
			if (Integer.parseInt(test.get(12)) < Integer.parseInt(test.get(0)))
				minusbulan = 1;
			if ((Integer.parseInt(test.get(13)) - minusbulan) < Integer.parseInt(test.get(1))) {
				plusbulan = 12;
				minustahun = 1;
			}
			int umursara_bulan = Integer.parseInt(test.get(13)) - minusbulan + plusbulan - Integer.parseInt(test.get(1));
			int umursara_tahun = Integer.parseInt(test.get(14)) - minustahun - Integer.parseInt(test.get(2));
		
			assertEquals(umursara_bulan,8);
			assertEquals(umursara_tahun,40);
			
		}
		@Test
		void testcase21() { //TC28 = Hari Lahir = 19.2.1970 & Retirement date = 18.10.2010
			ArrayList<String> test = new ArrayList<>();
			test.add("19");
			test.add("2");
			test.add("1970");//tahunlahir
			test.add("1");
			test.add("1");
			test.add("2000");//tahunkerja
			test.add("3300");//gaji
			test.add("150");//allowance
			test.add("120");//gajicuti
			test.add("0");//cutihari
			test.add("0");//cutibulan
			test.add("0");//cutitahun
			test.add("18");//harisara
			test.add("10");//bulansara
			test.add("2010");//tahunsara
			test.add("L");//jantina
			test.add("N");//istimewa
			int minusbulan = 0;
			int minustahun;
			int plusbulan = 0;

			minustahun = 0;
			if (Integer.parseInt(test.get(12)) < Integer.parseInt(test.get(0)))
				minusbulan = 1;
			if ((Integer.parseInt(test.get(13)) - minusbulan) < Integer.parseInt(test.get(1))) {
				plusbulan = 12;
				minustahun = 1;
			}
			int umursara_bulan = Integer.parseInt(test.get(13)) - minusbulan + plusbulan - Integer.parseInt(test.get(1));
			int umursara_tahun = Integer.parseInt(test.get(14)) - minustahun - Integer.parseInt(test.get(2));
		
			assertEquals(umursara_bulan,7);
			assertEquals(umursara_tahun,40);
			
		}
		@Test
		void testcase22() { //TC29 = start kerja= 12/4/1989 & Gender = 'P' & istimewa = 'N'
			String[] montharray = new String[] { "Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct",
					"Nov", "Dec" };
			ArrayList<String> test = new ArrayList<>();
			test.add("1");
			test.add("1");
			test.add("1970");//tahunlahir
			test.add("12");
			test.add("4");
			test.add("1989");//tahunkerja
			test.add("3300");//gaji
			test.add("150");//allowance
			test.add("120");//gajicuti
			test.add("0");//cutihari
			test.add("0");//cutibulan
			test.add("0");//cutitahun
			test.add("1");//harisara
			test.add("2");//bulansara
			test.add("1995");//tahunsara
			test.add("P");//jantina
			test.add("N");//istimewa
			int tmkhidmat_hari = Integer.parseInt(test.get(3));//tarikh hari start khidmat
			int tmkhidmat_bulan = Integer.parseInt(test.get(4));//bulan start khidmat
			int tmkhidmat_tahun = Integer.parseInt(test.get(5));//tahun start khidmat
			String mkstr = montharray[tmkhidmat_bulan - 1] + " " + tmkhidmat_hari + ", " + tmkhidmat_tahun;
			Date mkstr1 = null;
			try {
				mkstr1 = new SimpleDateFormat("MMMM d, yyyy", Locale.ENGLISH).parse(mkstr);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			String sDate1 = "Apr 12, 1991";//patutnya Apr 1, 1991
			Date tarapril = null;
			try {
				tarapril = new SimpleDateFormat("MMMM d, yyyy", Locale.ENGLISH).parse(sDate1);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			int umurbayarpencen = 0;
			if (mkstr1.before(tarapril) && ((test.get(15).equals("L") && test.get(16).equals("Y")) || test.get(15).equals("P"))) {
				umurbayarpencen = 45;
			} else {
				if (mkstr1.before(tarapril)) {
					umurbayarpencen = 50;
				} else {
				}
				umurbayarpencen = 55;
			}
		assertEquals(umurbayarpencen,45);
		}
		@Test
		void testcase23() { //TC30 = start kerja= 12/1/1982 & Gender = 'L' & istimewa = 'N'
			String[] montharray = new String[] { "Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct",
					"Nov", "Dec" };
			ArrayList<String> test = new ArrayList<>();
			test.add("1");
			test.add("1");
			test.add("1970");//tahunlahir
			test.add("12");
			test.add("1");
			test.add("1982");//tahunkerja
			test.add("3300");//gaji
			test.add("150");//allowance
			test.add("120");//gajicuti
			test.add("0");//cutihari
			test.add("0");//cutibulan
			test.add("0");//cutitahun
			test.add("1");//harisara
			test.add("2");//bulansara
			test.add("1995");//tahunsara
			test.add("L");//jantina
			test.add("N");//istimewa
			int tmkhidmat_hari = Integer.parseInt(test.get(3));//tarikh hari start khidmat
			int tmkhidmat_bulan = Integer.parseInt(test.get(4));//bulan start khidmat
			int tmkhidmat_tahun = Integer.parseInt(test.get(5));//tahun start khidmat
			String mkstr = montharray[tmkhidmat_bulan - 1] + " " + tmkhidmat_hari + ", " + tmkhidmat_tahun;
			Date mkstr1 = null;
			try {
				mkstr1 = new SimpleDateFormat("MMMM d, yyyy", Locale.ENGLISH).parse(mkstr);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			String sDate1 = "Apr 12, 1991";//patutnya Apr 1, 1991
			Date tarapril = null;
			try {
				tarapril = new SimpleDateFormat("MMMM d, yyyy", Locale.ENGLISH).parse(sDate1);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			int umurbayarpencen = 0;
			if (mkstr1.before(tarapril) && ((test.get(15).equals("L") && test.get(16).equals("Y")) || test.get(15).equals("P"))) {
				umurbayarpencen = 45;
			} else {
				if (mkstr1.before(tarapril)) {
					umurbayarpencen = 50;
				} else {
				}
				umurbayarpencen = 55;
			}
		assertEquals(umurbayarpencen,50);
		}
		@Test
		void testcase24() { //TC31 = start kerja= 10/9/2001 & Gender = 'P' & istimewa = 'N'
			String[] montharray = new String[] { "Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct",
					"Nov", "Dec" };
			ArrayList<String> test = new ArrayList<>();
			test.add("1");
			test.add("1");
			test.add("1970");//tahunlahir
			test.add("10");
			test.add("9");
			test.add("2001");//tahunkerja
			test.add("3300");//gaji
			test.add("150");//allowance
			test.add("120");//gajicuti
			test.add("0");//cutihari
			test.add("0");//cutibulan
			test.add("0");//cutitahun
			test.add("1");//harisara
			test.add("2");//bulansara
			test.add("1995");//tahunsara
			test.add("P");//jantina
			test.add("N");//istimewa
			int tmkhidmat_hari = Integer.parseInt(test.get(3));//tarikh hari start khidmat
			int tmkhidmat_bulan = Integer.parseInt(test.get(4));//bulan start khidmat
			int tmkhidmat_tahun = Integer.parseInt(test.get(5));//tahun start khidmat
			String mkstr = montharray[tmkhidmat_bulan - 1] + " " + tmkhidmat_hari + ", " + tmkhidmat_tahun;
			Date mkstr1 = null;
			try {
				mkstr1 = new SimpleDateFormat("MMMM d, yyyy", Locale.ENGLISH).parse(mkstr);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			String sDate1 = "Apr 12, 1991";//patutnya Apr 1, 1991
			Date tarapril = null;
			try {
				tarapril = new SimpleDateFormat("MMMM d, yyyy", Locale.ENGLISH).parse(sDate1);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			int umurbayarpencen = 0;
			if (mkstr1.before(tarapril) && ((test.get(15).equals("L") && test.get(16).equals("Y")) || test.get(15).equals("P"))) {
				umurbayarpencen = 45;
			} else {
				if (mkstr1.before(tarapril)) {
					umurbayarpencen = 50;
				} else {
				}
				umurbayarpencen = 55;
			}
		assertEquals(umurbayarpencen,55);
		}
		@Test
		void testcase25() { //TC32 = start kerja= 10/9/2001 & Gender = 'L' & istimewa = 'N'
			String[] montharray = new String[] { "Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct",
					"Nov", "Dec" };
			ArrayList<String> test = new ArrayList<>();
			test.add("1");
			test.add("1");
			test.add("1970");//tahunlahir
			test.add("10");
			test.add("9");
			test.add("2001");//tahunkerja
			test.add("3300");//gaji
			test.add("150");//allowance
			test.add("120");//gajicuti
			test.add("0");//cutihari
			test.add("0");//cutibulan
			test.add("0");//cutitahun
			test.add("1");//harisara
			test.add("2");//bulansara
			test.add("1995");//tahunsara
			test.add("P");//jantina
			test.add("N");//istimewa
			int tmkhidmat_hari = Integer.parseInt(test.get(3));//tarikh hari start khidmat
			int tmkhidmat_bulan = Integer.parseInt(test.get(4));//bulan start khidmat
			int tmkhidmat_tahun = Integer.parseInt(test.get(5));//tahun start khidmat
			String mkstr = montharray[tmkhidmat_bulan - 1] + " " + tmkhidmat_hari + ", " + tmkhidmat_tahun;
			Date mkstr1 = null;
			try {
				mkstr1 = new SimpleDateFormat("MMMM d, yyyy", Locale.ENGLISH).parse(mkstr);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			String sDate1 = "Apr 12, 1991";//patutnya Apr 1, 1991
			Date tarapril = null;
			try {
				tarapril = new SimpleDateFormat("MMMM d, yyyy", Locale.ENGLISH).parse(sDate1);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			int umurbayarpencen = 0;
			if (mkstr1.before(tarapril) && ((test.get(15).equals("L") && test.get(16).equals("Y")) || test.get(15).equals("P"))) {
				umurbayarpencen = 45;
			} else {
				if (mkstr1.before(tarapril)) {
					umurbayarpencen = 50;
				} else {
				}
				umurbayarpencen = 55;
			}
		assertEquals(umurbayarpencen,55);
		}
		@Test
		void testcase26() { //TC33 = start kerja= 10/9/1987 & Gender = 'L' & istimewa = 'Y'
			String[] montharray = new String[] { "Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct",
					"Nov", "Dec" };
			ArrayList<String> test = new ArrayList<>();
			test.add("1");
			test.add("1");
			test.add("1970");//tahunlahir
			test.add("10");
			test.add("9");
			test.add("1987");//tahunkerja
			test.add("3300");//gaji
			test.add("150");//allowance
			test.add("120");//gajicuti
			test.add("0");//cutihari
			test.add("0");//cutibulan
			test.add("0");//cutitahun
			test.add("1");//harisara
			test.add("2");//bulansara
			test.add("1995");//tahunsara
			test.add("L");//jantina
			test.add("Y");//istimewa
			int tmkhidmat_hari = Integer.parseInt(test.get(3));//tarikh hari start khidmat
			int tmkhidmat_bulan = Integer.parseInt(test.get(4));//bulan start khidmat
			int tmkhidmat_tahun = Integer.parseInt(test.get(5));//tahun start khidmat
			String mkstr = montharray[tmkhidmat_bulan - 1] + " " + tmkhidmat_hari + ", " + tmkhidmat_tahun;
			Date mkstr1 = null;
			try {
				mkstr1 = new SimpleDateFormat("MMMM d, yyyy", Locale.ENGLISH).parse(mkstr);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			String sDate1 = "Apr 12, 1991";//patutnya Apr 1, 1991
			Date tarapril = null;
			try {
				tarapril = new SimpleDateFormat("MMMM d, yyyy", Locale.ENGLISH).parse(sDate1);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			int umurbayarpencen = 0;
			if (mkstr1.before(tarapril) && ((test.get(15).equals("L") && test.get(16).equals("Y")) || test.get(15).equals("P"))) {
				umurbayarpencen = 45;
			} else {
				if (mkstr1.before(tarapril)) {
					umurbayarpencen = 50;
				} else {
				}
				umurbayarpencen = 55;
			}
		assertEquals(umurbayarpencen,45);
		}
		@Test
		void testcase27() { //TC34 = start kerja= 10/9/1987 & Gender = 'P' & istimewa = 'Y'
			String[] montharray = new String[] { "Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct",
					"Nov", "Dec" };
			ArrayList<String> test = new ArrayList<>();
			test.add("1");
			test.add("1");
			test.add("1970");//tahunlahir
			test.add("10");
			test.add("9");
			test.add("1987");//tahunkerja
			test.add("3300");//gaji
			test.add("150");//allowance
			test.add("120");//gajicuti
			test.add("0");//cutihari
			test.add("0");//cutibulan
			test.add("0");//cutitahun
			test.add("1");//harisara
			test.add("2");//bulansara
			test.add("1995");//tahunsara
			test.add("P");//jantina
			test.add("Y");//istimewa
			int tmkhidmat_hari = Integer.parseInt(test.get(3));//tarikh hari start khidmat
			int tmkhidmat_bulan = Integer.parseInt(test.get(4));//bulan start khidmat
			int tmkhidmat_tahun = Integer.parseInt(test.get(5));//tahun start khidmat
			String mkstr = montharray[tmkhidmat_bulan - 1] + " " + tmkhidmat_hari + ", " + tmkhidmat_tahun;
			Date mkstr1 = null;
			try {
				mkstr1 = new SimpleDateFormat("MMMM d, yyyy", Locale.ENGLISH).parse(mkstr);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			String sDate1 = "Apr 12, 1991";//patutnya Apr 1, 1991
			Date tarapril = null;
			try {
				tarapril = new SimpleDateFormat("MMMM d, yyyy", Locale.ENGLISH).parse(sDate1);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			int umurbayarpencen = 0;
			if (mkstr1.before(tarapril) && ((test.get(15).equals("L") && test.get(16).equals("Y")) || test.get(15).equals("P"))) {
				umurbayarpencen = 45;
			} else {
				if (mkstr1.before(tarapril)) {
					umurbayarpencen = 50;
				} else {
				}
				umurbayarpencen = 55;
			}
		assertEquals(umurbayarpencen,45);
		}
		@Test
		void testcase28() { //TC35 = start kerja= 10/9/1987 & Gender = 'L' & istimewa = 'N'
			String[] montharray = new String[] { "Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct",
					"Nov", "Dec" };
			ArrayList<String> test = new ArrayList<>();
			test.add("1");
			test.add("1");
			test.add("1970");//tahunlahir
			test.add("10");
			test.add("9");
			test.add("1987");//tahunkerja
			test.add("3300");//gaji
			test.add("150");//allowance
			test.add("120");//gajicuti
			test.add("0");//cutihari
			test.add("0");//cutibulan
			test.add("0");//cutitahun
			test.add("1");//harisara
			test.add("2");//bulansara
			test.add("1995");//tahunsara
			test.add("L");//jantina
			test.add("N");//istimewa
			int tmkhidmat_hari = Integer.parseInt(test.get(3));//tarikh hari start khidmat
			int tmkhidmat_bulan = Integer.parseInt(test.get(4));//bulan start khidmat
			int tmkhidmat_tahun = Integer.parseInt(test.get(5));//tahun start khidmat
			String mkstr = montharray[tmkhidmat_bulan - 1] + " " + tmkhidmat_hari + ", " + tmkhidmat_tahun;
			Date mkstr1 = null;
			try {
				mkstr1 = new SimpleDateFormat("MMMM d, yyyy", Locale.ENGLISH).parse(mkstr);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			String sDate1 = "Apr 12, 1991";//patutnya Apr 1, 1991
			Date tarapril = null;
			try {
				tarapril = new SimpleDateFormat("MMMM d, yyyy", Locale.ENGLISH).parse(sDate1);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			int umurbayarpencen = 0;
			if (mkstr1.before(tarapril) && ((test.get(15).equals("L") && test.get(16).equals("Y")) || test.get(15).equals("P"))) {
				umurbayarpencen = 45;
			} else {
				if (mkstr1.before(tarapril)) {
					umurbayarpencen = 50;
				} else {
				}
				umurbayarpencen = 55;
			}
		assertEquals(umurbayarpencen,50);
		}
		@Test
		void testcase29() { //TC36 = start kerja= 10/9/1987 & Gender = 'P' & istimewa = 'N'
			String[] montharray = new String[] { "Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct",
					"Nov", "Dec" };
			ArrayList<String> test = new ArrayList<>();
			test.add("1");
			test.add("1");
			test.add("1970");//tahunlahir
			test.add("10");
			test.add("9");
			test.add("1987");//tahunkerja
			test.add("3300");//gaji
			test.add("150");//allowance
			test.add("120");//gajicuti
			test.add("0");//cutihari
			test.add("0");//cutibulan
			test.add("0");//cutitahun
			test.add("1");//harisara
			test.add("2");//bulansara
			test.add("1995");//tahunsara
			test.add("P");//jantina
			test.add("N");//istimewa
			int tmkhidmat_hari = Integer.parseInt(test.get(3));//tarikh hari start khidmat
			int tmkhidmat_bulan = Integer.parseInt(test.get(4));//bulan start khidmat
			int tmkhidmat_tahun = Integer.parseInt(test.get(5));//tahun start khidmat
			String mkstr = montharray[tmkhidmat_bulan - 1] + " " + tmkhidmat_hari + ", " + tmkhidmat_tahun;
			Date mkstr1 = null;
			try {
				mkstr1 = new SimpleDateFormat("MMMM d, yyyy", Locale.ENGLISH).parse(mkstr);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			String sDate1 = "Apr 12, 1991";//patutnya Apr 1, 1991
			Date tarapril = null;
			try {
				tarapril = new SimpleDateFormat("MMMM d, yyyy", Locale.ENGLISH).parse(sDate1);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			int umurbayarpencen = 0;
			if (mkstr1.before(tarapril) && ((test.get(15).equals("L") && test.get(16).equals("Y")) || test.get(15).equals("P"))) {
				umurbayarpencen = 45;
			} else {
				if (mkstr1.before(tarapril)) {
					umurbayarpencen = 50;
				} else {
				}
				umurbayarpencen = 55;
			}
		assertEquals(umurbayarpencen,45);
		}
		@Test
		void testcase30() { //TC37 = start kerja= 10/9/2001 & Gender = 'P' & istimewa = 'Y'
			String[] montharray = new String[] { "Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct",
					"Nov", "Dec" };
			ArrayList<String> test = new ArrayList<>();
			test.add("1");
			test.add("1");
			test.add("1970");//tahunlahir
			test.add("10");
			test.add("9");
			test.add("2001");//tahunkerja
			test.add("3300");//gaji
			test.add("150");//allowance
			test.add("120");//gajicuti
			test.add("0");//cutihari
			test.add("0");//cutibulan
			test.add("0");//cutitahun
			test.add("1");//harisara
			test.add("2");//bulansara
			test.add("1995");//tahunsara
			test.add("P");//jantina
			test.add("Y");//istimewa
			int tmkhidmat_hari = Integer.parseInt(test.get(3));//tarikh hari start khidmat
			int tmkhidmat_bulan = Integer.parseInt(test.get(4));//bulan start khidmat
			int tmkhidmat_tahun = Integer.parseInt(test.get(5));//tahun start khidmat
			String mkstr = montharray[tmkhidmat_bulan - 1] + " " + tmkhidmat_hari + ", " + tmkhidmat_tahun;
			Date mkstr1 = null;
			try {
				mkstr1 = new SimpleDateFormat("MMMM d, yyyy", Locale.ENGLISH).parse(mkstr);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			String sDate1 = "Apr 12, 1991";//patutnya Apr 1, 1991
			Date tarapril = null;
			try {
				tarapril = new SimpleDateFormat("MMMM d, yyyy", Locale.ENGLISH).parse(sDate1);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			int umurbayarpencen = 0;
			if (mkstr1.before(tarapril) && ((test.get(15).equals("L") && test.get(16).equals("Y")) || test.get(15).equals("P"))) {
				umurbayarpencen = 45;
			} else {
				if (mkstr1.before(tarapril)) {
					umurbayarpencen = 50;
				} else {
				}
				umurbayarpencen = 55;
			}
		assertEquals(umurbayarpencen,55);
		}
		@Test
		void testcase31() { //TC38 = start kerja= 10/9/2001 & Gender = 'L' & istimewa = 'Y'
			String[] montharray = new String[] { "Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct",
					"Nov", "Dec" };
			ArrayList<String> test = new ArrayList<>();
			test.add("1");
			test.add("1");
			test.add("1970");//tahunlahir
			test.add("10");
			test.add("9");
			test.add("2001");//tahunkerja
			test.add("3300");//gaji
			test.add("150");//allowance
			test.add("120");//gajicuti
			test.add("0");//cutihari
			test.add("0");//cutibulan
			test.add("0");//cutitahun
			test.add("1");//harisara
			test.add("2");//bulansara
			test.add("1995");//tahunsara
			test.add("L");//jantina
			test.add("Y");//istimewa
			int tmkhidmat_hari = Integer.parseInt(test.get(3));//tarikh hari start khidmat
			int tmkhidmat_bulan = Integer.parseInt(test.get(4));//bulan start khidmat
			int tmkhidmat_tahun = Integer.parseInt(test.get(5));//tahun start khidmat
			String mkstr = montharray[tmkhidmat_bulan - 1] + " " + tmkhidmat_hari + ", " + tmkhidmat_tahun;
			Date mkstr1 = null;
			try {
				mkstr1 = new SimpleDateFormat("MMMM d, yyyy", Locale.ENGLISH).parse(mkstr);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			String sDate1 = "Apr 12, 1991";//patutnya Apr 1, 1991
			Date tarapril = null;
			try {
				tarapril = new SimpleDateFormat("MMMM d, yyyy", Locale.ENGLISH).parse(sDate1);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			int umurbayarpencen = 0;
			if (mkstr1.before(tarapril) && ((test.get(15).equals("L") && test.get(16).equals("Y")) || test.get(15).equals("P"))) {
				umurbayarpencen = 45;
			} else {
				if (mkstr1.before(tarapril)) {
					umurbayarpencen = 50;
				} else {
				}
				umurbayarpencen = 55;
			}
		assertEquals(umurbayarpencen,55);
		}
		@Test
		void testcase32() { //TC39 = start kerja= 10/9/2001 & Gender = 'P' & istimewa = 'N'
			String[] montharray = new String[] { "Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct",
					"Nov", "Dec" };
			ArrayList<String> test = new ArrayList<>();
			test.add("1");
			test.add("1");
			test.add("1970");//tahunlahir
			test.add("10");
			test.add("9");
			test.add("2001");//tahunkerja
			test.add("3300");//gaji
			test.add("150");//allowance
			test.add("120");//gajicuti
			test.add("0");//cutihari
			test.add("0");//cutibulan
			test.add("0");//cutitahun
			test.add("1");//harisara
			test.add("2");//bulansara
			test.add("1995");//tahunsara
			test.add("P");//jantina
			test.add("N");//istimewa
			int tmkhidmat_hari = Integer.parseInt(test.get(3));//tarikh hari start khidmat
			int tmkhidmat_bulan = Integer.parseInt(test.get(4));//bulan start khidmat
			int tmkhidmat_tahun = Integer.parseInt(test.get(5));//tahun start khidmat
			String mkstr = montharray[tmkhidmat_bulan - 1] + " " + tmkhidmat_hari + ", " + tmkhidmat_tahun;
			Date mkstr1 = null;
			try {
				mkstr1 = new SimpleDateFormat("MMMM d, yyyy", Locale.ENGLISH).parse(mkstr);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			String sDate1 = "Apr 12, 1991";//patutnya Apr 1, 1991
			Date tarapril = null;
			try {
				tarapril = new SimpleDateFormat("MMMM d, yyyy", Locale.ENGLISH).parse(sDate1);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			int umurbayarpencen = 0;
			if (mkstr1.before(tarapril) && ((test.get(15).equals("L") && test.get(16).equals("Y")) || test.get(15).equals("P"))) {
				umurbayarpencen = 45;
			} else {
				if (mkstr1.before(tarapril)) {
					umurbayarpencen = 50;
				} else {
				}
				umurbayarpencen = 55;
			}
		assertEquals(umurbayarpencen,55);
		}
		@Test
		void testcase33() { //TC40 = start kerja= 10/9/2001 & Gender = 'L' & istimewa = 'N'
			String[] montharray = new String[] { "Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct",
					"Nov", "Dec" };
			ArrayList<String> test = new ArrayList<>();
			test.add("1");
			test.add("1");
			test.add("1970");//tahunlahir
			test.add("10");
			test.add("9");
			test.add("2001");//tahunkerja
			test.add("3300");//gaji
			test.add("150");//allowance
			test.add("120");//gajicuti
			test.add("0");//cutihari
			test.add("0");//cutibulan
			test.add("0");//cutitahun
			test.add("1");//harisara
			test.add("2");//bulansara
			test.add("1995");//tahunsara
			test.add("L");//jantina
			test.add("N");//istimewa
			int tmkhidmat_hari = Integer.parseInt(test.get(3));//tarikh hari start khidmat
			int tmkhidmat_bulan = Integer.parseInt(test.get(4));//bulan start khidmat
			int tmkhidmat_tahun = Integer.parseInt(test.get(5));//tahun start khidmat
			String mkstr = montharray[tmkhidmat_bulan - 1] + " " + tmkhidmat_hari + ", " + tmkhidmat_tahun;
			Date mkstr1 = null;
			try {
				mkstr1 = new SimpleDateFormat("MMMM d, yyyy", Locale.ENGLISH).parse(mkstr);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			String sDate1 = "Apr 12, 1991";//patutnya Apr 1, 1991
			Date tarapril = null;
			try {
				tarapril = new SimpleDateFormat("MMMM d, yyyy", Locale.ENGLISH).parse(sDate1);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			int umurbayarpencen = 0;
			if (mkstr1.before(tarapril) && ((test.get(15).equals("L") && test.get(16).equals("Y")) || test.get(15).equals("P"))) {
				umurbayarpencen = 45;
			} else {
				if (mkstr1.before(tarapril)) {
					umurbayarpencen = 50;
				} else {
				}
				umurbayarpencen = 55;
			}
		assertEquals(umurbayarpencen,55);
		}
		@Test
		void testcase34() { //TC41 Retirementdate = 12/2/2010 StartKerja = 21/8/2000 -113
			ArrayList<String> test = new ArrayList<>();
			test.add("1");
			test.add("1");
			test.add("1970");//tahunlahir
			test.add("21");//harikerja
			test.add("8");//bulankerja
			test.add("2000");//tahunkerja
			test.add("3300");//gaji
			test.add("150");//allowance
			test.add("120");//gajicuti
			test.add("0");//cutihari
			test.add("0");//cutibulan
			test.add("0");//cutitahun
			test.add("12");//harisara
			test.add("2");//bulansara
			test.add("2010");//tahunsara
			test.add("L");//jantina
			test.add("N");//istimewa
			// ************* calculate month working
					int minusbulan = 0;
					int minustahun = 0;
					int plusbulan = 0;
					int bulan_cuti_tg = (Integer.parseInt(test.get(11)) * 12) + Integer.parseInt(test.get(10));

					if (Integer.parseInt(test.get(12)) < Integer.parseInt(test.get(3)))
						minusbulan = 1;
					if ((Integer.parseInt(test.get(13)) - minusbulan) < Integer.parseInt(test.get(4))) {
						minustahun = 1;
						plusbulan = 12;
					}

					int tbk = Integer.parseInt(test.get(13)) - minusbulan + plusbulan - Integer.parseInt(test.get(4));
					int ttk = Integer.parseInt(test.get(14)) - minustahun - Integer.parseInt(test.get(5));

					int bulankira = ((ttk * 12) + tbk) - bulan_cuti_tg;
					assertEquals(bulankira,113);
		}
		@Test
		void testcase35() { //TC42 Retirementdate = 21/2/2010 StartKerja = 12/8/2000 -114
			ArrayList<String> test = new ArrayList<>();
			test.add("1");
			test.add("1");
			test.add("1970");//tahunlahir
			test.add("12");//harikerja
			test.add("8");//bulankerja
			test.add("2000");//tahunkerja
			test.add("3300");//gaji
			test.add("150");//allowance
			test.add("120");//gajicuti
			test.add("0");//cutihari
			test.add("0");//cutibulan
			test.add("0");//cutitahun
			test.add("21");//harisara
			test.add("2");//bulansara
			test.add("2010");//tahunsara
			test.add("L");//jantina
			test.add("N");//istimewa
			// ************* calculate month working
					int minusbulan = 0;
					int minustahun = 0;
					int plusbulan = 0;
					int bulan_cuti_tg = (Integer.parseInt(test.get(11)) * 12) + Integer.parseInt(test.get(10));

					if (Integer.parseInt(test.get(12)) < Integer.parseInt(test.get(3)))
						minusbulan = 1;
					if ((Integer.parseInt(test.get(13)) - minusbulan) < Integer.parseInt(test.get(4))) {
						minustahun = 1;
						plusbulan = 12;
					}

					int tbk = Integer.parseInt(test.get(13)) - minusbulan + plusbulan - Integer.parseInt(test.get(4));
					int ttk = Integer.parseInt(test.get(14)) - minustahun - Integer.parseInt(test.get(5));

					int bulankira = ((ttk * 12) + tbk) - bulan_cuti_tg;
					assertEquals(bulankira,114);
		}
		@Test
		void testcase36() { //TC43 Retirementdate = 12/8/2010 StartKerja = 21/2/2000 -125
			ArrayList<String> test = new ArrayList<>();
			test.add("1");
			test.add("1");
			test.add("1970");//tahunlahir
			test.add("21");//harikerja
			test.add("2");//bulankerja
			test.add("2000");//tahunkerja
			test.add("3300");//gaji
			test.add("150");//allowance
			test.add("120");//gajicuti
			test.add("0");//cutihari
			test.add("0");//cutibulan
			test.add("0");//cutitahun
			test.add("12");//harisara
			test.add("8");//bulansara
			test.add("2010");//tahunsara
			test.add("L");//jantina
			test.add("N");//istimewa
			// ************* calculate month working
					int minusbulan = 0;
					int minustahun = 0;
					int plusbulan = 0;
					int bulan_cuti_tg = (Integer.parseInt(test.get(11)) * 12) + Integer.parseInt(test.get(10));

					if (Integer.parseInt(test.get(12)) < Integer.parseInt(test.get(3)))
						minusbulan = 1;
					if ((Integer.parseInt(test.get(13)) - minusbulan) < Integer.parseInt(test.get(4))) {
						minustahun = 1;
						plusbulan = 12;
					}

					int tbk = Integer.parseInt(test.get(13)) - minusbulan + plusbulan - Integer.parseInt(test.get(4));
					int ttk = Integer.parseInt(test.get(14)) - minustahun - Integer.parseInt(test.get(5));

					int bulankira = ((ttk * 12) + tbk) - bulan_cuti_tg;
					assertEquals(bulankira,125);
		}
		@Test
		void testcase37() { //TC44 Retirementdate = 21/8/2010 StartKerja = 12/2/2000 -126
			ArrayList<String> test = new ArrayList<>();
			test.add("1");
			test.add("1");
			test.add("1970");//tahunlahir
			test.add("12");//harikerja
			test.add("2");//bulankerja
			test.add("2000");//tahunkerja
			test.add("3300");//gaji
			test.add("150");//allowance
			test.add("120");//gajicuti
			test.add("0");//cutihari
			test.add("0");//cutibulan
			test.add("0");//cutitahun
			test.add("21");//harisara
			test.add("8");//bulansara
			test.add("2010");//tahunsara
			test.add("L");//jantina
			test.add("N");//istimewa
			// ************* calculate month working
					int minusbulan = 0;
					int minustahun = 0;
					int plusbulan = 0;
					int bulan_cuti_tg = (Integer.parseInt(test.get(11)) * 12) + Integer.parseInt(test.get(10));

					if (Integer.parseInt(test.get(12)) < Integer.parseInt(test.get(3)))
						minusbulan = 1;
					if ((Integer.parseInt(test.get(13)) - minusbulan) < Integer.parseInt(test.get(4))) {
						minustahun = 1;
						plusbulan = 12;
					}

					int tbk = Integer.parseInt(test.get(13)) - minusbulan + plusbulan - Integer.parseInt(test.get(4));
					int ttk = Integer.parseInt(test.get(14)) - minustahun - Integer.parseInt(test.get(5));

					int bulankira = ((ttk * 12) + tbk) - bulan_cuti_tg;
					assertEquals(bulankira,126);
		}
		@Test
		void testcase38() { //TC45: retirement age =30 & bulankira ='DONT CARE'
			PensionServiceIMP pc = new PensionServiceIMP();
			ArrayList<String> test = new ArrayList<>();
			test.add("1");
			test.add("12");
			test.add("1980");//tahunlahir
			test.add("1");
			test.add("7");
			test.add("2000");//tahunkerja
			test.add("3300");//gaji
			test.add("150");//allowance
			test.add("120");//gajicuti
			test.add("0");//cutihari
			test.add("0");//cutibulan
			test.add("0");//cutitahun
			test.add("1");//harisara
			test.add("12");//bulansara
			test.add("2010");//tahunsara
			test.add("P");//jantina
			test.add("N");//istimewa
			ArrayList<String> output = pc.kirapencen(test);
			String tiadaganjaran = output.get(2);
			assertEquals(tiadaganjaran,"1");
		}
		@Test
		void testcase39() { //TC46: retirement age =49 & bulankira =100
			PensionServiceIMP pc = new PensionServiceIMP();
			ArrayList<String> test = new ArrayList<>();
			test.add("1");
			test.add("5");
			test.add("1959");//tahunlahir
			test.add("1");
			test.add("1");
			test.add("2000");//tahunkerja
			test.add("3300");//gaji
			test.add("150");//allowance
			test.add("120");//gajicuti
			test.add("0");//cutihari
			test.add("0");//cutibulan
			test.add("0");//cutitahun
			test.add("1");//harisara
			test.add("5");//bulansara
			test.add("2008");//tahunsara
			test.add("P");//jantina
			test.add("N");//istimewa
			ArrayList<String> output = pc.kirapencen(test);
			String tiadaganjaran = output.get(2);
			assertEquals(tiadaganjaran,"2");
		}
		@Test
		void testcase40() { //TC47: retirement age =50 & bulankira =121
			PensionServiceIMP pc = new PensionServiceIMP();
			ArrayList<String> test = new ArrayList<>();
			test.add("1");
			test.add("2");
			test.add("1960");//tahunlahir
			test.add("1");
			test.add("1");
			test.add("2000");//tahunkerja
			test.add("3300");//gaji
			test.add("150");//allowance
			test.add("120");//gajicuti
			test.add("0");//cutihari
			test.add("0");//cutibulan
			test.add("0");//cutitahun
			test.add("1");//harisara
			test.add("2");//bulansara
			test.add("2010");//tahunsara
			test.add("P");//jantina
			test.add("N");//istimewa
			ArrayList<String> output = pc.kirapencen(test);
			String tiadaganjaran = output.get(2);
			assertEquals(tiadaganjaran,"0");
		}
		@Test
		void testcase41() { //TC48: retirement age =30 & bulankira =110
			PensionServiceIMP pc = new PensionServiceIMP();
			ArrayList<String> test = new ArrayList<>();
			test.add("1");
			test.add("3");
			test.add("1979");//tahunlahir
			test.add("1");
			test.add("1");
			test.add("2000");//tahunkerja
			test.add("3300");//gaji
			test.add("150");//allowance
			test.add("120");//gajicuti
			test.add("0");//cutihari
			test.add("0");//cutibulan
			test.add("0");//cutitahun
			test.add("1");//harisara
			test.add("3");//bulansara
			test.add("2009");//tahunsara
			test.add("P");//jantina
			test.add("N");//istimewa
			ArrayList<String> output = pc.kirapencen(test);
			String tiadaganjaran = output.get(2);
			assertEquals(tiadaganjaran,"1");
		}
		@Test
		void testcase42() { //TC49: retirement age =30 & bulankira =125
			PensionServiceIMP pc = new PensionServiceIMP();
			ArrayList<String> test = new ArrayList<>();
			test.add("1");
			test.add("6");
			test.add("1980");//tahunlahir
			test.add("1");
			test.add("1");
			test.add("2000");//tahunkerja
			test.add("3300");//gaji
			test.add("150");//allowance
			test.add("120");//gajicuti
			test.add("0");//cutihari
			test.add("0");//cutibulan
			test.add("0");//cutitahun
			test.add("1");//harisara
			test.add("6");//bulansara
			test.add("2010");//tahunsara
			test.add("P");//jantina
			test.add("N");//istimewa
			ArrayList<String> output = pc.kirapencen(test);
			String tiadaganjaran = output.get(2);
			assertEquals(tiadaganjaran,"1");
		}
		@Test
		void testcase43() { // TC50 = reckonabe POS = 361, Pension-1980
			PensionServiceIMP pc = new PensionServiceIMP();
			ArrayList<String> test = new ArrayList<>();
			test.add("1");
			test.add("12");
			test.add("1975");//tahunlahir
			test.add("1");
			test.add("7");
			test.add("2000");//tahunkerja
			test.add("3300");//gaji
			test.add("150");//allowance
			test.add("120");//gajicuti
			test.add("0");//cutihari
			test.add("0");//cutibulan
			test.add("0");//cutitahun
			test.add("1");//harisara
			test.add("8");//bulansara
			test.add("2030");//tahunsara
			test.add("P");//jantina
			test.add("N");//istimewa
			ArrayList<String> output = pc.kirapencen(test);
			double PencenMinima;
			double bulankira = Integer.parseInt(output.get(3));
			if (bulankira > 360)
				bulankira = 360;
			
			double jumpenc = (1.00 / 600.00) * bulankira * Double.parseDouble(test.get(6));
			PencenMinima = jumpenc;

			if (PencenMinima < 720)
				PencenMinima = 720;
			if (bulankira < 300)
				PencenMinima = jumpenc;
			assertEquals(Math.round(PencenMinima),1980);
		}
		@Test
		void testcase44() { //TC51 = reckonabe POS = 121, Pension-665.5
			PensionServiceIMP pc = new PensionServiceIMP();
			ArrayList<String> test = new ArrayList<>();
			test.add("1");
			test.add("12");
			test.add("1965");//tahunlahir
			test.add("1");
			test.add("7");
			test.add("2000");//tahunkerja
			test.add("3300");//gaji
			test.add("150");//allowance
			test.add("120");//gajicuti
			test.add("0");//cutihari
			test.add("0");//cutibulan
			test.add("0");//cutitahun
			test.add("1");//harisara
			test.add("8");//bulansara
			test.add("2010");//tahunsara
			test.add("P");//jantina
			test.add("N");//istimewa
			ArrayList<String> output = pc.kirapencen(test);
			double PencenMinima;
			double bulankira = Integer.parseInt(output.get(3));
			if (bulankira > 360)
				bulankira = 360;
			
			double jumpenc = (1.00 / 600.00) * bulankira * Double.parseDouble(test.get(6));
			PencenMinima = jumpenc;

			if (PencenMinima < 720)
				PencenMinima = 720;
			if (bulankira < 300)
				PencenMinima = jumpenc;
			assertEquals(Math.round(PencenMinima),665.5);
		}
		@Test
		void testcase45() { //TC52 = reckonabe POS = 160, Cash Award-17250
			PensionServiceIMP pc = new PensionServiceIMP();
			ArrayList<String> test = new ArrayList<>();
			test.add("1");
			test.add("12");
			test.add("1965");//tahunlahir
			test.add("1");
			test.add("7");
			test.add("2000");//tahunkerja
			test.add("3300");//gaji
			test.add("150");//allowance
			test.add("160");//gajicuti
			test.add("0");//cutihari
			test.add("0");//cutibulan
			test.add("0");//cutitahun
			test.add("1");//harisara
			test.add("8");//bulansara
			test.add("2010");//tahunsara
			test.add("P");//jantina
			test.add("N");//istimewa
			ArrayList<String> output = pc.kirapencen(test);
			Double jumganjarancr = Double.parseDouble(output.get(6));
			assertEquals(jumganjarancr,17250);
		}
		@Test
		void testcase46() { //TC53 = reckonabe POS = 100, Cash Award-11500
			PensionServiceIMP pc = new PensionServiceIMP();
			ArrayList<String> test = new ArrayList<>();
			test.add("1");
			test.add("12");
			test.add("1965");//tahunlahir
			test.add("1");
			test.add("7");
			test.add("2000");//tahunkerja
			test.add("3300");//gaji
			test.add("150");//allowance
			test.add("100");//gajicuti
			test.add("0");//cutihari
			test.add("0");//cutibulan
			test.add("0");//cutitahun
			test.add("1");//harisara
			test.add("8");//bulansara
			test.add("2010");//tahunsara
			test.add("P");//jantina
			test.add("N");//istimewa
			ArrayList<String> output = pc.kirapencen(test);
			Double jumganjarancr = Double.parseDouble(output.get(6));
			assertEquals(jumganjarancr,11500);
		}
		@Test
		void testcase47() { //TC54 = Birthdate = 0 Jan 1970, Pension Year-2024
			PensionServiceIMP pc = new PensionServiceIMP();
			ArrayList<String> test = new ArrayList<>();
			test.add("0");
			test.add("1");
			test.add("1970");//tahunlahir
			test.add("1");
			test.add("7");
			test.add("2000");//tahunkerja
			test.add("3300");//gaji
			test.add("150");//allowance
			test.add("120");//gajicuti
			test.add("0");//cutihari
			test.add("0");//cutibulan
			test.add("0");//cutitahun
			test.add("1");//harisara
			test.add("8");//bulansara
			test.add("2010");//tahunsara
			test.add("P");//jantina
			test.add("N");//istimewa
			ArrayList<String> output = pc.kirapencen(test);
			String pensionYear = (output.get(7));
			assertEquals(pensionYear.substring(5, 9),"2024");
		}
		@Test
		void testcase48() { //TC55 = Birthdate = 20 Dec 1970, Pension Year-2025
			PensionServiceIMP pc = new PensionServiceIMP();
			ArrayList<String> test = new ArrayList<>();
			test.add("20");
			test.add("12");
			test.add("1970");//tahunlahir
			test.add("1");
			test.add("7");
			test.add("2000");//tahunkerja
			test.add("3000");//gaji
			test.add("110");//allowance
			test.add("100");//gajicuti
			test.add("0");//cutihari
			test.add("0");//cutibulan
			test.add("0");//cutitahun
			test.add("1");//harisara
			test.add("8");//bulansara
			test.add("2010");//tahunsara
			test.add("P");//jantina
			test.add("N");//istimewa
			ArrayList<String> output = pc.kirapencen(test);
			String pensionYear = (output.get(7));
			assertEquals(pensionYear.substring(5, 9),"2025");
		}
}
