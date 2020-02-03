/**
 * 
 */
package no.hvl.dat109.stigespill;

/**
 * 
 * Klasse som definerer brikke 
 * @author Julie Heldal og Vilde Fossum
 *
 */
public class Brikke {
	private Rute rute;
	private Brett brett;
	private Farge farge; 
	
	/**
	 * 
	 * Oppretter et nytt brikke objekt.
	 * @param farge 
	 * @param brett
	 */

	public Brikke(Brett brett, Farge farge) {
		//this.rute = startRute;
		this.brett = brett;
		this.farge=farge;
		this.rute= brett.getRuter().get(0);
		
	}
	
	
	/**
	 * Flytter brikken et gitt antall steg, dersom man ikke treffer 100 akkurat 
	 * vil man bli stående til man gjør.
	 * 
	 * @param verdi, verdien til antall steg
	 */
	
	public void flytt(Integer verdi) {
		if(rute.getRuteNr() + verdi <= 100) {
		Rute nyRute = brett.finnRute(rute, verdi);
		setRute(nyRute);
		}	
	}
	
/**
 * 
 * @return returnerer ruten som brikken står på
 */
	public Rute getRute() {
		return rute;
	}

	private void setRute(Rute rute) {
	this.rute=rute;
		
	}
	/**
	 * 
	 * @return returnerer fargen til brikken
	 */
	public Farge getFarge() {
		return farge;
	}
	public void setFarge(Farge farge) {
		this.farge=farge;
	}
	
	/*
	 * Flytter brikken tilbake til start
	 */
	public void flyttStart() {
		setRute(brett.getRuter().get(0));
	}
	
	

}
