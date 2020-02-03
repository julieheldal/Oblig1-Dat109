package no.hvl.dat109.test;


import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import no.hvl.dat109.stigespill.Brett;
import no.hvl.dat109.stigespill.Brikke;
import no.hvl.dat109.stigespill.Farge;
import no.hvl.dat109.stigespill.Rute;
import no.hvl.dat109.stigespill.Spiller;
import no.hvl.dat109.stigespill.Stigespill;
import no.hvl.dat109.stigespill.Terning;

public class StigespillTest {
	
	/**
	 * @author Julie Heldal og Vilde Fossum
	 */
	
	Stigespill stigespill;
	Spiller spiller;
	Brett brett;
	Terning terning;
	Rute start;
	Rute rute;
	Rute stige;
	Rute slange;
	
	Brikke brikke;
	Brikke brikke1;
	Brikke brikke2;
	Brikke brikke3;
	
	@BeforeEach
	void setup() {
		stigespill = new Stigespill();
		spiller = new Spiller("navn", Farge.BLÅ, new Brett());
		brett = new Brett();
		terning = new Terning();
		
		
		brikke =  new Brikke(brett, Farge.BLÅ);
		brikke1 = new Brikke(brett,Farge.GRØNN);
		brikke2 = new Brikke(brett, Farge.GUL);
		brikke3 = new Brikke(brett,Farge.RØD);
		
		start = new Rute(1);
		rute = new Rute(7);
		stige = new Rute(14);
		slange = new Rute(7);
		
		
	}
	/**
	 * Tester metoden ikkeVunnet
	 */
	
	@Test
	void testVunnet() {
		assertTrue(stigespill.ikkeVunnet());
		
	}
		
	/**
	 * tester metoden flytt(), også for stige og slange
	 */
	@Test
	void testFlytt() {
		brikke.flytt(4);
		assertEquals(5, brikke.getRute().getRuteNr());
		brikke1.flytt(8);
		assertEquals(31, brikke1.getRute().getRuteNr());
		brikke2.flytt(16);
		assertEquals(7, brikke2.getRute().getRuteNr());
	}
	/**
	 * Tester om metoden flyttStart() flytter brikken til start
	 */
	@Test
	void testFlyttStart() {
		brikke.flytt(5);
		brikke.flyttStart();
		assertEquals(1, brikke.getRute().getRuteNr());
	}
	/**
	 * Tester om metoden finnRute() gir oss riktig rute.
	 *  Tester også om den lander på stige eller slange.
	 */
	@Test
	void testfinnRute() {
		assertEquals(brett.finnRute(start, 6).getRuteNr(), rute.getRuteNr());
		assertEquals(brett.finnRute(start, 3).getRuteNr(), stige.getRuteNr());
		assertEquals(brett.finnRute(start, 16).getRuteNr(), slange.getRuteNr());
		
	}
	
	


}
