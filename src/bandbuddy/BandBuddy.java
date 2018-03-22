/**
 * 
 */
package bandbuddy;

/**
 * BandBuddy-luokka
 * @author Markus M�ntymaa & Lauri Makkonen
 * @version 13.03.2018
 */
public class BandBuddy {
    private Henkilot henkilot = new Henkilot();
    
    
    /**
     * Parametriton konstruktori BandBuddylle
     */
    public BandBuddy() {
    }
    
    
    /**
     * Lis�� henkil�n taulukkoon
     * @param henkilo   Lis�tt�v� henkil�
     */
    public void lisaa(Henkilo henkilo) {
        henkilot.lisaa(henkilo);
    }
    
    
    /**
     * Tulostaa koko taulukon
     */
    public void tulosta() {
        henkilot.tulosta();
    }
    
    
    /**
     * @param args ei k�yt�ss�
     */
    public static void main(String[] args) {
        BandBuddy bandbuddy = new BandBuddy();
        Henkilo testiHenkilo1 = new Henkilo();
        Henkilo testiHenkilo2 = new Henkilo();
        testiHenkilo1.rekisteroi();
        testiHenkilo1.taytaValiaikaisetTiedot();
        testiHenkilo2.rekisteroi();
        testiHenkilo2.taytaValiaikaisetTiedot();
        bandbuddy.lisaa(testiHenkilo1);
        bandbuddy.lisaa(testiHenkilo2);
        bandbuddy.tulosta();
    }
}