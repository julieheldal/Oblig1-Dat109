/**
 * 
 */
package no.hvl.dat109.stigespill;

import java.util.Random;

/**
 * 
 * @author Julie Marie Heldal
 *
 */
public class Terning {
	
	private Integer verdi;
	
	
	/**
	 * Oppretter et nytt terning objekt
	 */
	
	public Terning() {
		this.verdi=0;
	}

	
	/**
	 * metode som triller terning og gir den ny verdi
	 */
	public void trill() {
		Random tall = new Random();
		verdi = 1 + tall.nextInt(6);
		
	}
	/**
	 * 
	 * @return returnerer verdien til terningen
	 */
	
	public Integer getVerdi() {
		return this.verdi;
	}
}
