package klondike.version02;

public class SuitToStraightView {
	
	private SuitToStraight suitToStraight;

	public SuitToStraightView(SuitToStraight suitToStraight) {
		this.suitToStraight = suitToStraight;
	}

	public void render() {
		int suit;
		suit = new LimitedIntDialog("De qué palo? [0-Oros, 1-Copas, 2-Espadas, 3-Bastos]",1,3).read();
		int straight;
		straight = new LimitedIntDialog("A qué escalera [1-7]",1,7).read();
		boolean result = suitToStraight.suitToStraight(suit,straight);
		if(!result){
			new IO().writeln("ERROR!!!! No se puede realizar ese movimiento");
		}else{
			if(suitToStraight.getBoard().isFinished()){
				new IO().writeln("ENHORABUENA!!!! HA GANADO!!!");
			}
			else{
				suitToStraight.close();
			}
		}
		
	}

}
