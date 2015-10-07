package klondike.version02;

public class StraightToSuit extends MoveController {

	protected StraightToSuit(Board board) {
		super(board);
	}
	
	@Override
	public void receive(View gameView) {
		gameView.atender(this);
	}
	
	public boolean straightToSuit(int escalera){
		return board.straightToSuit(escalera);
	}

}
