package kopierer.state_pattern.energie_sparen;

public class AusState extends KopiererState 
{
	public KopiererState ea()
	{
		
		return new RuhendState();
	}
}
