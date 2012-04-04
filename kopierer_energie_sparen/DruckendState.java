package kopierer_energie_sparen;

public class DruckendState extends KopiererState 
{
	public KopiererState kopie()
	{
		return new FehlerState();
	}	
}
