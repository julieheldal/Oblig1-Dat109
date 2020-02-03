/**
 * 
 */
package no.hvl.dat109.stigespill;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Julie Marie Heldal
 * 
 * En klasse som representerer et brett
 *
 */
public class Brett {
	private List<Rute> ruter;
	
	
	/*
	 * Oppretter et nytt brett-objekt
	 */

	public Brett() {
		ruter = new ArrayList<Rute>();
		addRuter();
		
	}
	/**
	 * metode for å legge til 100 ruter med stiger og slanger
	 */
	
	public void addRuter() {

		
		ruter = new ArrayList<Rute>();
		for (int i = 1; i <= 100; i++) {
			ruter.add(new Rute(i));
		
		}
		
				// Slanger
				ruter.get(98).getSlange().setLengde(21);
				ruter.get(94).getSlange().setLengde(20);
				ruter.get(92).getSlange().setLengde(20);
				ruter.get(86).getSlange().setLengde(63);
				ruter.get(63).getSlange().setLengde(4);
				ruter.get(61).getSlange().setLengde(43);
				ruter.get(53).getSlange().setLengde(20);
				ruter.get(16).getSlange().setLengde(10);

				// Stiger
				ruter.get(3).getStige().setLengde(10);
				ruter.get(8).getStige().setLengde(22);
				ruter.get(19).getStige().setLengde(18);
				ruter.get(27).getStige().setLengde(57);
				ruter.get(39).getStige().setLengde(19);
				ruter.get(50).getStige().setLengde(16);
				ruter.get(62).getStige().setLengde(18);
				ruter.get(70).getStige().setLengde(20);
	}
	
	/**
	 * Velger den nye ruten som brikken skal flyttes til 
	 * 
	 * @param rute (nåværende rute)
	 * @param verdi (terningkast verdi og antall ruter brikken skal flyttes)
	 * @return returnerer den nye ruten som brikken skal flyttes til.
	 */
	public Rute finnRute(Rute rute, Integer verdi) {
		//Rute nyRute = ruter.get(rute.getRuteNr() + verdi -1);
	
		int v = rute.getRuteNr() + verdi -1; 
		Rute nyRute = ruter.get(v);
		if(nyRute.getSlange().getLengde() > 0 ) {
			nyRute = ruter.get(v-ruter.get(v).getSlange().getLengde());
			System.out.println("DU LANDET PÅ EN SLANGE!!!!");
			
		} else if(nyRute.getStige().getLengde() > 0 ) {
			nyRute = ruter.get(v+ruter.get(v).getStige().getLengde());
			System.out.println("DU LANDET PÅ EN STIGE!!!!");
		}
		
		return nyRute; 
	}
	
	public List<Rute> getRuter(){
		return ruter;
	}
	
	

}
