package kopierer.state_pattern;

public class AusState extends KopiererState 
{
	public KopiererState ea()
	{
		
		return new RuhendState();
	}
}
