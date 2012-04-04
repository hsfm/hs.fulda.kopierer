package kopierer.state.pattern;

public class Kopierer 
{
	protected KopiererState state;
	private String eingabesymbol;	
	
	public Kopierer()
	{
		state = new AusState();		
		eingabesymbol = "000120";
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
		else
		{
			System.out.println(state);
			state = new EnergieSparState();
		}
		
	}
	
	public static void main(String[] args)
	{
		new Kopierer();
	}
}
