package kopierer.state.pattern;

public abstract class KopiererState 
{
	
	
	public KopiererState ea()
	{
		return new AusState();
	}
	
	public KopiererState kopie()
	{
		return new DruckendState();
	}
	
	public KopiererState reset()
	{
		return new RuhendState();
	}
}
