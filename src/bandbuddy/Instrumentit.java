package bandbuddy;

import java.util.*;
import java.io.*;

/**
 * Instrumentit-luokka
 * Sis�lt�� tietorakenteen josta l�ytyy kaikki yksitt�iset instrumentti-alkiot
 * @author Markus M�ntymaa & Lauri Makkonen
 * @version 19.04.2018
 */
public class Instrumentit implements Iterable<Instrumentti> {
	
	private String                         tiedostonNimi   = "instrumentit.dat";
	private final Collection<Instrumentti> alkiot          = new ArrayList<Instrumentti>();
	
	
    /**
     * Instrumentit-luokan alustaminen ilman parametreja
     */
    public Instrumentit() {
    }
	
    
    /**
     * Hakee instrumentin tunnusnron avulla
     * @param tunnusnro instrumentin tunnusnro
     * @return instrumentin merkkijonona.
     * #import java.util.*;
     * @example
     * <pre name="test">
     * Instrumentit i = new Instrumentit();
     * Instrumentti a = new Instrumentti("Kitara"); 
     * a.rekisteroi(); 
     * i.lisaa(a);
     * Instrumentti b = new Instrumentti("Rummut"); 
     * b.rekisteroi(); 
     * i.lisaa(b);
     * Instrumentti c = new Instrumentti("Basso"); 
     * c.rekisteroi(); 
     * i.lisaa(c);
     * i.getLkm()       === 3;
     * i.soitin(-1)     === "ei toimi";
     * i.soitin(3)      === "Basso";
     * i.soitin(1)      === "Kitara";
     * </pre> 
     */
    public String soitin(int tunnusnro) {
         List<Instrumentti> kaikki = new ArrayList<Instrumentti>();
         for (Instrumentti soitin : this.alkiot) {
        	  kaikki.add(soitin);
         }
         for (int i = 0; i < kaikki.size(); i++) {
              if (tunnusnro == kaikki.get(i).getTunnusNro()) {
                  return kaikki.get(i).getInstrumentti();
              }
         }
         return "ei toimi";
    }
    
    
    /**
     * lis�� instrumentin tietorakenteeseen
     * @param soitin lis�tt�v� instrumentti.
     */
    public void lisaa(Instrumentti soitin) {
    	alkiot.add(soitin);
    }

    
    /**
     * Lukee instrumentit tiedostosta ja lis�� ne tietorakenteeseen
     * Jos tiedoston lukeminen ei onnistu niin ohjelma luo uuden tiedoston jota ohjelma k�ytt�� jatkossa
     * @example
     * <pre name="test">
     * #THROWS IOException
     * #import java.io.IOException;
     * #import fi.jyu.mit.ohj2.VertaaTiedosto;
     * VertaaTiedosto.kirjoitaTiedosto("testi.dat", ";nid|instrumentti|\n1|S�hk�kitara|\n2|S�hk�basso|\n3|Oboe|\n4|Fagotti|\n5|Saksofoni|\n");
     * Instrumentit testiInstrumentitLuokka = new Instrumentit();
     * testiInstrumentitLuokka.setLuettavaTiedosto("testi.dat");
     * testiInstrumentitLuokka.lueTiedostosta();
     * VertaaTiedosto.tuhoaTiedosto("testi.dat");
     * testiInstrumentitLuokka.getLkm() === 5;
     * testiInstrumentitLuokka.soitin(1) === "S�hk�kitara";
     * testiInstrumentitLuokka.soitin(2) === "S�hk�basso";
     * testiInstrumentitLuokka.soitin(3) === "Oboe";
     * testiInstrumentitLuokka.soitin(4) === "Fagotti";
     * testiInstrumentitLuokka.soitin(5) === "Saksofoni";
     * </pre>
     */
    public void lueTiedostosta() {
    	try ( Scanner fi = new Scanner(new FileInputStream(new File(this.tiedostonNimi)), "ISO-8859-1") ) {
            String rivi;
            while (fi.hasNextLine()) {
                rivi = fi.nextLine().trim();
                if ( "".equals(rivi) || rivi.charAt(0) == ';' ) continue;
                Instrumentti in = new Instrumentti();
                in.parse(rivi); 
                lisaa(in);
            }

        } catch ( FileNotFoundException fnfe ) {
            System.err.println("Tiedoston lukeminen ei onnistunut " + fnfe.getMessage());
            try {
                new File("instrumentit.dat").createNewFile();
            } catch (IOException ioe) {
                System.err.println("Tiedoston luominen ei onnistunut " + ioe.getMessage());
            }
        }
    }
        
    
    /**
     * Lukee tietorakenteen alkiot ja luo sen mukaa rivej� tiedostoon
     */
    public void kirjoitaTiedostoon() {
        String kohdetiedostonNimi = this.tiedostonNimi;
        
        try ( PrintStream fo = new PrintStream(new FileOutputStream(kohdetiedostonNimi))) {
            fo.println(";nid|instrumentti|");
            for (Instrumentti in : this.alkiot) {
                fo.println(in.toString());
            }
        } catch (FileNotFoundException fnfe) {
            System.err.println("Tiedostoon kirjoittaminen ei onnistunut! " + fnfe.getMessage());
        }
    }
    

    /**
     * @return instrumentin listan koko
     */
    public int getLkm() {
    	return alkiot.size();
    }
        
    
    /**
     * Iteraattori kaikkien instrumenttejen l�pik�ymiseen.
     * @return instrumentti-iteraattori
     * @example
     * <pre name="test">
     * #PACKAGEIMPORT
     * #import java.util.*;
     * 
     *  Instrumentit soittimet = new Instrumentit();
     *  Instrumentti a = new Instrumentti("Kitara"); soittimet.lisaa(a);
     *  Instrumentti b = new Instrumentti("Basso"); soittimet.lisaa(b);
     *  Instrumentti c = new Instrumentti("Rummut"); soittimet.lisaa(c);
     * 
     *  Iterator<Instrumentti> i2 = soittimet.iterator();
     *  i2.next() === a;
     *  i2.next() === b;
     *  i2.next() === c;
     *  i2.next() === b;  #THROWS NoSuchElementException
     *  
     * </pre>
     */
	@Override
	public Iterator<Instrumentti> iterator() {
		return alkiot.iterator();
	}	
	
	
	/**
	 * Laittaa luettavaksi tiedostoksi annetun merkkijonon
	 * k�ytet��n testeiss�
	 * @param tiedosto     tiedosto jota halutaan lukea
	 */
	public void setLuettavaTiedosto(String tiedosto) {
	    this.tiedostonNimi = tiedosto;
	}	
	
	
	/**
	 * Etsii merkkijonoa vastaavan instrumentin, jos l�ytyy
	 * @param etsittava        etsittava instrumentti
	 * @return                 etsitt�v�n instrumentin, muutoin null
	 */
	public Instrumentti loytyykoInstrumenttia(String etsittava) {
	    for (Instrumentti alkio : this.alkiot) {
	        if (alkio.getInstrumentti().equalsIgnoreCase(etsittava)) return alkio;
	    }
	    return null;
	}
}