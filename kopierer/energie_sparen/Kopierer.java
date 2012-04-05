package kopierer.energie_sparen;

public class Kopierer
{
	protected KopiererState state;
	// 3 Möglichkeiten: einaus, kopie, reset
	private String[] eingabesymbol;	
	
	public Kopierer()
	{
		state = new AusState();						
	}
	
	public void setEingabesymbol(String input)
	{
		eingabesymbol = input.split("[,]");		
	}
	
	public void start()
	{
		// Wenn im Energiesparmodus dann hole letzten Zustand vor betreten des ESM
		if(state instanceof EnergieSparState)
		{
			state = ((EnergieSparState) state).getOld_state();
		}			
		delta_dach();		
	}
	
	private KopiererState delta(String input_d)
	{		
		if(input_d.equals("einaus"))
		{
			System.out.println(state);
			return state.ea();
		}
		else if(input_d.equals("kopie"))
		{
			System.out.println(state);
			return state.kopie();
		}
		else if(input_d.equals("reset"))
		{
			System.out.println(state);
			return state.reset();
		}
		return state;
	}
	
	private void delta_dach()
	{		
		for(String s : eingabesymbol)
		{
			state = delta(s);
		}			
		// Nach durchlaufen des Arrays sind die Eingabesymbole immer aufgebraucht
		System.out.println(state);
		// Darf nur ausgeführt werden, wenn aktueller Zustand nicht AusState ist!			
		if(!(state instanceof AusState))
		{
			// Wechsel in Energiesparmodus
			state = new EnergieSparState().energieSparen(state);
			System.out.println(state);
		}		
	}	

	public static void main(String[] args)
	{
		Kopierer k = new Kopierer();
		k.setEingabesymbol("einaus,kopie,reset");
		k.start();
		k.setEingabesymbol("einaus,kopie,reset,einaus");
		k.start();
	}
}
