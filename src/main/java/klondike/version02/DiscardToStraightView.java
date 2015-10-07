package klondike.version02;

public class DiscardToStraightView {

	private DiscardToStright discardToStright;

	public DiscardToStraightView(DiscardToStright discardToStright) {
		this.discardToStright = discardToStright;
	}

	public void render() {
		int escalera;
		escalera = new LimitedIntDialog("A qué escalera",1,7).read();
		boolean result = discardToStright.move(escalera);		
		if(!result){
			new IO().writeln("ERROR!!!! No se puede realizar ese movimiento");
		}else{
			if(discardToStright.getBoard().isFinished()){
				new IO().writeln("ENHORABUENA!!!! HA GANADO!!!");
			}
			else{
				discardToStright.close();
			}
		}
	}

}
