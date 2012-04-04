package kopierer_energie_sparen;

public class Kopierer
{
	protected KopiererState state;
	private String eingabesymbol;	
	
	public Kopierer()
	{
		state = new AusState();						
	}
	
	public void setEingabesymbol(String input)
	{
		eingabesymbol = input;
	}
	
	public void start()
	{
		if(state instanceof EnergieSparState)
		{
			//String[] results = ((EnergieSparState) state).getOld_state().getClass().getName().split("[.]");
			//System.out.println(results[results.length-1]);
			state = ((EnergieSparState) state).getOld_state();
		}			
		delta_dach(eingabesymbol);		
	}
	
	private KopiererState delta(char input_d)
	{		
		
		switch(input_d)
		{
			case '0': // Ein/Aus
				System.out.println(state);
				return state.ea();
			case '1': // Kopieren
				System.out.println(state);
				return state.kopie();
			case '2': // Reset
				System.out.println(state);
				return state.reset();
		}		
		
		return state;
	}
	
	private void delta_dach(String input_dd)
	{		
		if(input_dd.length() > 0)
		{
			state = delta(input_dd.charAt(0));
			delta_dach(input_dd.substring(1));
		}
		// Wird ausgeführt, wenn Eingabesymbole aufgebraucht sind
		else
		{
			System.out.println(state);
			
			//Darf nur ausgeführt werden, wenn aktueller Zustand nicht AusState ist!			
			if(!(state instanceof AusState))
			{
				//Wechsel in Energiesparmodus
				state = new EnergieSparState().energieSparen(state);
				System.out.println(state);
			}
		}	
	}	

	public static void main(String[] args)
	{
		Kopierer k = new Kopierer();
		k.setEingabesymbol("011212");
		k.start();
		k.setEingabesymbol("10");
		k.start();
	}
}
