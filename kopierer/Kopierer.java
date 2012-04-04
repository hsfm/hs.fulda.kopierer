package kopierer;

/**
 * Die Klasse Kopierer demonstriert die Implementierung eines einfachen,
 * deterministischen endlichen Automaten (Zustandsdiagramm).
 * 
 * @author Annika Wagner
 */

public class Kopierer {

	protected int state;
	
	protected static int ausgeschaltet = 0;
	protected static int ruhend = 1;
	protected static int druckend = 2;
	protected static int fehler = -1;
	protected static int energie_sparen = -2;
	
	public Kopierer(){
		// Initialisierung mit Anfangszustand
		state = ausgeschaltet;
	}
	
	/**
	 * Behandlung des Ereignisses: Drücken von Ein/Aus
	 */
	public void E_A_gedrueckt(){
		//Fallunterscheidung über alle Zustände
		if (state == ausgeschaltet){
			// Übergang in Folgezustand
			state = ruhend;
		} else {
			state = ausgeschaltet;
		}
		
	}
	
	/*
	 * Behandlung des Ereignisses: keine Taste gedrückt
	 */
	
	public void keineEingabe()
	{
		//Wenn aktueller state nicht ausgeschaltet ist, dann Wechsel in Engergie_sparen
		if(!(state == ausgeschaltet))
		{
			state = energie_sparen;
		}
	}
	
	/**
	 * Behandlung des Ereignisses: Kopie gedrückt
	 */
	public void Kopie_gedrueckt(){
		// Fallunterscheidung über alle Zustände
		if (state == ruhend){
			// Übergang in Folgezustand
			state = druckend;
		} else if (state == druckend){
			// Fehlerhafte Benutzung
			state = fehler;
		}
	}
	
	/**
	 * Behandlung des Ereignisses: Reset gedrückt
	 */
	public void Reset_gedrueckt(){
		// Fallunterscheidung über alle Zustände
		if (state == druckend | state == fehler){
			// Übergang in Folgezustand
			state = ruhend;
		}
	}
	
	public String printResult(){
		// prüfe, ob Endzustand
		if (state == ausgeschaltet){
			return("Kopierer korrekt verwendet!");
		}else {
			return("Kopierer nicht korrekt verwendet!");
		}
	}
}
