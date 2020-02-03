/**
 * 
 */
package no.hvl.dat109.stigespill;

/**
 * Klasse som representerer en rute
 * 
 * @author Julie Marie Heldal og Vilde Kristine Fossum
 *
 */
public class Rute {
	
	private Integer ruteNr;
	private Slanger slange;
	private Stiger stige;
	
	
	public Rute(int i) {
		this.ruteNr=i;
		this.slange= new Slanger();
		this.stige= new Stiger();
	}
	
	public Integer getRuteNr() {
		return this.ruteNr;
	}


	public void setRuteNr(int ruteNr) {
		this.ruteNr = ruteNr;
	}
	
	public Slanger getSlange() {
		return this.slange;
	}
	
	public Stiger getStige() {
		return this.stige;
	}

	
	

}
