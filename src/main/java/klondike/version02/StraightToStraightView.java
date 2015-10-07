package klondike.version02;

public class StraightToStraightView {

	private StraightToStraight straightToStraight;
	
	public StraightToStraightView(StraightToStraight straightToStraight) {
		this.straightToStraight = straightToStraight;
	}

	public void render() {
		int oldStraight;
		oldStraight = new LimitedIntDialog("De qué escalera [1-7]",1,7).read();
		int newStraight;
		newStraight = new LimitedIntDialog("A qué escalera [1-7]",1,7).read();
		boolean result = straightToStraight.straightToStraight(oldStraight,newStraight);
		if(!result){
			new IO().writeln("ERROR!!!! No se puede realizar ese movimiento");
		}else{
			if(straightToStraight.getBoard().isFinished()){
				new IO().writeln("ENHORABUENA!!!! HA GANADO!!!");
			}
			else{
				straightToStraight.close();
			}
		}
		
	}

}
