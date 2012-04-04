package kopierer_energie_sparen;

public class FehlerState extends KopiererState
{
	public KopiererState kopie()
	{
		return new FehlerState();
	}
}
