package kopierer.state.pattern;

public class FehlerState extends KopiererState
{
	public KopiererState kopie()
	{
		return new FehlerState();
	}
}
