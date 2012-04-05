package kopierer.energie_sparen;

public class EnergieSparState extends KopiererState 
{
	// Speicherung des Vorzustandes
	protected KopiererState old_state;
	
	public KopiererState energieSparen(KopiererState state)
	{ 
		old_state = state;
		// Wechseln in EnergieSparState
		return this;
	}

	public KopiererState getOld_state() 
	{
		return old_state;
	}	
}
