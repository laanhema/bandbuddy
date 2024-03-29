package bandbuddy.testit;
// Generated by ComTest BEGIN
import static org.junit.Assert.*;
import org.junit.*;
import bandbuddy.*;
// Generated by ComTest END

/**
 * Test class made by ComTest
 * @version 2018.04.20 09:15:22 // Generated by ComTest
 *
 */
@SuppressWarnings("all")
public class HenkiloJaGenreTest {



  // Generated by ComTest BEGIN
  /** testParse95 */
  @Test
  public void testParse95() {    // HenkiloJaGenre: 95
    HenkiloJaGenre testialkio1 = new HenkiloJaGenre(1, 2); 
    assertEquals("From: HenkiloJaGenre line: 97", 1, testialkio1.getHenkilonNro()); 
    assertEquals("From: HenkiloJaGenre line: 98", 2, testialkio1.getGenrenNro()); 
    assertEquals("From: HenkiloJaGenre line: 99", "1|2|", testialkio1.toString()); 
    testialkio1.parse("4|8|"); 
    assertEquals("From: HenkiloJaGenre line: 101", 4, testialkio1.getHenkilonNro()); 
    assertEquals("From: HenkiloJaGenre line: 102", 8, testialkio1.getGenrenNro()); 
  } // Generated by ComTest END
}