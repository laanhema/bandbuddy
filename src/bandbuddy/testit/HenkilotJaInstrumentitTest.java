package bandbuddy.testit;
// Generated by ComTest BEGIN
import java.util.*;
import static org.junit.Assert.*;
import org.junit.*;
import bandbuddy.*;
// Generated by ComTest END

/**
 * Test class made by ComTest
 * @version 2018.03.23 12:56:32 // Generated by ComTest
 *
 */
@SuppressWarnings("all")
public class HenkilotJaInstrumentitTest {



  // Generated by ComTest BEGIN
  /** testSoittimet53 */
  @Test
  public void testSoittimet53() {    // HenkilotJaInstrumentit: 53
    HenkilotJaInstrumentit hi = new HenkilotJaInstrumentit(); 
    HenkiloJaInstrumentti a = new HenkiloJaInstrumentti(1); hi.lisaa(a); 
    HenkiloJaInstrumentti b = new HenkiloJaInstrumentti(1); hi.lisaa(b); 
    HenkiloJaInstrumentti c = new HenkiloJaInstrumentti(2); hi.lisaa(c); 
    List<HenkiloJaInstrumentti> kaikki; 
    kaikki = hi.soittimet(1); 
    assertEquals("From: HenkilotJaInstrumentit line: 60", 2, kaikki.size()); 
  } // Generated by ComTest END
}