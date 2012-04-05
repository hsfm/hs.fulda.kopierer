package kopierer.state_pattern;

public class DruckendState extends KopiererState 
{
	public KopiererState kopie()
	{
		return new FehlerState();
	}	
}
