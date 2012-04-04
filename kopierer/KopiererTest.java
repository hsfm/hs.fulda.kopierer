package kopierer;
import junit.framework.TestCase;

/**
 * UnitTest für die Implementierung des Zustandsdiagramms eines Kopierers. 
 * 
 * @author Annika Wagner
 */

public class KopiererTest extends TestCase {
	
	private Kopierer kop;
	
	protected void setUp(){
		
	}
	
	public void testRecognized(){
		kop = new Kopierer();
		
		//		 Sinnvolle Folge von Events
		kop.E_A_gedrueckt();
		kop.Kopie_gedrueckt();
		kop.E_A_gedrueckt();
		
		assertEquals("Kopierer korrekt verwendet!", kop.printResult());		
	}
	
	public void testNotRecognized(){
		kop = new Kopierer();
		
		// Nicht sinnvolle Folge von Events
		kop.Kopie_gedrueckt();
		kop.E_A_gedrueckt();
		
		assertEquals("Kopierer nicht korrekt verwendet!", kop.printResult());
	}
	
	public void testFailureRecovery(){
		kop = new Kopierer();
		
		//		 Sinnvolle Folge von Events
		kop.E_A_gedrueckt();
		kop.Kopie_gedrueckt();
		kop.Kopie_gedrueckt();
		kop.Kopie_gedrueckt();
		kop.Reset_gedrueckt();
		kop.E_A_gedrueckt();
		
		assertEquals("Kopierer korrekt verwendet!", kop.printResult());				
	}
}
