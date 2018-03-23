package bandbuddy.fxml;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import bandbuddy.Henkilo;
import bandbuddy.HenkiloJaInstrumentti;
import bandbuddy.HenkilotJaInstrumentit;
import bandbuddy.Instrumentti;
import fi.jyu.mit.fxgui.ModalController;
import fi.jyu.mit.fxgui.ModalControllerInterface;
import fi.jyu.mit.ohj2.Mjonot;


/**
 * @author Markus M�ntymaa & Lauri Makkonen
 * @version 13.03.2018
 */
public class HenkilonLisaysController implements ModalControllerInterface<Henkilo> {
    private Henkilo kasiteltavaHenkilo;
    // private String a;
    // private Instrumentti kasiteltavaInstrumentti;
    @FXML private TextField nimiKentta;
    @FXML private TextField ikaKentta;
    @FXML private TextField sukupuoliKentta;
    @FXML private TextField paikkakuntaKentta;
    @FXML private TextField instrumentitKentta;
    @FXML private TextField genretKentta;
    @FXML private TextField vapaanaKentta;
    @FXML private TextField kokemusKentta;
    @FXML private TextField yhteystiedotKentta;
    @FXML private Button henkilonLisaysLisaaJasen;
    @FXML private Button henkilonLisaysPeruuta;
    
    
    @FXML
    void henkilonLisaysLisaaJasenPainettu(ActionEvent event) {
        lisaaHenkilo();
        ModalController.closeStage(henkilonLisaysLisaaJasen);
    }
    
    @FXML
    void henkilonLisaysPeruutaPainettu(ActionEvent event) {
        ModalController.closeStage(henkilonLisaysPeruuta);
    }
    
    /**
     * Asettaa henkil�n tiedot tekstikenttien mukaan ja rekister�i henkil�n
     */
    public void lisaaHenkilo() {
        kasiteltavaHenkilo.rekisteroi();
        
        kasiteltavaHenkilo.setNimi(nimiKentta.getText());
        kasiteltavaHenkilo.setIka(Mjonot.erotaInt(ikaKentta.getText(), 0));
        kasiteltavaHenkilo.setSukupuoli(sukupuoliKentta.getText());
        kasiteltavaHenkilo.setPaikkakunta(paikkakuntaKentta.getText());
        Instrumentti uusi = new Instrumentti(instrumentitKentta.getText());
        // String a = instrumentitKentta.getText();
        BandBuddyController.getInstrumentti(instrumentitKentta.getText());
        uusi.rekisteroi();
        uusi.tulosta(System.out);
        // kasiteltavaInstrumentti.rekisteroi();
        // kasiteltavaInstrumentti.tulosta(System.out);
        // HenkiloJaInstrumentti u= new HenkiloJaInstrumentti(kasiteltavaHenkilo.getId(),uusi.getTunnusNro());
        // lisaa(u);
        // kasiteltavaHenkilo.setGenret(genretKentta.getText());
        kasiteltavaHenkilo.setVapaana(vapaanaKentta.getText());
        kasiteltavaHenkilo.setKokemus(kokemusKentta.getText());
        kasiteltavaHenkilo.setYhteystiedot(yhteystiedotKentta.getText());
    }

 //   public String getA() {
     //   return a;
 //   }
    
    @Override
    public Henkilo getResult() {
        return null;
    }


    @Override
    public void handleShown() {
        //
    }

    @Override
    public void setDefault(Henkilo uusi) {
        kasiteltavaHenkilo = uusi;
        // kasiteltavaInstrumentti = uusiInstrumentti;
    }
    
    
    public void setDefault(Instrumentti uusi) {
     //   kasiteltavaInstrumentti = uusi;
        // kasiteltavaInstrumentti = uusiInstrumentti;
    }
    
    
    /**
     * @param modalityStage x
     * @param uusi x
     * @param uusiInstrumentti x
     * @return x
     */
    public static Henkilo avaaLisaaHenkilo(Stage modalityStage, Henkilo uusi, Instrumentti uusiInstrumentti) {
        return ModalController.<Henkilo, HenkilonLisaysController>showModal(HenkilonLisaysController.class.getResource("henkilonlisays.fxml"), "Uuden henkil�n tiedot", modalityStage, uusi, null);
    }
    
    
}