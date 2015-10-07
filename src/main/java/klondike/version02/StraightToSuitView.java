package klondike.version02;

public class StraightToSuitView {
	
	private StraightToSuit straightToSuit;

	public StraightToSuitView(StraightToSuit straightToSuit) {
		this.straightToSuit = straightToSuit;
	}

	public void render() {
		int escalera;
		escalera = new LimitedIntDialog("De qué escalera [1-7]",1,7).read();
		boolean result = straightToSuit.straightToSuit(escalera);
		if(!result){
			new IO().writeln("ERROR!!!! No se puede realizar ese movimiento");
		}else{
			if(straightToSuit.getBoard().isFinished()){
				new IO().writeln("ENHORABUENA!!!! HA GANADO!!!");
			}
			else{
				straightToSuit.close();
			}
		}
	}

}
